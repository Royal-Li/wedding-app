package com.application.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.application.entity.App_order_passenger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jason
 * @since 2019-05-08
 */
public interface App_order_passengerMapper extends BaseMapper<App_order_passenger> {

	/**
	 * @Description 
	 * @author Jason
	 * @date May 8, 2019
	 * @param id
	 * @param passengerIds
	 * @return
	 */
	int saveOrderPassenger(@Param("order_id")Integer id, @Param("passengerIds")List<Integer> passengerIds);

}
