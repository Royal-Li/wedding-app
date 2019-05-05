package com.application.service;

import java.util.List;

import com.application.entity.App_order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * app 订单表 服务类
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
public interface IApp_orderService extends IService<App_order> {

	/**
	 * @Description 跟据用户查询订单
	 * @author Jason
	 * @date Apr 28, 2019
	 * @param user_id
	 * @param type 
	 * @return
	 */
	List<App_order> getOrderListByUserId(Integer user_id, Integer type);

	/**
	 * @Description 修改订单状态
	 * @author Jason
	 * @date Apr 29, 2019
	 * @param order_id
	 * @param status
	 * @return
	 */
	boolean updateOrderStatus(Integer order_id, Integer status);

}
