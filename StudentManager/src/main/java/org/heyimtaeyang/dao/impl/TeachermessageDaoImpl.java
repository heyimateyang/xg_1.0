package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.TeachermessageDao;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class TeachermessageDaoImpl extends HibernateUtil implements TeachermessageDao {

	@Override
	public int addTeacherMessage(Teachermessage teachermessage) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(teachermessage);
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
	public List<Teachermessage> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Teachermessage> list = null;
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
	public Teachermessage findByid(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 //session.beginTransaction();
	         query = session.createQuery(hql);
	         //session.getTransaction().commit();
	         return (Teachermessage) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public int updateTeacherMessage(String sql) {
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

	@Override
	public int deleteTeacherMessage(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

}
