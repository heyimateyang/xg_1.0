package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Grade;

public interface GradeBiz {
	
	//显示全部年级
	List<Grade> findAll();

}
