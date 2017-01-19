<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<SCRIPT language=javascript src="js/AdminUpdateVerification.js"></script>
	<SCRIPT language=javascript src="../js/AdminUpdateVerification.js"></script>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />	
	<script src="js/checkUserNameAjax.js" type="text/javascript"></script>
	<script src="../js/checkUserNameAjax.js" type="text/javascript"></script>
	<script type="text/javascript">
	    function validate(){
	        var page = document.getElementsByName("page")[0].value; 
	        if(page > <s:property value="#request.pageBean.totalPage"/>){
	            alert("你输入的页数大于最大页数，页面将跳转到首页！");
	            window.document.location.href = "LeaveStudentListAdmin";
	            return false;
	        }
	        return true;
	    }
    </script>
	<%
		//登录验证
		Object admin_message = session.getAttribute("admin_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
<title>信工学生管理系统- 管理员</title>

</head>
<body>
   <div class="banner">
        <div class="bgh">
            <div class="page" id="page">
            <div id="logo">
            	<a>
                	<img src="images/logo.png" alt="" width="300" height="67" />
                </a>
            </div>
                <div class="topxx">
                   辅导员：${admin_message.adminName }欢迎您！
                    <a href="quitSession">安全退出</a>
                </div>
                 <div class="blog_nav">
                    <ul>
                        <li><a href="CollegePageBeanAdmin">所有学院</a></li>
                        <li><a href="ProfessionPageAdmin">所有专业</a></li>
                        <li><a href="ClassmessagePageAdmin">所有班级</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
				<div class="ta1">
					 <strong>信息中心</strong>
					 <div class="leftbgbt2">
					 </div>
				</div>
				<div class="cdlist">
				 <div>
				   <a href="showPageSysteminformationAdmin">发布系统公告</a>
				 </div>
				</div>
				<div class="cdlist">
					<div>
					<a href="AdminAdminmessagePage">学生咨询信息</a>
					</div>
				</div>
				
                	<div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                         <div>
                           <a href="findAdminById?adminId=${admin_message.adminId }">管理员信息</a>
                        </div>
                    </div>
                    <div class="ta1">
                        <strong>信息中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                       
                        <div>
                            <a href="StudentPageAdmin">学生信息 </a>
                        </div>
                        <div>
                            <a href="LeaveStudentListAdmin">学生请假信息 </a>
                        </div>
                         <div>
                            <a href="GradeteacherPageAdmin">辅导员信息  </a>
                        </div>
                         <div>
                            <a href="TeacherPageAdmin">辅导员助理信息  </a>
                        </div>
                    </div> 
                    <div class="ta1">
                        <strong>添加信息</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                    	 <div>
                           <!-- <a href="addGradeTeacher">添加年级辅导员信息 </a> -->
                           <a href="addGradeTeacher">添加辅导员信息 </a>
                        </div>
                    	 <div>
                           <a href="addTeacherList">添加辅导员助理信息 </a>
                        </div>
                         
                         <div>
                           <a href="addStudenrAdmin">添加学生信息 </a>
                        </div>
                    </div> 
                    <div class="ta1">
                        <strong>添加学院</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
	                    <div>
	                          <a href="addCollegeIndex">添加学院 </a>
	                    </div>
	                    <div>
	                          <a href="addProfessionIndex">添加专业 </a>
	                    </div> 
	                    <div>
	                          <a href="addClassmessage">添加班级 </a>
	                    </div> 
	               </div>
                </div>
            </div>
            <div class="rightbox">
<h2 class="mbx">学生请假信息 &gt;学生请假信息</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">学生请假信息</a></li>
</ul>

</div>
<div class="cztable">
    
    <form action="updateLeaveAdmin" method="post">
    <input type="hidden" name="leaveId" value="${leavestudent.leaveId}"/>
    <table width="100%" cellpadding="0" cellspacing="0">
	  <tr>
        	<td colspan="2"><h3>请假条存根（编号：）${leavestudent.leaveId }</h3></td>
        </tr>
        <tr>
        	<td width="48%"><h4>请假事由:</h4></td>
            <td width="52%" align="left">
            	${leavestudent.leaveContent }
            </td>
        </tr>
        <tr>
        	<td>
            	<h4>请假时间：</h4>
            </td>
            <td>
            	<h4>
                	${leavestudent.leaveBeginTime }到${leavestudent.leaveEndTime }
                </h4>
            </td>
        </tr>
        <tr>
        	<td>
        		<h4>联系电话：${ leavestudent.student.phoneNumber}</h4>
        	</td>
        	<td>
        		<h4>宿舍号：${ leavestudent.student.dormitory}</h4>
        	</td>
        </tr>
        <tr>
        	<td colspan="2">
        		<input name="" type="submit" value="审批通过">
        	</td>
        </tr>
     </table>
 </form>
</div>
            </div>   
        </div>
        
        <div class="footer">
            <p>
            	学生管理系统
            </p>
        </div>
 </div>
</body>
</html>