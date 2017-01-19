package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.AdminDao;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AdminDaoImpl extends HibernateUtil implements AdminDao {

	//按id查找管理员
	public Admin find_adminById(String hql) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			query = session.createQuery(hql);
			return (Admin) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//修改管理员资料
	public int updateAdmin(Admin admin) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(admin);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	//登录时按usersId显示登录管理员的信息
	public Admin findAdminByUsersId(String sql) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			query = session.createSQLQuery(sql).addEntity(Admin.class);
			return (Admin) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//显示全部管理员(既辅导员)
	@SuppressWarnings({ "unused", "unchecked" })
	public List<Admin> showAll() {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Admin> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery("from Admin order by adminId ");
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public void addAdmin(Admin admin) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(admin);
			 session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		
	}

}
