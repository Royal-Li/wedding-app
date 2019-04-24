package com.application.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_product;
import com.application.response.StatusResult;
import com.application.service.IApp_productService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * app商品表： 婚礼 旅拍  前端控制器
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Controller
@RequestMapping("/app_product")
public class App_productController {
	
	private static Logger logger = LoggerFactory.getLogger(App_areaController.class);
	
	@Autowired
	IApp_productService productService;
	
	/**
	 * @Description 根据类型查找所有商品
	 * @author Jason
	 * @date Apr 19, 2019
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/list/{type}", method=RequestMethod.GET)
	public StatusResult getProductListByType(@PathVariable Integer type) {
		
		logger.info("后台 /product/list/{type}");
		List<App_product> list = productService.queryProductByType(type);
		return StatusResult.ok(list);
	}
	
	/**
	 * @Description 查询商品详细信息
	 * @author Jason
	 * @date Apr 22, 2019
	 * @param product_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/detail/{product_id}", method=RequestMethod.GET)
	public StatusResult getProductDetail(@PathVariable Integer product_id) {
		logger.info("后台  /product/list/{id}");
		App_product product = productService.queryProductDetail(product_id);
		return StatusResult.ok(product);
	}
	
	
}

