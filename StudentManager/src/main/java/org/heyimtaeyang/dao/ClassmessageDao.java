package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Classmessage;

public interface ClassmessageDao {
	
	//按teacherId查找班级老师
	Classmessage findTeacherByTeacherId(String sql);
	
	//查找班级
	List<Classmessage> findClassmessage(String hql);
	
	//按年级查找班级
	Classmessage findGradeId(String hql);
	
	/**
	 * 分页显示所有班级
	 * @author heyimtaeyang
	 *
	 */
	List<Classmessage> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //添加班级
    void addClassmessage(Classmessage classmessage);
    
    //删除班级按班级id
    void deleteClassmessage(String sql);
    
    //修改班级信息
    void updateClassmessage(Classmessage classmessage);
    
    //显示全部班级
    List<Classmessage> findAll();
    
    //查找是否有重复的用户名字
  	boolean  findClassmessageName(String sql);
  	
  	//修改班级信息的单个字段
  	int updateClassmessage(String sql);
	

}
