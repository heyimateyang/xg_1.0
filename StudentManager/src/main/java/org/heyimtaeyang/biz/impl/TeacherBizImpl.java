package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.dao.TeacherDao;
import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.dao.impl.TeacherDaoImpl;
import org.heyimtaeyang.dao.impl.UsersDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Jurisdiction;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;

public class TeacherBizImpl implements TeacherBiz {
	

	//按id显示班级辅导员信息
	public Teacher findTeacherById(int teacherId) {
		String hql = "from Teacher as u where u.teacherId="+teacherId;
		TeacherDao teacherDao = new TeacherDaoImpl();
		Teacher teacher = teacherDao.findTeacherById(hql);
		return teacher;
	}

	//按UsersId显示班级辅导员信息
	public Teacher findTeacherByUserId(int userId) {
		String sql = "select * from teacher where userId="+userId;
		TeacherDao teacherDao = new TeacherDaoImpl();
		Teacher teacher = teacherDao.findTeacherByIdSQL(sql);
		return teacher;
	}

	//模糊查询显示班级辅导员信息
	public List<Teacher> findLikeTeacher(String teacherName) {
		String hql = "from Teacher as u where u.teacherName like '%"+teacherName+"%'";
		TeacherDao teacherDao = new TeacherDaoImpl();
		List<Teacher> list = teacherDao.findLikeTeacher(hql);
		return list;
	}

	//按年级查找班级辅导员
	public Teacher findTeacherByClassmessageId(int classmessageId) {
		String sql 
			= "select * from teacher where classmessageId="+classmessageId;
		TeacherDao teacherDao = new TeacherDaoImpl();
		Teacher teacher = teacherDao.findTeacherByIdSQL(sql);
		return teacher;
	}

	//按ClassmessageId查找班级辅导员
	public List<Teacher> ListTeacherByClassmessageId(int classmessageId) {
		String sql 
			= "select * from teacher where classmessageId="+classmessageId;
		TeacherDao teacherDao = new TeacherDaoImpl();
		List<Teacher> list = teacherDao.findTeacherByClassmessageId(sql);
		return list;
	}

	//添加班级辅导员
	public void addTeacher(String userName, String userPwd, int gradeId,
			String teacherName, String teacherAddress, int teacherPhone,
			int teacherQq, int workNumber, String myFileFileName) {
		//SHA加密
		SHA sha = new SHA();
		
		TeacherDao teacherDao = new TeacherDaoImpl();
		UsersDao usersDao = new UsersDaoImpl();
		Teacher teacher = new Teacher();
		Users users = new Users();
		
		Grade grade = new Grade();
		grade.setGradeId(gradeId);
		
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(3);
		
		try {
			teacher.setGrade(grade);
			teacher.setHeadportrait(myFileFileName);
			teacher.setJurisdiction(jurisdiction);
			teacher.setTeacherAddress(teacherAddress);
			teacher.setTeacherName(teacherName);
			teacher.setTeacherPhone(teacherPhone);
			teacher.setTeacherQq(teacherQq);
			teacher.setWorkNumber(workNumber);
			
			users.setUserName(userName);
			users.setJurisdiction(jurisdiction);
			users.setUserPwd(sha.shaEncode(userPwd));
			
			teacher.setUsers(users);
			
			usersDao.addUsers(users);
			teacherDao.addTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//按工号显示班级辅导员信息
	public Teacher findTeacherNumber(int workNumber) {
		String hql = "from Teacher as u where u.workNumber="+workNumber;
		TeacherDao teacherDao = new TeacherDaoImpl();
		Teacher teacher = teacherDao.findTeacherById(hql);
		return teacher;
	}

	//添加班级辅导员班级
	public void addTeacherClassMessage(int teacherId, int classmessageId) {
		TeacherDao teacherDao = new TeacherDaoImpl();
		TeacherBiz teacherBiz = new TeacherBizImpl();
		//查找班级辅导员
		Teacher teacher = teacherBiz.findTeacherById(teacherId);
		
		Users users = new Users();
		users.setUserId(teacher.getUsers().getUserId());
		
		Grade grade = new Grade();
		grade.setGradeId(teacher.getGrade().getGradeId());
		
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(3);
		
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		Classmessage add_classmessage = classmessageBiz.findClassmessageId(classmessageId); 
		Classmessage classmessage = new Classmessage();
		classmessage.setClassmessageId(classmessageId);
		
		College college = new College();
		college.setCollegeId(add_classmessage.getCollege().getCollegeId());

		Teacher add_teacher = new Teacher();
		
		//add_teacher.setClassmessage(classmessage);
		add_teacher.setCollege(college);
		add_teacher.setGrade(grade);
		add_teacher.setHeadportrait(teacher.getHeadportrait());
		add_teacher.setJurisdiction(jurisdiction);
		add_teacher.setTeacherAddress(teacher.getTeacherAddress());
		add_teacher.setTeacherId(teacherId);
		add_teacher.setTeacherName(teacher.getTeacherName());
		add_teacher.setTeacherPhone(teacher.getTeacherPhone());
		add_teacher.setTeacherQq(teacher.getTeacherQq());
		add_teacher.setUsers(users);
		add_teacher.setWorkNumber(teacher.getWorkNumber());
		teacherDao.updateTeacherClasee(add_teacher);
	}

	//按id删除班级辅导员
	public void deleteTeacherById(int teacherId,int userId) {
		String sql = "DELETE FROM teacher WHERE teacherId="+teacherId;
		//删除班级成绩表
		TeacherDao teacherDao = new TeacherDaoImpl();
		teacherDao.deleteTeacher(sql);
		//删除用户表
		UsersBiz usersBiz = new UsersBizImpl();
		usersBiz.deleteUsersById(userId);
	}

	//更新班级辅导员
	public void updateTeacher(int teacherId, String teacherName,
			String userName, String userPwd, String myFileFileName,
			int workNumber,  String teacherAddress,
			int teacherPhone, int teacherQq,int userId) {
		//SHA加密
		SHA sha = new SHA();
		//载入用户表
		UsersDao usersDao = new UsersDaoImpl();
		UsersBiz usersBiz = new UsersBizImpl();
		Users Pwdusers = new Users();
		Pwdusers = usersBiz.findUsersById(userId);
		Users users = new Users();
		users.setUserName(userName);
		users.setUserId(userId);
		//载入权限
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(3);
		users.setJurisdiction(jurisdiction);
		
		//载入班级辅导员信息
		TeacherDao teacherDao = new TeacherDaoImpl();
		try {
			//加密用户登录密码
			if(userPwd.length()==0){
				users.setUserPwd(Pwdusers.getUserPwd());
			}else{
				users.setUserPwd(sha.shaEncode(userPwd));
			}
			Teacher teacher = new Teacher();
			teacher.setHeadportrait(myFileFileName);
			teacher.setJurisdiction(jurisdiction);
			teacher.setTeacherAddress(teacherAddress);
			teacher.setTeacherId(teacherId);
			teacher.setTeacherName(teacherName);
			teacher.setTeacherPhone(teacherPhone);
			teacher.setTeacherQq(teacherQq);
			teacher.setUsers(users);
			teacher.setWorkNumber(workNumber);
			teacherDao.updateTeacher(teacher);
			usersDao.update_users(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addTeacher(String userName, String userPwd, String teacherName,
			String teacherAddress, int teacherPhone, int teacherQq,
			int workNumber, String myFileFileName) {
		//SHA加密
		SHA sha = new SHA();
		//添加辅导员助理
		TeacherDao teacherDao = new TeacherDaoImpl();
		try {
			Jurisdiction jurisdiction = new Jurisdiction();
			jurisdiction.setJurisdictionId(3);
			
			//载入用户表的信息
			Users users = new Users();
			UsersDao usersDao = new UsersDaoImpl();
			users.setJurisdiction(jurisdiction);
			users.setUserName(userName);
			users.setUserPwd(sha.shaEncode(userPwd));
			
			Teacher teacher = new Teacher();
			teacher.setHeadportrait(myFileFileName);
			teacher.setTeacherAddress(teacherAddress);
			teacher.setTeacherName(teacherName);
			teacher.setTeacherPhone(teacherPhone);
			teacher.setTeacherQq(teacherQq);
			teacher.setWorkNumber(workNumber);
			teacher.setUsers(users);
			usersDao.addUsers(users);
			teacherDao.addTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*//按工号 查询辅导员助理信息
		TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher2 = teacherBiz.findTeacherNumber(workNumber);
		
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		classmessageBiz.updateClassmessage(classmessageId, teacher2.getTeacherId());*/
		
	}
}
