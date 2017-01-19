package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Admin;


/**
 * AdminDao
 * @author heyimtaeyang
 *
 */

public interface AdminDao {
	
	//按id查找管理员
	Admin find_adminById(String hql);
	
	//修改管理员资料
	int updateAdmin(Admin admin);
	
	//登录时按usersId显示登录管理员的信息
	Admin findAdminByUsersId(String sql);
	
	//显示全部管理员(既辅导员)
	List<Admin> showAll();
	
	void addAdmin(Admin admin);
}
