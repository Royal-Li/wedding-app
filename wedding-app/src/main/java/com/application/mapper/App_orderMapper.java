package com.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.application.entity.App_order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * app 订单表 Mapper 接口
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Mapper
public interface App_orderMapper extends BaseMapper<App_order> {

	/**
	 * @Description 根据用户查询订单
	 * @author Jason
	 * @date Apr 28, 2019
	 * @param user_id
	 * @param type 
	 * @return
	 */
	List<App_order> getOrderListByUserId(@Param("user_id")Integer user_id, @Param("type")Integer type);

	/**
	 * @Description 修改订单状态
	 * @author Jason
	 * @date Apr 29, 2019
	 * @param order_id
	 * @param status
	 * @return
	 */
	boolean updateOrderStatus(@Param("order_id")Integer order_id, @Param("status")Integer status);

}
