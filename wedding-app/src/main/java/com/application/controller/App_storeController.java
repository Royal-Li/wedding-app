package com.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_store;
import com.application.response.StatusResult;
import com.application.service.IApp_storeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app店家表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_store")
public class App_storeController {
	
	private static Logger logger = LoggerFactory.getLogger(App_storeController.class);
	
	@Autowired
	IApp_storeService storeService;
	
	@ResponseBody
	@RequestMapping(value="/store")
	public StatusResult getStore(@RequestParam(defaultValue="1")Integer currentPage, @RequestParam(defaultValue="10")Integer pageSize) {
		Page<App_store> page =new Page<>(currentPage, pageSize);
		IPage<App_store> store = storeService.page(page);
		return StatusResult.ok(store);
	}

}

