package com.biz.imp;
import java.util.List;
import com.po.*;
import com.service.DaoService;
import com.biz.*;
import com.dao.*;
public class WelfareBizImp implements WelfareBiz {
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public List<Welfare> findAll() {
		return daoService.getWelfareDAO().findAll();
	}

}
