package com.action;
import java.io.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bean.*;
import com.po.*;
import com.service.BizService;
import com.biz.DepBiz;
import com.biz.EmpBiz;
import com.biz.WelfareBiz;
import com.biz.imp.DepBizImp;
import com.biz.imp.EmpBizImp;
import com.biz.imp.WelfareBizImp;
public class EmpAction implements IAction {
	private Integer eid;
	private Emp emp;
	private String path;
	
	private int page;
	private int rows;
	
	private BizService bizService;
	
	
	
	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	

	public String save() {
		//��ȡ�ϴ��ļ�������·��
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		/********************�ļ��ϴ�*******************************/
		//�ж��Ƿ�����ļ��ϴ�
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//��ȡ�ϴ��ļ�������
			String fname = emp.getPicFileName();
			//�ж��ļ��Ƿ���ں�׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺����
				String ext=fname.substring(fname.lastIndexOf("."));
				//�жϺ�׺�Ƿ�Ϊjpg
				if(ext.equalsIgnoreCase(".jpg")){
					//�ļ�����
					fname=new Date().getTime()+ext;
					
					//����Ŀ���ļ�����ָ���ļ��Ĵ��λ��
					File destFile=new File(reapath+"/uppic/"+fname);
					
					try {
						//��ʼ�ϴ�
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(fname);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		/*********************************************************/
		
		boolean flag=bizService.getEmpBiz().save(emp);
		if(flag){
			emp=null;
			path="findAll_Emp";
			return "ok";
		}
		return "fail";
	}

	public String update() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		//��ȡ�ϴ��ļ�������·��
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		//��ȡԭ����Ա����Ƭ����
		String oldphoto=bizService.getEmpBiz().findById(emp.getEid()).getPhoto();
		
		/********************�ļ��ϴ�*******************************/
		//�ж��Ƿ�����ļ��ϴ�
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//��ȡ�ϴ��ļ�������
			String fname = emp.getPicFileName();
			//�ж��ļ��Ƿ���ں�׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺����
				String ext=fname.substring(fname.lastIndexOf("."));
				//�жϺ�׺�Ƿ�Ϊjpg
				if(ext.equalsIgnoreCase(".jpg")){
					//�ļ�����
					fname=new Date().getTime()+ext;
					
					//����Ŀ���ļ�����ָ���ļ��Ĵ��λ��
					File destFile=new File(reapath+"/uppic/"+fname);
					
					try {
						//��ʼ�ϴ�
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(fname);
						
						/*****ɾ��ԭ������Ƭ*****/
						File oldfile=new File(reapath+"/uppic/"+oldphoto);
						if(oldfile.exists()&&!oldphoto.equals("default.jpg")){
							oldfile.delete();//ɾ��ԭ����Ƭ
						  }
						/********************/
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else{
			emp.setPhoto(oldphoto);//δ������Ƭ��������ԭ��Ƭ
		}
		/*********************************************************/
		
		
		boolean flag=bizService.getEmpBiz().update(emp);
		if(flag){
			session.removeAttribute("oldemp");
			emp=null;
			path="findAll_Emp";
			return "ok";
		}
		return "fail";
	}

	public String delById() {
		//��ȡ�ϴ��ļ�������·��
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		//��ȡԭ����Ա����Ƭ����
		String oldphoto=bizService.getEmpBiz().findById(eid).getPhoto();
				
		boolean flag=bizService.getEmpBiz().delById(eid);
		if(flag){
			/*****ɾ��ԭ������Ƭ*****/
			File oldfile=new File(reapath+"/uppic/"+oldphoto);
			if(oldfile.exists()&&!oldphoto.equals("default.jpg")){
				oldfile.delete();//ɾ��ԭ����Ƭ
			}
			/********************/
			path="findAll_Emp";
			return "ok";
		}
		return "fail";
	}
	

	public String findById() {
		Emp oldemp=bizService.getEmpBiz().findById(eid);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("oldemp",oldemp);
		path="empupdate.jsp";
		return "ok";
	}
	public String findDetail() {
		Emp demp=bizService.getEmpBiz().findById(eid);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("demp",demp);
		path="empdetail.jsp";
		return "ok";
	}

	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		/****��ʼ��****************/
		List<Dep> lsdep=bizService.getDepBiz().findAll();
		List<Welfare> lswf=bizService.getWelfareBiz().findAll();
		
		session.setAttribute("lsdep",lsdep);
		session.setAttribute("lswf",lswf);
		/************************/
		
		//��ȡ��ҳ��ʵ�����
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page<1?pb.getPage():page;
		rows=rows<1?pb.getRows():rows;
		
		//����ÿҳ��¼�����ܳ���20��
		if(rows>20)rows=20;
		
		//��ȡ�ܼ�¼��
		int maxrow=bizService.getEmpBiz().findMaxRow();
		int maxpage=1;//������ҳ��ֵ
		if(maxrow!=0){
			maxpage=maxrow%rows==0?maxrow/rows:maxrow/rows+1;
		}
		if(page>maxpage)page=maxpage;//���Ƶ�ǰҳ�����ܳ������ҳ��
		
		//��ȡ��ǰҳ�ļ�¼����
		List<Emp> lsemp=bizService.getEmpBiz().findPageAll(page, rows);
		
		//��װ��ҳ����
		pb.setPage(page);
		pb.setRows(rows);
		pb.setMaxpage(maxpage);
		pb.setPagelist(lsemp);
		
		session.setAttribute("pb", pb);
		path="emplist.jsp";
		return "ok";
	}

	public String doinit() {
		System.out.println("doinit.....");
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		List<Dep> lsdep=bizService.getDepBiz().findAll();
		List<Welfare> lswf=bizService.getWelfareBiz().findAll();
		
		session.setAttribute("lsdep",lsdep);
		session.setAttribute("lswf",lswf);
		path="empadd.jsp";
		return "ok";
	}

}
