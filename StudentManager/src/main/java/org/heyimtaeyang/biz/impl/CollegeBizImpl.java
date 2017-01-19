package org.heyimtaeyang.biz.impl;

import org.heyimtaeyang.biz.CollegeBiz;
import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.dao.impl.CollegeDaoImpl;
import org.heyimtaeyang.entity.College;

public class CollegeBizImpl implements CollegeBiz {

	//添加学院
	public void addCollege(String collegeName) {
		CollegeDao collegeDao = new CollegeDaoImpl();
		College college = new College();
		college.setCollegeName(collegeName);
		collegeDao.addCollege(college);
	}

	//按id删除学院
	public void deleteCollegeById(int collegeId) {
		String sql = "DELETE FROM college WHERE collegeId="+collegeId;
		CollegeDao collegeDao = new CollegeDaoImpl();
		collegeDao.deleteCollegeById(sql);
	}

	//查找是否有重复的学院名字
	public boolean findCollegeName(String collegeName) {
		String hql = "select * from college where collegeName="+"'"+collegeName+"'";
		CollegeDao collegeDao = new CollegeDaoImpl();
		boolean  rs = collegeDao.findCollegeName(hql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}

}
