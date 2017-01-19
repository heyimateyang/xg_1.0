package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.PostBiz;
import org.heyimtaeyang.dao.PostDao;
import org.heyimtaeyang.dao.impl.PostDaoImpl;
import org.heyimtaeyang.entity.Post;

public class PostBizImpl implements PostBiz {

	@Override
	public List<Post> showAll() {
		String hql = "from Post";
		PostDao postDao = new PostDaoImpl();
		try {
			List<Post> list = postDao.findAll(hql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
