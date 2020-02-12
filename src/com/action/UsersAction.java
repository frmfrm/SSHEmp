package com.action;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.po.*;
import com.service.BizService;
import com.biz.*;
import com.biz.imp.*;
public class UsersAction {
	private Users us;
	private String path;

	private BizService bizService;

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	public Users getUs() {
		return us;
	}
	public void setUs(Users us) 
	{
		this.us = us;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String check(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		Users nus=bizService.getUsersBiz().check(us);
		if(nus!=null){
			session.setAttribute("nus", nus);
			path="main.jsp";
			return "ok";
		}
		return "fail";
	}
}
