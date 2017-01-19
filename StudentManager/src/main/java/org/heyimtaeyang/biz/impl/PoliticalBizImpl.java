package org.heyimtaeyang.biz.impl;

import java.util.List;

import org.heyimtaeyang.biz.PoliticalBiz;
import org.heyimtaeyang.dao.PoliticalDao;
import org.heyimtaeyang.dao.impl.PoliticalDaoImpl;
import org.heyimtaeyang.entity.Political;

public class PoliticalBizImpl implements PoliticalBiz {

	@Override
	public List<Political> showAll() {
		String hql = "from Political";
		PoliticalDao politicalDao = new PoliticalDaoImpl();
		try {
			List<Political> list = politicalDao.showAll(hql);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
