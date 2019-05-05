package com.application.service.impl;

import com.application.entity.App_product;
import com.application.enums.ProductType;
import com.application.mapper.App_productMapper;
import com.application.service.IApp_productService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app商品表： 婚礼 旅拍  服务实现类
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Service
public class App_productServiceImpl extends ServiceImpl<App_productMapper, App_product> implements IApp_productService {

	@Autowired
	App_productMapper productMapper;
	
	@Override
	public List<App_product> queryProductByType(Integer type) {
		List<App_product> list = baseMapper.queryProductByType(type);
		return list;
	}

	@Override
	public App_product queryProductDetail(Integer product_id) {
		App_product product = productMapper.queryProductDetail(product_id);
		return product;
	}

	@Override
	public List<App_product> queryProductListByDestination(Integer id) {
		List<App_product> list = baseMapper.queryProductListByDestination(id);
		return list;
	}

	@Override
	public Map<String, Object> queryRecommendProduct() {
		Map<String,Object> recommend = new HashMap<>();
		List<App_product> weddingList = baseMapper.queryProductByType(ProductType.Wedding.getId());
		List<App_product> travelList = baseMapper.queryProductByType(ProductType.Travel.getId());
		List<App_product> hotelList = baseMapper.queryProductByType(ProductType.Hotel.getId());
		recommend.put("wedding", weddingList);
		recommend.put("travel", travelList);
		recommend.put("hotel", hotelList);
		return recommend;
	}

}
