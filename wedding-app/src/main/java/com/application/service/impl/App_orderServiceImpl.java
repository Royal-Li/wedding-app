package com.application.service.impl;

import com.application.entity.App_order;
import com.application.entity.App_order_passenger;
import com.application.entity.App_passenger;
import com.application.mapper.App_orderMapper;
import com.application.mapper.App_order_passengerMapper;
import com.application.service.IApp_orderService;
import com.application.utils.UUIDUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	App_orderMapper orderMapper;
	@Autowired
	App_order_passengerMapper orderPassengerMapper;
	

	@Override
	public List<App_order> getOrderListByUserId(Integer user_id, Integer type) {
		
		return baseMapper.getOrderListByUserId(user_id, type);
	}

	@Override
	public boolean updateOrderStatus(Integer order_id, Integer status) {
		
		return baseMapper.updateOrderStatus(order_id, status);
	}

	@Override
	@Transactional
	public boolean SaveOrder(Integer user_id, Integer product_id, App_order order) throws Exception {
		//s生成订单编号
		order.setOrder_num(UUIDUtils.getUUID());
		//s保存订单 
		int result = orderMapper.SaveOrder(order);
		//s保存订单乘客
		int result2 = 0;
		if(order.getPassengers().size()>0) {
			List<Integer> passengerIds = new ArrayList<>();
			for(App_passenger passenger: order.getPassengers()) {
				passengerIds.add(passenger.getId());
			}
			result2 = orderPassengerMapper.saveOrderPassenger(order.getId(),passengerIds);
		}
		if(result>0) {
			return true;
		}
		return false;
	}
}
