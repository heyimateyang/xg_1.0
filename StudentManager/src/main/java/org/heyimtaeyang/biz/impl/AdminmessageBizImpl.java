package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.heyimtaeyang.biz.AdminmessageBiz;
import org.heyimtaeyang.dao.AdminmessageDao;
import org.heyimtaeyang.dao.impl.AdminmessageDaoImpl;
import org.heyimtaeyang.entity.Admin;
import org.heyimtaeyang.entity.Adminmessage;
import org.heyimtaeyang.entity.Student;

public class AdminmessageBizImpl implements AdminmessageBiz {

	@Override
	public int AddMessage(String MessageTitle, String content1, int adminId,
			int studentId) {
		
		AdminmessageDao adminmessageDao = new AdminmessageDaoImpl();
		Adminmessage adminmessage = new Adminmessage();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Student student = new Student();
		student.setStudentId(studentId);
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		
		try {
			adminmessage.setAdmin(admin);
			adminmessage.setStudent(student);
			adminmessage.setMessageTitle(MessageTitle);
			adminmessage.setSystemDate(df.format(new Date()));
			adminmessage.setSystemMessage(content1);
			adminmessage.setState(1);
			adminmessageDao.AddMessage(adminmessage);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//按id查询一条信息
	public Adminmessage findById(int systermMessageId) {
		String hql = "from Adminmessage where systermMessageId = "+systermMessageId;
		AdminmessageDao adminmessageDao = new AdminmessageDaoImpl();
		Adminmessage adminmessage = adminmessageDao.findById(hql);
		if(adminmessage !=null){
			return adminmessage;
		}
		return null;
	}

	@Override
	public int updateStateAminMessage(int systermMessageId) {
		String sql 
			= "UPDATE adminmessage SET state =2 where systermMessageId = "+systermMessageId;
		AdminmessageDao adminmessageDao = new AdminmessageDaoImpl();
		int id = adminmessageDao.updateAdminMessage(sql);
		if(id ==1){
			return 1;
		}
		return 0;
	}

}
