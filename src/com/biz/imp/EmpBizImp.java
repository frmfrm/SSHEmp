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
			/*********����н������*********/
			Set<Salary> ss=new HashSet<Salary>();
			Salary sa=new Salary(emp, emp.getEmoney());
			ss.add(sa);
			emp.setSalaries(ss);
			/***************************/
			
			/****����Ա��������ϵ������***************/
			Set<Empwelfare> ews=new HashSet<Empwelfare>();
			Integer[] wids=emp.getWids();//�ӽ����ȡ��Ա�������������(��ѡ��)
			if(wids!=null&&wids.length>0){
				for (int i = 0; i < wids.length; i++) {
					Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
					Empwelfare ewf=new Empwelfare(emp, wf);
					ews.add(ewf);
				}
			}
			emp.setEmpwelfares(ews);//����ϵ���������׼��ֵ			
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
		//��ȡԭ����Ա������
		Emp oldemp=daoService.getEmpDAO().findById(emp.getEid());
		try {
			/********����н������*********/
			Set<Salary> oldss=oldemp.getSalaries();
			if(oldss!=null&&oldss.size()>0){//����н��
				for (Salary oldsa : oldss) {
					oldsa.setEmoney(emp.getEmoney());
				}
				emp.setSalaries(oldss);
			}else{//��н��
				Set<Salary> ss=new HashSet<Salary>();
				Salary sa=new Salary(emp, emp.getEmoney());
				ss.add(sa);
				emp.setSalaries(ss);
			}			
			/**************************/
			
			/**************Ա�������Ĵ���******************/
			//��ȡԭ����Ա����������
			Set<Empwelfare> oldews=oldemp.getEmpwelfares();
			if(oldews!=null&&oldews.size()>0){
				//ɾ��ԭ����Ա��������ϵ������
				for (Empwelfare oldewf : oldews) {
					daoService.getEmpwelfareDAO().delete(oldewf);
				}
			}
			
			//����µ�Ա������
			Set<Empwelfare> ews=new HashSet<Empwelfare>();
			Integer[] wids=emp.getWids();//�ӽ����ȡ��Ա�������������(��ѡ��)
			if(wids!=null&&wids.length>0){
				for (int i = 0; i < wids.length; i++) {
					Welfare wf=daoService.getWelfareDAO().findById(wids[i]);
					Empwelfare ewf=new Empwelfare(emp, wf);
					ews.add(ewf);
				}
			}
			emp.setEmpwelfares(ews);//����ϵ���������׼��ֵ	
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
		
		/***��ȡн��****************/
		Set<Salary> ss=emp.getSalaries();
		if(ss!=null&&ss.size()>0){
			for (Salary sa : ss) {
				emp.setEmoney(sa.getEmoney());
			}
		}
		/*************************/
		
		/*****��ȡԱ������************************/
		Set<Empwelfare> ews=emp.getEmpwelfares();
		if(ews!=null&&ews.size()>0){
			Integer[] wids=new Integer[ews.size()];
			int i=0;//�����±�
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
