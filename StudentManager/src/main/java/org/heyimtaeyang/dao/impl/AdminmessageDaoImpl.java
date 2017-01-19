package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.AdminmessageDao;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AdminmessageDaoImpl extends HibernateUtil implements AdminmessageDao {

	//添加一条信息的信息
	public int AddMessage(Adminmessage adminmessage) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(adminmessage);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Adminmessage> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Adminmessage> list = null;
		try{
			session.beginTransaction();
            Query query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
            list = query.list();
            session.getTransaction().commit();    
        }
        catch (Exception e){
        	//session.getTransaction().rollback();
        	e.printStackTrace();
        }finally{
            HibernateUtil.closeSession();
        } 
        return list;
	}

	@Override
	public int getAllRowCount(String hql) {
		//HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		int allRows = 0;
		try{
		  session.beginTransaction();
		  query = session.createQuery(hql);
		  allRows = query.list().size();
		  session.getTransaction().commit();
		  }
		catch (Exception e){
		    //session.getTransaction().rollback();
		    e.printStackTrace();
		}finally{
		    HibernateUtil.closeSession();
		}
		        
		return allRows;
	}

	//按id查询一条信息
	public Adminmessage findById(String hql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 session.getTransaction().commit();
			 return (Adminmessage) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//修改单个字段
	public int updateAdminMessage(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = getSession().createSQLQuery(sql);
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

}
