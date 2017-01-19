package org.heyimtaeyang.dao;

public interface DeleteDao {
	
	//删除咨询信息
	int deleteAdminMessage(String sql);
	
	//删除回复信息
	int deleteReplyMessage(String sql);
	
	//删除助理辅导员的咨询信息
	int deleteTeachermessage(String sql);
	
	//删除助理辅导员的咨询信息
	int deleteTeacherReplymessage(String sql);
}
