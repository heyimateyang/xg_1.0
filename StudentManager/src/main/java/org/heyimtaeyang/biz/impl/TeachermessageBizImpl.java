package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.heyimtaeyang.biz.TeachermessageBiz;
import org.heyimtaeyang.dao.TeachermessageDao;
import org.heyimtaeyang.dao.impl.TeachermessageDaoImpl;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Teachermessage;

public class TeachermessageBizImpl implements TeachermessageBiz {

	@Override
	public int addTeachermessage(String teacherMessageTitle,
			String teacherMessage, int studentId, int gradeteacherId) {
		Teachermessage teacher_message = new Teachermessage();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		Student student = new Student();
		student.setStudentId(studentId);
		
		Gradeteacher gradeteacher = new Gradeteacher();
		gradeteacher.setGradeteacherId(gradeteacherId);
		
		TeachermessageDao teachermessageDao = new TeachermessageDaoImpl();
		try {
			teacher_message.setState(1);
			teacher_message.setStudent(student);
			teacher_message.setGradeteacher(gradeteacher);
			teacher_message.setTeacherMessage(teacherMessage);
			teacher_message.setTeacherMessageDate(df.format(new Date()));
			teacher_message.setTeacherMessageTitle(teacherMessageTitle);
			teachermessageDao.addTeacherMessage(teacher_message);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Teachermessage findByTeacherMessageId(int teacherMessageId) {
		String hql = "from Teachermessage where teacherMessageId = "+teacherMessageId;
		TeachermessageDao teachermessageDao = new TeachermessageDaoImpl();
		Teachermessage teachermessage = teachermessageDao.findByid(hql);
		if(teachermessage!=null){
			return teachermessage;
			
		}
		return null;
	}

	@Override
	public int updateTeacherMessage(int teacherMessageId) {
		String sql 
			= "UPDATE Teachermessage SET state =2 where teacherMessageId = "+teacherMessageId;
		TeachermessageDao teachermessageDao = new TeachermessageDaoImpl();
		int id = teachermessageDao.updateTeacherMessage(sql);
		if(id ==1){
			return 1;
		}
		return 0;
	}

	

	

}
