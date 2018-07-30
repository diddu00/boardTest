package kr.or.ddit.comments.model;

import java.util.Date;

public class CommentVo {
	private String comment_code	;
	private String comment_ctt	;
	private Date comment_reg_dt	;
	private String post_code	;
	private String std_id;
	
	public CommentVo() {

	}
	
	
	public String getStd_id() {
		return std_id;
	}


	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}


	public String getComment_code() {
		return comment_code;
	}
	public void setComment_code(String comment_code) {
		this.comment_code = comment_code;
	}
	public String getComment_ctt() {
		return comment_ctt;
	}
	public void setComment_ctt(String comment_ctt) {
		this.comment_ctt = comment_ctt;
	}
	public Date getComment_reg_dt() {
		return comment_reg_dt;
	}
	public void setComment_reg_dt(Date comment_reg_dt) {
		this.comment_reg_dt = comment_reg_dt;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}


	@Override
	public String toString() {
		return "CommentVo [comment_code=" + comment_code + ", comment_ctt="
				+ comment_ctt + ", comment_reg_dt=" + comment_reg_dt
				+ ", post_code=" + post_code + ", std_id=" + std_id + "]";
	}
	
	
	
	
	
}
