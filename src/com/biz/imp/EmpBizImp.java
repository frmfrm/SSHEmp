package com.biz.imp;


import java.util.*;

import com.po.*;
import com.service.DaoService;
import com.biz.*;
import com.dao.*;

public class EmpBizImp implements EmpBiz {
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(Emp emp) {
		try {
			/*********处理薪资数据*********/
			Set<Salary> ss=new HashSet<Salary>();
			Salary sa=new Salary(emp, emp.getEmoney());
			ss.add(sa);
			emp.setSalaries(ss);
			/***************************/
			
			/****处理员工福利关系表数据***************/
			Set<Empwelfare> ews=new HashSet<Empwelfare>();
			Integer[] wids=emp.getWids();//从界面获取的员工福利编号数组(复选框)
			if(wids!=null&&wids.length>0){
				for (int i = 0; i < wids.length; i++) {
					Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
					Empwelfare ewf=new Empwelfare(emp, wf);
					ews.add(ewf);
				}
			}
			emp.setEmpwelfares(ews);//给关系表插入数据准备值			
			/***********************************/
			daoService.getEmpDAO().save(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Emp emp) {
		//获取原来的员工对象
		Emp oldemp=daoService.getEmpDAO().findById(emp.getEid());
		try {
			/********处理薪资数据*********/
			Set<Salary> oldss=oldemp.getSalaries();
			if(oldss!=null&&oldss.size()>0){//存在薪资
				for (Salary oldsa : oldss) {
					oldsa.setEmoney(emp.getEmoney());
				}
				emp.setSalaries(oldss);
			}else{//无薪资
				Set<Salary> ss=new HashSet<Salary>();
				Salary sa=new Salary(emp, emp.getEmoney());
				ss.add(sa);
				emp.setSalaries(ss);
			}			
			/**************************/
			
			/**************员工福利的处理******************/
			//获取原来的员工福利集合
			Set<Empwelfare> oldews=oldemp.getEmpwelfares();
			if(oldews!=null&&oldews.size()>0){
				//删除原来的员工福利关系表数据
				for (Empwelfare oldewf : oldews) {
					daoService.getEmpwelfareDAO().delete(oldewf);
				}
			}
			
			//添加新的员工福利
			Set<Empwelfare> ews=new HashSet<Empwelfare>();
			Integer[] wids=emp.getWids();//从界面获取的员工福利编号数组(复选框)
			if(wids!=null&&wids.length>0){
				for (int i = 0; i < wids.length; i++) {
					Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
					Empwelfare ewf=new Empwelfare(emp, wf);
					ews.add(ewf);
				}
			}
			emp.setEmpwelfares(ews);//给关系表插入数据准备值	
			/******************************************/
			daoService.getEmpDAO().merge(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delById(Integer eid) {
		Emp emp=daoService.getEmpDAO().findById(eid);
		try {
			daoService.getEmpDAO().delete(emp);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Emp findById(Integer eid) {
		Emp emp=daoService.getEmpDAO().findById(eid);
		
		/***获取薪资****************/
		Set<Salary> ss=emp.getSalaries();
		if(ss!=null&&ss.size()>0){
			for (Salary sa : ss) {
				emp.setEmoney(sa.getEmoney());
			}
		}
		/*************************/
		
		/*****获取员工福利************************/
		Set<Empwelfare> ews=emp.getEmpwelfares();
		if(ews!=null&&ews.size()>0){
			Integer[] wids=new Integer[ews.size()];
			int i=0;//数组下标
			for(Empwelfare ewf:ews){
				wids[i]=ewf.getWelfare().getWid();
				i++;
			}
			emp.setWids(wids);
		}
		/**************************************/
		
		return emp;
	}

	public List<Emp> findPageAll(int page, int rows) {
		if(page<1)page=1;
		if(rows<1)rows=5;
		return daoService.getEmpDAO().findPageAll(page, rows);
	}

	public int findMaxRow() {
		return daoService.getEmpDAO().findMaxRow().intValue();
	}

}
