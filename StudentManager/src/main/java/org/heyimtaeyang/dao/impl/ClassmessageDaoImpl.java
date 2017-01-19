package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.ClassmessageDao;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ClassmessageDaoImpl extends HibernateUtil implements ClassmessageDao {

	//按teacherId查找班级老师
	public Classmessage findTeacherByTeacherId(String sql) {
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			query = session.createSQLQuery(sql).addEntity(Classmessage.class);
			return (Classmessage) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//显示全部班级
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Classmessage> findClassmessage(String hql) {
		Session session = HibernateUtil.getSession();
		List<Classmessage> list = null;
		Query query = null;
		try {
			//session.beginTransaction();
			query = session.createQuery(hql);
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按年级查找班级
	public Classmessage findGradeId(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			//session.getTransaction().commit();
			return (Classmessage) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classmessage> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Classmessage> list = null;
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

	//添加班级
	public void addClassmessage(Classmessage classmessage) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(classmessage);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
	}

	//删除班级按班级id
	public void deleteClassmessage(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Classmessage.class);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//修改班级信息
	public void updateClassmessage(Classmessage classmessage) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(classmessage);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//显示全部班级
	@SuppressWarnings({ "unused", "unchecked" })
	public List<Classmessage> findAll() {
		Session session = HibernateUtil.getSession();
		List<Classmessage> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery("from Classmessage where teacherId IS null");
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//查找是否有重复的用户名字
	public boolean findClassmessageName(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql).addEntity(Classmessage.class);
	         session.getTransaction().commit();
	         if(query.list().size()>0){
	        	 return true;
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public int updateClassmessage(String sql) {
		HibernateUtil.closeSession();
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
