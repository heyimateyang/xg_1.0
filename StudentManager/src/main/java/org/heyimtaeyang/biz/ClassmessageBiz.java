package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Classmessage;

public interface ClassmessageBiz {
	
	//按teacherId查找班级老师
	Classmessage findTeacherByTeacherId(int teacherId);
	
	//显示全部班级
	List<Classmessage> findAll();
	
	//按年级查找班级
	List<Classmessage> findByGradeId(int gradeId);
	
	List<Classmessage> findByteacherId(int teacherId);
	
	//按年级查找班级
	Classmessage findGradeId(int gradeId);
	
	//按classmessageId查找信息
	Classmessage findClassmessageId(int classmessageId);
	
	//添加班级信息
	void addClassmessage(String classmessageName,int gradeId,int professionId,String classmessageGradeName);
	
	//按班级信息id删除班级信息
	void deleteClassmessage(int classmessageId);
	
	//修改班级信息
	void updateClassmessage(int classmessageId,String classmessageName,
			int gradeId,int professionId,
			String slogan,int classQqnumber,String content1);
	
	//查找是否有重复的用户名字
  	boolean findClassmessageName(int gradeId,String classmessageName);
  	
  	//修改班级信息单个字段
  	int updateClassmessage(int classmessageId,int teacherId);
  	
  	//清空字段
  	void updateClassmessageNull(int teacherId);
}
