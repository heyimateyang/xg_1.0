package org.heyimtaeyang.dao.impl;

import org.heyimtaeyang.dao.UsersDao;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class UsersDaoImpl extends HibernateUtil implements UsersDao {

	//首页登录
	public Users login(String sql,String userName, String userPwd) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			query = session.createSQLQuery(sql).addEntity(Users.class);
			query.setParameter(0, userName);
			query.setParameter(1, userPwd);
			return (Users) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//修改用户表
	public int update_users(Users users) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(users);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	//按usersId查找用户信息
	public Users findUsersById(String hql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
	         query = session.createQuery(hql);
	         session.getTransaction().commit();
	         return (Users) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//添加用户
	public int addUsers(Users users) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(users);
			 session.getTransaction().commit();
			 return 1;
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	//查找是否有重复的用户名字
	public boolean  finduserName(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
	         session.getTransaction().commit();
	         if(query.list().size()>0){
	        	 return true;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//按找id删除用户表
	public int deleteUsersById(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Users.class);
			query.executeUpdate();
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public int updateUsers(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = getSession().createSQLQuery(sql);
			//session.getTransaction().commit();
			query.executeUpdate();
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public void addUser(Users users) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(users);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

}
