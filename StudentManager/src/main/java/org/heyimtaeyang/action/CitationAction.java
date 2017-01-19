package org.heyimtaeyang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.heyimtaeyang.bean.CitationPageBean;
import org.heyimtaeyang.biz.CitationBiz;
import org.heyimtaeyang.biz.impl.CitationBizImpl;
import org.heyimtaeyang.entity.Citation;
import org.heyimtaeyang.service.CitationService;
import org.heyimtaeyang.service.impl.CitationServiceImpl;
import org.heyimtaeyang.test.Test3;
import org.heyimtaeyang.test.Test5;
import org.heyimtaeyang.until.My_UID;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CitationAction extends ActionSupport{
	
	private CitationService citationService = new CitationServiceImpl();
	
	//全局变量
	public HttpServletRequest request 
		= (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
	public HttpSession session = request.getSession();
	public HttpServletResponse response;
	
	//生成get set
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	//citationTitle属性用来封获奖标题  
    private String citationTitle;  
    private String citationMessage;  //获奖内容
    private String citationName;
    private String citationDate;
    private String citationlevel;
    
    
    public CitationService getCitationService() {
		return citationService;
	}
	public void setCitationService(CitationService citationService) {
		this.citationService = citationService;
	}
	public String getCitationName() {
		return citationName;
	}
	public void setCitationName(String citationName) {
		this.citationName = citationName;
	}
	public String getCitationDate() {
		return citationDate;
	}
	public void setCitationDate(String citationDate) {
		this.citationDate = citationDate;
	}
	public String getCitationlevel() {
		return citationlevel;
	}
	public void setCitationlevel(String citationlevel) {
		this.citationlevel = citationlevel;
	}

	//接收字段
    private int studentId;
    private int citationId;
    private int judgeId;
    public int getJudgeId() {
		return judgeId;
	}
	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}
	public int getCitationId() {
		return citationId;
	}

	public void setCitationId(int citationId) {
		this.citationId = citationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCitationTitle() {
		return citationTitle;
	}

	public void setCitationTitle(String citationTitle) {
		this.citationTitle = citationTitle;
	}

	public String getCitationMessage() {
		return citationMessage;
	}

	public void setCitationMessage(String citationMessage) {
		this.citationMessage = citationMessage;
	}

	// myFile属性用来封装上传的文件  
    private File myFile;  
      
    // myFileContentType属性用来封装上传文件的类型  
    private String myFileContentType;  
  
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;  
  
      
   
    //获得myFile值  
    public File getMyFile() {  
        return myFile;  
    }  
  
    //设置myFile值  
    public void setMyFile(File myFile) {  
        this.myFile = myFile;  
    }  
  
    //获得myFileContentType值  
    public String getMyFileContentType() {  
        return myFileContentType;  
    }  
  
    //设置myFileContentType值  
    public void setMyFileContentType(String myFileContentType) {  
        this.myFileContentType = myFileContentType;  
    }  
  
    //获得myFileFileName值  
    public String getMyFileFileName() {  
        return myFileFileName;  
    }  
  
    //设置myFileFileName值  
    public void setMyFileFileName(String myFileFileName) {  
        this.myFileFileName = myFileFileName;  
    }  
  
    
    //学生添加获奖情况student
    public String upload() throws Exception {  
    	
    	if(myFileFileName == null){
    		 CitationBiz citationBiz = new CitationBizImpl();
    	        int id = 
    	        	citationBiz.addCitation( studentId, citationTitle, citationMessage, myFileFileName, citationName,
    	        		     citationDate, citationlevel);
    	        if(id!=0){
    	        	request.setAttribute("studentId", studentId);
    	        	return SUCCESS;  
    	        }else{
    	        	return ERROR;
    	        }
    	}else{
    		//基于myFile创建一个文件输入流  
            InputStream is = new FileInputStream(myFile);  
              
            // 设置上传文件目录  
            String uploadPath = ServletActionContext.getServletContext()  
                    .getRealPath("CitationImage"); 
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
            
            
            //生成全球唯一标识码
            int n=1;  
            String MyId = "1";
	        while(n-->0){  
	        	MyId =My_UID.getId(); 
	        }
	        new My_UID().renameFile(uploadPath+"\\"+myFileFileName, uploadPath+"\\"+MyId+".jpg");
            
	        myFileFileName = MyId+".jpg";
          
            CitationBiz citationBiz = new CitationBizImpl();
	        int id = 
	        	citationBiz.addCitation(studentId, citationTitle, citationMessage, myFileFileName,citationName,
	            citationDate,citationlevel);
	        if(id!=0){
	        	request.setAttribute("studentId", studentId);
	        	return SUCCESS;  
	        }else{
	        	return ERROR;
	        }
    	}
    	}
 
        
        
       
        
     
    
    //无操作跳转 student
    public String addCitation(){
    	return SUCCESS;
    }
    
    //分页显示该学生的全部奖项成绩Student
    public String ShowListCitation(){
    	//表示每页显示5条记录，page表示当前网页
        CitationPageBean pageBean = citationService.getPageBean(5, page,this.studentId);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }
    
    //分页显示该学生的全部奖项成绩GradeTeacher
    public String ShowListCitationGradeTeacher(){
    	//表示每页显示3条记录，page表示当前网页
        CitationPageBean pageBean = citationService.getPageBean(5, page,this.studentId);
        //HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }
    
    //分页显示该学生的全部奖项成绩Teacher
    public String ShowListCitationTeacher(){
    	//表示每页显示3条记录，page表示当前网页
        CitationPageBean pageBean = citationService.getPageBean(5, page,this.studentId);
        //HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }
    
    //按获奖id查找该学生的获奖情况Student
    public String ShowCitation(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	Citation citatio = citationBiz.findCitation(citationId);
    	request.setAttribute("citatio_message", citatio);
    	return SUCCESS;
    }
    
    //按Id删除删除获奖信息Student
    public String deleteStudentCitation(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	citationBiz.deleteCitation(citationId);
    	request.setAttribute("studentId", studentId);
    	session.setAttribute("studentId", studentId);
    	return SUCCESS;
    }
    
  //分页显示该学生的全部奖项成绩Student
    public String ShowListCitationAfter(){
    	int id = (int) request.getSession().getAttribute("deleteLeaveStudent");
    	//表示每页显示5条记录，page表示当前网页
        CitationPageBean pageBean = citationService.getPageBean(10, page,id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }
    
    
    //按学生id分页显示该学生的全部奖项成绩Admin
    public String ShowListCitationAdmin(){
    	//表示每页显示5条记录，page表示当前网页
        CitationPageBean pageBean = citationService.getPageBean(5, page,this.studentId);
        //HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("pageBean", pageBean);
        return SUCCESS;
    }
    
    //按获奖id查找该学生的获奖情况Admin
    public String ShowCitationAdmin(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	Citation citatio = citationBiz.findCitation(citationId);
    	request.setAttribute("citatio_message", citatio);
    	return SUCCESS;
    }
    //按获奖id修改该学生的获奖情况Admin
    public String UpdateCitationAdmin(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	citationBiz.updateCitationByCitationId(citationId,judgeId);
    	request.setAttribute("studentId", studentId);
        return SUCCESS;
    }
    
    //按获奖id修改该学生的获奖情况GradeTeacher
    public String UpdateCitationGradeTeacher(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	citationBiz.updateCitationByCitationId(citationId);
    	request.setAttribute("studentId", studentId);
        return SUCCESS;
    }
    
    //按获奖id修改该学生的获奖情况Teacher
    public String UpdateCitationTeacher(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	citationBiz.updateCitationByCitationIdTeacher(citationId);
    	request.setAttribute("studentId", studentId);
        return SUCCESS;
    }
    
    //按学生id查询该学生的获奖情况Teacher
    public String SwhoCitationTeacher(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	Citation citatio = citationBiz.findCitation(citationId);
		request.setAttribute("citatio_message", citatio);
        return SUCCESS;
    }
    
    //按学生id查询该学生的获奖情况GradeTeacher
    public String SwhoCitationGradeTeacher(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	Citation citatio = citationBiz.findCitation(citationId);
		request.setAttribute("citatio_message", citatio);
        return SUCCESS;
    }
    
    //查奖状等级信息
    public String Find_Citationlevel(){
    	CitationBiz citationBiz = new CitationBizImpl();
    	List<Citation> findCitation = citationBiz.find_Citation(citationlevel);
    	request.setAttribute("findCitation", findCitation);
    	return SUCCESS;
    }
}
