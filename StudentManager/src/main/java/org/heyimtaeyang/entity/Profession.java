package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Profession entity. @author MyEclipse Persistence Tools
 */

public class Profession implements java.io.Serializable {

	// Fields

	private Integer professionId;
	private College college;
	private String professionName;
	private Set classmessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Profession() {
	}

	/** full constructor */
	public Profession(College college, String professionName, Set classmessages) {
		this.college = college;
		this.professionName = professionName;
		this.classmessages = classmessages;
	}

	// Property accessors

	public Integer getProfessionId() {
		return this.professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getProfessionName() {
		return this.professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public Set getClassmessages() {
		return this.classmessages;
	}

	public void setClassmessages(Set classmessages) {
		this.classmessages = classmessages;
	}

}