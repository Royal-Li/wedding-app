package com.application.response;

/**
 * 自定义返回消息
 * @class ResponseStatus
 * @author Jason
 * @description
 * @date Jan 21, 2019 10:22:09 AM
 */
public enum ResponseStatusMsg {
	
	UPDATE_SUCCESS("修改成功"),
	UPDATE_FAIL("修改失败"),
	FIND_SUCCESS("查询成功"),
	FIND_FAIL("查询失败"),
	FIND_NONE("不存在"),
	FIND_EXIST("已存在"),
	ADD_SUCCESS("添加成功"),
	ADD_FAIL("添加失败"),
	DELETE_SUCCESS("删除成功"),
	DELETE_FAIL("删除失败"),
	DELETE_FAIL_FK("删除失败，请先删除与此关联的对象"),
	DELETE_FAIL_SUICIDE("删除失败，不能删除自身"),
	NO_AUTHORITY("您无此功能权限"),
	AVAILABLE("该名称可用"),
	UPLOAD_SUCCESS("上传成功"),
	UPLOAD_FAIL("上传失败"),
	LOGIN_INVALID("登录失效");
	
	private String msg;

	private ResponseStatusMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	
}
