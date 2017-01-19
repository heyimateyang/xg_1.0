<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
			//登录验证
			Object admin_message = session.getAttribute("teacher_message"); 
			if(admin_message==null){
				response.sendRedirect("404.html"); 
			} 
 	%>
 	
 	
 	
<title>信工学生管理系统—辅导员</title>
	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	
	
</head>
<body>

<div class="banner">
        <div class="banner">
        <div class="bgh">
            <div class="page" id="page">
            <div id="logo">
            	<a>
                	<img src="images/logo.png" alt="" width="300" height="67" />
                </a>
            </div>
                <div class="topxx">
                   助理辅导员：${teacher_message.teacherName }欢迎您！
                     <a href="TeacherquitSession">安全退出</a>
                </div>
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
					   <a href="showPageSysteminformationTeacher">系统公告</a>
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
                           <a href="TeacherByid?teacherId=${ teacher_message.teacherId}">班级辅导员信息  </a>
                        </div>
                        
                    </div> 
                      <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="findStudentScroeTeacher?gradeId=${ teacher_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩</a>
                        </div>
                        <div>
                            <a href="StudentPageTeacher?gradeId=${ teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">学生信息 </a>
                        </div>
                    </div> 
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        学生咨询信息 &gt; 查询学生咨询信息&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<label style="color: red;">本地上传图片和图片空间功能暂不开放</label></h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" >咨询信息</a> </li>
           	
        </ul>
    </div>
    <div class="cztable">
    	 <table width="100%" cellpadding="0" cellspacing="0">
	        <tr>
	            <td width="15%" align="right"><div align="right">咨询标题： </div></td>
	            <td style="text-align: center;font-size: 19px">${teachermessage_message.teacherMessageTitle }</td>
	        </tr>
	        <tr>
	            <td width="15%" align="right"><div align="right">发布日期： </div></td>
	            <td style="font-size: 19px">${teachermessage_message.teacherMessageDate }</td>
	        </tr>
	      
	        
	        <tr>
	            <td width="15%" align="right"><div align="right">咨询内容： </div></td>
	            <td>
	            	${teachermessage_message.teacherMessage}
	            </td>
	        </tr>
	        <tr>
	            <td width="15%" align="right"><div align="right">处理状态： </div></td>
	            <td>
	            	<label style="color: red;">已处理</label>
	            </td>
	        </tr>
	    </table>
	    <br/>
    </div>
    <div class="morebt">
        <ul>
           	<li><a class="tab2">回复咨询信息</a> </li>
        </ul>
    </div>
    <div class="cztable">
		 <table width="100%" cellpadding="0" cellspacing="0">
	        <tr>
	            <td width="15%" align="right"><div align="right">回复标题： </div></td>
	            <td style="text-align: center;font-size: 19px">${teacherreply_message.replyTitle }</td>
	        </tr>
	      
		      <tr>
		            <td width="15%" align="right"><div align="right">回复时间： </div></td>
		            <td>
		            	${teacherreply_message.replyDate }
		            </td>
		      </tr>
	        
	        <tr>
	            <td width="15%" align="right"><div align="right">回复内容： </div></td>
	            <td>
	            	${teacherreply_message.replymessage }
	            </td>
	        </tr>
	    </table>
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