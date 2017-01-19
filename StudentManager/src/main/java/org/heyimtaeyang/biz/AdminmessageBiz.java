package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Adminmessage;

public interface AdminmessageBiz {
	
	//添加一条新的信息
	int AddMessage(String MessageTitle,String content1,int adminId,int studentId);
	
	//按id查询一条信息
	Adminmessage findById(int systermMessageId);
	
	//修改信息的状态
	int updateStateAminMessage(int systermMessageId);

}
