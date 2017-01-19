package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.heyimtaeyang.biz.AdminmessageBiz;
import org.heyimtaeyang.biz.ReplyBiz;
import org.heyimtaeyang.dao.ReplyDao;
import org.heyimtaeyang.dao.impl.ReplyDaoImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.entity.Reply;
import org.heyimtaeyang.entity.Student;

public class ReplyBizImpl implements ReplyBiz {

	@Override
	public int addReply(String replymessage, int studentId, int gradeteacherId,String replyTitle,int TeacherReplyId) {
		ReplyDao replyDao = new ReplyDaoImpl();
		AdminmessageBiz adminmessageBiz = new AdminmessageBizImpl();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

		//载入实体类
		Reply reply = new Reply();
		Student student = new Student();
		/*Admin admin = new Admin();
		Adminmessage adminmessage = new Adminmessage();
		adminmessage.setSystermMessageId(TeacherReplyId);

		student.setStudentId(studentId);
		admin.setAdminId(adminId);
		
		
		reply.setAdmin(admin);
		reply.setAdminmessage(adminmessage);
		reply.setReplyDate(df.format(new Date()));
		reply.setReplymessage(replymessage);
		reply.setReplyTitle(replyTitle);
		reply.setStudent(student);
		
		int id = replyDao.addReply(reply);
		if(id != 0){
			adminmessageBiz.updateStateAminMessage(systermMessageId);
			return 1;
		}*/
		return 0;
	}

	@Override
	public Reply findByReplyId(int systermMessageId) {
		String hql = "from Reply where systermMessageId="+systermMessageId;
		ReplyDao replyDao = new ReplyDaoImpl();
		Reply reply = new Reply();
		reply = replyDao.findByid(hql);
		if(reply!=null){
			return reply;
		}
		return null;
	}

}
