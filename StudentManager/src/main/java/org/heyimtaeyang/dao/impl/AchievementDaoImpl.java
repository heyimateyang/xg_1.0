package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.AchievementDao;
import org.heyimtaeyang.entity.Achievement;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class AchievementDaoImpl extends HibernateUtil implements AchievementDao {

	public Query query = null;
	
	
	@SuppressWarnings("unchecked")
	public List<Achievement> queryByPage(String sql, int offset, int pageSize) {
		//HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Achievement> list = null;
		try{
			session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(Achievement.class).setFirstResult(offset).setMaxResults(pageSize);
            list = query.list();
            session.getTransaction().commit();    
        }
        catch (Exception e){
        	session.getTransaction().rollback();
        	e.printStackTrace();
        }finally{
            //HibernateUtil.closeSession();
        } 
        return list;
	}

	@Override
	public int getAllRowCount(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		int allRows = 0;
		try{
            session.beginTransaction();
            Query query = session.createSQLQuery(sql).addEntity(Achievement.class);
            allRows = query.list().size();
            session.getTransaction().commit();
        }
        catch (Exception e){
        	session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        
        return allRows;
	}

	//添加学生成绩
	public int addAchievement(Achievement achievement) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(achievement);
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

	//按id删除成绩
	public int deleteAchievementById(String sql) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(sql).addEntity(Achievement.class);
			query.executeUpdate();
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return 0;
	}

	//模糊查询成绩
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Achievement> findLikeAchievement(String sql) {
		Session session = HibernateUtil.getSession();
		List<Achievement> list = null;
		Query query = null;
		try{
            session.beginTransaction();
            query = session.createSQLQuery(sql).addEntity(Achievement.class);
            session.getTransaction().commit();
            return list = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }
        
        return null;
	}

	//查找该学生是否有重复的科目名字
	public boolean findAchievementName(String sql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		Query query = null;
		try {
			 session.beginTransaction();
			 query = session.createSQLQuery(sql).addEntity(Achievement.class);
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
