package org.heyimtaeyang.entity;

/**
 * Teacherreply entity. @author MyEclipse Persistence Tools
 */

public class Teacherreply implements java.io.Serializable {

	// Fields

	private Integer teacherReplyId;
	private Teachermessage teachermessage;
	private Gradeteacher gradeteacher;
	private Student student;
	private Teacher teacher;
	private String replymessage;
	private String replyDate;
	private String replyTitle;

	// Constructors

	/** default constructor */
	public Teacherreply() {
	}

	/** full constructor */
	public Teacherreply(Teachermessage teachermessage,
			Gradeteacher gradeteacher, Student student, Teacher teacher,
			String replymessage, String replyDate, String replyTitle) {
		this.teachermessage = teachermessage;
		this.gradeteacher = gradeteacher;
		this.student = student;
		this.teacher = teacher;
		this.replymessage = replymessage;
		this.replyDate = replyDate;
		this.replyTitle = replyTitle;
	}

	// Property accessors

	public Integer getTeacherReplyId() {
		return this.teacherReplyId;
	}

	public void setTeacherReplyId(Integer teacherReplyId) {
		this.teacherReplyId = teacherReplyId;
	}

	public Teachermessage getTeachermessage() {
		return this.teachermessage;
	}

	public void setTeachermessage(Teachermessage teachermessage) {
		this.teachermessage = teachermessage;
	}

	public Gradeteacher getGradeteacher() {
		return this.gradeteacher;
	}

	public void setGradeteacher(Gradeteacher gradeteacher) {
		this.gradeteacher = gradeteacher;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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