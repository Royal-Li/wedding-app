package com.application.enums;

public enum ProductType {
	
	Wedding(1,"wedding"),
	Travel(2,"travel"),
	HoneyMoon(3,"honeymoon"),
	Hotel(4,"hotel"),
	Designer(5,"designer");
	
	
	private Integer id;
	private String name;
	
	private ProductType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
