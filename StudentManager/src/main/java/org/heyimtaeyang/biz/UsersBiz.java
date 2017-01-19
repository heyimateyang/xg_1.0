package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Users;


/**
 * UserBIZ
 * @author heyimtaeyang
 *
 */

public interface UsersBiz {
	
	//首页登录
	Users login(String userName, String userPwd);
	
	//按usersId查找用户信息
	Users findUsersById(int userId);
	
	//按usersId查找用户信息
	Users findUsersById(String userName);
	
	//查找是否有重复的用户名字
	boolean finduserName(String userName);
	
	//按找id删除用户表
	int deleteUsersById(int userId);
	
	//修改用户表个别字段
	int UpdateUsers(String userPwd,int userId);
	
	void addUsers ();

}
