package com.po;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private String passwd;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String aname, String passwd) {
		this.aname = aname;
		this.passwd = passwd;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}