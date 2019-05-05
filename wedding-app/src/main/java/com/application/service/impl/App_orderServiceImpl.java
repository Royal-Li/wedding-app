package com.application.service.impl;

import com.application.entity.App_order;
import com.application.mapper.App_orderMapper;
import com.application.service.IApp_orderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * app 订单表 服务实现类
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Service
public class App_orderServiceImpl extends ServiceImpl<App_orderMapper, App_order> implements IApp_orderService {

	@Override
	public List<App_order> getOrderListByUserId(Integer user_id, Integer type) {
		
		return baseMapper.getOrderListByUserId(user_id, type);
	}

	@Override
	public boolean updateOrderStatus(Integer order_id, Integer status) {
		
		return baseMapper.updateOrderStatus(order_id, status);
	}

}
