package com.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.logging.LogFactory;
import com.application.entity.App_picture;
import com.application.response.StatusResult;
import com.application.service.IApp_pictureService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app 轮播图表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_picture")
public class App_pictureController {
	
	private static Logger logger = LoggerFactory.getLogger(App_pictureController.class);
	
	@Autowired
	IApp_pictureService app_PictureService;
	
	@ResponseBody
	@RequestMapping(value="/picture",method=RequestMethod.GET)
	public StatusResult getAppPicture() {
		
		logger.info("后台  /picture");
		List<App_picture> list = app_PictureService.list();
		return StatusResult.ok(list);
	}

}

