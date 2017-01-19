package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College implements java.io.Serializable {

	// Fields

	private Integer collegeId;
	private String collegeName;
	private Set professions = new HashSet(0);
	private Set gradeteachers = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set students = new HashSet(0);
	private Set classmessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public College() {
	}

	/** full constructor */
	public College(String collegeName, Set professions, Set gradeteachers,
			Set teachers, Set students, Set classmessages) {
		this.collegeName = collegeName;
		this.professions = professions;
		this.gradeteachers = gradeteachers;
		this.teachers = teachers;
		this.students = students;
		this.classmessages = classmessages;
	}

	// Property accessors

	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Set getProfessions() {
		return this.professions;
	}

	public void setProfessions(Set professions) {
		this.professions = professions;
	}

	public Set getGradeteachers() {
		return this.gradeteachers;
	}

	public void setGradeteachers(Set gradeteachers) {
		this.gradeteachers = gradeteachers;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getClassmessages() {
		return this.classmessages;
	}

	public void setClassmessages(Set classmessages) {
		this.classmessages = classmessages;
	}

}