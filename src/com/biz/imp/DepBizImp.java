package com.biz.imp;

import java.util.List;

import com.po.*;
import com.service.DaoService;
import com.biz.DepBiz;
import com.dao.*;

public class DepBizImp implements DepBiz {
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public List<Dep> findAll() {
		return daoService.getDepDAO().findAll();
	}

	public boolean save(Dep dep) {
		try {
			daoService.getDepDAO().save(dep);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer id) {
		Dep dep = daoService.getDepDAO().findById(id);
		try {
			daoService.getDepDAO().delete(dep);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
