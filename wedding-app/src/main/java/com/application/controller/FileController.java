package com.application.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

	private String url;

	@Value("${web.uploadPath.wedding}")
	private String uploadPath;
	

	
	@RequestMapping("/file")
	public ModelAndView test(ModelAndView mv) {
		mv.setViewName("/file");
		return mv;
	}

	@RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String uploadFile(@RequestParam("fileName") MultipartFile file, HttpServletRequest request) {
	 
	        System.out.print("上传文件==="+"\n");
	        
	        if (file.isEmpty()) {
	            return "上传文件不可为空";
	        }
	 
	        String fileName = file.getOriginalFilename();
	 
	        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
	        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");
	 
	 
	        //s加个时间戳，尽量避免文件名称重复
	        String path = uploadPath + fileName;
	        //s文件绝对路径
	        System.out.print("保存文件绝对路径"+path+"\n");
	 
	        //s创建文件路径
	        File dest = new File(path);
	 
	        //s判断文件是否已经存在
	        if (dest.exists()) {
	            return "文件已经存在";
	        }
	 
	        //s判断文件父目录是否存在
	        if (!dest.getParentFile().exists()) {
	            dest.getParentFile().mkdirs();
	        }
	 
	        try {
	            //s上传文件
	            file.transferTo(dest); //s保存文件
	            System.out.print("保存文件路径"+path+"\n");
	            url=request.getServerName()+":"+request.getServerPort()+"/"+fileName;
	            System.out.print("保存的完整url===="+url+"\n");
	 
	        } catch (IOException e) {
	            return "上传失败";
	        }
	 
	        return "请求地址:"+url;
	    }

}
