package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.heyimtaeyang.biz.LeaveStudentBiz;
import org.heyimtaeyang.dao.LeavestudentDao;
import org.heyimtaeyang.dao.impl.LeavestudentDaoImpl;
import org.heyimtaeyang.entity.Leavestudent;
import org.heyimtaeyang.entity.Student;

public class LeaveStudentBizImpl implements LeaveStudentBiz {
	
	
	private LeavestudentDao leavestudentDao = new LeavestudentDaoImpl();

	@Override
	public int addLeaveStudent(int studentId, String leaveContent,
			String leaveBeginTime, String leaveEndTime) {
		
		Leavestudent leavestudent = new Leavestudent();
		Student student = new Student();
		
		student.setStudentId(studentId);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		leavestudent.setLeaveTime(df.format(new Date()));
		leavestudent.setLeaveState(1);
		leavestudent.setStudent(student);
		leavestudent.setLeaveContent(leaveContent);
		leavestudent.setLeaveBeginTime(leaveBeginTime);
		leavestudent.setLeaveEndTime(leaveEndTime);
		
		int i = leavestudentDao.addLeavestudent(leavestudent);
		
		if(i!=0){
			return 1;
		}
		
		return 0;
	}

	@Override
	public int deleteLeaveStudent(int leaveId) {
		String sql = "delete from Leavestudent where leaveId="+leaveId;
		int i = leavestudentDao.deleteLeaveStudent(sql);
		if(i!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public Leavestudent ShowLeaveStudent(int leaveId) {
		String hql = "from Leavestudent where leaveId="+leaveId;
		Leavestudent leavestudent = leavestudentDao.ShowLeaveStudent(hql);
		return leavestudent;
	}

	@Override
	public int updateLeaveStudent(int leaveId) {
		String sql = "UPDATE Leavestudent SET leaveState =2 where leaveId = "+leaveId;
		leavestudentDao.updateLeaveStudent(sql);
		return 1;
	}

}
