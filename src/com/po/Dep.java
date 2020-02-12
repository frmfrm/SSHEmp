package com.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Dep entity. @author MyEclipse Persistence Tools
 */

public class Dep implements java.io.Serializable {

	// Fields

	private Integer depid;
	private String depname;
	private Set emps = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dep() {
	}

	/** minimal constructor */
	public Dep(String depname) {
		this.depname = depname;
	}

	/** full constructor */
	public Dep(String depname, Set emps) {
		this.depname = depname;
		this.emps = emps;
	}

	// Property accessors

	public Integer getDepid() {
		return this.depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	public String getDepname() {
		return this.depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Set getEmps() {
		return this.emps;
	}

	public void setEmps(Set emps) {
		this.emps = emps;
	}

}