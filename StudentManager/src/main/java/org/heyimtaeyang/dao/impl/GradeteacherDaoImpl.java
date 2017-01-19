package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.GradeteacherDao;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class GradeteacherDaoImpl extends HibernateUtil implements GradeteacherDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Gradeteacher> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Gradeteacher> list = null;
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
            //session.beginTransaction();
            query = session.createQuery(hql);
            allRows = query.list().size();
            //session.getTransaction().commit();
        }
        catch (Exception e){
        	//session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
			HibernateUtil.closeSession();
		}
        
        return allRows;
	}

	//按id显示班级辅导员
	public Gradeteacher findGradeTeacher(String hql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			//session.getTransaction().commit();
			return (Gradeteacher) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按id删除班级辅导员
	public int deleteGradeteacherById(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Gradeteacher.class);
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

	//按年级显示年级辅导员
	public Gradeteacher findGradeteacherByGrade(String sql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(Gradeteacher.class);
			session.getTransaction().commit();
			return (Gradeteacher) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//模糊查询年级辅导员
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Gradeteacher> findLikeGradeTeacher(String hql) {
		Session session = HibernateUtil.getSession();
		List<Gradeteacher> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			return list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//添加年级辅导员
	public void addGradeTeacher(Gradeteacher gradeteacher) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(gradeteacher);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
	}

	//更新年级辅导员
	public void UpdateGradeTeacher(Gradeteacher gradeteacher) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(gradeteacher);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//判断该学院该年级是否有重复的年级管理员
	public boolean findGradeTeacherByGradeandCollege(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql).addEntity(Gradeteacher.class);
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
}
