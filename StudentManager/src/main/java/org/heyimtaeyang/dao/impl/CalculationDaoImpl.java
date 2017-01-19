package org.heyimtaeyang.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.heyimtaeyang.dao.CalculationDao;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.until.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class CalculationDaoImpl extends HibernateUtil implements CalculationDao {

	//计算
	public List Calculation_Message(String hql) {
		HibernateUtil.closeSession();
		Session session = HibernateUtil.getSession();
		List list = new ArrayList();
		try {
			 session.beginTransaction();
			 Query query = session.createQuery(hql);
			 list = query.list();
			 session.getTransaction().commit();
			 return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return null;
	}

}
