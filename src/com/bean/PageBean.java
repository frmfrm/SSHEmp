package com.bean;

import java.io.Serializable;
import java.util.*;
public class PageBean implements Serializable {
	private int page=1;//��ǰҳ��
	private int rows=5;//ÿҳ��ʾ�ļ�¼��
	private int maxpage=1;//��ҳ��
	private List<?> pagelist;//��ǰ��¼�ļ���  ?===T���� ���з�Object����
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
