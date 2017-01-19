package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Admin;


/**
 * AdminBiz
 * @author heyimtaeyang
 *
 */

public interface AdminBiz {
	
	//按id查找管理员
	Admin find_adminById(int adminId);
	
	//修改管理员资料
	Admin updateAdmin(int qqnumber,int phone,int jurisdictionId,int adminId,int userId,String adminName,String userName,String userPwd);
	
	//登录时按usersId显示登录管理员的信息
	Admin findAdminByUsersId(int userId);


}
