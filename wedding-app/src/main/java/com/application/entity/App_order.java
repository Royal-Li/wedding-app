package com.application.entity;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * app 订单表
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class App_order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单编号
     */
    @TableField("order_num")
    private String order_num;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer user_id;

    /**
     * 商品id  婚礼 旅拍 蜜月。。。
     */
    @TableField("product_id")
    private Integer product_id;

    @TableField("price")
    private String price;

    /**
     *联系人姓名
     */
    @TableField("buyer_name")
    private String buyer_name;

    /**
     * 实付电话
     */
    @TableField("buyer_mobile")
    private String buyer_mobile;
    
    /**
     * 联系人邮箱
     */
    @TableField("buyer_email")
    private String buyer_email;
    
    /**
     * 出发城市
     */
    @TableField("start_city")
    private String start_city;
    
    /**
     * 出发日期
     */
    @TableField("start_date")
    private String start_date;
    
    
    /**
     * 订单状态 未支付 已支付 待出行  已取消
     */
    @TableField("status")
    private Integer status;

    @TableField("sort")
    private String sort;

    @TableField("create_time")
    private String create_time;

    @TableField("update_time")
    private String update_time;
    
    @TableField(exist=false)
    private App_product product;
    
    @TableField(exist=false)
    private App_user user;
    
    @TableField(exist=false)
    private List<App_passenger> passengers;


}
