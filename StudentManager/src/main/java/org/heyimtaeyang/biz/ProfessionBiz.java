package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Profession;

public interface ProfessionBiz {
	
	//按学院id查找专业
	List<Profession> findProfessionByCollege(int collegeId);
	
	//添加专业
	void addProfession(String professionName,int collegeId);
	
	//按id删除专业
    void deleteProfession(int professionId);
    
    //按专业id查找学院id
    List<Profession> findProfessionByProfessionId(int professionId);
    
    //按专业id查找学院
    Profession findCollege(int professionId);
    
    //遍历全部专业
    List<Profession> findAll();
    
    //查找是否有重复的专业名称
    boolean findProfessionName(String ProfessionName);
    
    //按专业id查找班级
    List<Classmessage> findProfession(int professionId);
}
