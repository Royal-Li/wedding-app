package com.application.service.impl;

import com.application.entity.App_product;
import com.application.enums.ProductType;
import com.application.mapper.App_productMapper;
import com.application.service.IApp_productService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
	public Map<String, Object> queryRecommendProduct() {
		Map<String,Object> recommend = new HashMap<>();
		Page<App_product> page = new Page<>(1, 10);
		List<App_product> weddingList = baseMapper.queryProductByType(ProductType.Wedding.getId(), page);
		List<App_product> travelList = baseMapper.queryProductByType(ProductType.Travel.getId(), page);
		List<App_product> hotelList = baseMapper.queryProductByType(ProductType.Hotel.getId(), page);
		recommend.put("wedding", weddingList);
		recommend.put("travel", travelList);
		recommend.put("hotel", hotelList);
		return recommend;
	}
	
	@Override
	public List<App_product> queryProductByType(Integer type, Integer currentPage, Integer pageSize) {
		Page<App_product> page = new Page<>(currentPage, pageSize);
		List<App_product> list = baseMapper.queryProductByType(type, page);
		return list;
	}

	@Override
	public App_product queryProductDetail(Integer product_id) {
		App_product product = productMapper.queryProductDetail(product_id);
		return product;
	}

	@Override
	public Page<Object> queryProductListByDestination(Page page, Integer id) {
		return page.setRecords(this.baseMapper.queryProductListByDestination(page, id));
	}
	
	@Override
	public Page<Object> queryProductListByStore(Page page, Integer id) {
		return page.setRecords(this.baseMapper.queryProductListByStore(page, id));
	}

	
	/**
	 * mybatis-puls 多表条件查询+分页
	 */
	@Override
	public Page<Object> queryProductListBySearch(Page page, String text) {
		return page.setRecords(this.baseMapper.queryProductListBySearch(page, text));
	}


}
