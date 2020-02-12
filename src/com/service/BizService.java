package com.service;

import com.biz.*;

public class BizService {
	
	private DepBiz depBiz;
	private EmpBiz empBiz;
	private UsersBiz usersBiz;
	private WelfareBiz welfareBiz;
	public DepBiz getDepBiz() {
		return depBiz;
	}
	public void setDepBiz(DepBiz depBiz) {
		this.depBiz = depBiz;
	}
	public EmpBiz getEmpBiz() {
		return empBiz;
	}
	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}
	public UsersBiz getUsersBiz() {
		return usersBiz;
	}
	public void setUsersBiz(UsersBiz usersBiz) {
		this.usersBiz = usersBiz;
	}
	public WelfareBiz getWelfareBiz() {
		return welfareBiz;
	}
	public void setWelfareBiz(WelfareBiz welfareBiz) {
		this.welfareBiz = welfareBiz;
	}
}
