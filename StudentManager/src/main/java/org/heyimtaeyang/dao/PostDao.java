package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Post;

public interface PostDao {
	
	//载入全部班级职务
	
	List<Post> findAll(String hql);

}
