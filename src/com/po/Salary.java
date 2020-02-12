package com.po;

/**
 * Salary entity. @author MyEclipse Persistence Tools
 */

public class Salary implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Emp emp;
	private Float emoney;

	// Constructors

	/** default constructor */
	public Salary() {
	}

	/** minimal constructor */
	public Salary(Emp emp) {
		this.emp = emp;
	}

	/** full constructor */
	public Salary(Emp emp, Float emoney) {
		this.emp = emp;
		this.emoney = emoney;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Float getEmoney() {
		return this.emoney;
	}

	public void setEmoney(Float emoney) {
		this.emoney = emoney;
	}

}