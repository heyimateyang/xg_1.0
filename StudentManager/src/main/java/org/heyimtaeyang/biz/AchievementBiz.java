package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Achievement;

/**
 * AchievementBiz
 * @author heyimtaeyang
 *
 */
public interface AchievementBiz {
	
	//添加学生成绩
    int addAchievement(String achievementName, int achievementScore,int studentId);
    
    //按id删除学生成绩
    int deleteAchievementById(int achievementId);
    
    //模糊查询成绩
    List<Achievement> findLikeAchievement(int gradeId,String achievementName);
    
    //按学生id删除学生成绩
    void deleteAchievementByStudentId(int studentId);
    
    //查找该学生是否有重复的科目名字
    boolean  findAchievementName(int studentId,String achievementName);
}
