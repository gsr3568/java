package com.test.dao;

import java.io.Serializable;

public class PersonDTO implements Serializable {
	
	@Override
	public String toString() {
		return "PersonDTO [pid=" + pid + ", fname=" + fname + ", lname="
				+ lname + ", address=" + address + ", city=" + city
				+ ", phone=" + phone + "]";
	}
	private int pid;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String phone;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public PersonDTO(int pid, String fname, String lname, String address,
			String city) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
	}
	public PersonDTO() {
		super();
	}
	
	
	

}
