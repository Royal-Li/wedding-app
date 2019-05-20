package com.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_user;
import com.application.response.StatusResult;
import com.application.service.IApp_userService;
import com.application.utils.PasswordUtils;
import com.application.utils.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import ch.qos.logback.core.status.StatusBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
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
		login_password = PasswordUtils.encodPassword(login_password);
		if(app_user!=null&&app_user.getLogin_password().equals(login_password)) {
			token = TokenUtil.createToken(app_user.getId().toString(), app_user.getLogin_name(), app_user.getLogin_password(), "", null);
			app_user.setToken(token);
			Cookie cookie = new Cookie("token", token);
			cookie.setPath("/");
			cookie.isHttpOnly();
			cookie.setMaxAge(60*60);//s过期时间一小时
			response.addCookie(cookie);
		}else {
			return StatusResult.error("登录出错");
		}
		return StatusResult.ok(app_user);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public StatusResult register(HttpServletRequest request, App_user user, Integer code) {
		int sessionCode = (int)request.getSession().getAttribute("code");
		if(code!=null) {
			if(sessionCode==code) {
				QueryWrapper<App_user> query = new QueryWrapper<>();
				query.eq("login_name", user.getLogin_name());
				App_user one = userService.getOne(query);
				if(one==null) {
					user.setName("用户"+code);
					user.setLogin_password(PasswordUtils.encodPassword(user.getLogin_password()));
					user.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					userService.save(user);
				}else {
					return StatusResult.error("手机号已经被注册过了");
				}
			} else {
				return StatusResult.error("验证码错误");
			}
		}
		return StatusResult.ok();
	}
	
	@ResponseBody
	@RequestMapping(value="/code", method=RequestMethod.GET)
	public StatusResult randomCode(HttpServletRequest request) {
		int code = RandomUtils.nextInt(1000, 9999);
		request.getSession().setAttribute("code", code);
		return StatusResult.ok(code);
	}
}

