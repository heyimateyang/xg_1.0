package org.heyimtaeyang.service.impl;

import java.util.List;

import org.heyimtaeyang.bean.ReplyPageBean;
import org.heyimtaeyang.dao.ReplyDao;
import org.heyimtaeyang.dao.impl.ReplyDaoImpl;
import org.heyimtaeyang.entity.Reply;
import org.heyimtaeyang.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
	
	public ReplyDao replyDao = new ReplyDaoImpl();

	@Override
	public ReplyPageBean getPageBean(int pageSize, int page, int studentId) {
		ReplyPageBean pageBean = new ReplyPageBean();
		String sql = "from Reply where studentId= "+studentId+"and state =2"+"order by replyDate";
        int allRows = replyDao.getAllRowCount(sql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Reply> list = replyDao.queryByPage(sql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
	}

}
