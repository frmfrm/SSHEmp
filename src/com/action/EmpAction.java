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
		//获取上传文件的物理路径
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		/********************文件上传*******************************/
		//判断是否存在文件上传
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//获取上传文件的名称
			String fname = emp.getPicFileName();
			//判断文件是否存在后缀
			if(fname.lastIndexOf(".")!=-1){
				//获取后缀名称
				String ext=fname.substring(fname.lastIndexOf("."));
				//判断后缀是否为jpg
				if(ext.equalsIgnoreCase(".jpg")){
					//文件更名
					fname=new Date().getTime()+ext;
					
					//创建目标文件对象，指定文件的存放位置
					File destFile=new File(reapath+"/uppic/"+fname);
					
					try {
						//开始上传
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
		//获取上传文件的物理路径
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		//获取原来的员工照片名称
		String oldphoto=bizService.getEmpBiz().findById(emp.getEid()).getPhoto();
		
		/********************文件上传*******************************/
		//判断是否存在文件上传
		if(emp.getPic()!=null&&emp.getPic().length()>0){
			//获取上传文件的名称
			String fname = emp.getPicFileName();
			//判断文件是否存在后缀
			if(fname.lastIndexOf(".")!=-1){
				//获取后缀名称
				String ext=fname.substring(fname.lastIndexOf("."));
				//判断后缀是否为jpg
				if(ext.equalsIgnoreCase(".jpg")){
					//文件更名
					fname=new Date().getTime()+ext;
					
					//创建目标文件对象，指定文件的存放位置
					File destFile=new File(reapath+"/uppic/"+fname);
					
					try {
						//开始上传
						FileUtils.copyFile(emp.getPic(), destFile);
						emp.setPhoto(fname);
						
						/*****删除原来的照片*****/
						File oldfile=new File(reapath+"/uppic/"+oldphoto);
						if(oldfile.exists()&&!oldphoto.equals("default.jpg")){
							oldfile.delete();//删除原来照片
						  }
						/********************/
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}else{
			emp.setPhoto(oldphoto);//未更新照片，则设置原照片
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
		//获取上传文件的物理路径
		String reapath=ServletActionContext.getServletContext().getRealPath("/");
		//获取原来的员工照片名称
		String oldphoto=bizService.getEmpBiz().findById(eid).getPhoto();
				
		boolean flag=bizService.getEmpBiz().delById(eid);
		if(flag){
			/*****删除原来的照片*****/
			File oldfile=new File(reapath+"/uppic/"+oldphoto);
			if(oldfile.exists()&&!oldphoto.equals("default.jpg")){
				oldfile.delete();//删除原来照片
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
		/****初始化****************/
		List<Dep> lsdep=bizService.getDepBiz().findAll();
		List<Welfare> lswf=bizService.getWelfareBiz().findAll();
		
		session.setAttribute("lsdep",lsdep);
		session.setAttribute("lswf",lswf);
		/************************/
		
		//获取分页的实体对象
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		
		page=page<1?pb.getPage():page;
		rows=rows<1?pb.getRows():rows;
		
		//限制每页记录数不能超过20条
		if(rows>20)rows=20;
		
		//获取总记录数
		int maxrow=bizService.getEmpBiz().findMaxRow();
		int maxpage=1;//定义总页数值
		if(maxrow!=0){
			maxpage=maxrow%rows==0?maxrow/rows:maxrow/rows+1;
		}
		if(page>maxpage)page=maxpage;//限制当前页数不能超过最大页数
		
		//获取当前页的记录集合
		List<Emp> lsemp=bizService.getEmpBiz().findPageAll(page, rows);
		
		//封装分页数据
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
