package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private Users users;
	private Jurisdiction jurisdiction;
	private String adminName;
	private Integer qqnumber;
	private Integer phone;
	private Set adminmessages = new HashSet(0);
	private Set replies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(Users users, Jurisdiction jurisdiction, String adminName,
			Integer qqnumber, Integer phone, Set adminmessages, Set replies) {
		this.users = users;
		this.jurisdiction = jurisdiction;
		this.adminName = adminName;
		this.qqnumber = qqnumber;
		this.phone = phone;
		this.adminmessages = adminmessages;
		this.replies = replies;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Jurisdiction getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getQqnumber() {
		return this.qqnumber;
	}

	public void setQqnumber(Integer qqnumber) {
		this.qqnumber = qqnumber;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Set getAdminmessages() {
		return this.adminmessages;
	}

	public void setAdminmessages(Set adminmessages) {
		this.adminmessages = adminmessages;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

}