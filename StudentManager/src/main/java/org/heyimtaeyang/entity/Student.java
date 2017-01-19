package org.heyimtaeyang.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private College college;
	private Classmessage classmessage;
	private Users users;
	private Grade grade;
	private Political political;
	private Jurisdiction jurisdiction;
	private Post post;
	private String headportrait;
	private String weChat;
	private String idcard;
	private String placeofBirth;
	private String weight;
	private String height;
	private String nation;
	private String studentName;
	private Long studentNumber;
	private String state;
	private String address;
	private Long qqNumber;
	private Long phoneNumber;
	private String homePhone;
	private String dateTime;
	private String sex;
	private String email;
	private String shcoolName;
	private String corporation;
	private String corporationpost;
	private String birthday;
	private String remarks;
	private String interest;
	private String dormitory;
	private Integer politicallandscapestate;
	private Integer poor;
	private Integer poorId;
	private Integer stateId;
	private Integer studentstate;
	private String studentGradeName;
	private Set teachermessages = new HashSet(0);
	private Set teacherreplies = new HashSet(0);
	private Set replies = new HashSet(0);
	private Set adminmessages = new HashSet(0);
	private Set citations = new HashSet(0);
	private Set leavestudents = new HashSet(0);
	private Set achievements = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(College college, Classmessage classmessage, Users users,
			Grade grade, Political political, Jurisdiction jurisdiction,
			Post post, String headportrait, String weChat, String idcard,
			String placeofBirth, String weight, String height, String nation,
			String studentName, Long studentNumber, String state,
			String address, Long qqNumber, Long phoneNumber, String homePhone,
			String dateTime, String sex, String email, String shcoolName,
			String corporation, String corporationpost, String birthday,
			String remarks, String interest, String dormitory,
			Integer politicallandscapestate, Integer poor, Integer poorId,
			Integer stateId, Integer studentstate, String studentGradeName,
			Set teachermessages, Set teacherreplies, Set replies,
			Set adminmessages, Set citations, Set leavestudents,
			Set achievements) {
		this.college = college;
		this.classmessage = classmessage;
		this.users = users;
		this.grade = grade;
		this.political = political;
		this.jurisdiction = jurisdiction;
		this.post = post;
		this.headportrait = headportrait;
		this.weChat = weChat;
		this.idcard = idcard;
		this.placeofBirth = placeofBirth;
		this.weight = weight;
		this.height = height;
		this.nation = nation;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.state = state;
		this.address = address;
		this.qqNumber = qqNumber;
		this.phoneNumber = phoneNumber;
		this.homePhone = homePhone;
		this.dateTime = dateTime;
		this.sex = sex;
		this.email = email;
		this.shcoolName = shcoolName;
		this.corporation = corporation;
		this.corporationpost = corporationpost;
		this.birthday = birthday;
		this.remarks = remarks;
		this.interest = interest;
		this.dormitory = dormitory;
		this.politicallandscapestate = politicallandscapestate;
		this.poor = poor;
		this.poorId = poorId;
		this.stateId = stateId;
		this.studentstate = studentstate;
		this.studentGradeName = studentGradeName;
		this.teachermessages = teachermessages;
		this.teacherreplies = teacherreplies;
		this.replies = replies;
		this.adminmessages = adminmessages;
		this.citations = citations;
		this.leavestudents = leavestudents;
		this.achievements = achievements;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public College getCollege() {
		return this.college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Classmessage getClassmessage() {
		return this.classmessage;
	}

	public void setClassmessage(Classmessage classmessage) {
		this.classmessage = classmessage;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Political getPolitical() {
		return this.political;
	}

	public void setPolitical(Political political) {
		this.political = political;
	}

	public Jurisdiction getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getHeadportrait() {
		return this.headportrait;
	}

	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}

	public String getWeChat() {
		return this.weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPlaceofBirth() {
		return this.placeofBirth;
	}

	public void setPlaceofBirth(String placeofBirth) {
		this.placeofBirth = placeofBirth;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getQqNumber() {
		return this.qqNumber;
	}

	public void setQqNumber(Long qqNumber) {
		this.qqNumber = qqNumber;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShcoolName() {
		return this.shcoolName;
	}

	public void setShcoolName(String shcoolName) {
		this.shcoolName = shcoolName;
	}

	public String getCorporation() {
		return this.corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCorporationpost() {
		return this.corporationpost;
	}

	public void setCorporationpost(String corporationpost) {
		this.corporationpost = corporationpost;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getDormitory() {
		return this.dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public Integer getPoliticallandscapestate() {
		return this.politicallandscapestate;
	}

	public void setPoliticallandscapestate(Integer politicallandscapestate) {
		this.politicallandscapestate = politicallandscapestate;
	}

	public Integer getPoor() {
		return this.poor;
	}

	public void setPoor(Integer poor) {
		this.poor = poor;
	}

	public Integer getPoorId() {
		return this.poorId;
	}

	public void setPoorId(Integer poorId) {
		this.poorId = poorId;
	}

	public Integer getStateId() {
		return this.stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getStudentstate() {
		return this.studentstate;
	}

	public void setStudentstate(Integer studentstate) {
		this.studentstate = studentstate;
	}

	public String getStudentGradeName() {
		return this.studentGradeName;
	}

	public void setStudentGradeName(String studentGradeName) {
		this.studentGradeName = studentGradeName;
	}

	public Set getTeachermessages() {
		return this.teachermessages;
	}

	public void setTeachermessages(Set teachermessages) {
		this.teachermessages = teachermessages;
	}

	public Set getTeacherreplies() {
		return this.teacherreplies;
	}

	public void setTeacherreplies(Set teacherreplies) {
		this.teacherreplies = teacherreplies;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

	public Set getAdminmessages() {
		return this.adminmessages;
	}

	public void setAdminmessages(Set adminmessages) {
		this.adminmessages = adminmessages;
	}

	public Set getCitations() {
		return this.citations;
	}

	public void setCitations(Set citations) {
		this.citations = citations;
	}

	public Set getLeavestudents() {
		return this.leavestudents;
	}

	public void setLeavestudents(Set leavestudents) {
		this.leavestudents = leavestudents;
	}

	public Set getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set achievements) {
		this.achievements = achievements;
	}

}