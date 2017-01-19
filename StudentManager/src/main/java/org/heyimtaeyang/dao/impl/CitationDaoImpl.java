package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.CitationDao;
import org.heyimtaeyang.entity.Citation;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CitationDaoImpl extends HibernateUtil implements CitationDao {

	//添加学生获奖情况
	public int addCitation(Citation Citation) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(Citation);
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
	public List<Citation> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Citation> list = null;
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

	//按Id查找奖状
	public Citation findCitation(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 session.getTransaction().commit();
			 return (Citation) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按Id删除奖状
	public int deleteCitation(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Citation.class);
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

	//按Citationid修改奖状
	public void updateCitationByCitationId(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Citation.class);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	@Override
	public List<Citation> find_Citation(String hql) {
		Session session = HibernateUtil.getSession();
		List<Citation> list = null;
		try {
			session.beginTransaction();
			 Query query = session.createQuery(hql);
	         list = query.list();
	         session.getTransaction().commit();   
	         return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}
}
