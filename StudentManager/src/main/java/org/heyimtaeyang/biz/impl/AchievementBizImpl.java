package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.AchievementBiz;
import org.heyimtaeyang.dao.AchievementDao;
import org.heyimtaeyang.dao.impl.AchievementDaoImpl;
import org.heyimtaeyang.entity.Achievement;
import org.heyimtaeyang.entity.Student;


public class AchievementBizImpl implements AchievementBiz {

	/*public AchievementDao achievementDao = new AchievementDaoImpl();*/
	
	//添加学生成绩
	public int addAchievement(String achievementName, int achievementScore,int studentId) {
		Achievement achievement = new Achievement();
		AchievementDao achievementDao = new AchievementDaoImpl();
		
		Student student = new Student();
		student.setStudentId(studentId);
		
		achievement.setStudent(student);
		achievement.setAchievementName(achievementName);
		achievement.setAchievementScore(achievementScore);

		int id = achievementDao.addAchievement(achievement);
		if(id!=0){
			return 1;
		}else{
			return 0;
		}	
	}

	//按id删除学生成绩
	public int deleteAchievementById(int achievementId) {
		AchievementDao achievementDao = new AchievementDaoImpl();
		String sql = "delete from achievement where achievementId="+achievementId;
		int id  = achievementDao.deleteAchievementById(sql);
		if(id !=0){
			return 1;
		}else{
			return 0;
		}
	}

	//模糊查询成绩
	public List<Achievement> findLikeAchievement(int gradeId,String achievementName) {
		String sql = "select * from achievement,student where student.gradeId="+gradeId+" and achievementName like '%"+achievementName+"%' and achievement.studentId=student.studentId";
		AchievementDao achievementDao = new AchievementDaoImpl();
		List<Achievement> list = achievementDao.findLikeAchievement(sql);
		return list;
	}

	//按学生id删除学生成绩
	public void deleteAchievementByStudentId(int studentId) {
		String sql = "delete from achievement where studentId="+studentId;
		AchievementDao achievementDao = new AchievementDaoImpl();
		achievementDao.deleteAchievementById(sql);
	}

	//查找该学生是否有重复的科目名字
	public boolean findAchievementName(int studentId,String achievementName) {
		String sql = "select * from achievement where studentId "
				+ "="+studentId+" and achievementName="+"'"+achievementName+"'";
		AchievementDao achievementDao = new AchievementDaoImpl();
		boolean  rs = achievementDao.findAchievementName(sql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}
}
