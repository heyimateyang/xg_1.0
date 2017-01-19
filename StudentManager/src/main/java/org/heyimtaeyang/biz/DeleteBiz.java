package org.heyimtaeyang.biz;

public interface DeleteBiz {
	
	//删除咨询信息
	int deleteAdminMessage(int systermMessageId);
		
	//删除回复信息
	int deleteReplyMessage(int systermMessageId);
	
	//删除助理辅导员的咨询信息
	int deleteTeachermessage(int gradeteacherId);
		
	//删除助理辅导员的咨询信息
	int deleteTeacherReplymessage(int gradeteacherId);
}
