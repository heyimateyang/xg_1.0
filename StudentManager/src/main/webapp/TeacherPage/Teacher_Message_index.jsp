<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%
		//登录验证
		Object admin_message = session.getAttribute("teacher_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
 	<script type="text/javascript">
	    function word(){
			document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
		}
    </script>
<title>信工学生管理系统-辅导员助理</title>

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
                   辅导员助理：${teacher_message.teacherName }欢迎您！
                    <a href="TeacherquitSession">安全退出</a>
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
					<%-- <div class="cdlist">
						<div>
						<a href="showNoReply?teacherId=${teacher_message.teacherId }">学生咨询信息</a>
						</div>
					</div> --%>
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                           <a href="TeacherByid?teacherId=${ teacher_message.teacherId}">辅导员助理信息  </a>
                        </div>
                        
                    </div> 
                      <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <%-- <div>
                            <a href="findStudentScroeTeacher?gradeId=${ teacher_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩</a>
                        </div> --%>
                        <div>
                           <a href="StudentPageTeacher?teacherId=${teacher_message.teacherId }">学生信息 </a>
                        </div>
                    </div> 
                </div>
            </div>
            <div class="rightbox">
<h2 class="mbx">辅导员助理信息 &gt;辅导员助理信息</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">辅导员助理资料</a></li>
    <li><a class="tab2" href="updateTeacherIndex">修改辅导员助理资料</a></li>
</ul>

</div>
<div class="cztable">
	<form action="servlet/ExportWordServlet.servlet" method="post">
	<input type="submit" name="Word" value="导出文档" onclick="word()"/>
	<input type="hidden" id="tableInfo" name="tableInfo" value=""/>
	<span id="table">
    <table width="100%" cellpadding="0" cellspacing="0">
    <tbody>
    	<tr>
            <td align="left" colspan="4" style="color: red;">基本资料：</td>
        </tr>
        <tr>
            <td align="right" width="80">姓名：</td>
            <td>${teacher_message.teacherName }&nbsp;</td>
            <td align="right" width="90">登录帐号：</td>
            <td>${teacher_message.users.userName }&nbsp;</td>
            <td rowspan="9"><div align="center"><img id="pic_face"  height="160" width="120" src="TeacherHeadportrait/${teacher_message.headportrait }" style="padding:2px 2px 5px; border:1px #ddd solid;"></div> </td>
        </tr>
        <tr>
            <td align="right">管理班级：</td>
            <td colspan="3">
            	<c:forEach var="list" items="${sessionScope.list}" >
				 	${list.classmessageName }<br/>
				</c:forEach>
			</td>
           
        </tr>
       <%--   <tr>
            <td align="right">教学班级：</td>
            <td>${teacher_message.classmessage.classmessageName}&nbsp;</td>
             <td align="right">班级口号：</td>
            <td>${teacher_message.classmessage.slogan}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级Q群：</td>
            <td>${teacher_message.classmessage.classQqnumber}&nbsp;</td>
             <td align="right">班级专业：</td>
            <td>${teacher_message.classmessage.profession.professionName}&nbsp;</td>
        </tr> --%>
        <tr>
            <td align="left" colspan="4" style="color: red;">联系方式：</td>
        </tr>
         <tr>
            <td align="right">联系地址：</td>
            <td>${teacher_message.teacherAddress}&nbsp;</td>
            <td align="right">电话号码：</td>
            <td>${teacher_message.teacherPhone}&nbsp;</td>
        </tr>
        
         <tr>
         	<td align="right">QQ号码：</td>
            <td colspan="3">${teacher_message.teacherQq}&nbsp;</td>
         </tr>
        <tbody>
    </table>
    </span>
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