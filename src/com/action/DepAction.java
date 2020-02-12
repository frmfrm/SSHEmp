package com.action;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.po.*;
import com.service.BizService;
import com.biz.*;
import com.biz.imp.*;
public class DepAction implements IAction{
	private Dep dep;
	private String path;
	private BizService bizService;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	public String save() {
		boolean flag=bizService.getDepBiz().save(dep);
		if(flag){
			path="findAll_Dep";
			return "ok";
		}
		return "fail";
	}

	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public String delById() {
		boolean flag=bizService.getDepBiz().delById(id);
		if(flag){
			path="findAll_Dep";
			return "ok";
		}
		return "fail";
	}

	public String findById() {
		// TODO Auto-generated method stub
		return null;
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Dep> lsdep=bizService.getDepBiz().findAll();
		session.setAttribute("lsdep", lsdep);
		path="dep.jsp";
		return "ok";
	}

	public String doinit() {
		// TODO Auto-generated method stub
		return null;
	}
}
