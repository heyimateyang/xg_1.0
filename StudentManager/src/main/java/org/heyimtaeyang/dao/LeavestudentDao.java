package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Leavestudent;

public interface LeavestudentDao {
	
	/**
	 * 请假信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Leavestudent> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //添加请假条存根
    int addLeavestudent(Leavestudent leavestudent);
    
    //按ID删除查询请假条
    int deleteLeaveStudent(String sql);
    
    //按id查询请假条
    Leavestudent ShowLeaveStudent(String hql);
    
    //修改请假条状态
    int updateLeaveStudent(String sql);

}
