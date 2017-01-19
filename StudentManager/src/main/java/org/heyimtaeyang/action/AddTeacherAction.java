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
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.TeacherBizImpl;
import org.heyimtaeyang.dao.ClassmessageDao;
import org.heyimtaeyang.dao.impl.ClassmessageDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Teacher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddTeacherAction extends ActionSupport{
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
    
    //从页面接收字段
    private String userName;
    private String userPwd;
    private int gradeId;
    private String teacherName;
    private String teacherAddress;
    private int teacherPhone; 
    private int teacherQq;
    private int workNumber;
    private int teacherId;
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

	private List<String> classmessageId;
    
    public List<String> getClassmessageId() {
		return classmessageId;
	}

	public void setClassmessageId(List<String> classmessageId) {
		this.classmessageId = classmessageId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	

	public int getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(int workNumber) {
		this.workNumber = workNumber;
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public int getTeacherPhone() {
		return teacherPhone;
	}

	public void setTeacherPhone(int teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public int getTeacherQq() {
		return teacherQq;
	}

	public void setTeacherQq(int teacherQq) {
		this.teacherQq = teacherQq;
	}

	//跳转到添加老师页面Admin
    public String addTeacherList(){
    	
    	return SUCCESS;
    }
    
    //添加班级辅导员Admin
    public String addTeacherAdmin() throws IOException{
    	TeacherBiz teacherBiz = new TeacherBizImpl();
    	
    	//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("TeacherHeadportrait"); 
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
        
        teacherBiz.addTeacher(userName, userPwd, teacherName,
    			teacherAddress,  teacherPhone,  teacherQq,
    			workNumber,  myFileFileName); 

        /*Teacher teacher = teacherBiz.findTeacherNumber(workNumber);
        request.setAttribute("teacher_message", teacher);
        ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
        List<Classmessage> list = classmessageBiz.findByGradeId(gradeId);
        request.setAttribute("Classmessage", list);*/
    	request.setAttribute("workNumber", workNumber);
    	return SUCCESS;
    }
    
    //跳转到助理辅导员的管理班级admin
    public String addTeacherClassmessage(){
    	TeacherBiz teacherBiz = new TeacherBizImpl();
    	Teacher teacher = teacherBiz.findTeacherNumber(workNumber);
    	request.setAttribute("teacher_message", teacher);
    	ClassmessageDao classmessageDao = new ClassmessageDaoImpl();
    	List<Classmessage> list = classmessageDao.findAll();
    	request.setAttribute("listClassmessage", list);
    	return SUCCESS;
    }
    
    //添加助理辅导员管理班级admin
    public String addClassmessageTeacherAdmin(){
    	ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
    	for(int i=0;i<this.getClassmessageId().size();i++){  
    		int id = 
    			classmessageBiz.updateClassmessage(Integer.valueOf(this.getClassmessageId().get(i)),teacherId );
    		if(id==0){
    			return ERROR;
    		}
   	 	}  
    	return SUCCESS;
    }
    
    //添加班级辅导员Admin
    public String addTeacherAdminClass(){
    	
    	//teacherBiz.addTeacherClassMessage(teacherId, classmessageId);
    	return SUCCESS;
    }
    
    //跳转到修改班级辅导员页面admin
    public String updateTeacherAdminIndex(){
    	TeacherBiz teacherBiz = new TeacherBizImpl();
    	//查找班级辅导员
		Teacher teacher = teacherBiz.findTeacherById(this.teacherId);
		//存入班级辅导员资料
		request.setAttribute("teacher_message", teacher);
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		List<Classmessage> list = classmessageBiz.findByteacherId(this.teacherId);
		request.setAttribute("list_classmessage", list);
    	return SUCCESS;
    }
    
    //修改班级辅导员信息admin
    public String updateTeacherAdminMessage() throws IOException{
    	
    	if(myFile == null){
    		myFileFileName = this.picName;
    		//修改班级辅导员资料
            TeacherBiz teacherBiz = new TeacherBizImpl();
            teacherBiz.updateTeacher(teacherId,  teacherName,
        			 userName,  userPwd,  myFileFileName,
        			 workNumber,   teacherAddress,
        			 teacherPhone,  teacherQq, userId);
            request.setAttribute("teacherId", teacherId);
        	return SUCCESS;
    	}else{
    		//基于myFile创建一个文件输入流  
            InputStream is = new FileInputStream(myFile);  
              
            // 设置上传文件目录  
            String uploadPath = ServletActionContext.getServletContext()  
                    .getRealPath("TeacherHeadportrait"); 
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
            
            //修改班级辅导员资料
            TeacherBiz teacherBiz = new TeacherBizImpl();
            teacherBiz.updateTeacher(teacherId,  teacherName,
       			 userName,  userPwd,  myFileFileName,
       			 workNumber,   teacherAddress,
       			 teacherPhone,  teacherQq, userId);
            request.setAttribute("teacherId", teacherId);
        	return SUCCESS;
    	}
    	
    }
    
    //跳转到修改班级辅导员页面Teacher
    public String updateTeacherIndex(){
    	
    	return SUCCESS;
    }
    
    //修改班级辅导员信息admin
    public String updateTeacherMessage() throws IOException{
    	
    	if(myFile==null){
    		myFileFileName = this.picName;
    		//修改班级辅导员资料
            TeacherBiz teacherBiz = new TeacherBizImpl();
            /*teacherBiz.updateTeacher(teacherId, teacherName, userName, userPwd, 
            		myFileFileName, workNumber, classmessageId, 
            		teacherAddress, teacherPhone, 
            		teacherQq, userId);*/
            request.setAttribute("teacherId", teacherId);
        	return SUCCESS;
    	}else{
    		//基于myFile创建一个文件输入流  
            InputStream is = new FileInputStream(myFile);  
              
            // 设置上传文件目录  
            String uploadPath = ServletActionContext.getServletContext()  
                    .getRealPath("TeacherHeadportrait"); 
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

            //修改班级辅导员资料
            TeacherBiz teacherBiz = new TeacherBizImpl();
           /* teacherBiz.updateTeacher(teacherId, teacherName, userName, userPwd, 
            		myFileFileName, workNumber, classmessageId, 
            		teacherAddress, teacherPhone, 
            		teacherQq, userId);*/
            request.setAttribute("teacherId", teacherId);
        	return SUCCESS;
    	}
    	
    }
}
