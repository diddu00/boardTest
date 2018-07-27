package kr.or.ddit.attachments.model;

public class AttachmentVo {
	private String attach_code	;
	private String attach_path	;
	private String attach_nm	;
	private String attach_file	;
	private String post_code	;
	
	public AttachmentVo() {
 
	}

	public String getAttach_code() {
		return attach_code;
	}

	public void setAttach_code(String attach_code) {
		this.attach_code = attach_code;
	}

	public String getAttach_path() {
		return attach_path;
	}

	public void setAttach_path(String attach_path) {
		this.attach_path = attach_path;
	}

	public String getAttach_nm() {
		return attach_nm;
	}

	public void setAttach_nm(String attach_nm) {
		this.attach_nm = attach_nm;
	}

	public String getAttach_file() {
		return attach_file;
	}

	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	@Override
	public String toString() {
		return "AttachmentVo [attach_code=" + attach_code + ", attach_path="
				+ attach_path + ", attach_nm=" + attach_nm + ", attach_file="
				+ attach_file + ", post_code=" + post_code + "]";
	}
	
	
	
}
