package org.heyimtaeyang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.impl.StudentBizImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SutdentUpdateAction extends ActionSupport{
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	public HttpServletResponse response;
	
	// myFile属性用来封装上传的文件  
    private File myFile;  
    // myFileContentType属性用来封装上传文件的类型  
    private String myFileContentType;  
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;
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
	
	//从学生更新页面接收字段
	private int studentId;
	private int userId;
	private String userPwd;
	private String studentName;
	private String sex;
	private String nation;
	private int PoliticallandscapeId;
	private String PlaceofBirth;
	private String birthday;
	private String height;
	private String weight;
	
	private int classmessageId;
	private int postId;
	private String corporation;
	private String corporationpost;
	private String interest;
	private String dormitory;
	private Long phoneNumber;
	private String homePhone;
	private Long qqNumber;
	private String WeChat;
	private String email;
	private String address;
	private String picName;

	private int gradeName;
	private int JurisdictionId;
	private String remarks;
	
	private String userName;
	private Long studentNumber;
	private String shcoolName;
	private String dateTime;
	private String state;
	
	private String idcard;

	
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getShcoolName() {
		return shcoolName;
	}
	public void setShcoolName(String shcoolName) {
		this.shcoolName = shcoolName;
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
	public int getGradeName() {
		return gradeName;
	}
	public void setGradeName(int gradeName) {
		this.gradeName = gradeName;
	}
	public int getJurisdictionId() {
		return JurisdictionId;
	}
	public void setJurisdictionId(int jurisdictionId) {
		JurisdictionId = jurisdictionId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
	
	public int getClassmessageId() {
		return classmessageId;
	}
	public void setClassmessageId(int classmessageId) {
		this.classmessageId = classmessageId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
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
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	public String getWeChat() {
		return WeChat;
	}
	public void setWeChat(String weChat) {
		WeChat = weChat;
	}
	public Long getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(Long qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	//学生页面更新学生信息Student
	public String update_Student() throws Exception{
		System.out.println(idcard);
		if(myFile==null){
			myFileFileName = this.picName;
			StudentBiz studentBiz = new StudentBizImpl();
	        try {
	        	studentBiz.updateStudent(studentId, userId, userPwd, myFileFileName, studentName, sex, nation
	          			, PoliticallandscapeId, PlaceofBirth, birthday, height, weight
	          			,  classmessageId, postId, corporation, corporationpost, interest,
	          			 dormitory, phoneNumber, homePhone, qqNumber, WeChat, email, address);
	        	request.setAttribute("studentId", studentId);
	        	return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
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
	        //更新学生信息
	        StudentBiz studentBiz = new StudentBizImpl();
	        try {
	        	studentBiz.updateStudent(studentId, userId, userPwd, myFileFileName, studentName, sex, nation
	          			, PoliticallandscapeId, PlaceofBirth, birthday, height, weight
	          			,classmessageId, postId, corporation, corporationpost, interest,
	          			 dormitory, phoneNumber, homePhone, qqNumber, WeChat, email, address);
	        	request.setAttribute("studentId", studentId);
	        	return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        return ERROR;
	}
	
	
}
