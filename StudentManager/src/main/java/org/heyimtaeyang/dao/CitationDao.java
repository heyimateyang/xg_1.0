package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Citation;

public interface CitationDao {
	
	//添加学生获奖情况
	int addCitation(Citation Citation);
	
	//分也显示学生奖状情况
	List<Citation> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
     
    //按Id查找奖状
    Citation findCitation(String hql);
    
    //按Id删除奖状
    int deleteCitation(String sql);
    
    //按Citationid修改奖状
    void updateCitationByCitationId(String sql);
    
    List<Citation> find_Citation(String hql);

}
