package com.application.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.application.entity.App_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * app用户表 Mapper 接口
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Mapper
public interface App_userMapper extends BaseMapper<App_user> {

}
