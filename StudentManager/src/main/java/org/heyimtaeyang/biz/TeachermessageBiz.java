package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Teachermessage;

public interface TeachermessageBiz {
	
	//添加一条助理辅导员的信息
	int addTeachermessage(String teacherMessageTitle,String teacherMessage,int studentId ,int gradeteacherId);
	
	//按ID查找一条助理辅导员的信息
    Teachermessage findByTeacherMessageId(int teacherMessageId);

    //修改信息状态
    int updateTeacherMessage(int teacherMessageId);

}
