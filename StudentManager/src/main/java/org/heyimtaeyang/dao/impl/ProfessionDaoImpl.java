package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.ProfessionDao;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Profession;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProfessionDaoImpl extends HibernateUtil implements ProfessionDao {

	//按学院id查找专业
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Profession> findProfessionByCollege(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Profession> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(Profession.class);
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//添加专业
	public void addProfession(Profession profession) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(profession);
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
	public List<Profession> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Profession> list = null;
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

	//按id删除专业
	public void deleteProfession(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Profession.class);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//显示全部专业
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Profession> findAll() {
		Session session = HibernateUtil.getSession();
		Query query = null;
		List<Profession> list = null;
		try {
			session.beginTransaction();
			query = session.createQuery("from Profession");
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按专业id查找学院
	public Profession findCollege(String sql) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			//session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(Profession.class);
			return (Profession) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//查找是否有重复的专业名称
	public boolean findProfessionName(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql).addEntity(Profession.class);
	         session.getTransaction().commit();
	         if(query.list().size()>0){
	        	 return true;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//按照ID查找班级
	public List<Classmessage> findId(String hql) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		List<Classmessage> list = null;
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

}
