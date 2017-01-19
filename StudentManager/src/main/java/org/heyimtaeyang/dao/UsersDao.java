package org.heyimtaeyang.dao;

import org.heyimtaeyang.entity.Users;


/**
 * UserDAO
 * @author heyimtaeyang
 *
 */


public interface UsersDao {

	//首页登录
	Users login(String sql,String userName, String userPwd);
	
	//修改用户表
	int update_users(Users users);
	
	//按usersId查找用户信息
	Users findUsersById(String hql);
	
	//添加用户
	int addUsers(Users users);
	
	//查找是否有重复的用户名字
	boolean  finduserName(String hql);
	
	//按找id删除用户表
	int deleteUsersById(String sql);
	
	//更新某字段
	int updateUsers(String sql);
	
	void addUser(Users users);
}
