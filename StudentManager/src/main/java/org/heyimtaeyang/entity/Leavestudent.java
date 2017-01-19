package org.heyimtaeyang.entity;

/**
 * Leavestudent entity. @author MyEclipse Persistence Tools
 */

public class Leavestudent implements java.io.Serializable {

	// Fields

	private Integer leaveId;
	private Student student;
	private String leaveContent;
	private String leaveBeginTime;
	private String leaveEndTime;
	private String leaveTime;
	private Integer leaveState;

	// Constructors

	/** default constructor */
	public Leavestudent() {
	}

	/** full constructor */
	public Leavestudent(Student student, String leaveContent,
			String leaveBeginTime, String leaveEndTime, String leaveTime,
			Integer leaveState) {
		this.student = student;
		this.leaveContent = leaveContent;
		this.leaveBeginTime = leaveBeginTime;
		this.leaveEndTime = leaveEndTime;
		this.leaveTime = leaveTime;
		this.leaveState = leaveState;
	}

	// Property accessors

	public Integer getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getLeaveContent() {
		return this.leaveContent;
	}

	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}

	public String getLeaveBeginTime() {
		return this.leaveBeginTime;
	}

	public void setLeaveBeginTime(String leaveBeginTime) {
		this.leaveBeginTime = leaveBeginTime;
	}

	public String getLeaveEndTime() {
		return this.leaveEndTime;
	}

	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}

	public String getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Integer getLeaveState() {
		return this.leaveState;
	}

	public void setLeaveState(Integer leaveState) {
		this.leaveState = leaveState;
	}

}