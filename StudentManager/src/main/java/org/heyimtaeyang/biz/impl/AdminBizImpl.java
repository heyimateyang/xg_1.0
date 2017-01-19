package org.heyimtaeyang.biz.impl;

import org.heyimtaeyang.biz.AdminBiz;
import org.heyimtaeyang.dao.AdminDao;
import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.dao.impl.AdminDaoImpl;
import org.heyimtaeyang.dao.impl.UsersDaoImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Jurisdiction;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;

public class AdminBizImpl implements AdminBiz {

	//按id查找管理员
	public Admin find_adminById(int adminId) {
		String hql = "from Admin as u where u.adminId="+adminId;
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.find_adminById(hql);
		if(admin!=null){
			return admin;
		}
		return null;
	}

	//修改管理员资料
	public Admin updateAdmin(int qqnumber,int phone,int jurisdictionId,int adminId, int userId, String adminName,
			String userName, String userPwd) {
		//SHA加密
		SHA sha = new SHA();
		
		AdminDao adminDao = new AdminDaoImpl();
		UsersDao usersDao = new UsersDaoImpl();
		Admin admin = new Admin();
		Users users = new Users();
		Jurisdiction jurisdiction = new Jurisdiction();
		try {
			jurisdiction.setJurisdictionId(jurisdictionId);
			
			//修改管理员资料
			admin.setAdminId(adminId);
			admin.setAdminName(adminName);
			admin.setQqnumber(qqnumber);
			admin.setPhone(phone);
			
			//修改用户表资料
			users.setUserId(userId);
			users.setUserName(userName);
			users.setUserPwd(sha.shaEncode(userPwd));
			users.setJurisdiction(jurisdiction);
			
			admin.setUsers(users);
			int update_id = adminDao.updateAdmin(admin);
			int update_id2 = usersDao.update_users(users);
			
			if(update_id!=0 || update_id2!=0){
				return admin;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//登录时按usersId显示登录管理员的信息
	public Admin findAdminByUsersId(int userId) {
		String sql = "select * from admin where userId = "+userId;
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.findAdminByUsersId(sql);
		return admin;
	}
}
