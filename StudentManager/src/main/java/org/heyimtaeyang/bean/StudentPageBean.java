package org.heyimtaeyang.bean;

import java.util.List;

import org.heyimtaeyang.entity.Student;

public class StudentPageBean {
	private List<Student> list; //通过hql从数据库分页查询出来的list集合,学生集合
	private int allRows; //总记录数   
	private int totalPage; //总页数
	private int currentPage; //当前页
	
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getAllRows() {
		return allRows;
	}
	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	 
    /**
     * 得到总页数
     * @param pageSize 每页记录数
     * @param allRows  总记录数
     * @return 总页数
     * @author heyimtaeyang
     */
	public int getTotalPages(int pageSize, int allRows){
        int totalPage = 
        	(allRows % pageSize == 0)? (allRows / pageSize): (allRows / pageSize) + 1;
        return totalPage;
    }
	
	/**
     * 得到当前开始记录号
     * @param pageSize 每页记录数
     * @param currentPage 当前页
     * @author heyimtaeyang
     */
    public int getCurrentPageOffset(int pageSize, int currentPage){
        int offset = pageSize * (currentPage - 1); 
        return offset;
    }
    
    /**
     * 得到当前页， 如果为0 则开始第一页，否则为当前页
     * @param page
     * @author heyimtaeyang
     */
    public int getCurPage(int page){
        int currentPage = (page == 0)? 1: page;
        return currentPage;
    }
}
