package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CollegeDaoImpl extends HibernateUtil implements CollegeDao {

	//显示全部学院
	@SuppressWarnings({ "unchecked", "unused" })
	public List<College> findAll() {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<College> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery("from College");
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

	//添加学院
	public void addCollege(College college) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(college);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<College> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<College> list = null;
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
		HibernateUtil.closeSession();
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

	//按id删除学院
	public void deleteCollegeById(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(College.class);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//查找是否有重复的学院名字
	public boolean findCollegeName(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql);
	         session.getTransaction().commit();
	         if(query.list().size()>0){
	        	 return true;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
