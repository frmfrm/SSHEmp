package com.po;

import java.util.HashSet;
import java.util.Set;

/**
 * Welfare entity. @author MyEclipse Persistence Tools
 */

public class Welfare implements java.io.Serializable {

	// Fields

	private Integer wid;
	private String wname;
	private Set empwelfares = new HashSet(0);

	// Constructors

	/** default constructor */
	public Welfare() {
	}

	/** minimal constructor */
	public Welfare(String wname) {
		this.wname = wname;
	}

	/** full constructor */
	public Welfare(String wname, Set empwelfares) {
		this.wname = wname;
		this.empwelfares = empwelfares;
	}

	// Property accessors

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public Set getEmpwelfares() {
		return this.empwelfares;
	}

	public void setEmpwelfares(Set empwelfares) {
		this.empwelfares = empwelfares;
	}

}