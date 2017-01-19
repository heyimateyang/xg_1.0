package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Reply;

public interface ReplyBiz {
	
	//添加一条新的信息
	int addReply(String replymessage,int studentId,int adminId,String gradeteacherId,int TeacherReplyId);
	
	//按回复id显示一条信息
	Reply findByReplyId(int systermMessageId);

}
