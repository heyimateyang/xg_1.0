package org.heyimtaeyang.entity;

/**
 * Achievement entity. @author MyEclipse Persistence Tools
 */

public class Achievement implements java.io.Serializable {

	// Fields

	private Integer achievementId;
	private Student student;
	private Integer achievementScore;
	private String achievementName;

	// Constructors

	/** default constructor */
	public Achievement() {
	}

	/** full constructor */
	public Achievement(Student student, Integer achievementScore,
			String achievementName) {
		this.student = student;
		this.achievementScore = achievementScore;
		this.achievementName = achievementName;
	}

	// Property accessors

	public Integer getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getAchievementScore() {
		return this.achievementScore;
	}

	public void setAchievementScore(Integer achievementScore) {
		this.achievementScore = achievementScore;
	}

	public String getAchievementName() {
		return this.achievementName;
	}

	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}

}