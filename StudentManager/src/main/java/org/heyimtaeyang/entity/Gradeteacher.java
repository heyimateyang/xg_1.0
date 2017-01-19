package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Gradeteacher entity. @author MyEclipse Persistence Tools
 */

public class Gradeteacher implements java.io.Serializable {

	// Fields

	private Integer gradeteacherId;
	private College college;
	private Grade grade;
	private Users users;
	private String gradeteacherName;
	private Integer gradeteacherQqnumber;
	private String address;
	private Integer gradeteacherPhone;
	private String headportrait;
	private Integer workNumber;
	private Set teachermessages = new HashSet(0);
	private Set teacherreplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Gradeteacher() {
	}

	/** full constructor */
	public Gradeteacher(College college, Grade grade, Users users,
			String gradeteacherName, Integer gradeteacherQqnumber,
			String address, Integer gradeteacherPhone, String headportrait,
			Integer workNumber, Set teachermessages, Set teacherreplies) {
		this.college = college;
		this.grade = grade;
		this.users = users;
		this.gradeteacherName = gradeteacherName;
		this.gradeteacherQqnumber = gradeteacherQqnumber;
		this.address = address;
		this.gradeteacherPhone = gradeteacherPhone;
		this.headportrait = headportrait;
		this.workNumber = workNumber;
		this.teachermessages = teachermessages;
		this.teacherreplies = teacherreplies;
	}

	// Property accessors

	public Integer getGradeteacherId() {
		return this.gradeteacherId;
	}

	public void setGradeteacherId(Integer gradeteacherId) {
		this.gradeteacherId = gradeteacherId;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getGradeteacherName() {
		return this.gradeteacherName;
	}

	public void setGradeteacherName(String gradeteacherName) {
		this.gradeteacherName = gradeteacherName;
	}

	public Integer getGradeteacherQqnumber() {
		return this.gradeteacherQqnumber;
	}

	public void setGradeteacherQqnumber(Integer gradeteacherQqnumber) {
		this.gradeteacherQqnumber = gradeteacherQqnumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getGradeteacherPhone() {
		return this.gradeteacherPhone;
	}

	public void setGradeteacherPhone(Integer gradeteacherPhone) {
		this.gradeteacherPhone = gradeteacherPhone;
	}

	public String getHeadportrait() {
		return this.headportrait;
	}

	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
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

}