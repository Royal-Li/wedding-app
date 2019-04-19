package com.application.controller;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_area;
import com.application.enums.ClickStatus;
import com.application.response.StatusResult;
import com.application.service.IApp_areaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * app 地区表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_area")
public class App_areaController {
	
	private static Logger logger = LoggerFactory.getLogger(App_areaController.class);
	
	@Autowired
	IApp_areaService areaService;
	
	
	/**
	 * @Description 查询地区一级菜单
	 * @author Jason
	 * @date Apr 19, 2019
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/area", method=RequestMethod.GET)
	public StatusResult getAppArea() {
		logger.info("后台 /area");
		
		QueryWrapper<App_area> query = new QueryWrapper<App_area>();
		query.isNull("parent_id").eq("status", 1);
		List<App_area> list = areaService.list(query);
		return StatusResult.ok(list);
	}
	
	/**
	 * @Description 查询地区二级菜单
	 * @author Jason
	 * @date Apr 19, 2019
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/area/{parent_id}", method=RequestMethod.GET)
	public StatusResult getAppAreaChild(@PathVariable Integer parent_id, String type) {
		
		logger.info("后台 /area/{parent_id}");
		QueryWrapper<App_area> query = new QueryWrapper<>();
		if(!StringUtils.isEmpty(type)&&type.equals(ClickStatus.First.getStatus())) {
			query.eq("level", 2).eq("status", 1).isNotNull("sort").orderByAsc("sort");
		} else {
			query.eq("parent_id", parent_id).eq("level", 2).eq("status", 1);
		}
		List<App_area> list = areaService.list(query);
		return StatusResult.ok(list);
	}

}

