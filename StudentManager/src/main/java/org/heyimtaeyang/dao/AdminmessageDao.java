package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Adminmessage;

public interface AdminmessageDao {
	
	//添加一条新的信息
	int AddMessage(Adminmessage adminmessage);
	
	//按id查询一条信息
	Adminmessage findById(String hql);
	
	//修改一条信息
	int updateAdminMessage(String sql);
	
	/**
	 * 信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Adminmessage> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);

}
