package org.heyimtaeyang.entity;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Integer replyId;
	private Admin admin;
	private Adminmessage adminmessage;
	private Student student;
	private String replymessage;
	private String replyDate;
	private String replyTitle;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(Admin admin, Adminmessage adminmessage, Student student,
			String replymessage, String replyDate, String replyTitle) {
		this.admin = admin;
		this.adminmessage = adminmessage;
		this.student = student;
		this.replymessage = replymessage;
		this.replyDate = replyDate;
		this.replyTitle = replyTitle;
	}

	// Property accessors

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Adminmessage getAdminmessage() {
		return this.adminmessage;
	}

	public void setAdminmessage(Adminmessage adminmessage) {
		this.adminmessage = adminmessage;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getReplymessage() {
		return this.replymessage;
	}

	public void setReplymessage(String replymessage) {
		this.replymessage = replymessage;
	}

	public String getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyTitle() {
		return this.replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

}