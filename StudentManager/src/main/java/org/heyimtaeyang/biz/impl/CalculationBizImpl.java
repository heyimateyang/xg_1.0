package org.heyimtaeyang.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.heyimtaeyang.biz.CalculationBiz;
import org.heyimtaeyang.dao.CalculationDao;
import org.heyimtaeyang.dao.impl.CalculationDaoImpl;

public class CalculationBizImpl implements CalculationBiz {

	//计算总数
	public List Total_Message(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId;
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	//计算男生的总人数
	public List Total_Man(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and sex='男'";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_Girl(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and sex='女'";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_Members(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and PoliticallandscapeId=2";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_ReservePartyMember(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and PoliticallandscapeId=3";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_PartyMember(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and PoliticallandscapeId=4";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_PartyActivists(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and PoliticallandscapeId=5";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

	@Override
	public List Total_Poor(int classmessageId) {
		List list = new ArrayList();
		String hql
			= "select COUNT(studentName) from Student where classmessageId="+classmessageId+" and poor=1";
		CalculationDao calculationDao = new CalculationDaoImpl();
		list = calculationDao.Calculation_Message(hql);
		return list;
	}

}
