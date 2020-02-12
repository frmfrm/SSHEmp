package com.biz;

import java.util.List;

import com.po.Dep;

public interface DepBiz {
	public List<Dep> findAll();	
	public boolean save(Dep  dep);
	public boolean delById(Integer id);
}
