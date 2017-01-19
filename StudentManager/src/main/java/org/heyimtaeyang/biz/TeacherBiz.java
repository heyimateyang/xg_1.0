package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Teacher;

public interface TeacherBiz {
	
	//按teacherId显示班级辅导员信息
    Teacher findTeacherById(int teacherId);
    
    //按UsersId显示班级辅导员信息
    Teacher findTeacherByUserId(int userId);
    
    //模糊查询显示班级辅导员信息
    List<Teacher> findLikeTeacher(String teacherName);
    
    
    //按classmessageId显示班级辅导员信息
    Teacher findTeacherByClassmessageId(int classmessageId);
    
    //按classmessageId显示班级辅导员信息
    List<Teacher> ListTeacherByClassmessageId(int classmessageId);
    
    //添加班级辅导员(作废)
  	void addTeacher(String userName,
    String userPwd,
    int gradeId,
    String teacherName,
    String teacherAddress,
    int teacherPhone,
    int teacherQq,
    int workNumber,String myFileFileName);
  	
  	//添加班级辅导员
  	void addTeacher(String userName,
    String userPwd,
    String teacherName,
    String teacherAddress,
    int teacherPhone,
    int teacherQq,
    int workNumber,String myFileFileName);
  	
  	//按工号显示班级辅导员信息
    Teacher findTeacherNumber(int workNumber);
    
    //添加班级辅导员班级
    void addTeacherClassMessage(int teacherId,int classmessageId);
    
    //按id删除班级辅导员
    void deleteTeacherById(int teacherId,int userId);
    
    //更新班级辅导员
    void updateTeacher(int teacherId,String teacherName,
    		String userName,String userPwd,
    		String myFileFileName,int workNumber,
    		String teacherAddress,
    		int teacherPhone,int teacherQq,int userId );
}
