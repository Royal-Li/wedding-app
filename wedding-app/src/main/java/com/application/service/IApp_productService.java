package com.application.service;

import java.util.List;
import java.util.Map;

import com.application.entity.App_product;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * app商品表： 婚礼 旅拍  服务类
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
public interface IApp_productService extends IService<App_product> {

	/**
	 * @Description 获取首页推荐商品
	 * @author Jason
	 * @date May 5, 2019
	 * @return
	 */
	Map<String, Object> queryRecommendProduct();
	
	/**
	 * @Description 根据类型查找product
	 * @author Jason
	 * @date Apr 19, 2019
	 * @param type
	 * @param pageSize 
	 * @param currentPage 
	 * @return
	 */
	List<App_product> queryProductByType(Integer type, Integer currentPage, Integer pageSize);

	/**
	 * @Description 根据商品id 查询商品详细信息
	 * @author Jason
	 * @date Apr 22, 2019
	 * @param product_id
	 * @return
	 */
	App_product queryProductDetail(Integer product_id);
	
	/**
	 * @Description 根据目的地查询相应的商品列表
	 * @author Jason
	 * @date May 5, 2019
	 * @param id
	 * @return
	 */
	Page<Object> queryProductListByDestination(Page page, Integer id);

	
	
	/**
	 * @Description 根据商店查询商品列表
	 * @author Jason
	 * @date May 6, 2019
	 * @param id
	 * @return
	 */
	Page<Object> queryProductListByStore(Page page, Integer id);

	
	/**
	 * @Description 根据search 查询商品
	 * @author Jason
	 * @date 2019年5月10日
	 * @param page
	 * @param text
	 * @return
	 */
	Page<Object> queryProductListBySearch(Page page, String text);


	

}
