package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private College college;
	private Users users;
	private Grade grade;
	private Jurisdiction jurisdiction;
	private String teacherName;
	private Integer teacherPhone;
	private Integer teacherQq;
	private String teacherAddress;
	private String headportrait;
	private Integer classmessageId;
	private Integer workNumber;
	private Set teachermessages = new HashSet(0);
	private Set teacherreplies = new HashSet(0);
	private Set classmessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(College college, Users users, Grade grade,
			Jurisdiction jurisdiction, String teacherName,
			Integer teacherPhone, Integer teacherQq, String teacherAddress,
			String headportrait, Integer classmessageId, Integer workNumber,
			Set teachermessages, Set teacherreplies, Set classmessages) {
		this.college = college;
		this.users = users;
		this.grade = grade;
		this.jurisdiction = jurisdiction;
		this.teacherName = teacherName;
		this.teacherPhone = teacherPhone;
		this.teacherQq = teacherQq;
		this.teacherAddress = teacherAddress;
		this.headportrait = headportrait;
		this.classmessageId = classmessageId;
		this.workNumber = workNumber;
		this.teachermessages = teachermessages;
		this.teacherreplies = teacherreplies;
		this.classmessages = classmessages;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Jurisdiction getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getTeacherPhone() {
		return this.teacherPhone;
	}

	public void setTeacherPhone(Integer teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public Integer getTeacherQq() {
		return this.teacherQq;
	}

	public void setTeacherQq(Integer teacherQq) {
		this.teacherQq = teacherQq;
	}

	public String getTeacherAddress() {
		return this.teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getHeadportrait() {
		return this.headportrait;
	}

	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}

	public Integer getClassmessageId() {
		return this.classmessageId;
	}

	public void setClassmessageId(Integer classmessageId) {
		this.classmessageId = classmessageId;
	}

	public Integer getWorkNumber() {
		return this.workNumber;
	}

	public void setWorkNumber(Integer workNumber) {
		this.workNumber = workNumber;
	}

	public Set getTeachermessages() {
		return this.teachermessages;
	}

	public void setTeachermessages(Set teachermessages) {
		this.teachermessages = teachermessages;
	}

	public Set getTeacherreplies() {
		return this.teacherreplies;
	}

	public void setTeacherreplies(Set teacherreplies) {
		this.teacherreplies = teacherreplies;
	}

	public Set getClassmessages() {
		return this.classmessages;
	}

	public void setClassmessages(Set classmessages) {
		this.classmessages = classmessages;
	}

}