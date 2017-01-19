package org.heyimtaeyang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.StudentPageBean;
import org.heyimtaeyang.biz.AchievementBiz;
import org.heyimtaeyang.biz.CitationBiz;
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.GradeBiz;
import org.heyimtaeyang.biz.PoliticalBiz;
import org.heyimtaeyang.biz.PostBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.StudentDeleteBiz;
import org.heyimtaeyang.biz.SysteminformationBiz;
import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.biz.impl.AchievementBizImpl;
import org.heyimtaeyang.biz.impl.CitationBizImpl;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.GradeBizImpl;
import org.heyimtaeyang.biz.impl.PoliticalBizImpl;
import org.heyimtaeyang.biz.impl.PostBizImpl;
import org.heyimtaeyang.biz.impl.StudentBizImpl;
import org.heyimtaeyang.biz.impl.StudentDeleteBizImpl;
import org.heyimtaeyang.biz.impl.SysteminformationBizImpl;
import org.heyimtaeyang.biz.impl.UsersBizImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Grade;
import org.heyimtaeyang.entity.Political;
import org.heyimtaeyang.entity.Post;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Systeminformation;
import org.heyimtaeyang.service.StudentService;
import org.heyimtaeyang.service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {
	
	private StudentService studentService = new StudentServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	public HttpServletResponse response;
	
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	//生成get set
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//从管理员页面接收字段
	private int studentId;
	private int userId;
	private String userPwd;
	private int poor;
	public int getPoor() {
		return poor;
	}
	public void setPoor(int poor) {
		this.poor = poor;
	}

	private String picName;
	
	
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}

	//从页面接收字段
	private String nation;
	private int PoliticallandscapeId;
	private String PlaceofBirth;
	private String birthday;
	private String height;
	private String weight;
	private int gradeName;
	private String corporation;
	private String corporationpost;
	private String WeChat;
	private int JurisdictionId;
	private String idcard;
	private int postId;
	private String remarks;
	private String dormitory;
	private String interest;
	
	
	
	public String getStudentGradeName() {
		return studentGradeName;
	}
	public void setStudentGradeName(String studentGradeName) {
		this.studentGradeName = studentGradeName;
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
	public String getWeChat() {
		return WeChat;
	}
	public void setWeChat(String weChat) {
		WeChat = weChat;
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
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	private String userName;
	private String sex;
	private Long studentNumber;
	private String shcoolName;
	private int classmessageId;
	private String dateTime;
	private String state;
	private Long phoneNumber;
	private String homePhone;
	private String email;
	private String address;
	private Long qqNumber;
	private String studentGradeName;
	
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
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public int getClassmessageId() {
		return classmessageId;
	}
	public void setClassmessageId(int classmessageId) {
		this.classmessageId = classmessageId;
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
	public Long getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(Long qqNumber) {
		this.qqNumber = qqNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String studentName;
	private int gradeId;
	private int teacherId;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	//按班级查找学生admin
	public String StudentPageClassmessId(){
		StudentPageBean pageBean 
			= studentService.getPageBeanClassmessageId(10, page, classmessageId);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("classmessageId", classmessageId);
		return SUCCESS;
	}
	
	//按年级查询学生admin
	public String StudentPageGrade(){
		StudentPageBean pageBean = studentService.getPageBean(10, page,studentGradeName);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("gradeId", gradeId);
		return SUCCESS;
	}
	
	
	//分页显示学生admin
	public String StudentPageAdmin(){
		//表示每页显示10条记录，page表示当前网页
        StudentPageBean pageBean = studentService.getPageBean(10, page);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
	}
	//显示学生模糊查询admin
	public String LikeStudentPageAdmin() throws UnsupportedEncodingException {
		StudentBiz studentBiz = new StudentBizImpl();
		List<Student> list  = studentBiz.findLikeStudent(this.studentName);
		request.setAttribute("student_list", list);
	    return SUCCESS;
	}
	//显示学生模糊查询GradeTeacher
	public String LikeStudentPageGradeTeacher() throws UnsupportedEncodingException {
		StudentBiz studentBiz = new StudentBizImpl();
		List<Student> list  = studentBiz.findLikeStudent(this.studentName,this.gradeId);
		request.setAttribute("student_list", list);
		return SUCCESS;
	}
	
	//显示学生模糊查询Teacher
	public String LikeStudentPageTeacher() throws UnsupportedEncodingException {
		StudentBiz studentBiz = new StudentBizImpl();
		/*int id = Integer.valueOf(this.classmessageId);*/
		System.out.println(classmessageId);
		List<Student> list  = studentBiz.findLikeStudentTeacher(this.studentName,this.classmessageId);
		request.setAttribute("student_list", list);
		return SUCCESS;
	}
	
	
	//按id查找学生admin
	public String  findStudentById(){
		StudentBiz studentBiz = new StudentBizImpl();
		Student student = studentBiz.findStudentById(this.studentId);
		session.setAttribute("student_admin_message", student);
		
		return SUCCESS;
	}
	
	//按id查找学生GradeTeacher
	public String  findStudentGradeTeacherById(){
		StudentBiz studentBiz = new StudentBizImpl();
		Student student = studentBiz.findStudentById(this.studentId);
		session.setAttribute("student_admin_message", student);
		return SUCCESS;
	}
	
	//按id查找学生Teacher
	public String  findStudentTeacherById(){
		StudentBiz studentBiz = new StudentBizImpl();
		Student student = studentBiz.findStudentByStudentId(this.studentId);
		session.setAttribute("student_admin_message", student);
		return SUCCESS;
	}
	
	//无操作跳转admin
	public String class_ShowStudent(){
		return SUCCESS;
	}
	
	//无操作跳转GradeTeacher
	public String class_ShowStudentGreadTeacher(){
		return SUCCESS;
	}
	
	//无操作跳转Student
	public String class_ShowStudentMessage(){
		SysteminformationBiz systeminformationBiz = new SysteminformationBizImpl();
		List<Systeminformation> list = systeminformationBiz.showTop5();
		StudentBiz studentBiz = new StudentBizImpl();
		Student student = studentBiz.findStudentById(studentId);
		session.setAttribute("student_message", student);
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	//分页显示学生GradeTeacher
	public String StudentPageGradeTeacher(){
		//表示每页显示5条记录，page表示当前网页
	    StudentPageBean pageBean = studentService.getPageBean(10, page);
	    request.setAttribute("pageBean", pageBean);
	    return SUCCESS;
	}
	
	//分页显示学生Teacher
	public String StudentPageTeacher(){
		//表示每页显示5条记录，page表示当前网页
		StudentPageBean pageBean = studentService.getPageBeans(10, page,this.teacherId);
	    request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}
	
	//无操作跳转到修改学生页面
	public String UpdateStudent(){
		PoliticalBiz politicalBiz = new PoliticalBizImpl();
		List<Political> list_political = politicalBiz.showAll();
		PostBiz postBiz = new PostBizImpl();
		List<Post> list_Post = postBiz.showAll();
		
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		List<Classmessage> listClassmessage = classmessageBiz.findAll();
		request.setAttribute("listClassmessage", listClassmessage);
		request.setAttribute("list_Post", list_Post);
		request.setAttribute("list_political", list_political);
		return SUCCESS;
	}
	
	//跳转到添加学生信息页面Admin
	public String addStudenrAdmin(){
		GradeBiz gradeBiz = new GradeBizImpl();
		PoliticalBiz politicalBiz = new PoliticalBizImpl();
		List<Political> list_political = politicalBiz.showAll();
		List<Grade> list = gradeBiz.findAll();
		request.setAttribute("list_AddStudent", list);
		request.setAttribute("list_political", list_political);
		return SUCCESS;
	}
	
	//删除学生admin
	public String deleteStudentAdmin(){
		StudentBiz studentBiz = new StudentBizImpl();
		UsersBiz usersBiz = new UsersBizImpl();
		StudentDeleteBiz studentDeleteBiz = new StudentDeleteBizImpl();
		AchievementBiz achievementBiz = new AchievementBizImpl();
		CitationBiz citationBiz = new CitationBizImpl();
		
		studentDeleteBiz.deleteReplyMessage(studentId);
		studentDeleteBiz.deleteAdminMessage(studentId);
		studentDeleteBiz.deleteTeacherReplymessage(studentId);
		studentDeleteBiz.deleteTeachermessage(studentId);
		
		achievementBiz.deleteAchievementByStudentId(studentId);
		citationBiz.deleteCitationByStudentId(studentId);
		studentBiz.deleteUsersById(userId);
		usersBiz.deleteUsersById(userId);
		return SUCCESS;
	}
	
	//跳转到修改学生资料页面admin
	public String UpdateSutdentAdminIndex(){
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		List<Classmessage> list = classmessageBiz.findAll();
		StudentBiz studentBiz = new StudentBizImpl();
		Student student = studentBiz.findStudentById(this.studentId);
		PoliticalBiz politicalBiz = new PoliticalBizImpl();
		List<Political> list_politiacal = politicalBiz.showAll();
		PostBiz postBiz = new PostBizImpl();
		List<Post> list_post = postBiz.showAll();
		request.setAttribute("list_post", list_post);
		request.setAttribute("list_politiacal", list_politiacal);
		session.setAttribute("student_admin_message", student);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	//修改学生的政治面貌admin
	public String updateSutdentPoliticall(){
		StudentBiz studentBiz = new StudentBizImpl();
		try {
			studentBiz.updateSutdent(this.studentId);
			request.setAttribute("studentId", studentId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//修改学生的政治面貌GradeTeacher
	public String updateSutdentPoliticallGradeTeacher(){
		StudentBiz studentBiz = new StudentBizImpl();
		try {
			studentBiz.updateSutdentGradeTeacher(this.studentId);
			request.setAttribute("studentId", studentId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	//修改学生的政治面貌GradeTeacher
	public String updateSutdentPoliticallTeacher(){
		StudentBiz studentBiz = new StudentBizImpl();
		try {
			studentBiz.updateSutdentTeacher(this.studentId);
			request.setAttribute("studentId", studentId);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
		
	//修改学生资料admin
	public String updateStudentAdmin() throws IOException{
					System.out.println(studentGradeName);
					if(myFile == null){
						myFileFileName = this.picName;
						 //更新学生信息
				        StudentBiz studentBiz = new StudentBizImpl();
				        studentBiz.adminUpdateStudent(studentId,studentName,userName,
				        		myFileFileName, sex,
				      			studentNumber,shcoolName,classmessageId,
				      			dateTime, state, phoneNumber,
				      			homePhone, email, address, userId, qqNumber, userPwd,
				      			PoliticallandscapeId,
				      			idcard,interest,dormitory,remarks,weight,PlaceofBirth,birthday,
				      			height,corporation,corporationpost,nation,WeChat,postId,this.poor,this.studentGradeName);
				        request.setAttribute("studentId", studentId);
						return SUCCESS;
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
				        studentBiz.adminUpdateStudent(studentId,studentName,userName,
				      			myFileFileName, sex,
				      			studentNumber,shcoolName,classmessageId,
				      			dateTime, state, phoneNumber,
				      			homePhone, email, address, userId, qqNumber, userPwd,
				      			PoliticallandscapeId,
				      			idcard,interest,dormitory,remarks,weight,PlaceofBirth,birthday,
				      			height,corporation,corporationpost,nation,WeChat,postId,this.poor,this.studentGradeName);
				        request.setAttribute("studentId", studentId);
						return SUCCESS;
					}
				}
	
}
