package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.ReplyDao;
import org.heyimtaeyang.entity.Reply;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class ReplyDaoImpl extends HibernateUtil implements ReplyDao {

	@Override
	public int addReply(Reply reply) {
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 session.save(reply);
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

	@Override
	public Reply findByid(String hql) {
		HibernateUtil.closeSession();
		Query query = null;
		Session session = HibernateUtil.getSession();
		try {
			 session.beginTransaction();
			 query = session.createQuery(hql);
			 //session.getTransaction().commit();
			 return (Reply) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> queryByPage(String hql, int offset, int pageSize) {
		Session session = HibernateUtil.getSession();
		List<Reply> list = null;
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

}
