package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.TeacherreplyDao;
import org.heyimtaeyang.entity.Teacherreply;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class TeacherreplyDaoImpl implements TeacherreplyDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacherreply> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Teacherreply> list = null;
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
	public int addTeacherRepyl(Teacherreply teacherreply) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(teacherreply);
			 session.getTransaction().commit();
			 return 1;
		} catch (Exception e) {
			session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public Teacherreply findById(String hql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 //session.getTransaction().commit();
			 return (Teacherreply) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

}
