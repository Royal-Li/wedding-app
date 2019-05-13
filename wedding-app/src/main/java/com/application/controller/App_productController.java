package com.application.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.entity.App_product;
import com.application.response.StatusResult;
import com.application.service.IApp_productService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

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
	 * @Description 首页推荐商品
	 * @author Jason
	 * @date May 5, 2019
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/index/recommend",method=RequestMethod.GET)
	public StatusResult getRecommendProduct() {
		Map<String, Object> recommend = productService.queryRecommendProduct();
		return StatusResult.ok(recommend);
	}
	
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
	
	/**
	 * @Description 根据目的地查找商品
	 * @author Jason
	 * @date May 5, 2019
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/destination/{id}",method=RequestMethod.GET)
	public StatusResult getProductListByDestination(@PathVariable Integer id) {
		List<App_product> list = productService.queryProductListByDestination(id);
		return StatusResult.ok(list);
		
	}
	
	/**
	 * @Description 根据店铺查找商品
	 * @author Jason
	 * @date 2019年5月10日
	 * @param id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/store/{id}", method=RequestMethod.GET)
	public StatusResult getProductListByStore(@PathVariable Integer id, Integer currentPage, Integer pageSize) {
		
		List<App_product> list = productService.queryProductListByStore(id);
		return StatusResult.ok(list);
	}
	
	/**
	 * @Description search 搜索商品
	 * @author Jason
	 * @date 2019年5月13日
	 * @param text
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/search/{text}", method=RequestMethod.GET)
	public StatusResult getProductListBySearch(@PathVariable String text, @RequestParam(defaultValue="1")Integer currentPage, @RequestParam(defaultValue="10")Integer pageSize) {
		
		Page<Object> page = productService.queryProductListBySearch(new Page<>(currentPage, pageSize), text);
		return StatusResult.ok(page);
	}
	
}

