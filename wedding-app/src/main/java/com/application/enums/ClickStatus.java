package com.application.enums;

/**
 * @class ClickStatus 点击记录 枚举类 0 第一次点击 1 不是第一次点击
 * @author Jason
 * @description
 * @date Apr 19, 2019 5:03:44 PM
 */
public enum ClickStatus {
	
	First(0,"First"),//第一次点击
	NotFisrt(1,"NotFirst");//不是第一次点击

	private Integer code;
	private String status;
	
	private ClickStatus(Integer code, String status) {
		this.code = code;
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
