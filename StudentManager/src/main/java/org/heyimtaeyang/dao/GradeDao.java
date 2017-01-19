package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Grade;



public interface GradeDao {
	
	//显示全部年级
	List<Grade> findAll(String hql);
}
