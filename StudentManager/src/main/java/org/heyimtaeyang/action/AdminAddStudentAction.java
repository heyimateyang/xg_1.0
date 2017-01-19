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
import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.biz.PoliticalBiz;
import org.heyimtaeyang.biz.PostBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.GradeBizImpl;
import org.heyimtaeyang.biz.impl.PoliticalBizImpl;
import org.heyimtaeyang.biz.impl.PostBizImpl;
import org.heyimtaeyang.biz.impl.StudentBizImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Political;
import org.heyimtaeyang.entity.Post;
import org.heyimtaeyang.entity.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAddStudentAction extends ActionSupport{
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	
	//从页面接收字段
	private String userName;
	private String userPwd;
	private Long studentNumber; 
	private String studentName;
	private String sex;
	private String nation;
	private int PoliticallandscapeId;
	private String PlaceofBirth;
	private String birthday;
	private String height;
	private String weight;
	private int gradeName;
	private String dateTime;
	private String state;
	private String corporation;
	private String corporationpost;
	private Long phoneNumber;
	private String homePhone;
	private Long qqNumber;
	private String WeChat;
	private String email;
	private String address;
	private int JurisdictionId;
	private String idcard;
	private String shcoolName;
	private int classmessageId;
	private int studentId;
	private int postId;
	private String remarks;
	private String dormitory;
	private String interest;
	private int poor;
	private int gradeId;
	private String studentGradeName;

	public String getStudentGradeName() {
		return studentGradeName;
	}


	public void setStudentGradeName(String studentGradeName) {
		this.studentGradeName = studentGradeName;
	}


	public int getGradeId() {
		return gradeId;
	}


	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}


	public int getPoor() {
		return poor;
	}


	public void setPoor(int poor) {
		this.poor = poor;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getDormitory() {
		return dormitory;
	}


	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}


	public String getInterest() {
		return interest;
	}


	public void setInterest(String interest) {
		this.interest = interest;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public int getClassmessageId() {
		return classmessageId;
	}


	public void setClassmessageId(int classmessageId) {
		this.classmessageId = classmessageId;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
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


	public Long getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public int getPoliticallandscapeId() {
		return PoliticallandscapeId;
	}


	public void setPoliticallandscapeId(int politicallandscapeId) {
		PoliticallandscapeId = politicallandscapeId;
	}


	public String getPlaceofBirth() {
		return PlaceofBirth;
	}


	public void setPlaceofBirth(String placeofBirth) {
		PlaceofBirth = placeofBirth;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public int getGradeName() {
		return gradeName;
	}


	public void setGradeName(int gradeName) {
		this.gradeName = gradeName;
	}


	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCorporation() {
		return corporation;
	}


	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}


	public String getCorporationpost() {
		return corporationpost;
	}


	public void setCorporationpost(String corporationpost) {
		this.corporationpost = corporationpost;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}


	public Long getQqNumber() {
		return qqNumber;
	}


	public void setQqNumber(Long qqNumber) {
		this.qqNumber = qqNumber;
	}


	public String getWeChat() {
		return WeChat;
	}


	public void setWeChat(String weChat) {
		WeChat = weChat;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getJurisdictionId() {
		return JurisdictionId;
	}


	public void setJurisdictionId(int jurisdictionId) {
		JurisdictionId = jurisdictionId;
	}


	public String getIdcard() {
		return idcard;
	}


	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}


	public String getShcoolName() {
		return shcoolName;
	}


	public void setShcoolName(String shcoolName) {
		this.shcoolName = shcoolName;
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

	// myFile属性用来封装上传的文件  
    private File myFile;  
      
    // myFileContentType属性用来封装上传文件的类型  
    private String myFileContentType;  
  
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;
    
    
    //添加学生信息
    public String addStudentAdmin() throws IOException{
    	//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("studentHeadportrait"); 
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
        System.out.println(studentGradeName);
    	StudentBiz studentBiz = new StudentBizImpl();
    	studentBiz.addStudent( userName, userPwd, myFileFileName, studentNumber, studentName,
      			 sex, nation, PoliticallandscapeId, PlaceofBirth, birthday, height,
      			 weight, gradeName, dateTime, state, corporation, corporationpost, phoneNumber,
      			 homePhone, qqNumber, WeChat, email, address, JurisdictionId, idcard, shcoolName
      			, interest, dormitory, remarks, poor,studentGradeName);
    	
    	//根据usersId查找学生传值
    	Student student = studentBiz.findStudentNumber(studentNumber);
    	
    	ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
    	List<Classmessage> list = classmessageBiz.findByGradeId(gradeName);
    	PostBiz postBiz = new PostBizImpl();
    	List<Post> post_list = postBiz.showAll();
    	request.setAttribute("post_list", post_list);   //载入班级职务
    	request.setAttribute("list", list);
    	session.setAttribute("student", student);
    	return SUCCESS;
    }
    
    //添加学生班级信息 admin
  	public String addClassMessage(){
  		
  		StudentBiz studentBiz = new StudentBizImpl();
  		studentBiz.updateStudentClass(classmessageId,studentId, this.postId );
  		
  		return SUCCESS;
  	}
  	
  	//添加学生班级信息GradeTeacher
  	public String addClassMessageGradeTeacher(){
  		
  		StudentBiz studentBiz = new StudentBizImpl();
  		studentBiz.updateStudentClassGradeTeacher(classmessageId,studentId, this.postId );
  		request.setAttribute("gradeId", gradeId);
  		return SUCCESS;
  	}
  	
  	//跳转辅导员添加学生班级页面
  	
  	//辅导员添加学生
    public String addStudentGradeTeacher() throws IOException{
    	//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
          
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("studentHeadportrait"); 
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
        System.out.println("111上传文件类型"+myFileContentType);  
        //关闭输入流  
        is.close();   
        //关闭输出流  
        os.close(); 
        System.out.println(studentGradeName);
    	StudentBiz studentBiz = new StudentBizImpl();
    	studentBiz.addStudentGradeTeacher( userName, userPwd, myFileFileName, studentNumber, studentName,
      			 sex, nation, PoliticallandscapeId, PlaceofBirth, birthday, height,
      			 weight, gradeName, dateTime, state, corporation, corporationpost, phoneNumber,
      			 homePhone, qqNumber, WeChat, email, address, JurisdictionId, idcard, shcoolName
      			, interest, dormitory, remarks, poor,studentGradeName);
    	
    	//根据usersId查找学生传值
    	Student student = studentBiz.findStudentNumber(studentNumber);
    	System.out.println(student.getStudentId());
    	ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
    	List<Classmessage> list = classmessageBiz.findByGradeId(gradeName);
    	PostBiz postBiz = new PostBizImpl();
    	List<Post> post_list = postBiz.showAll();
    	request.setAttribute("post_list", post_list);   //载入班级职务
    	request.setAttribute("list", list);
    	session.setAttribute("student", student);
    	return SUCCESS;
    }
    
    //无操GradTeacher跳转到辅导员添加学生页面
    public String AddSutdentGradeTeacherPage(){
    	GradeBiz gradeBiz = new GradeBizImpl();
		PoliticalBiz politicalBiz = new PoliticalBizImpl();
    	List<Political> list_political = politicalBiz.showAll();
		List<Grade> list = gradeBiz.findAll();
		request.setAttribute("list_AddStudent", list);
		request.setAttribute("list_political", list_political);
    	return SUCCESS;
    }
    
    //启动学生帐号
    public String AdminStudentState(){
    	StudentBiz studentBiz = new StudentBizImpl();
    	studentBiz.updateSutdentState(this.studentId);
    	request.setAttribute("studentId", studentId);
    	return SUCCESS;
    }
}
