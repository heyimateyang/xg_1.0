package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Gradeteacher;

public interface GradeteacherBiz {
	
	//按Id查找班级辅导员
	Gradeteacher findGradeTeacher(int gradeteacherId);
	
	//按id删除班级辅导员
	int deleteGradeteacherById(int gradeteacherId);
	
	//按年级显示年级辅导员
    Gradeteacher findGradeteacherByGrade(int gradeId);
    
    //登录时按usersId显示年级辅导员的信息
    Gradeteacher findGradeteacherByUsersId(int userId);

    //模糊查询年级辅导员
    List<Gradeteacher> findLikeGradeTeacher(String gradeteacherName);
    
    //显示全部辅导员
    List<Gradeteacher> findAllGradeTeacher();
    
    //添加年级辅导员
    void addGradeTeacher( String userName,String userPwd,String gradeteacherName,
    
    String address,
    int gradeteacherPhone,
    int gradeteacherQqnumber,
    String myFileFileName,int workNumber);
    
    //修改年级辅导员
    void UpdateGradeTeacher(int gradeteacherId,String gradeteacherName,
    		String userName,String userPwd,
    		String myFileFileName,int workNumber,
    		
    		String address,int gradeteacherPhone,
    		int gradeteacherQqnumber,int userId);
    
    //判断该学院该年级是否有重复的年级管理员
    boolean findGradeTeacherByGradeandCollege(int gradeId , int collegeId);
}
