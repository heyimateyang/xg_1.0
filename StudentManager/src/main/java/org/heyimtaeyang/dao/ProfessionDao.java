package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Profession;

public interface ProfessionDao {
	
	//按学院id查找专业
	List<Profession> findProfessionByCollege(String sql);
	
	//添加专业
	void addProfession(Profession profession);
	
	/**
	 * 分页显示所有专业
	 * @author heyimtaeyang
	 *
	 */
	List<Profession> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    //按id删除专业
    void deleteProfession(String sql);
    
    //显示全部专业
    List<Profession> findAll();
    
    //按照ID查找班级
    List<Classmessage> findId(String hql);
    
    //按专业id查找学院
    Profession findCollege(String sql);
    
    //查找是否有重复的专业名称
    boolean  findProfessionName(String sql);

}
