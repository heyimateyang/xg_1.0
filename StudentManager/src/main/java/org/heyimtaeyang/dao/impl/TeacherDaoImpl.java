package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.TeacherDao;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class TeacherDaoImpl extends HibernateUtil implements TeacherDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Teacher> list = null;
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

	//按id显示班级辅导员信息
	public Teacher findTeacherById(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 //session.beginTransaction();
	         query = session.createQuery(hql);
	         //session.getTransaction().commit();
	         return (Teacher) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按id显示班级辅导员信息
	public Teacher findTeacherByIdSQL(String sql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
	         query = session.createSQLQuery(sql).addEntity(Teacher.class);
	         session.getTransaction().commit();
	         return (Teacher) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//模糊查询显示班级辅导员信息
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Teacher> findLikeTeacher(String hql) {
		Query query = null;
		List<Teacher> list = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按年级查找班级辅导员
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Teacher> findTeacherByGradeId(String sql) {
		Query query = null;
		List<Teacher> list = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(Teacher.class);
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//按ClassmessageId查找班级辅导员
	@SuppressWarnings({ "unused", "unchecked" })
	public List<Teacher> findTeacherByClassmessageId(String sql) {
		Query query = null;
		List<Teacher> list = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createSQLQuery(sql).addEntity(Teacher.class);
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//添加班级辅导员
	public void addTeacher(Teacher teacher) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(teacher);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
	}

	//添加班级辅导员班级
	public void updateTeacherClasee(Teacher teacher) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.merge(teacher);
			 session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
            e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
	}

	//删除班级辅导员
	public void deleteTeacher(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Teacher.class);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			//session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}

	//更新班级辅导员
	public void updateTeacher(Teacher teacher) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(teacher);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		
	}

	//显示全部班级辅导员(既助理辅导员)
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Teacher> showAll(){
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Teacher> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery("from Teacher order by teacherId ");
			session.getTransaction().commit();
			return list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}
}
