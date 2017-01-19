package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.StudentDao;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class StudentDaoImpl extends HibernateUtil implements StudentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Student> list = null;
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

	//按id查找学生信息
	public Student findStudentById(String hql) {
		//HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 //session.beginTransaction();
			 query = session.createQuery(hql);
			 //session.getTransaction().commit();
			 return (Student) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//按usersId查找学生信息
	public Student findStudentByUserId(String sql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql).addEntity(Student.class);
			 session.getTransaction().commit();
			 return (Student) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//模糊查询学生信息
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Student> findLikeStudent(String sql) {
		//HibernateUtil.closeSession();
		Query query = null;
		List<Student> list = null;
		Session session = HibernateUtil.getSession();
		try{
            session.beginTransaction();
            query = session.createSQLQuery(sql).addEntity(Student.class);
            session.getTransaction().commit();
            return list = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
			HibernateUtil.closeSession();
		}
        return null;
	}

	//修改学生资料
	public int updateStudent(Student student) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.merge(student);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return 0;
	}

	//添加学生信息
	public int addStudent(Student student) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(student);
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

	 //按学生名字查找学生信息
	public Student findStudentNumber(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 session.getTransaction().commit();
			 return (Student) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//更新学生班级信息
	public int updateStudentClass(Student student) {
		//Session session = null;
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		//Transaction tx = null;
		try {
			//tx = getSession().beginTransaction();
			session.beginTransaction();
			session.merge(student);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
        }
		return 0;
	}

	//根据id删除学生
	public int deleteUsersById(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Student.class);
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

	//按id查找学生信息
	public Student findStudentByStudentId(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 //session.getTransaction().commit();
			 return (Student) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	//修改单个字段
	public int updateStudent(String sql) {
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
	public List<Student> queryByPages(String sql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Student> list = null;
		try{
			session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(Student.class).setFirstResult(offset).setMaxResults(pageSize);
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
	public int getAllRowCounts(String sql) {
		//HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		int allRows = 0;
		try{
		      session.beginTransaction();
		      query = session.createSQLQuery(sql).addEntity(Student.class);
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

}
