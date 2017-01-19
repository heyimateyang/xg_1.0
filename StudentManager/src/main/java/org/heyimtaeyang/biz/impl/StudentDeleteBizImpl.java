package org.heyimtaeyang.biz.impl;

import org.heyimtaeyang.biz.StudentDeleteBiz;
import org.heyimtaeyang.dao.DeleteDao;
import org.heyimtaeyang.dao.impl.DeleteDaoImpl;

public class StudentDeleteBizImpl implements StudentDeleteBiz {

	private DeleteDao deleteDao = new DeleteDaoImpl();
	
	@Override
	public int deleteAdminMessage(int studentId) {
		String sql = "delete from adminmessage where studentId="+studentId;
		int id = deleteDao.deleteAdminMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteReplyMessage(int studentId) {
		String sql = "delete from reply where studentId="+studentId;
		int id = deleteDao.deleteReplyMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteTeachermessage(int studentId) {
		String sql = "delete from teachermessage where studentId="+studentId;
		int id = deleteDao.deleteReplyMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteTeacherReplymessage(int studentId) {
		String sql = "delete from teacherreply where studentId="+studentId;
		int id = deleteDao.deleteTeachermessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

}
