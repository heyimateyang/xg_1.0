package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.ProfessionBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.dao.ClassmessageDao;
import org.heyimtaeyang.dao.impl.ClassmessageDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Profession;

public class ClassmessageBizImpl implements ClassmessageBiz {

	//按teacherId查找班级老师
	public Classmessage findTeacherByTeacherId(int teacherId) {
		String sql = "select * from classmessage where teacherId="+teacherId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		Classmessage classmessage = classmessageDao.findTeacherByTeacherId(sql);
		return classmessage;
	}

	//显示全部班级
	public List<Classmessage> findAll() {
		String hql = "from Classmessage order by gradeId";
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		List<Classmessage> list = classmessageDao.findClassmessage(hql);
		return list;
	}

	//按年级查找班级
	public List<Classmessage> findByGradeId(int gradeId) {
		String hql = "from Classmessage where gradeId = "+gradeId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		List<Classmessage> list = classmessageDao.findClassmessage(hql);
		return list;
	}

	//按年级查找班级
	public Classmessage findGradeId(int gradeId) {
		String hql = "from Classmessage where gradeId = "+gradeId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		Classmessage classmessage = classmessageDao.findGradeId(hql);
		return classmessage;
	}

	//按classmessageId查找信息
	public Classmessage findClassmessageId(int classmessageId) {
		String hql = "from Classmessage where classmessageId = "+classmessageId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		Classmessage classmessage = classmessageDao.findGradeId(hql);
		return classmessage;
	}

	//添加班级信息
	public void addClassmessage(String classmessageName, int gradeId,
			int professionId,String classmessageGradeName) {
		//载入年级
		Grade grade = new Grade();
		grade.setGradeId(gradeId);
		//载入专业
		Profession profession = new Profession();
		profession.setProfessionId(professionId);
		//按专业id查找学院
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		Profession add_profession = professionBiz.findCollege(professionId);
		//载入学院id
		College college = new College();
		college.setCollegeId(add_profession.getCollege().getCollegeId());
		//载入班级信息
		Classmessage classmessage = new Classmessage();
		classmessage.setClassmessageName(classmessageName);
		classmessage.setCollege(college);
		classmessage.setGrade(grade);
		classmessage.setProfession(profession);
		classmessage.setClassmessageGradeName(classmessageGradeName);
		
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		classmessageDao.addClassmessage(classmessage);
	}

	//按班级信息id删除班级信息
	public void deleteClassmessage(int classmessageId) {
		String sql = "DELETE FROM classmessage WHERE classmessageId="+classmessageId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		classmessageDao.deleteClassmessage(sql);
	}

	//修改班级信息
	public void updateClassmessage(int classmessageId, String classmessageName,
			int gradeId, int professionId, String slogan, int classQqnumber,String content1) {
		//实例班级信息dao
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		Classmessage classmessage = new Classmessage();
		//载入年级
		Grade grade = new Grade();
		grade.setGradeId(gradeId);
		//载入专业
		Profession profession = new Profession();
		//按专业id查找学院id
		ProfessionBiz professionBiz = new ProfessionBizImpl();
		profession = professionBiz.findCollege(professionId);
		//载入学院
		College college = new College();
		college.setCollegeId(profession.getCollege().getCollegeId());
		//载入班级信息
		classmessage.setClassmessageId(classmessageId);
		
		classmessage.setClassmessageName(classmessageName);
		
		classmessage.setClassQqnumber(classQqnumber);
		classmessage.setCollege(college);
		classmessage.setClassmessagehonor(content1);
		classmessage.setGrade(grade);
		classmessage.setProfession(profession);
		classmessage.setSlogan(slogan);
		
		StudentBiz studentBiz = new StudentBizImpl();
		studentBiz.updateStudentGrade(classmessageId, gradeId);
		//修改班级信息
		classmessageDao.updateClassmessage(classmessage);
		
	}

	//查找是否有重复的用户名字
	public boolean findClassmessageName(int gradeId,String classmessageName) {
		String sql = "select * from classmessage where gradeId "
				+ "="+gradeId+" and classmessageName="+"'"+classmessageName+"'";
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		boolean  rs = classmessageDao.findClassmessageName(sql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int updateClassmessage(int classmessageId,int teacherId) {
		String sql = "UPDATE classmessage SET teacherId="+teacherId+" where classmessageId ="+classmessageId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		int id = classmessageDao.updateClassmessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public List<Classmessage> findByteacherId(int teacherId) {
		String hql = "from Classmessage where teacherId="+teacherId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		List<Classmessage> list = classmessageDao.findClassmessage(hql);
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public void updateClassmessageNull(int teacherId) {
		String sql = "UPDATE classmessage SET teacherId=null where teacherId ="+teacherId;
		ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
		classmessageDao.updateClassmessage(sql);
		
	}

}
