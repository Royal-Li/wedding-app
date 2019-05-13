package com.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.application.entity.App_product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

	
	List<App_product> queryProductByType(@Param("type")Integer type);

	App_product queryProductDetail(@Param("product_id") Integer product_id);

	List<App_product> queryProductListByDestination(@Param("target_city")Integer id);

	List<App_product> queryProductListByStore(@Param("store_id")Integer id);

	
	/*@Select("SELECT"
			+ " ap.id,ap.numb,ap.title,ap.description,ap.price,app.id AS picture_id,app.img_url,app.mark,app.sort,ast.id AS store_id,ast.name AS store_name, ast.img_url as store_img_url,ast.tel as store_tel" 
			+ " FROM" 
			+ " app_product ap, app_product_picture app,app_store ast" 
			+ " WHERE" 
			+ " app.product_id = ap.id" 
			+ " AND ast.id = ap.store_id" 
			+ " AND ap.title like '%' #{text} '%'")*/
	List<App_product> queryProductListBySearch(Page page, @Param("text")String text);


}
