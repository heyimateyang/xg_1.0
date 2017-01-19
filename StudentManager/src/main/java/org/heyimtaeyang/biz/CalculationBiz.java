package org.heyimtaeyang.biz;

import java.util.List;

public interface CalculationBiz {
	
	//计算总数
	List Total_Message(int classmessageId);
	
	//计算男生总数
	List Total_Man(int classmessageId);
	
	//计算女生总数
	List Total_Girl(int classmessageId);
	
	//计算团员人数
	List Total_Members(int classmessageId);
	
	//计算预备党员人数
	List Total_ReservePartyMember(int classmessageId);
	
	//计算党员人数
	List Total_PartyMember(int classmessageId);
	
	//计算入党积极分子
	List Total_PartyActivists(int classmessageId);
	
	//计算有多少个贫困生
	List Total_Poor(int classmessageId);
	

}
