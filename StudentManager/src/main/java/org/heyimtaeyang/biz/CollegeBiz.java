package org.heyimtaeyang.biz;

public interface CollegeBiz {
	
	//添加学院
	void addCollege(String collegeName);
	
	//按id删除学院
    void deleteCollegeById(int collegeId);
    
    //查找是否有重复的学院名字
  	boolean  findCollegeName(String collegeName);
}
