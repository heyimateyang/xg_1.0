package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Systeminformation;

/**
 * 
 * @author heyimtaeyang
 *
 */
public interface SysteminformationDao {
	
	//添加系统公告
    int addSysteminformation(Systeminformation systeminformation);
    
    //按id显示系统公告
    Systeminformation findById(String hql);
    
    //删除系统公告
    int deleteSysteminformationByid(String hql);
    
    //显示系统公告
    List<Systeminformation> showSysteminformation(String hql);
    
    /**
	 * 分页显示所有系统公告
	 * @author heyimtaeyang
	 *
	 */
	List<Systeminformation> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);

}
