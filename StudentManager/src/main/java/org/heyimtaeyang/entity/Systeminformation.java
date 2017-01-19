package org.heyimtaeyang.entity;

/**
 * Systeminformation entity. @author MyEclipse Persistence Tools
 */

public class Systeminformation implements java.io.Serializable {

	// Fields

	private Integer informationId;
	private String informationMessage;
	private String informationDate;
	private String informationTitle;

	// Constructors

	/** default constructor */
	public Systeminformation() {
	}

	/** full constructor */
	public Systeminformation(String informationMessage, String informationDate,
			String informationTitle) {
		this.informationMessage = informationMessage;
		this.informationDate = informationDate;
		this.informationTitle = informationTitle;
	}

	// Property accessors

	public Integer getInformationId() {
		return this.informationId;
	}

	public void setInformationId(Integer informationId) {
		this.informationId = informationId;
	}

	public String getInformationMessage() {
		return this.informationMessage;
	}

	public void setInformationMessage(String informationMessage) {
		this.informationMessage = informationMessage;
	}

	public String getInformationDate() {
		return this.informationDate;
	}

	public void setInformationDate(String informationDate) {
		this.informationDate = informationDate;
	}

	public String getInformationTitle() {
		return this.informationTitle;
	}

	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}

}