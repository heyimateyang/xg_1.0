package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.dao.GradeteacherDao;
import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.dao.impl.GradeteacherDaoImpl;
import org.heyimtaeyang.dao.impl.UsersDaoImpl;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Jurisdiction;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;

public class GradeteacherBizImpl implements GradeteacherBiz {

	//按Id查找班级辅导员
	public Gradeteacher findGradeTeacher(int gradeteacherId) {
		String hql = "from Gradeteacher as u where u.gradeteacherId="+gradeteacherId;
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		Gradeteacher gradeteacher = gradeteacherDao.findGradeTeacher(hql);
		return gradeteacher;
	}

	//按id删除班级辅导员
	public int deleteGradeteacherById(int gradeteacherId) {
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		String sql = "delete from gradeteacher where gradeteacherId="+gradeteacherId;
		int id  = gradeteacherDao.deleteGradeteacherById(sql);
		if(id !=0){
			return 1;
		}else{
			return 0;
		}
	}

	//按年级显示年级辅导员
	public Gradeteacher findGradeteacherByGrade(int gradeId) {
		String sql = "select * from gradeteacher where gradeId="+gradeId;
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		Gradeteacher gradeteacher = gradeteacherDao.findGradeteacherByGrade(sql);
		return gradeteacher;
	}

	//登录时按usersId显示年级辅导员的信息
	public Gradeteacher findGradeteacherByUsersId(int userId) {
		String sql = "select * from gradeteacher where usersId="+userId;
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		Gradeteacher gradeteacher = gradeteacherDao.findGradeteacherByGrade(sql);
		return gradeteacher;
	}

	//模糊查询年级辅导员
	public List<Gradeteacher> findLikeGradeTeacher(String gradeteacherName) {
		String hql = "from Gradeteacher as u where u.gradeteacherName like '%"+gradeteacherName+"%'";
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		List<Gradeteacher> list = gradeteacherDao.findLikeGradeTeacher(hql);
		return list;
	}
	
	//添加年级辅导员
	public void addGradeTeacher(String userName, String userPwd,
			String gradeteacherName,  
			String address, int gradeteacherPhone, int gradeteacherQqnumber,
			String myFileFileName,int workNumber) {
		//SHA加密
		SHA sha = new SHA();
		//用户表信息
		Users users = new Users();
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(2);
		UsersDao usersDao = new UsersDaoImpl();
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		Gradeteacher gradeteacher = new Gradeteacher();
	
		try {	
			gradeteacher.setAddress(address);
			gradeteacher.setGradeteacherName(gradeteacherName);
			gradeteacher.setGradeteacherPhone(gradeteacherPhone);
			gradeteacher.setGradeteacherQqnumber(gradeteacherQqnumber);
			gradeteacher.setHeadportrait(myFileFileName);
			gradeteacher.setWorkNumber(workNumber);
			
			users.setUserName(userName);
			users.setUserPwd(sha.shaEncode(userPwd));
			users.setJurisdiction(jurisdiction);
			
			gradeteacher.setUsers(users);
			
			usersDao.addUsers(users);
			gradeteacherDao.addGradeTeacher(gradeteacher);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//修改年级辅导员
	public void UpdateGradeTeacher(int gradeteacherId, String gradeteacherName,
			String userName, String userPwd, String myFileFileName,
			int workNumber,   String address,
			int gradeteacherPhone, int gradeteacherQqnumber,int userId) {
		//SHA加密
		SHA sha = new SHA();
		//载入用户表
		Users users = new Users();
		users.setUserId(userId);
		users.setUserName(userName);
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setJurisdictionId(2);
		users.setJurisdiction(jurisdiction);
		

		//载入年级辅导员信息
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		Gradeteacher gradeteacher = new Gradeteacher();
		UsersDao usersDao = new UsersDaoImpl();
		try {
 			if(userPwd.length()==0){
				UsersBiz usersBiz = new UsersBizImpl();
				Users users2 = new Users(); 
				users2 = usersBiz.findUsersById(userId);
				users.setUserPwd(users2.getUserPwd());
			}else{
				users.setUserPwd(sha.shaEncode(userPwd));			//SHA加密
			}
			gradeteacher.setAddress(address);
			gradeteacher.setGradeteacherId(gradeteacherId);
			gradeteacher.setGradeteacherName(gradeteacherName);
			gradeteacher.setGradeteacherPhone(gradeteacherPhone);
			gradeteacher.setGradeteacherQqnumber(gradeteacherQqnumber);
			gradeteacher.setHeadportrait(myFileFileName);
			gradeteacher.setUsers(users);
			gradeteacher.setWorkNumber(workNumber);
			gradeteacherDao.UpdateGradeTeacher(gradeteacher);
			
			
			usersDao.update_users(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//判断该学院该年级是否有重复的年级管理员
	public boolean findGradeTeacherByGradeandCollege(int gradeId, int collegeId) {
		String sql = "select * from gradeteacher "
				+ "where gradeId="+gradeId+" and collegeId="+collegeId;
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		boolean  rs 
			= gradeteacherDao.findGradeTeacherByGradeandCollege(sql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Gradeteacher> findAllGradeTeacher() {
		GradeteacherDao gradeteacherDao = new GradeteacherDaoImpl();
		List<Gradeteacher> list = gradeteacherDao.findLikeGradeTeacher("from Gradeteacher");
		
		return list;
	}
}
