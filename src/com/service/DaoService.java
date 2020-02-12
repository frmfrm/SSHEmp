package com.service;

import com.dao.*;

public class DaoService {
	private DepDAO depDAO ;
	private EmpDAO empDAO;
	private EmpwelfareDAO empwelfareDAO;
	private SalaryDAO salaryDAO;
	private UsersDAO usersDAO;
	private WelfareDAO welfareDAO;
	public DepDAO getDepDAO() {
		return depDAO;
	}
	public void setDepDAO(DepDAO depDAO) {
		this.depDAO = depDAO;
	}
	public EmpDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	public EmpwelfareDAO getEmpwelfareDAO() {
		return empwelfareDAO;
	}
	public void setEmpwelfareDAO(EmpwelfareDAO empwelfareDAO) {
		this.empwelfareDAO = empwelfareDAO;
	}
	public SalaryDAO getSalaryDAO() {
		return salaryDAO;
	}
	public void setSalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAO = salaryDAO;
	}
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	public WelfareDAO getWelfareDAO() {
		return welfareDAO;
	}
	public void setWelfareDAO(WelfareDAO welfareDAO) {
		this.welfareDAO = welfareDAO;
	}

	
}
