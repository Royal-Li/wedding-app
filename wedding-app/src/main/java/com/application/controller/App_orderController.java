package com.application.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_order;
import com.application.response.StatusResult;
import com.application.service.IApp_orderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app 订单表 前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_order")
public class App_orderController {

	private static Logger logger = LoggerFactory.getLogger(App_orderController.class);
	
	@Autowired
	IApp_orderService orderService;
	
	/**
	 * @Description 根据类型显示订单
	 * @author Jason
	 * @date Apr 29, 2019
	 * @param user_id
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/order/{user_id}", method=RequestMethod.GET)
	public StatusResult getOrderListByUserId(@PathVariable Integer user_id, Integer type) {
		List<App_order> list = orderService.getOrderListByUserId(user_id, type);
		return StatusResult.ok(list);
	}
	
	
	/**
	 * @Description 修改订单状态
	 * @author Jason
	 * @date Apr 29, 2019
	 * @param order_id
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/order/{order_id}", method=RequestMethod.POST)
	public StatusResult updateOrderStatus(@PathVariable Integer order_id, Integer status) {
		boolean result =orderService.updateOrderStatus(order_id, status);
		return StatusResult.ok(result);
	}
	
	@ResponseBody
	@RequestMapping(value="/order/")
	public StatusResult SaveOrder(App_order order) {
		return StatusResult.ok();
	}
	
}

