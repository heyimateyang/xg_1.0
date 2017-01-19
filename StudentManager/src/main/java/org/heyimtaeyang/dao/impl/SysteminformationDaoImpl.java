package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.SysteminformationDao;
import org.heyimtaeyang.entity.Systeminformation;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class SysteminformationDaoImpl extends HibernateUtil implements SysteminformationDao {

	//添加系统公告
	public int addSysteminformation(Systeminformation systeminformation) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(systeminformation);
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

	//按id查询系统公告
	public Systeminformation findById(String hql) {
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			session.getTransaction().commit();
			return (Systeminformation) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Systeminformation> queryByPage(String hql, int offset,
			int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Systeminformation> list = null;
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
		/*HibernateUtil.closeSession();*/
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

	//删除系统公告
	public int deleteSysteminformationByid(String hql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
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

	@SuppressWarnings({ "unchecked", "unused" })
	//显示系统公告
	public List<Systeminformation> showSysteminformation(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Systeminformation> list = null;
		Query query = null;
		try {
			session.beginTransaction();
			query = session.createQuery(hql);
			query.setFirstResult(0);
			query.setMaxResults(5);
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

}
