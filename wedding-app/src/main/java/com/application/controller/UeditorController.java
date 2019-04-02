package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.ActionEnter;

@Controller
public class UeditorController {
	
	@Value("${web.uploadPath.wedding}")
	private String uploadPath;
	
	@RequestMapping("test")
	public ModelAndView test(ModelAndView mv) {
		mv.setViewName("/test");
		return mv;
	}
	@RequestMapping("/ueditorTest")
	public String ueditorTest(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return "/UEditor";
	}
	
	@RequestMapping("/ueditor")
	public void ueditor(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进来了 action : "+request.getParameter("action"));
//		String rootPath ;
//		if(request.getParameter("action").equals("config")) {
//			rootPath= request.getSession().getServletContext().getRealPath("/");	
//		}else {
//			rootPath = uploadPath;
//		}
		String rootPath = request.getSession().getServletContext().getRealPath("/");
//		String configPath="WEB-INF/classes/static/lib/ueditor/jsp/config.json";
		try {
			request.setCharacterEncoding( "utf-8" );
			response.setHeader("Content-Type" , "text/html");
	        response.setContentType("application/json");
	        //在tomcat 中运行时使用   去加载config.json文件
//	        String rootPath = request.getServerName()+":"+request.getServerPort();
			PrintWriter out = response.getWriter();
			String exec = new ActionEnter( request, rootPath ).exec();
//			你如果想自己定义路径 configPath 就是你自定义的路径
//			String exec = new ActionEnter( request, rootPath, configPath).exec();
			System.out.println(rootPath+"\n"+exec);
			out.write( exec );
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}
