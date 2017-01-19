package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.ProfessionBiz;
import org.heyimtaeyang.dao.ProfessionDao;
import org.heyimtaeyang.dao.impl.ProfessionDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Profession;

public class ProfessionBizImpl implements ProfessionBiz {

	//显示全部
	public List<Profession> findProfessionByCollege(int collegeId) {
		String sql = "select * from profession where collegeId="+collegeId;
		ProfessionDao professionDao = new ProfessionDaoImpl();
		List<Profession> list = professionDao.findProfessionByCollege(sql);
		return list;
	}

	//添加专业
	public void addProfession(String professionName, int collegeId) {
		Profession profession = new Profession();
		College college = new College();
		college.setCollegeId(collegeId);
		ProfessionDao professionDao = new ProfessionDaoImpl();
		
		//载入专业信息
		profession.setProfessionName(professionName);
		profession.setCollege(college);
		professionDao.addProfession(profession);
	}

	//按id删除专业
	public void deleteProfession(int professionId) {
		String sql 
			= "DELETE FROM profession WHERE professionId="+professionId;
		ProfessionDao professionDao = new ProfessionDaoImpl();
		professionDao.deleteProfession(sql);
	}

	//按专业id查找学院id
	public List<Profession> findProfessionByProfessionId(int professionId) {
		String sql = "select * from profession where professionId="+professionId;
		ProfessionDao professionDao = new ProfessionDaoImpl();
		List<Profession> list = professionDao.findProfessionByCollege(sql);
		return list;
	}

	//按专业id查找学院
	public Profession findCollege(int professionId) {
		String sql = "select * from profession where professionId="+professionId;
		ProfessionDao professionDao = new ProfessionDaoImpl();
		Profession profession = professionDao.findCollege(sql);
		return profession;
	}

	//遍历全部专业
	public List<Profession> findAll() {
		ProfessionDao professionDao = new ProfessionDaoImpl();
		List<Profession> list 
			= professionDao.findProfessionByCollege("select * from profession");
		return list;
	}

	//查找是否有重复的专业名称
	public boolean findProfessionName(String ProfessionName) {
		String sql = "select * from profession where professionName="+"'"+ProfessionName+"'";
		ProfessionDao professionDao = new ProfessionDaoImpl();
		boolean  rs = professionDao.findProfessionName(sql);
		if(rs==true){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Classmessage> findProfession(int professionId) {
		String hql = "from Classmessage where professionId="+professionId;
		ProfessionDao professionDao = new ProfessionDaoImpl();
		List<Classmessage> list = professionDao.findId(hql);
		return list;
	}

}
