package com.po;

/**
 * Empwelfare entity. @author MyEclipse Persistence Tools
 */

public class Empwelfare implements java.io.Serializable {

	// Fields

	private Integer ewid;
	private Emp emp;
	private Welfare welfare;

	// Constructors

	/** default constructor */
	public Empwelfare() {
	}

	/** full constructor */
	public Empwelfare(Emp emp, Welfare welfare) {
		this.emp = emp;
		this.welfare = welfare;
	}

	// Property accessors

	public Integer getEwid() {
		return this.ewid;
	}

	public void setEwid(Integer ewid) {
		this.ewid = ewid;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Welfare getWelfare() {
		return this.welfare;
	}

	public void setWelfare(Welfare welfare) {
		this.welfare = welfare;
	}

}