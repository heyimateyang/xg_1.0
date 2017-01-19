package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Achievement;


/**
 * 成绩DAO
 * @author heyimtaeyang
 *
 */

public interface AchievementDao {
	
	/**
	 * 学生成绩分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Achievement> queryByPage(String sql, int offset, int pageSize);
    int getAllRowCount(String sql);
	
    //添加学生成绩
    int addAchievement(Achievement achievement);
	
    //按id删除成绩
    int deleteAchievementById(String sql);
    
    //模糊查询成绩
    List<Achievement> findLikeAchievement(String sql);
    
    //查找该学生是否有重复的科目名字
    boolean  findAchievementName(String sql);
    
  
}
