package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Reply;

public interface ReplyDao {
	
	//添加一条新信息
	int addReply(Reply reply);
	
	//按id显示一条回复信息
	Reply findByid(String hql);
	
	/**
	 * 信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Reply> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);


}
