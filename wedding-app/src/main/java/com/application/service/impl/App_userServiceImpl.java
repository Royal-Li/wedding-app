package com.application.service.impl;

import com.application.entity.App_user;
import com.application.mapper.App_userMapper;
import com.application.service.IApp_userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app用户表 服务实现类
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Service
public class App_userServiceImpl extends ServiceImpl<App_userMapper, App_user> implements IApp_userService {

}
