package org.heyimtaeyang.biz.impl;

import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.dao.AdminDao;
import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.dao.impl.AdminDaoImpl;
import org.heyimtaeyang.dao.impl.UsersDaoImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Jurisdiction;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;

public class UsersBizImpl implements UsersBiz {

	//首页登录(登录控制)
	public Users login(String userName, String userPwd) {
		String sql
			= "select * from users as u where userName=? and userPwd=? ";
		UsersDao usersDao = new UsersDaoImpl();
		//SHA加密
		SHA sha = new SHA();
		Users users;
		try {
			users = usersDao.login(sql, userName, sha.shaEncode(userPwd));
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//按usersId查找用户信息
	public Users findUsersById(int userId) {
		String hql = "from Users as u where u.userId="+userId;
		UsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.findUsersById(hql);
		return users;
	}

	//查找是否有重复的用户名字
	public boolean finduserName(String userName) {
		String hql = "from Users where userName="+userName;
		UsersDao usersDao = new UsersDaoImpl();
		boolean  rs = usersDao.finduserName(hql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}

	//按找id删除用户表
	public int deleteUsersById(int userId) {
		String sql = "DELETE FROM users WHERE userId="+userId;
		UsersDao usersDao = new UsersDaoImpl();
		usersDao.deleteUsersById(sql);
		return 1;
	}

	@Override
	public int UpdateUsers(String userPwd,int userId) {
		String sql = "UPDATE users SET userPwd ="+"'"+userPwd+"'"+"where userId = "+userId;
		UsersDao usersDao = new UsersDaoImpl();
		int id = usersDao.updateUsers(sql);
		if(id != 0){
			return 1;
		}
		return 0;
	}

	@Override
	public Users findUsersById(String userName) {
		String hql = "from Users as u where u.userName="+userName;
		UsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.findUsersById(hql);
		return users;
	}
	
	@Override
	public void addUsers()  {
		SHA sha = new SHA();
		Users users = new Users();
		UsersDao usersDao = new UsersDaoImpl();
		Jurisdiction jurisdiction = new Jurisdiction(); 
		try {
			jurisdiction.setJurisdictionId(1);
			users.setJurisdiction(jurisdiction);
			users.setUserName("liuchujun");
			users.setUserPwd(sha.shaEncode("123"));
			usersDao.addUser(users);
			
			AdminDao adminDao = new AdminDaoImpl();
			Admin admin = new Admin();
			admin.setAdminName("liuchujun");
			admin.setUsers(users);
			adminDao.addAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
