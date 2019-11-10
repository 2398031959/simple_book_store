package com.lei.po;

public class User {
	private Integer uid;

	private String uname;

	private String upwd;

	private Integer uidentity;
	
	private User_identity identity;

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", uidentity=" + uidentity + ", identity=" + identity + "]";
	}

	public User_identity getIdentity() {
		return identity;
	}

	public void setIdentity(User_identity identity) {
		this.identity = identity;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname == null ? null : uname.trim();
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd == null ? null : upwd.trim();
	}

	public Integer getUidentity() {
		return uidentity;
	}

	public void setUidentity(Integer uidentity) {
		this.uidentity = uidentity;
	}
}