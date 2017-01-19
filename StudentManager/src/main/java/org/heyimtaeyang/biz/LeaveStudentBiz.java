package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Leavestudent;

public interface LeaveStudentBiz {
	
	//学生申请请假存根
	public int addLeaveStudent(int studentId,String leaveContent,
			String leaveBeginTime,String leaveEndTime );
	
	//删除请假存根
	int deleteLeaveStudent(int leaveId);
	
	//查看请假条
	public Leavestudent ShowLeaveStudent(int leaveId);
	
	int updateLeaveStudent(int leaveId);

}
