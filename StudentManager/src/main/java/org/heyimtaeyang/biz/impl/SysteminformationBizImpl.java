package org.heyimtaeyang.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.heyimtaeyang.biz.SysteminformationBiz;
import org.heyimtaeyang.dao.SysteminformationDao;
import org.heyimtaeyang.dao.impl.SysteminformationDaoImpl;
import org.heyimtaeyang.entity.Systeminformation;

public class SysteminformationBizImpl implements SysteminformationBiz {

	@Override
	public int add_SysteminformationBiz(String informationTitle, String content1) {
		SysteminformationDao systeminformationDao 
			= new SysteminformationDaoImpl();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		Systeminformation systeminformation = new Systeminformation();
		systeminformation.setInformationMessage(content1);
		systeminformation.setInformationTitle(informationTitle);
		systeminformation.setInformationDate(df.format(new Date()));
		
		try {
			systeminformationDao.addSysteminformation(systeminformation);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Systeminformation FindSysteminformationById(int informationId) {
		String 
			hql = "from Systeminformation where informationId="+informationId;
		SysteminformationDao systeminformationDao = new SysteminformationDaoImpl();
		Systeminformation systeminformation = new Systeminformation();
		try {
			systeminformation = systeminformationDao.findById(hql);
			return systeminformation;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteSysteminformationByid(int informationId) {
		String 
			hql = "DELETE FROM Systeminformation WHERE informationId="+informationId;
		SysteminformationDao systeminformationDao = new SysteminformationDaoImpl();
		try {
			systeminformationDao.deleteSysteminformationByid(hql);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//显示前5条系统公告
	public List<Systeminformation> showTop5() {
		String hql 
			= "from Systeminformation order by informationDate";
		SysteminformationDao systeminformationDao 
			= new SysteminformationDaoImpl();
		List<Systeminformation> list 
			= systeminformationDao.showSysteminformation(hql);
		if(list != null){
			return list;
		}
		return null;
	}

}
