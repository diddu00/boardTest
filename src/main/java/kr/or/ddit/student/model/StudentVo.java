package kr.or.ddit.student.model;

import java.util.Date;

public class StudentVo {
	private String std_id;	
	private int id;
	private String name;
	private int call_count;
	private Date reg_dt;
	private String add1;
	private String add2;	
	private String zipcd;	
	private String pic;	
	private String picpath;	
	private String picname;
	private String pass;
	
	
	public StudentVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentVo [std_id=" + std_id + ", id=" + id + ", name=" + name
				+ ", call_count=" + call_count + ", reg_dt=" + reg_dt
				+ ", add1=" + add1 + ", add2=" + add2 + ", zipcd=" + zipcd
				+ ", pic=" + pic + ", picpath=" + picpath + ", picname="
				+ picname + ", pass=" + pass + "]";
	}

	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCall_count() {
		return call_count;
	}
	public void setCall_count(int call_count) {
		this.call_count = call_count;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
