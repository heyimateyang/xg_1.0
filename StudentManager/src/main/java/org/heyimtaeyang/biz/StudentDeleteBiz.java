package org.heyimtaeyang.biz;

public interface StudentDeleteBiz {
	
	//删除咨询信息
	int deleteAdminMessage(int studentId);
		
	//删除回复信息
	int deleteReplyMessage(int studentId);
	
	//删除助理辅导员的咨询信息
	int deleteTeachermessage(int studentId);
		
	//删除助理辅导员的咨询信息
	int deleteTeacherReplymessage(int studentId);

}
