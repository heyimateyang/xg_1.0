package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.heyimtaeyang.biz.TeachermessageBiz;
import org.heyimtaeyang.biz.TeacherreplyBiz;
import org.heyimtaeyang.dao.TeacherreplyDao;
import org.heyimtaeyang.dao.impl.TeacherreplyDaoImpl;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Teacher;
import org.heyimtaeyang.entity.Teachermessage;
import org.heyimtaeyang.entity.Teacherreply;

public class TeacherreplyBizImpl implements TeacherreplyBiz {

	@Override
	public int addTercherreply(int TeacherMessageId, int studentId,
			int gradeteacherId,String replyTitle,String replymessage) {
		TeacherreplyDao teacherreplyDao = new TeacherreplyDaoImpl();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Teacherreply teacherreply = new Teacherreply();
		Gradeteacher gradeteacher = new Gradeteacher();
		gradeteacher.setGradeteacherId(gradeteacherId);
		Teachermessage teachermessage = new Teachermessage();
		teachermessage.setTeacherMessageId(TeacherMessageId);
		Student student = new Student();
		student.setStudentId(studentId);
		
		teacherreply.setReplyDate(df.format(new Date()));
		teacherreply.setReplymessage(replymessage);
		teacherreply.setReplyTitle(replyTitle);
		teacherreply.setTeachermessage(teachermessage);
		teacherreply.setGradeteacher(gradeteacher);
		teacherreply.setStudent(student);
		TeachermessageBiz teachermessageBiz = new TeachermessageBizImpl();
		teachermessageBiz.updateTeacherMessage(TeacherMessageId);
		
		int id = teacherreplyDao.addTeacherRepyl(teacherreply);
		if(id!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public Teacherreply findById(int gradeteacherId, int TeacherMessageId) {
		String hql 
			= "from Teacherreply where gradeteacherId=" + gradeteacherId + "and teacherReplyId=" + TeacherMessageId;
		TeacherreplyDao teacherreplyDao = new TeacherreplyDaoImpl();
		Teacherreply teacherreply = teacherreplyDao.findById(hql);
		return teacherreply;
	}

	@Override
	public Teacherreply findById(int gradeteacherId) {
		String hql 
			= "from Teacherreply where gradeteacherId=" + gradeteacherId;
		TeacherreplyDao teacherreplyDao = new TeacherreplyDaoImpl();
		Teacherreply teacherreply = teacherreplyDao.findById(hql);
		return teacherreply;
	}

	@Override
	public Teacherreply findByIdTeacherReplyId(int teacherReplyId) {
		String hql 
			= "from Teacherreply where teacherReplyId=" + teacherReplyId;
		TeacherreplyDao teacherreplyDao = new TeacherreplyDaoImpl();
		Teacherreply teacherreply = teacherreplyDao.findById(hql);
		return teacherreply;
	}

}
