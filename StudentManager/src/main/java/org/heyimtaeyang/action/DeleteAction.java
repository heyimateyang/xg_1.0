package org.heyimtaeyang.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.DeleteBiz;
import org.heyimtaeyang.biz.DeleteBizImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport {
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//页面接收字段
	private int systermMessageId;
	private int teacherId;
	private int teacherMessageId;
	private int teacherReplyId;
	
	public int getTeacherMessageId() {
		return teacherMessageId;
	}

	public void setTeacherMessageId(int teacherMessageId) {
		this.teacherMessageId = teacherMessageId;
	}

	public int getTeacherReplyId() {
		return teacherReplyId;
	}

	public void setTeacherReplyId(int teacherReplyId) {
		this.teacherReplyId = teacherReplyId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	//管理员(辅导员)页面删除咨询和回复信息
	public int getSystermMessageId() {
		return systermMessageId;
	}

	public void setSystermMessageId(int systermMessageId) {
		this.systermMessageId = systermMessageId;
	}

	public String deleteMessageReply(){
		DeleteBiz deleteBiz = new DeleteBizImpl();
		deleteBiz.deleteReplyMessage(systermMessageId);
		int id = deleteBiz.deleteAdminMessage(systermMessageId);
		if(id !=0 ){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String deleteTeacherMessageReply(){
		DeleteBiz deleteBiz = new DeleteBizImpl();
		deleteBiz.deleteTeacherReplymessage(teacherMessageId);
		deleteBiz.deleteTeachermessage(teacherMessageId);
		request.setAttribute("teacherId", teacherId);
		return SUCCESS;
	}

}
