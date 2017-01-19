package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Teachermessage entity. @author MyEclipse Persistence Tools
 */

public class Teachermessage implements java.io.Serializable {

	// Fields

	private Integer teacherMessageId;
	private Gradeteacher gradeteacher;
	private Student student;
	private Teacher teacher;
	private String teacherMessageDate;
	private String teacherMessage;
	private String teacherMessageTitle;
	private Integer state;
	private Set teacherreplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teachermessage() {
	}

	/** full constructor */
	public Teachermessage(Gradeteacher gradeteacher, Student student,
			Teacher teacher, String teacherMessageDate, String teacherMessage,
			String teacherMessageTitle, Integer state, Set teacherreplies) {
		this.gradeteacher = gradeteacher;
		this.student = student;
		this.teacher = teacher;
		this.teacherMessageDate = teacherMessageDate;
		this.teacherMessage = teacherMessage;
		this.teacherMessageTitle = teacherMessageTitle;
		this.state = state;
		this.teacherreplies = teacherreplies;
	}

	// Property accessors

	public Integer getTeacherMessageId() {
		return this.teacherMessageId;
	}

	public void setTeacherMessageId(Integer teacherMessageId) {
		this.teacherMessageId = teacherMessageId;
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

	public String getTeacherMessageDate() {
		return this.teacherMessageDate;
	}

	public void setTeacherMessageDate(String teacherMessageDate) {
		this.teacherMessageDate = teacherMessageDate;
	}

	public String getTeacherMessage() {
		return this.teacherMessage;
	}

	public void setTeacherMessage(String teacherMessage) {
		this.teacherMessage = teacherMessage;
	}

	public String getTeacherMessageTitle() {
		return this.teacherMessageTitle;
	}

	public void setTeacherMessageTitle(String teacherMessageTitle) {
		this.teacherMessageTitle = teacherMessageTitle;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getTeacherreplies() {
		return this.teacherreplies;
	}

	public void setTeacherreplies(Set teacherreplies) {
		this.teacherreplies = teacherreplies;
	}

}