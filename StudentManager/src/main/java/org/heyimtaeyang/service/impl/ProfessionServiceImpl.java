package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.ProfessionPageBean;
import org.heyimtaeyang.dao.ProfessionDao;
import org.heyimtaeyang.dao.impl.ProfessionDaoImpl;
import org.heyimtaeyang.entity.Profession;
import org.heyimtaeyang.service.ProfessionService;

public class ProfessionServiceImpl implements ProfessionService {

	private ProfessionDao professionDao = new ProfessionDaoImpl();
	
	@Override
	public ProfessionPageBean getPageBean(int pageSize, int page) {
		ProfessionPageBean ProfessionPageBean = new ProfessionPageBean();
		//HQL语句
        String hql = "from Profession";
        int allRows = professionDao.getAllRowCount(hql);
        int totalPage = ProfessionPageBean.getTotalPages(pageSize, allRows);
        int currentPage = ProfessionPageBean.getCurPage(page);
        int offset = ProfessionPageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Profession> list = professionDao.queryByPage(hql, offset, pageSize);
        ProfessionPageBean.setList(list);
        ProfessionPageBean.setAllRows(allRows);
        ProfessionPageBean.setCurrentPage(currentPage);
        ProfessionPageBean.setTotalPage(totalPage);
        return ProfessionPageBean;
	}

}
