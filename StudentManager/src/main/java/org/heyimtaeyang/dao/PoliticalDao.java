package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Political;

/**
 * 
 * @author heyimtaeyang
 * 政治面貌
 */

public interface PoliticalDao {
	
	//载入全部政治状态
	List<Political> showAll(String hql);

}
