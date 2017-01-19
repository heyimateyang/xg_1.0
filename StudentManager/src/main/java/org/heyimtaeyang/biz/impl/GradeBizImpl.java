package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.dao.GradeDao;
import org.heyimtaeyang.dao.impl.GradeDaoImpl;
import org.heyimtaeyang.entity.Grade;

public class GradeBizImpl implements GradeBiz {

	//显示全部年级
	public List<Grade> findAll() {
		String hql = "from Grade";
		GradeDao gradeDao = new GradeDaoImpl();
		List<Grade> list = gradeDao.findAll(hql);
		return list;
	}

}
