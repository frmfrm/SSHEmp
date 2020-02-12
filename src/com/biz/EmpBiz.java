package com.biz;

import java.util.List;

import com.po.Emp;

public interface EmpBiz {
	public boolean save(Emp emp);
	public boolean update(Emp emp);
	public boolean delById(Integer eid);
	public Emp findById(Integer eid);
	public List<Emp> findPageAll(int page,int rows);
	public int findMaxRow();
}
