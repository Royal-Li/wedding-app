package com.application.service.impl;

import com.application.entity.App_product;
import com.application.mapper.App_productMapper;
import com.application.service.IApp_productService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

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

//	@Autowired
//	App_productMapper productMapper;
	
	@Override
	public List<App_product> queryProductByType(Integer type) {
		List<App_product> list = baseMapper.queryProductByType(type);
		return list;
	}

}
