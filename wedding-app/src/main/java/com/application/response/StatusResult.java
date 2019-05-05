package com.application.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 李忠硕 QQ:1598749808
 * @date 2019年4月19日14:04:55
 * @Description 自定义json响应式结构
 * @version V1.0
 */
public class StatusResult implements Serializable {
	private static final long serialVersionUID = 5387303482092052390L;


	// s定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// s响应业务状态
	private Integer status;

	// s响应消息
	private String msg;

	// s响应中的数据
	private Object data;
	
	public StatusResult() {

	}
	
	public StatusResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}
	
	public StatusResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public static StatusResult build(Integer status, String msg) {
		return new StatusResult(status, msg, null);
	}

	public static StatusResult build(Integer status, String msg, Object data) {
		return new StatusResult(status, msg, data);
	}
	
	/**
	 * @Description 返回 200 ok null
	 * @author Jason
	 * @date Jan 21, 2019
	 * @return
	 */
	public static StatusResult ok() {
		return new StatusResult(null);
	}

	/** 
	 * @Description 返回 200 ok date
	 * @author Jason
	 * @date Jan 21, 2019
	 * @param data
	 * @return
	 */
	public static StatusResult ok(Object data) {
		return new StatusResult(data);
	}

	/**
	 * @Description 返回 200 自定义msg null
	 * @author Jason
	 * @date Jan 21, 2019
	 * @param msg
	 * @return
	 */
	public static StatusResult ok(String msg) {
		return new StatusResult(200, msg, null);
	}
	
	/**
	 * @Description 返回 200 自定义msg data
	 * @author Jason
	 * @date Jan 21, 2019
	 * @param msg
	 * @param data
	 * @return
	 */
	public static StatusResult ok(String msg, Object data) {
		return new StatusResult(200, msg, data);
	}

	/**
	 * 找不到
	 * 
	 * @param msg
	 * @return
	 */
	public static StatusResult none(String msg) {
		return new StatusResult(404, msg, null);
	}

	/**
	 * 已存在
	 * 
	 * @param msg
	 * @return
	 */
	public static StatusResult exist(String msg) {
		return new StatusResult(444, msg, null);
	}

	/**
	 * 运行异常
	 * 
	 * @param msg
	 * @return
	 */
	public static StatusResult error(String msg) {
		return new StatusResult(500, msg, null);
	}

	/**
	 * token错误
	 * 
	 * @param msg
	 * @return
	 */
	public static StatusResult tokenInvalid(String msg) {
		return new StatusResult(400, msg, null);
	}
	
	/**
	 * 将json结果集转化为TaotaoResult对象
	 * 
	 * @param jsonData json数据
	 * @param clazz    TaotaoResult中的object类型
	 * @return
	 */
	public static StatusResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, StatusResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static StatusResult format(String json) {
		try {
			return MAPPER.readValue(json, StatusResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData json数据
	 * @param clazz    集合中的类型
	 * @return
	 */
	public static StatusResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
