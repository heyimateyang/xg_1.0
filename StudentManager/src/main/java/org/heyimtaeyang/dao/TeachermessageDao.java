package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Teachermessage;

public interface TeachermessageDao {
	
	//添加一条助理辅导员咨询信息
	int addTeacherMessage(Teachermessage teachermessage);
	
	/**
	 * 信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Teachermessage> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //按ID查找一条助理辅导员的信息
    Teachermessage findByid(String hql);
    
    //修改信息状态
    int updateTeacherMessage(String sql);
    
    //删除信息
    int deleteTeacherMessage(String sql);

}
