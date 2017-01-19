package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Political entity. @author MyEclipse Persistence Tools
 */

public class Political implements java.io.Serializable {

	// Fields

	private Integer politicallandscapeId;
	private String politicallandscape;
	private Integer politicallandscapestate;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Political() {
	}

	/** full constructor */
	public Political(String politicallandscape,
			Integer politicallandscapestate, Set students) {
		this.politicallandscape = politicallandscape;
		this.politicallandscapestate = politicallandscapestate;
		this.students = students;
	}

	// Property accessors

	public Integer getPoliticallandscapeId() {
		return this.politicallandscapeId;
	}

	public void setPoliticallandscapeId(Integer politicallandscapeId) {
		this.politicallandscapeId = politicallandscapeId;
	}

	public String getPoliticallandscape() {
		return this.politicallandscape;
	}

	public void setPoliticallandscape(String politicallandscape) {
		this.politicallandscape = politicallandscape;
	}

	public Integer getPoliticallandscapestate() {
		return this.politicallandscapestate;
	}

	public void setPoliticallandscapestate(Integer politicallandscapestate) {
		this.politicallandscapestate = politicallandscapestate;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}