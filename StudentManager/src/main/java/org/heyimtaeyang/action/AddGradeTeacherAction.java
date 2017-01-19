package org.heyimtaeyang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.impl.GradeBizImpl;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;
import org.heyimtaeyang.dao.CollegeDao;
import org.heyimtaeyang.dao.impl.CollegeDaoImpl;
import org.heyimtaeyang.entity.College;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Gradeteacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddGradeTeacherAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	// myFile属性用来封装上传的文件  
    private File myFile;    
    // myFileContentType属性用来封装上传文件的类型  
    private String myFileContentType;  
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;
    
    //从页面接收的字段
    private String userName;
    private String userPwd;
    private int workNumber;
    private int userId;
    private String picName;
    
    public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWorkNumber() {
		return workNumber;
	}
	public void setWorkNumber(int workNumber) {
		this.workNumber = workNumber;
	}

	private int gradeId;
    private int gradeteacherId;
    public int getGradeteacherId() {
		return gradeteacherId;
	}
	public void setGradeteacherId(int gradeteacherId) {
		this.gradeteacherId = gradeteacherId;
	}

	private int collegeId;
    private String address;
    private int gradeteacherPhone;
    private int gradeteacherQqnumber;
    private String gradeteacherName;
    
	public String getGradeteacherName() {
		return gradeteacherName;
	}
	public void setGradeteacherName(String gradeteacherName) {
		this.gradeteacherName = gradeteacherName;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getGradeteacherPhone() {
		return gradeteacherPhone;
	}
	public void setGradeteacherPhone(int gradeteacherPhone) {
		this.gradeteacherPhone = gradeteacherPhone;
	}
	public int getGradeteacherQqnumber() {
		return gradeteacherQqnumber;
	}
	public void setGradeteacherQqnumber(int gradeteacherQqnumber) {
		this.gradeteacherQqnumber = gradeteacherQqnumber;
	}
    
	//添加年级辅导员admin
	public String addGradeTeacherAdmin() throws IOException{
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("GradeTeacherHeadportrait"); 
          System.out.println(uploadPath);
        // 设置目标文件  
        File toFile = new File(uploadPath, this.getMyFileFileName());  
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        //System.out.println("上传用户"+username);  
        System.out.println("上传文件名"+myFileFileName);  
        System.out.println("上传文件类型"+myFileContentType);  
        //关闭输入流  
        is.close();   
        //关闭输出流  
        os.close(); 
        
        GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
        gradeteacherBiz.addGradeTeacher(userName, userPwd, gradeteacherName, 
        		address, gradeteacherPhone, gradeteacherQqnumber, myFileFileName,this.workNumber);
		return SUCCESS;
	}
	
	//跳转到修改年级辅导员页面AdminIndex
	public String updateGradeTeacherIndex(){
		//遍历年级元素
		GradeBiz gradeBiz = new GradeBizImpl();
		List<Grade> list = gradeBiz.findAll();
		request.setAttribute("Grade_list", list);
		//遍历学院元素
		CollegeDao collegeDao = new CollegeDaoImpl();
		List<College> lists = collegeDao.findAll();
		request.setAttribute("college_list", lists);
		//查找年级辅导员
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		Gradeteacher gradeteacher = gradeteacherBiz.findGradeTeacher(this.gradeteacherId);
		request.setAttribute("gradeteacher_message", gradeteacher);
		return SUCCESS;
	}
	
	//修改年级辅导员信息admin
	public String updateGradeTeacherAdmin() throws IOException{
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("GradeTeacherHeadportrait"); 
          System.out.println(uploadPath);
        // 设置目标文件  
        File toFile = new File(uploadPath, this.getMyFileFileName());  
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        //System.out.println("上传用户"+username);  
        System.out.println("上传文件名"+myFileFileName);  
        System.out.println("上传文件类型"+myFileContentType);  
        //关闭输入流  
        is.close();   
        //关闭输出流  
        os.close(); 
        
        
		GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
		gradeteacherBiz.UpdateGradeTeacher(gradeteacherId, gradeteacherName, userName, 
				userPwd, myFileFileName, workNumber,  
				address, gradeteacherPhone, gradeteacherQqnumber, userId);
		request.setAttribute("gradeteacherId", gradeteacherId);
		return SUCCESS;
	}
	
	//更新年级辅导员信息GradeTeacher
	public String updateActionGradeTeacher() throws IOException{
		
		if(myFile==null){
			myFileFileName = this.picName;
			GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
			gradeteacherBiz.UpdateGradeTeacher(gradeteacherId, gradeteacherName, userName, 
					userPwd, myFileFileName, workNumber, 
					address, 
					gradeteacherPhone, gradeteacherQqnumber, userId);
			request.setAttribute("gradeteacherId", gradeteacherId);
			return SUCCESS;
		}else{
			//基于myFile创建一个文件输入流  
	        InputStream is = new FileInputStream(myFile);  
	          
	        // 设置上传文件目录  
	        String uploadPath = ServletActionContext.getServletContext()  
	                .getRealPath("GradeTeacherHeadportrait"); 
	          System.out.println(uploadPath);
	        // 设置目标文件  
	        File toFile = new File(uploadPath, this.getMyFileFileName());  
	          
	        // 创建一个输出流  
	        OutputStream os = new FileOutputStream(toFile);  
	  
	        //设置缓存  
	        byte[] buffer = new byte[1024];  
	  
	        int length = 0;  
	  
	        //读取myFile文件输出到toFile文件中  
	        while ((length = is.read(buffer)) > 0) {  
	            os.write(buffer, 0, length);  
	        }  
	        //System.out.println("上传用户"+username);  
	        System.out.println("上传文件名"+myFileFileName);  
	        System.out.println("上传文件类型"+myFileContentType);  
	        //关闭输入流  
	        is.close();   
	        //关闭输出流  
	        os.close(); 
	        
	        GradeteacherBiz gradeteacherBiz = new GradeteacherBizImpl();
			gradeteacherBiz.UpdateGradeTeacher(gradeteacherId, gradeteacherName, userName, 
					userPwd, myFileFileName, workNumber, 
					 address, 
					gradeteacherPhone, gradeteacherQqnumber, userId);
			request.setAttribute("gradeteacherId", gradeteacherId);
			return SUCCESS;
		}
		
	}
}
