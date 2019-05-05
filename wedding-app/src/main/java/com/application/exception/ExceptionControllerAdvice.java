package com.application.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.response.StatusResult;

/**
 * controller增强器 处理异常
 * @class ExceptionControllerAdvice
 * @author Jason
 * @description
 * @date Apr 24, 2019 11:55:47 AM
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	
	/**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Jason");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public StatusResult errorHandler(Exception ex) {
    	logger.error("出错了 捕捉到异常:  "+ ex.getMessage());
    	StatusResult result = null;
    	
    	if(ex instanceof NotAuthException) {
    		result = StatusResult.tokenInvalid("token错误");
    	}else if (ex instanceof TokenExpirationException){
    		result = StatusResult.tokenInvalid("token过期");
    	}
    	
    	{
    		result = StatusResult.error("系统错误");
    		ex.printStackTrace();
        }
        
        return result;
    }

}
