package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Citation;

public interface CitationBiz {
	
	//添加获奖信息
	int addCitation(int studentId,String citationTitle,String citationMessage,String myFileFileName,String citationName,
    String citationDate,String citationlevel);
	
	//按id查找获奖信息
	Citation findCitation(int citationId);
	
	//按id删除获奖信息
    int deleteCitation(int citationId);
    
    //按id删除获奖信息
    void deleteCitationByStudentId(int studentId);
    
    //按Citationid修改奖状
    void updateCitationByCitationId(int citationId,int judgeId);
    
    //按Citationid修改奖状GradeTeacher
    void updateCitationByCitationId(int citationId);
    
    //按Citationid修改奖状Teacher
    void updateCitationByCitationIdTeacher(int citationId);
    
    //按id查找获奖信息
  	Citation findCitationByStudentId(int studentId);
  	
  	List<Citation> find_Citation(String citationlevel);
}
