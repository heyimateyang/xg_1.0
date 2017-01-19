package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {

	// Fields

	private Integer postId;
	private String postName;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** full constructor */
	public Post(String postName, Set students) {
		this.postName = postName;
		this.students = students;
	}

	// Property accessors

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}