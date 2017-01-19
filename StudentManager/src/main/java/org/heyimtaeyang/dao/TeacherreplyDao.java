package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Teacherreply;

public interface TeacherreplyDao {
	
	List<Teacherreply> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //添加一条助理辅导员回复信息
    int addTeacherRepyl(Teacherreply teacherreply);
    
    //按id查询一条助理员处理好的信息
    Teacherreply findById(String hql);

}
