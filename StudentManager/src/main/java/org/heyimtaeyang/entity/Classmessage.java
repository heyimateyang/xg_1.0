package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classmessage entity. @author MyEclipse Persistence Tools
 */

public class Classmessage implements java.io.Serializable {

	// Fields

	private Integer classmessageId;
	private College college;
	private Grade grade;
	private Teacher teacher;
	private Profession profession;
	private String classmessagehonor;
	private String classmessageName;
	private String slogan;
	private Integer classQqnumber;
	private String classmessageGradeName;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classmessage() {
	}

	/** full constructor */
	public Classmessage(College college, Grade grade, Teacher teacher,
			Profession profession, String classmessagehonor,
			String classmessageName, String slogan, Integer classQqnumber,
			String classmessageGradeName, Set students) {
		this.college = college;
		this.grade = grade;
		this.teacher = teacher;
		this.profession = profession;
		this.classmessagehonor = classmessagehonor;
		this.classmessageName = classmessageName;
		this.slogan = slogan;
		this.classQqnumber = classQqnumber;
		this.classmessageGradeName = classmessageGradeName;
		this.students = students;
	}

	// Property accessors

	public Integer getClassmessageId() {
		return this.classmessageId;
	}

	public void setClassmessageId(Integer classmessageId) {
		this.classmessageId = classmessageId;
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

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Profession getProfession() {
		return this.profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getClassmessagehonor() {
		return this.classmessagehonor;
	}

	public void setClassmessagehonor(String classmessagehonor) {
		this.classmessagehonor = classmessagehonor;
	}

	public String getClassmessageName() {
		return this.classmessageName;
	}

	public void setClassmessageName(String classmessageName) {
		this.classmessageName = classmessageName;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Integer getClassQqnumber() {
		return this.classQqnumber;
	}

	public void setClassQqnumber(Integer classQqnumber) {
		this.classQqnumber = classQqnumber;
	}

	public String getClassmessageGradeName() {
		return this.classmessageGradeName;
	}

	public void setClassmessageGradeName(String classmessageGradeName) {
		this.classmessageGradeName = classmessageGradeName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}