package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.CitationBiz;
import org.heyimtaeyang.dao.CitationDao;
import org.heyimtaeyang.dao.impl.CitationDaoImpl;
import org.heyimtaeyang.entity.Citation;
import org.heyimtaeyang.entity.Student;

public class CitationBizImpl implements CitationBiz {

	//添加获奖信息
	public int addCitation(int studentId,String citationTitle, String citationMessage,
			String myFileFileName,String citationName,
		    String citationDate,String citationlevel) {
		CitationDao citationDao = new CitationDaoImpl();
		Citation citation = new Citation();
		Student student = new Student();
		
		student.setStudentId(studentId);
		
		citation.setCitationImg(myFileFileName);
		citation.setCitationMessage(citationMessage);
		citation.setCitationTitle(citationTitle);
		citation.setCitationlevel(citationlevel);
		citation.setCitationName(citationName);
		citation.setCitationDate(citationDate);
		citation.setState(0);   //默认是没激活,需要管理员审批
		citation.setStudent(student);
		
		int id = citationDao.addCitation(citation);
		if(id !=0){
			return 1;
		}
		return 0;
	}

	//按id查找获奖信息
	public Citation findCitation(int citationId) {
		String hql = "from Citation as u where u.citationId="+citationId;
		CitationDao citationDao = new CitationDaoImpl();
		Citation citation = citationDao.findCitation(hql);
		return citation;
	}

	//按id删除获奖信息
	public int deleteCitation(int citationId) {
		String sql = "delete from citation where citationId="+citationId;
		CitationDao citationDao = new CitationDaoImpl();
		int deleteId = citationDao.deleteCitation(sql);
		if(deleteId!=0){
			return 1;
		}
		return 0;
	}

	//按id删除获奖信息
	public void deleteCitationByStudentId(int studentId) {
		String sql = "delete from citation where studentId="+studentId;
		CitationDao citationDao = new CitationDaoImpl();
		citationDao.deleteCitation(sql);
	}

	//按Citationid修改奖状
	public void updateCitationByCitationId(int citationId,int judgeId) {
		CitationDao citationDao = new CitationDaoImpl();
		if(judgeId==1){
			String sql = "UPDATE citation SET state = 1 WHERE citationid ="+citationId;
			citationDao.updateCitationByCitationId(sql);
		}else if (judgeId==2) {
			String sql = "UPDATE citation SET state = 0 WHERE citationid ="+citationId;
			citationDao.updateCitationByCitationId(sql);
		}
	}

	//按id查找获奖信息
	public Citation findCitationByStudentId(int studentId) {
		String hql = "from Citation where studentId="+studentId;
		CitationDao citationDao = new CitationDaoImpl();
		Citation citation = citationDao.findCitation(hql);
		return citation;
	}

	//辅导员审批获奖情况
	public void updateCitationByCitationId(int citationId) {
		CitationDao citationDao = new CitationDaoImpl();
		String sql = "UPDATE citation SET state = 2 WHERE citationid ="+citationId;
		citationDao.updateCitationByCitationId(sql);
	}

	@Override
	public void updateCitationByCitationIdTeacher(int citationId) {
		CitationDao citationDao = new CitationDaoImpl();
		String sql = "UPDATE citation SET state = 3 WHERE citationid ="+citationId;
		citationDao.updateCitationByCitationId(sql);
	}

	@Override
	public List<Citation> find_Citation(String citationlevel) {
		String hql = "from Citation where citationlevel="+"'"+citationlevel+"'";
		CitationDao citationDao = new CitationDaoImpl();
		List<Citation> list = citationDao.find_Citation(hql);
		return list;
	}
}
