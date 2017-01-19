package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Teacher;

public interface TeacherDao {
	
	/**
	 * 班级辅导员信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Teacher> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
	
    //按id显示班级辅导员信息
    Teacher findTeacherById(String hql);
    
    //按id显示班级辅导员信息
    Teacher findTeacherByIdSQL(String sql);
    
    //模糊查询显示班级辅导员信息
    List<Teacher> findLikeTeacher(String hql);
    
    //按年级查找班级辅导员
    List<Teacher> findTeacherByGradeId(String sql);
    
    //按ClassmessageId查找班级辅导员
    List<Teacher> findTeacherByClassmessageId(String sql);
    
    //添加班级辅导员
    void addTeacher(Teacher teacher);
    
    //添加班级辅导员班级
    void updateTeacherClasee(Teacher teacher);
    
    //删除班级辅导员
    void deleteTeacher(String sql);
    
    //更新班级辅导员
    void updateTeacher(Teacher teacher);
    
    //显示全部班级辅导员(既助理辅导员)
    List<Teacher> showAll();
  
}
