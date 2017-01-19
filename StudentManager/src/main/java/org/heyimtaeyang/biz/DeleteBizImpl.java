package org.heyimtaeyang.biz;

import org.heyimtaeyang.dao.DeleteDao;
import org.heyimtaeyang.dao.impl.DeleteDaoImpl;

public class DeleteBizImpl implements DeleteBiz {
	
	private DeleteDao deleteDao = new DeleteDaoImpl();

	@Override
	public int deleteAdminMessage(int systermMessageId) {
		String sql = "delete from adminmessage where systermMessageId="+systermMessageId;
		int id = deleteDao.deleteAdminMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteReplyMessage(int systermMessageId) {
		String sql = "delete from reply where systermMessageId="+systermMessageId;
		int id = deleteDao.deleteReplyMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteTeachermessage(int gradeteacherId) {
		String sql = "delete from teachermessage where gradeteacherId="+gradeteacherId;
		int id = deleteDao.deleteReplyMessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteTeacherReplymessage(int gradeteacherId) {
		String sql = "delete from teacherreply where gradeteacherId="+gradeteacherId;
		int id = deleteDao.deleteTeachermessage(sql);
		if(id!=0){
			return 1;
		}
		return 0;
	}

}
