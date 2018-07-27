package kr.or.ddit.posts.model;

import java.util.Date;

public class PostVo {
	private String post_code;	
	private Date   post_reg_dt;	
	private String post_dlt	;
	private String post_ttl	;
	private String post_ctt	;
	private String board_code;	
	private String std_id;
	private String post_super;
	private String post_group;
	
	public PostVo() {
	}
	
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public Date getPost_reg_dt() {
		return post_reg_dt;
	}
	public void setPost_reg_dt(Date post_reg_dt) {
		this.post_reg_dt = post_reg_dt;
	}
	public String getPost_dlt() {
		return post_dlt;
	}
	public void setPost_dlt(String post_dlt) {
		this.post_dlt = post_dlt;
	}
	public String getPost_ttl() {
		return post_ttl;
	}
	public void setPost_ttl(String post_ttl) {
		this.post_ttl = post_ttl;
	}
	public String getPost_ctt() {
		return post_ctt;
	}
	public void setPost_ctt(String post_ctt) {
		this.post_ctt = post_ctt;
	}
	public String getBoard_code() {
		return board_code;
	}
	public void setBoard_code(String board_code) {
		this.board_code = board_code;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getPost_super() {
		return post_super;
	}
	public void setPost_super(String post_super) {
		this.post_super = post_super;
	}
	public String getPost_group() {
		return post_group;
	}
	public void setPost_group(String post_group) {
		this.post_group = post_group;
	}
	@Override
	public String toString() {
		return "PostVo [post_code=" + post_code + ", post_reg_dt="
				+ post_reg_dt + ", post_dlt=" + post_dlt + ", post_ttl="
				+ post_ttl + ", post_ctt=" + post_ctt + ", board_code="
				+ board_code + ", std_id=" + std_id + ", post_super="
				+ post_super + ", post_group=" + post_group + "]";
	}
	
	
	
}
