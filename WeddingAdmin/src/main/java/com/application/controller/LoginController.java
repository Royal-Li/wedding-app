package com.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @class LoginController
 * @author Jason
 * @description
 * @date Mar 21, 2019 4:37:13 PM
 */
@Controller
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		logger.info("后台  /login 跳转登录");
		return "/login";
	}
}
