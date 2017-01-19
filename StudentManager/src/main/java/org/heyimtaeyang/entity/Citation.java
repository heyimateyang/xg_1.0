package org.heyimtaeyang.entity;

/**
 * Citation entity. @author MyEclipse Persistence Tools
 */

public class Citation implements java.io.Serializable {

	// Fields

	private Integer citationId;
	private Student student;
	private String citationlevel;
	private String citationTitle;
	private String citationDate;
	private String citationImg;
	private Integer state;
	private String citationMessage;
	private String citationName;

	// Constructors

	/** default constructor */
	public Citation() {
	}

	/** full constructor */
	public Citation(Student student, String citationlevel,
			String citationTitle, String citationDate, String citationImg,
			Integer state, String citationMessage, String citationName) {
		this.student = student;
		this.citationlevel = citationlevel;
		this.citationTitle = citationTitle;
		this.citationDate = citationDate;
		this.citationImg = citationImg;
		this.state = state;
		this.citationMessage = citationMessage;
		this.citationName = citationName;
	}

	// Property accessors

	public Integer getCitationId() {
		return this.citationId;
	}

	public void setCitationId(Integer citationId) {
		this.citationId = citationId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getCitationlevel() {
		return this.citationlevel;
	}

	public void setCitationlevel(String citationlevel) {
		this.citationlevel = citationlevel;
	}

	public String getCitationTitle() {
		return this.citationTitle;
	}

	public void setCitationTitle(String citationTitle) {
		this.citationTitle = citationTitle;
	}

	public String getCitationDate() {
		return this.citationDate;
	}

	public void setCitationDate(String citationDate) {
		this.citationDate = citationDate;
	}

	public String getCitationImg() {
		return this.citationImg;
	}

	public void setCitationImg(String citationImg) {
		this.citationImg = citationImg;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCitationMessage() {
		return this.citationMessage;
	}

	public void setCitationMessage(String citationMessage) {
		this.citationMessage = citationMessage;
	}

	public String getCitationName() {
		return this.citationName;
	}

	public void setCitationName(String citationName) {
		this.citationName = citationName;
	}

}