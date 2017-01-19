<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<%
		//登录验证
		Object admin_message = session.getAttribute("teacher_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<SCRIPT language=javascript src="js/addScroeVerification.js"></script>
	<SCRIPT language=javascript src="../js/addScroeVerification.js"></script>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />	
<title>信工学生管理系统-助理辅导员</title>

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
                     班级辅导员：${teacher_message.teacherName }欢迎您！
                    <a href="quitSession">安全退出</a>
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
                           <a href="showPageSysteminformationTeacher">系统公告  </a>
                        </div>
					 </div>
					 <div class="cdlist">
					     <div>
	<a href="showNoReply?teacherId=${teacher_message.teacherId }">学生咨询信息</a>
	                     </div>
					 </div>
				     <div class="ta1">
					  <strong>个人中心</strong>
					  <div class="leftbgbt">
					  </div>
					 </div>
					 <div class="cdlist">
					   <div>
					 <a
			href="TeacherByid?teacherId=${ teacher_message.teacherId}">班级辅导员信息
			         </a> 
					  </div>
					 </div>
				<div class="ta1">
					 <strong>教务中心</strong>
					 <div class="leftbgbt2">
					 </div>
				</div>
				     <div class="cdlist">	 
                        <div>
						<a href="findStudentScroeTeacher?gradeId=${teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩
						</a>
						</div>
					    <div>
						<a href="StudentPageTeacher?gradeId=${teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">学生信息 </a>
                        </div>
                    </div>
                  </div>
			  </div>
            <div class="rightbox">
<h2 class="mbx">添加学生成绩 &gt;添加学生成绩 </h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
	<li><a class="tab2" >添加学生成绩</a> </li>
	<li><a class="tab2" href="findStudentTeacherById?studentId=${student_admin_message.studentId }">学生个人资料</a> </li>
    <li><a class="tab2" href="StudentTeacherAchievementPage?studentId=${student_admin_message.studentId }">学生成绩</a> </li>
    <li><a class="tab2" href="ShowListCitationTeacher?studentId=${student_admin_message.studentId }">学生获奖情况</a> </li>
    <li><a class="tab2" href="clasee_MessageTeacher?gradeId=${student_admin_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">学生班级信息</a> </li>
</ul>

</div>
<div class="cztable">  
      <form action="" method=post name="form1" id="form1" onSubmit="return addAchievement()">
    	<table id="update_show" border="0" cellspacing="0" cellpadding="0" width="100%">
	    	<tr>
	            <td colspan="4" align="center">添加学生成绩&nbsp;</td>
	        </tr>
	          
	        <tr>
                <td align="right">学生名字：</td>
            	<td>
           			${student_admin_message.studentName }&nbsp; 
           		</td> 
           		<td align="right">学生学号：</td>
            	<td>
           		${student_admin_message.studentNumber }&nbsp; 
           		</td>              	
           	</tr>
	        
            <tr>
                <td align="right">添加科目：</td>
            	<td>
            		<input  type="text" name="achievementName" id="achievementName" value="" maxlength="8">&nbsp;
            	</td>
            	<td align="right">科目成绩：</td>
            	<td align="left">
            		<input type="text" name="achievementScore" id="achievementScore" value="" maxlength="5">&nbsp;            	
            	</td>
            </tr>        	
        	<tr>
       		  <td colspan="4" align="left" valign="middle" style="text-align: center;">
                	<input type="submit" name="Submit" value="确定修改" id="id_ok" class="input2">          
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