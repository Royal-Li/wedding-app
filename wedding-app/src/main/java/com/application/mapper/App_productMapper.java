package com.application.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.application.entity.App_product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * app商品表： 婚礼 旅拍  Mapper 接口
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Mapper
public interface App_productMapper extends BaseMapper<App_product> {

}
