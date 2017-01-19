package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.LeavestudentDao;
import org.heyimtaeyang.entity.Leavestudent;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class LeavestudentDaoImpl extends HibernateUtil implements LeavestudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Leavestudent> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Leavestudent> list = null;
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

	@Override
	public int addLeavestudent(Leavestudent leavestudent) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(leavestudent);
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
	public int deleteLeaveStudent(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Leavestudent.class);
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
	public Leavestudent ShowLeaveStudent(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 session.getTransaction().commit();
			 return (Leavestudent) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public int updateLeaveStudent(String sql) {
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
