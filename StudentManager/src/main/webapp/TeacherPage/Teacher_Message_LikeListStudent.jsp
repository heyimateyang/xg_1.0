<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
<title>信工学生管理系统-助理辅导员</title>
</head>
<body>
<div class="banner">
        <div class="bgh">
            <div class="page">
            <div id="logo">
            	<a>
                	<img src="images/logo.png" alt="" width="300" height="67" />
                </a>
            </div>
                <div class="topxx">
                   班级辅导员：${teacher_message.teacherName }欢迎您！
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
                           <a href="showPageSysteminformationTeacher">系统公告  </a>
                        </div>
					 </div>
					 <div class="cdlist">
		<%-- 			     <div>
	<a href="showNoReply?teacherId=${teacher_message.teacherId }">学生咨询信息</a>
	                     </div> --%>
					 </div>
				     <div class="ta1">
					  <strong>个人中心</strong>
					  <div class="leftbgbt">
					  </div>
					 </div>
					 <div class="cdlist">
					   <div>
					 <a
			href="TeacherByid?teacherId=${ teacher_message.teacherId}">辅导员助理信息
			         </a> 
					  </div>
					 </div>
				<div class="ta1">
					 <strong>教务中心</strong>
					 <div class="leftbgbt2">
					 </div>
				</div>
				     <div class="cdlist">	 
                        <%-- <div>
						<a href="findStudentScroeTeacher?gradeId=${teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩
						</a>
						</div> --%>
					    <div>
						<a href="StudentPageTeacher?teacherId=${teacher_message.teacherId }">学生信息 </a>
                        </div>
                    </div>
                  </div>
			  </div>
            <div class="rightbox">
                
    <h2 class="mbx">
       学生信息 &gt; 学生信息</h2>
      <a href="StudentPageTeacher?teacherId=${teacher_message.teacherId }" style="font-size: 18px">返回</a>
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="#">班级辅导员所在班级学生信息列表</a></li>    
        </ul>
    </div>
    <div class="cztable">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                    	编号                   
                     </th>
                    <th scope="col"> 
                    	学生姓名                    
                    </th>
                    <th scope="col"> 
                    	学生学号
                    </th>
                    <th scope="col"> 
                    	状态
                    </th>
                    <th scope="col"> 
                    	
                    </th>
                </tr>
               <c:forEach var="student_list" items="${requestScope.student_list}" >
			        <tr>
			            <th scope="col">${student_list.studentId }</th>
			            <th scope="col">${student_list.studentName }</th>
			            <th scope="col">${student_list.studentNumber }</th>  
			            <th scope="col">${student_list.state }</th> 
			            <th scope="col"> 
			            	<a href="findStudentTeacherById?studentId=${student_list.studentId }"  style="color: red">详情</a>
	                    	
                   		</th>       
			        </tr>
      			</c:forEach>
            </tbody>
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