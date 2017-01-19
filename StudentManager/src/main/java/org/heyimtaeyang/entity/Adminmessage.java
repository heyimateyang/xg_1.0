package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Adminmessage entity. @author MyEclipse Persistence Tools
 */

public class Adminmessage implements java.io.Serializable {

	// Fields

	private Integer systermMessageId;
	private Admin admin;
	private Student student;
	private String systemDate;
	private String systemMessage;
	private String messageTitle;
	private Integer state;
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Adminmessage() {
	}

	/** full constructor */
	public Adminmessage(Admin admin, Student student, String systemDate,
			String systemMessage, String messageTitle, Integer state,
			Set replies) {
		this.admin = admin;
		this.student = student;
		this.systemDate = systemDate;
		this.systemMessage = systemMessage;
		this.messageTitle = messageTitle;
		this.state = state;
		this.replies = replies;
	}

	// Property accessors

	public Integer getSystermMessageId() {
		return this.systermMessageId;
	}

	public void setSystermMessageId(Integer systermMessageId) {
		this.systermMessageId = systermMessageId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSystemDate() {
		return this.systemDate;
	}

	public void setSystemDate(String systemDate) {
		this.systemDate = systemDate;
	}

	public String getSystemMessage() {
		return this.systemMessage;
	}

	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}

	public String getMessageTitle() {
		return this.messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

}