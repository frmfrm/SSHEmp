package com.biz.imp;

import com.biz.UsersBiz;
import com.dao.UsersDAO;
import com.po.Users;
import com.service.DaoService;

public class UsersBizImp implements UsersBiz {
private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	public Users check(Users us) {
		
		return daoService.getUsersDAO().check(us);
	}

}
