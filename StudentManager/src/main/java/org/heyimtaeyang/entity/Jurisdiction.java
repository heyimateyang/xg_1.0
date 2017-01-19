package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Jurisdiction entity. @author MyEclipse Persistence Tools
 */

public class Jurisdiction implements java.io.Serializable {

	// Fields

	private Integer jurisdictionId;
	private String jurisdictionName;
	private Set students = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set admins = new HashSet(0);
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Jurisdiction() {
	}

	/** full constructor */
	public Jurisdiction(String jurisdictionName, Set students, Set teachers,
			Set admins, Set userses) {
		this.jurisdictionName = jurisdictionName;
		this.students = students;
		this.teachers = teachers;
		this.admins = admins;
		this.userses = userses;
	}

	// Property accessors

	public Integer getJurisdictionId() {
		return this.jurisdictionId;
	}

	public void setJurisdictionId(Integer jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}

	public String getJurisdictionName() {
		return this.jurisdictionName;
	}

	public void setJurisdictionName(String jurisdictionName) {
		this.jurisdictionName = jurisdictionName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getAdmins() {
		return this.admins;
	}

	public void setAdmins(Set admins) {
		this.admins = admins;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}