package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.College;

public interface CollegeDao {
	
	//显示全部学院
	List<College> findAll();
	
	//添加学院
	void addCollege(College college);
	
	/**
	 * 分页显示所有学园
	 * @author heyimtaeyang
	 *
	 */
	List<College> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //按id删除学院
    void deleteCollegeById(String sql);
    
    //查找是否有重复的学院名字
  	boolean  findCollegeName(String sql);

}
