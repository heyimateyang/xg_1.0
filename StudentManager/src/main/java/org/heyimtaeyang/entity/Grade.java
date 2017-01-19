package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	private Integer gradeId;
	private String gradeName;
	private Set students = new HashSet(0);
	private Set gradeteachers = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set classmessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** full constructor */
	public Grade(String gradeName, Set students, Set gradeteachers,
			Set teachers, Set classmessages) {
		this.gradeName = gradeName;
		this.students = students;
		this.gradeteachers = gradeteachers;
		this.teachers = teachers;
		this.classmessages = classmessages;
	}

	// Property accessors

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
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

	public Set getClassmessages() {
		return this.classmessages;
	}

	public void setClassmessages(Set classmessages) {
		this.classmessages = classmessages;
	}

}