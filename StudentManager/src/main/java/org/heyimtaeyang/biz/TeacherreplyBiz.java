package org.heyimtaeyang.biz;

import org.heyimtaeyang.entity.Teacherreply;

public interface TeacherreplyBiz {
	
	//添加一条助理辅导员回复信息
	int addTercherreply(int TeacherMessageId,int studentId,int gradeteacherId,String replyTitle,String replymessage);
	
	//按id查询一条助理员处理好的信息
    Teacherreply findById(int gradeteacherId,int TeacherMessageId);
    
    //按id查询一条助理员处理好的信息
    Teacherreply findById(int gradeteacherId);
    
    Teacherreply findByIdTeacherReplyId(int teacherReplyId);
    
    

}
