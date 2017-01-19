package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.PoliticalDao;
import org.heyimtaeyang.entity.Political;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class PoliticalDaoImpl extends HibernateUtil implements PoliticalDao {

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public List<Political> showAll(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Political> list = null;
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
