package com.bean;

import java.io.Serializable;
import java.util.*;
public class PageBean implements Serializable {
	private int page=1;//当前页数
	private int rows=5;//每页显示的记录数
	private int maxpage=1;//总页数
	private List<?> pagelist;//当前记录的集合  ?===T泛型 所有非Object类型
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public List<?> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<?> pagelist) {
		this.pagelist = pagelist;
	}
	
}
