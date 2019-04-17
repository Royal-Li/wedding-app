package com.application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * app用户表
 * </p>
 *
 * @author Jason
 * @since 2019-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class App_user implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("tel")
    private Long tel;

    @TableField("email")
    private String email;

    @TableField("qq")
    private String qq;

    @TableField("qq_img")
    private String qq_img;

    /**
     * 身份证号码
     */
    @TableField("identity")
    private String identity;

    /**
     * 护照号码
     */
    @TableField("passport")
    private String passport;


}
