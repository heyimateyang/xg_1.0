package org.heyimtaeyang.dao.impl;

import java.util.List;

import org.heyimtaeyang.dao.GradeDao;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class GradeDaoImpl implements GradeDao {

	//显示全部年级
	@SuppressWarnings({ "unused", "unchecked" })
	public List<Grade> findAll(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List<Grade> list = null;
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
