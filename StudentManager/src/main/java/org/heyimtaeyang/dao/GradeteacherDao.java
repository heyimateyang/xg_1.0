package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Gradeteacher;

public interface GradeteacherDao {
	
	/**
	 * 年级辅导员信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Gradeteacher> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //按id显示班级辅导员
    Gradeteacher findGradeTeacher(String hql);
    
    //按id删除年级辅导员
    int deleteGradeteacherById(String sql);
    
    //按年级显示年级辅导员
    Gradeteacher findGradeteacherByGrade(String sql);
    
    //模糊查询年级辅导员
    List<Gradeteacher> findLikeGradeTeacher(String hql);
    
    //添加年级辅导员
    void addGradeTeacher(Gradeteacher gradeteacher);
    
    //更新年级辅导员
    void UpdateGradeTeacher(Gradeteacher gradeteacher);
    
    //判断该学院该年级是否有重复的年级管理员
    boolean  findGradeTeacherByGradeandCollege(String sql);

}
