package com.application.service;

import java.util.List;

import com.application.entity.App_product;
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
	 * @Description 根据类型查找product
	 * @author Jason
	 * @date Apr 19, 2019
	 * @param type
	 * @return
	 */
	List<App_product> queryProductByType(Integer type);

	

}
