package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.PostDao;
import org.heyimtaeyang.entity.Post;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class PostDaoImpl extends HibernateUtil implements PostDao {

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Post> findAll(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Post> list = null;
		Query query = null;
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

}
