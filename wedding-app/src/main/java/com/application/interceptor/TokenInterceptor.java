package com.application.interceptor;



import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.application.entity.App_user;
import com.application.exception.NotAuthException;
import com.application.exception.TokenExpirationException;
import com.application.mapper.App_userMapper;
import com.application.service.IApp_userService;
import com.application.utils.TokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;;


/**
 * jdk1.8的新特性。查看 handlerIntercepter的接口方法都有default修饰。即使不重写也不会报错的
 * @class TokenInterceptor
 * @author Jason
 * @description
 * @date Apr 23, 2019 4:13:42 PM
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
	
	@Autowired 
	IApp_userService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("进入tokenInterceptor拦截器");
		String token = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if("token".equals(cookie.getName())) {
					token = cookie.getValue();
				}
			}
		}
		if(StringUtils.isEmpty(token)) {
			throw new NotAuthException("没有token认证信息");
		}
		Claims claims = null;
		try {
			claims = TokenUtil.parseToken(token);
		} catch (ExpiredJwtException e) {
			throw new TokenExpirationException("token过期");
		}catch (Exception e) {
			throw new NotAuthException("token信息不正确");
		}
		Date expiration = claims.getExpiration();
		//	token 过期直接抛出异常
		if(expiration.before(new Date())){
			throw new TokenExpirationException("token过期");
		}
		//s验证token的准确性的做法 1 在数据库保存token字段直接比较token 2解密token比较信息
		String id = claims.getId();
		String userName = claims.getIssuer();
		String password = claims.getSubject();
		App_user app_user = userService.getById(id);
		
		//s如果参数中有 user_id 应该拿着user_id和token解密的id比较一下
		if(null!=app_user) {
			if(!password.equals(app_user.getLogin_password())) {
				throw new NotAuthException("token 信息不正确");
			}
//			} else if(token.equals(app_user.getToken())) {
//				throw new NotAuthException("token 信息不正确");
//			}
		}
		
		return true;
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
}
