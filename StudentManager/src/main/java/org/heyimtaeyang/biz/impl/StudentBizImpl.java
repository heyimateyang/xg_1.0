package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.dao.StudentDao;
import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.dao.impl.StudentDaoImpl;
import org.heyimtaeyang.dao.impl.UsersDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Jurisdiction;
import org.heyimtaeyang.entity.Political;
import org.heyimtaeyang.entity.Post;
import org.heyimtaeyang.entity.Profession;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;

public class StudentBizImpl implements StudentBiz {

	//按id查找学生
	public Student findStudentById(int studentId) {
		String hql = "from Student as u where u.studentId="+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.findStudentById(hql);
		return student;
	}

	//按usersId查找学生信息
	public Student findStudentByUserId(int userId) {
		String sql = "select * from student where userId="+userId;
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.findStudentByUserId(sql);
		return student;
	}

	//模糊查询学生信息管理员年级辅导员
	public List<Student> findLikeStudent(String studentName,int classmessageId) {
		String sql = "select * from student  where studentName like '%"+studentName+"%' and gradeId="+classmessageId;
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.findLikeStudent(sql);
		return list;
	}

	//模糊查询学生信息年管理员
	public List<Student> findLikeStudent(String studentName) {
		String sql = "select * from student  where studentName like '%"+studentName+"%'";
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.findLikeStudent(sql);
		return list;
	}

	//模糊查询学生信息班级辅导员
	public List<Student> findLikeStudentTeacher(String studentName, int classmessageId) {
		/*ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findTeacherByTeacherId(teacherId);*/
		String sql 
			= "select * from student where studentName like '%"+studentName+"%' "+" and classmessageId="+classmessageId;
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.findLikeStudent(sql);
		return list;
	}

	//修改学生资料
	public Student updateStudent(int studentId,int userId,String studentName, String myFileFileName,
			String userPwd, Long phoneNumber, String homePhone, String email,
			String address,Long qqNumber)  {
		//SHA加密
		SHA sha = new SHA();
		
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		Users users = new Users();
		UsersDao usersDao = new UsersDaoImpl();
		UsersBiz usersBiz = new UsersBizImpl();
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(8);
		try {
			//查找该学生的用户表
			Users usersById = usersBiz.findUsersById(userId);
			
			users.setUserName(usersById.getUserName());
			users.setJurisdiction(jurisdiction);
			users.setUserPwd(sha.shaEncode(userPwd));
			users.setUserId(userId);
			
			//先查找该学生的其他信息
			Student studentById = studentDao.findStudentById("from Student as u where u.studentId="+studentId);
			
			student.setAddress(address);
			student.setDateTime(studentById.getDateTime());
			student.setEmail(email);
			student.setHeadportrait(myFileFileName);
			student.setQqNumber(qqNumber);
			student.setHomePhone(homePhone);
			student.setPhoneNumber(phoneNumber);
			student.setSex(studentById.getSex());
			student.setShcoolName(studentById.getShcoolName());
			student.setState(studentById.getState());
			student.setStudentId(studentId);
			student.setStudentName(studentName);
			student.setStudentNumber(studentById.getStudentNumber());
			
			
			student.setClassmessage(studentById.getClassmessage());
			student.setGrade(studentById.getGrade());
			student.setCollege(studentById.getCollege());
			//student.setProfession(studentById.getProfession());
			student.setJurisdiction(studentById.getJurisdiction());
			student.setUsers(users);
			
			int updayeId = usersDao.update_users(users);
			int updayeId2 = studentDao.updateStudent(student);
			if(updayeId!=0||updayeId2!=0){
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//添加学生信息
	public int addStudent(String userName, String userPwd, Long studentNumber,
			String shcoolName, int gradeName, String state, String dateTime,
			Long phoneNumber, String homePhone, Long qqNumber, String email,
			String address,String myFileFileName,String sex,String studentName,int JurisdictionId) {
		//SHA加密
		SHA sha = new SHA();
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		Users users = new Users();
		UsersDao usersDao = new UsersDaoImpl();
		Jurisdiction jurisdiction = new Jurisdiction();
		Grade grade = new Grade();
		try {
			grade.setGradeId(gradeName);
			
			student.setAddress(address);
			student.setDateTime(dateTime);
			student.setEmail(email);
			student.setGrade(grade);
			student.setHeadportrait(myFileFileName);
			student.setHomePhone(homePhone);
			student.setPhoneNumber(phoneNumber);
			student.setQqNumber(qqNumber);
			student.setSex(sex);
			student.setShcoolName(shcoolName);
			student.setState(state);
			student.setStudentName(studentName);
			student.setStudentNumber(studentNumber);
			
			//添加用户表
			users.setUserName(userName);
			users.setUserPwd(sha.shaEncode(userPwd));
			jurisdiction.setJurisdictionId(8);
			users.setJurisdiction(jurisdiction);
			
			student.setUsers(users);
			usersDao.addUsers(users);
			studentDao.addStudent(student);
			
		} catch (Exception e) {
			
		}
		return 1;
	}

	//按学生学号寻找学生
	public Student findStudentNumber(Long studentNumber) {
		String hql = "from Student as u where u.studentNumber="+studentNumber;
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.findStudentNumber(hql);
		return student;
	}
	//添加学生班级信息admin
	public void updateStudentClass(int classmessageId, int studentId,int postId) {
		StudentBiz studentBiz = new StudentBizImpl();
		StudentDao studentDao = new StudentDaoImpl();
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage add_Class = classmessageBiz.findClassmessageId(classmessageId);
		//查找学生
		Student student = studentBiz.findStudentById(studentId);
		Student add_student = new Student();
		Jurisdiction jurisdiction = new Jurisdiction();
		Grade grade = new Grade();
		Users users = new Users();
		Profession profession = new Profession();
		College college = new College();
		Post post = new Post();
		post.setPostId(postId);
		Political political = new Political();
		political.setPoliticallandscapeId(student.getPolitical().getPoliticallandscapeId());
		college.setCollegeId(add_Class.getCollege().getCollegeId());
		profession.setProfessionId(add_Class.getProfession().getProfessionId());
		
		Classmessage classmessage = new Classmessage();
		classmessage.setClassmessageId(classmessageId);
		//UsersDao usersDao = new UsersDaoImpl();
		
		
		jurisdiction.setJurisdictionId(8);
		users.setJurisdiction(jurisdiction);
		users.setUserId(student.getUsers().getUserId());
		
		grade.setGradeId(student.getGrade().getGradeId());
		
		//添加学生信息
		add_student.setCollege(college);
		add_student.setBirthday(student.getBirthday());
		add_student.setAddress(student.getAddress());
		add_student.setGrade(grade);
		add_student.setUsers(users);
		add_student.setPoliticallandscapestate(student.getPoliticallandscapestate());
		add_student.setCorporation(student.getCorporation());
		add_student.setPoor(student.getPoor());
		add_student.setStudentstate(1);
		add_student.setPoorId(1);
		add_student.setCorporationpost(student.getCorporationpost());
		add_student.setHeight(student.getHeight());
		add_student.setIdcard(student.getIdcard());
		add_student.setNation(student.getNation());
		add_student.setPlaceofBirth(student.getPlaceofBirth());
		add_student.setPolitical(political);
		add_student.setPoliticallandscapestate(1);
		add_student.setPost(post);
		add_student.setDormitory(student.getDormitory());
		add_student.setInterest(student.getInterest());
		add_student.setRemarks(student.getRemarks());
		add_student.setWeChat(student.getWeChat());
		add_student.setWeight(student.getWeight());
		add_student.setStudentName(student.getStudentName());
		add_student.setStudentNumber(student.getStudentNumber());
		add_student.setClassmessage(classmessage);
		add_student.setStudentId(studentId);
		add_student.setDateTime(student.getDateTime());
		add_student.setEmail(student.getEmail());
		add_student.setHeadportrait(student.getHeadportrait());
		add_student.setHomePhone(student.getHomePhone());
		add_student.setJurisdiction(jurisdiction);
		add_student.setPhoneNumber(student.getPhoneNumber());
		add_student.setSex(student.getSex());
		add_student.setQqNumber(student.getQqNumber());
		add_student.setShcoolName(student.getShcoolName());
		add_student.setState(student.getState());
		add_student.setPost(post);
		add_student.setStudentGradeName(student.getStudentGradeName());
		
		studentDao.updateStudentClass(add_student);
	}

	//按找id删除学生表
	public void deleteUsersById(int userId) {
		String sql = "DELETE FROM student WHERE userId="+userId;
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.deleteUsersById(sql);
	}

	//管理员页面修改学生信息
	public void adminUpdateStudent(int studentId,String studentName,String userName,
  			String myFileFileName,String sex,
  			Long studentNumber,String shcoolName,int classmessageId,
  			String dateTime,String state,Long phoneNumber,
  			String homePhone,String email,String address,int userId,Long qqNumber,String userPwd,
  			int PoliticallandscapeId,
  			String idcard,String interest,String dormitory,String remarks,String weight,String PlaceofBirth,String birthday,
  			String height,String corporation,String corporationpost,String nation,String WeChat,int postId,int poor,String studentGradeName
  			) {
		//SHA加密
		SHA sha = new SHA();
		//载入政治面貌
		Political political = new Political();
		political.setPoliticallandscapeId(PoliticallandscapeId);
		//按班级id查找班级信息
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage classmessage = classmessageBiz.findClassmessageId(classmessageId);
		Classmessage addClassmessage = new Classmessage();
		addClassmessage.setClassmessageId(classmessage.getClassmessageId());
		//载入年级
		Grade grade = new Grade();
		grade.setGradeId(classmessage.getGrade().getGradeId());
		//班级职务
		Post post = new Post();
		post.setPostId(postId);
		//载入学院
		College college = new College();
		/*college.setCollegeId(classmessage.getCollege().getCollegeId());
		College college2 = new College();
		college2.setCollegeId(college);*/
		int collegeId = classmessage.getCollege().getCollegeId();
		college.setCollegeId(collegeId);
		//载入权限
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(8);
		//载入用户表信息
		Users users = new Users();
		users.setUserId(userId);
		users.setUserName(userName);
		users.setJurisdiction(jurisdiction);
		UsersBiz usersBiz = new UsersBizImpl();
		Users users2 = usersBiz.findUsersById(userId);
		UsersDao usersDao = new UsersDaoImpl();
		//载入学生信息
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		try {
			student.setAddress(address);
			student.setStudentGradeName(studentGradeName);
			student.setClassmessage(addClassmessage);
			student.setCollege(college);
			student.setEmail(email);
			student.setIdcard(idcard);
			student.setHeight(height);
			student.setNation(nation);
			student.setPost(post);
			student.setPolitical(political);
			student.setPoor(poor);
			political.setPoliticallandscapestate(1);
			student.setGrade(grade);
			student.setHeadportrait(myFileFileName);
			student.setHomePhone(homePhone);
			student.setJurisdiction(jurisdiction);
			student.setPhoneNumber(phoneNumber);
			student.setQqNumber(qqNumber);
			student.setSex(sex);
			student.setInterest(interest);
			student.setDormitory(dormitory);
			student.setRemarks(remarks);
			student.setShcoolName(shcoolName);
			student.setState(state);
			student.setStudentId(studentId);
			student.setStudentName(studentName);
			student.setStudentNumber(studentNumber);
			student.setWeChat(WeChat);
			student.setWeight(weight);
			student.setPlaceofBirth(PlaceofBirth);
			student.setPolitical(political);
			student.setBirthday(birthday);
			student.setCorporation(corporation);
			student.setPoliticallandscapestate(1);
			student.setCorporationpost(corporationpost);
			student.setDateTime(dateTime);
			if(userPwd.length() !=0){
				users.setUserPwd(sha.shaEncode(userPwd));
			}else{
				users.setUserPwd(users2.getUserPwd());
			}
			
			student.setUsers(users);
			usersDao.update_users(users);
			//修改学生信息
			studentDao.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//按id查找学生
	public Student findStudentByStudentId(int studentId) {
		String hql = "from Student as u where u.studentId="+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.findStudentByStudentId(hql);
		return student;
	}
	
	

	//重写了管理员添加学生信息的接口
	public int addStudent(String userName,String userPwd,String myFileFileName,Long studentNumber,String studentName,
  			String sex,String nation,int PoliticallandscapeId,String PlaceofBirth,String birthday,String height,
  			String weight,int gradeName,String dateTime,String state,String corporation,String corporationpost,Long phoneNumber,
  			String homePhone,Long qqNumber,String WeChat,String email,String address,int JurisdictionId,String idcard,String shcoolName
  			,String interest,String dormitory,String remarks,int poor,String studentGradeName) {
		
		//SHA加密
		SHA sha = new SHA();
		StudentDao studentDao = new StudentDaoImpl();
		UsersDao usersDao = new UsersDaoImpl();
		
		//实例化所有外键连接的表的实体类
		Users users = new Users();   //用户表
		Jurisdiction jurisdiction = new Jurisdiction();  //权限表
		Political political = new Political();  //政治面貌表
		Grade grade = new Grade();          //年级表
		Student student = new Student();
		
		//实体类载入数据
		
		try {
			jurisdiction.setJurisdictionId(8);
			
			users.setUserName(userName);
			users.setUserPwd(sha.shaEncode(userPwd));
			users.setJurisdiction(jurisdiction);
			political.setPoliticallandscapeId(PoliticallandscapeId);
			grade.setGradeId(gradeName);
			student.setPoliticallandscapestate(1);
			student.setJurisdiction(jurisdiction);
			student.setInterest(interest);
			student.setDormitory(dormitory);
			student.setRemarks(remarks);
			student.setGrade(grade);
			student.setPoor(poor);
			student.setPoorId(1);
			student.setStudentGradeName(studentGradeName);
			student.setUsers(users);
			student.setAddress(address);
			student.setBirthday(birthday);
			student.setStudentstate(1);
			student.setCorporation(corporation);
			student.setCorporationpost(corporationpost);
			student.setDateTime(dateTime);
			student.setEmail(email);
			student.setGrade(grade);
			student.setHeadportrait(myFileFileName);
			student.setHeight(height);
			student.setHomePhone(homePhone);
			student.setIdcard(idcard);
			student.setNation(nation);
			student.setPhoneNumber(phoneNumber);
			student.setPlaceofBirth(PlaceofBirth);
			student.setPolitical(political);
			student.setQqNumber(qqNumber);
			student.setSex(sex);
			student.setShcoolName(shcoolName);
			student.setState(state);
			student.setStudentName(studentName);
			student.setStudentNumber(studentNumber);
			student.setWeChat(WeChat);
			student.setWeight(weight);
			//添加学生基本信息
			usersDao.addUsers(users);
			studentDao.addStudent(student);
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateSutdent(int studentId) {
		String sql 
			= "UPDATE student SET Politicallandscapestate =1 where studentId = "+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(sql);
	}
	//学生修改自己的个人信息
	public void updateStudent(int studentId,int userId,String userPwd, String myFileFileName,
			String studentName, String sex, String nation,
			int PoliticallandscapeId, String PlaceofBirth, String birthday,
			String height, String weight,  int classmessageId,
			int postId, String corporation, String corporationpost,
			String interest, String dormitory, Long phoneNumber, String homePhone,
			Long qqNumber, String WeChat, String email, String address) throws Exception {
		
		StudentDao studentDao = new StudentDaoImpl();
		String sql 
		= "UPDATE student SET Politicallandscapestate = 4 ,userId = "+userId+""
				+ ",headportrait = "+"'"+myFileFileName+"'"+""
						+ ",studentName = "+"'"+studentName+"'"+""
								+ ",sex = "+"'"+sex+"'"+",nation = "+"'"+nation+"'"
								+",PoliticallandscapeId = "
								+PoliticallandscapeId+
								",PlaceofBirth ="+"'"+PlaceofBirth+"'"
								+",birthday="+"'"+birthday+"'"+",height="+"'"+height+"'"+",weight="+"'"+weight+"'"
								+",classmessageId="+classmessageId+",postId="+postId+",corporation="+"'"+corporation+"'"
								+",corporationpost="+"'"+corporationpost+"'"+",interest="+"'"+interest+"'"+",dormitory="+"'"+dormitory+"'"
								+",phoneNumber="+phoneNumber+",homePhone="+"'"+homePhone+"'"+",qqNumber="+qqNumber+",WeChat="+"'"+WeChat+"'"
								+",email="+"'"+email+"'"+",address="+"'"+address+"'"+"where studentId="+studentId;
		if(userPwd.length() == 0){
			UsersBiz usersBiz = new UsersBizImpl();
			Users users = usersBiz.findUsersById(userId);
			userPwd = users.getUserPwd();
			usersBiz.UpdateUsers(userPwd,userId);
			studentDao.updateStudent(sql);
		}else{
			//SHA加密
			SHA sha = new SHA();
			UsersBiz usersBiz = new UsersBizImpl();
			usersBiz.UpdateUsers(sha.shaEncode(userPwd),userId);
			studentDao.updateStudent(sql);
			
		}
	}

	@Override
	public int updateStudentGrade(int classmessageId,int gradeId) {
		String sql = "UPDATE student SET gradeId="+gradeId+" where classmessageId="+classmessageId;
		StudentDao studentDao = new StudentDaoImpl();
		int id  = studentDao.updateStudent(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public void updateSutdentGradeTeacher(int studentId) {
		String sql 
			= "UPDATE student SET Politicallandscapestate =2 where studentId = "+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(sql);
	}

	@Override
	public int addStudentGradeTeacher(String userName, String userPwd,
			String myFileFileName, Long studentNumber, String studentName,
			String sex, String nation, int PoliticallandscapeId,
			String PlaceofBirth, String birthday, String height, String weight,
			int gradeName, String dateTime, String state, String corporation,
			String corporationpost, Long phoneNumber, String homePhone,
			Long qqNumber, String WeChat, String email, String address,
			int JurisdictionId, String idcard, String shcoolName,
			String interest, String dormitory, String remarks, int poor,String studentGradeName) {
			//SHA加密
			SHA sha = new SHA();
			StudentDao studentDao = new StudentDaoImpl();
			UsersDao usersDao = new UsersDaoImpl();
				
			//实例化所有外键连接的表的实体类
			Users users = new Users();   //用户表
			Jurisdiction jurisdiction = new Jurisdiction();  //权限表
			Political political = new Political();  //政治面貌表
			Grade grade = new Grade();          //年级表
			Student student = new Student();
				
			//实体类载入数据	
			try {
				jurisdiction.setJurisdictionId(8);
				users.setUserName(userName);
				users.setUserPwd(sha.shaEncode(userPwd));
				users.setJurisdiction(jurisdiction);
				political.setPoliticallandscapeId(PoliticallandscapeId);
				grade.setGradeId(gradeName);
				student.setPoliticallandscapestate(8); 			 /*辅导员添加学生,政治面貌初始值为4未审批*/
				student.setJurisdiction(jurisdiction);
				student.setInterest(interest);
				student.setDormitory(dormitory);
				student.setRemarks(remarks);
				student.setGrade(grade);
				student.setPoor(poor);
				student.setStudentGradeName(studentGradeName);
				student.setPoorId(2);
				student.setUsers(users);
				student.setAddress(address);
				student.setBirthday(birthday);
				student.setStudentstate(2);
				student.setCorporation(corporation);
				student.setCorporationpost(corporationpost);
				student.setDateTime(dateTime);
				student.setEmail(email);
				student.setGrade(grade);
				student.setHeadportrait(myFileFileName);
				student.setHeight(height);
				student.setHomePhone(homePhone);
				student.setIdcard(idcard);
				student.setNation(nation);
				student.setPhoneNumber(phoneNumber);
				student.setPlaceofBirth(PlaceofBirth);
				student.setPolitical(political);
				student.setQqNumber(qqNumber);
				student.setSex(sex);
				student.setShcoolName(shcoolName);
				student.setState(state);
				student.setStudentName(studentName);
				student.setStudentNumber(studentNumber);
				student.setWeChat(WeChat);
				student.setWeight(weight);
				//添加学生基本信息
				usersDao.addUsers(users);
				studentDao.addStudent(student);
				return 1;
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public void updateStudentClassGradeTeacher(int classmessageId,
			int studentId, int postId) {
		StudentBiz studentBiz = new StudentBizImpl();
		StudentDao studentDao = new StudentDaoImpl();
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage add_Class = classmessageBiz.findClassmessageId(classmessageId);
		//查找学生
		Student student = studentBiz.findStudentById(studentId);
		Student add_student = new Student();
		Jurisdiction jurisdiction = new Jurisdiction();
		Grade grade = new Grade();
		Users users = new Users();
		Profession profession = new Profession();
		College college = new College();
		Post post = new Post();
		post.setPostId(postId);
		Political political = new Political();
		political.setPoliticallandscapeId(student.getPolitical().getPoliticallandscapeId());
		college.setCollegeId(add_Class.getCollege().getCollegeId());
		profession.setProfessionId(add_Class.getProfession().getProfessionId());
		
		Classmessage classmessage = new Classmessage();
		classmessage.setClassmessageId(classmessageId);
		//UsersDao usersDao = new UsersDaoImpl();
		
		
		jurisdiction.setJurisdictionId(8);
		users.setJurisdiction(jurisdiction);
		users.setUserId(student.getUsers().getUserId());
		
		grade.setGradeId(student.getGrade().getGradeId());
		
		//添加学生信息
		add_student.setCollege(college);
		add_student.setStudentGradeName(student.getStudentGradeName());
		add_student.setBirthday(student.getBirthday());
		add_student.setAddress(student.getAddress());
		add_student.setGrade(grade);
		add_student.setUsers(users);
		add_student.setPoliticallandscapestate(student.getPoliticallandscapestate());
		add_student.setCorporation(student.getCorporation());
		add_student.setPoor(student.getPoor());
		add_student.setStudentstate(student.getStudentstate());
		add_student.setPoorId(2);
		add_student.setCorporationpost(student.getCorporationpost());
		add_student.setHeight(student.getHeight());
		add_student.setIdcard(student.getIdcard());
		add_student.setNation(student.getNation());
		add_student.setPlaceofBirth(student.getPlaceofBirth());
		add_student.setPolitical(political);
		add_student.setPoliticallandscapestate(1);
		add_student.setPost(post);
		add_student.setDormitory(student.getDormitory());
		add_student.setInterest(student.getInterest());
		add_student.setRemarks(student.getRemarks());
		add_student.setWeChat(student.getWeChat());
		add_student.setWeight(student.getWeight());
		add_student.setStudentName(student.getStudentName());
		add_student.setStudentNumber(student.getStudentNumber());
		add_student.setClassmessage(classmessage);
		add_student.setStudentId(studentId);
		add_student.setDateTime(student.getDateTime());
		add_student.setEmail(student.getEmail());
		add_student.setHeadportrait(student.getHeadportrait());
		add_student.setHomePhone(student.getHomePhone());
		add_student.setJurisdiction(jurisdiction);
		add_student.setPhoneNumber(student.getPhoneNumber());
		add_student.setSex(student.getSex());
		add_student.setQqNumber(student.getQqNumber());
		add_student.setShcoolName(student.getShcoolName());
		add_student.setState(student.getState());
		add_student.setPost(post);
		studentDao.updateStudentClass(add_student);
		
	}

	@Override
	public void updateSutdentState(int studentId) {
		String sql 
			= "UPDATE student SET studentstate=1 where studentId = "+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(sql);
	}

	@Override
	public void updateSutdentTeacher(int studentId) {
		String sql 
		= "UPDATE student SET Politicallandscapestate =3 where studentId = "+studentId;
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.updateStudent(sql);
		
	}

	

}
