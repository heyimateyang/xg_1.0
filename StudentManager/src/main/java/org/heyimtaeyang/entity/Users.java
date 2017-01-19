package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Jurisdiction jurisdiction;
	private String userName;
	private String userPwd;
	private Set gradeteachers = new HashSet(0);
	private Set students = new HashSet(0);
	private Set admins = new HashSet(0);
	private Set teachers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Jurisdiction jurisdiction, String userName, String userPwd,
			Set gradeteachers, Set students, Set admins, Set teachers) {
		this.jurisdiction = jurisdiction;
		this.userName = userName;
		this.userPwd = userPwd;
		this.gradeteachers = gradeteachers;
		this.students = students;
		this.admins = admins;
		this.teachers = teachers;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Jurisdiction getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set getGradeteachers() {
		return this.gradeteachers;
	}

	public void setGradeteachers(Set gradeteachers) {
		this.gradeteachers = gradeteachers;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set admins) {
		this.admins = admins;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

}