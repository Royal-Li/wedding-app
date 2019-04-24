package com.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_user;
import com.application.response.StatusResult;
import com.application.service.IApp_userService;
import com.application.utils.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app用户表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_user")
public class App_userController {

	private static Logger logger  = LoggerFactory.getLogger(App_userController.class);
	
	@Autowired
	IApp_userService userService;
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public StatusResult userLogin(HttpServletRequest request, HttpServletResponse response,String login_name, String login_password) {
		logger.info("后台 /login");
		
		QueryWrapper<App_user> query = new QueryWrapper<>();
		query.eq("login_name", login_name);
		App_user app_user = userService.getOne(query);
		String token = null;
		if(app_user!=null&&app_user.getLogin_password().equals(login_password)) {
			token = TokenUtil.createToken(app_user.getId().toString(), app_user.getLogin_name(), app_user.getLogin_password(), "", null);
			app_user.setToken(token);
			Cookie cookie = new Cookie("token", token);
			cookie.setPath("/");
			cookie.isHttpOnly();
			cookie.setMaxAge(60);//s过期时间一分钟
			response.addCookie(cookie);
		}else {
			return StatusResult.error("登录出错");
		}
		
		return StatusResult.ok(app_user);
	}
}

