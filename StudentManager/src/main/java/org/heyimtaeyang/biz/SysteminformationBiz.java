package org.heyimtaeyang.biz;



import java.util.List;

import org.heyimtaeyang.entity.Systeminformation;

public interface SysteminformationBiz {
	
	//添加系统公告信息
    int add_SysteminformationBiz(String informationTitle,String content1);
    
    //按id显示系统公告
    Systeminformation FindSysteminformationById(int informationId);
    
    //按id删除系统公告
    int deleteSysteminformationByid(int informationId);
    
    //显示前5条系统公告
    List<Systeminformation> showTop5();
    
    
}
