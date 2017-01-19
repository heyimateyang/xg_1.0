<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
		 //登录验证
		Object admin_message = session.getAttribute("gradeteacher_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		} 
 	%>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="js/jBox/Skins/Blue/jbox.css" rel="stylesheet"  />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
<title>信工学生管理系统-辅导员</title>
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
                   辅导员：${gradeteacher_message.gradeteacherName }欢迎您！
                     <a href="GradeTeacherquitSession">安全退出</a>
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
				   <a href="showPageSysteminformationGradeTeacher">系统公告</a>
				 </div>
				 <div>
				    <form action="showNoReply" method="post" name="from2" id="from2">
						<input type="hidden" name="gradeteacherId" value="${gradeteacher_message.gradeteacherId }"/>
						<a href="javascript:document:from2.submit();">学生咨询信息</a>
					</form>
				 </div>
				</div>
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                           <form action="ShowGradeTeacher" method="post" name="from1" id="from1">
							<input type="hidden" name="gradeteacherId" value="${gradeteacher_message.gradeteacherId }"/>
								<a href="javascript:document:from1.submit();">辅导员信息</a>
							</form>
                        </div>
                        
                        
                    </div>  
                    <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="StudentPageGradeTeacher">学生信息 </a>
                        </div>
                        <div>
                            <a href="AddSutdentGradeTeacherPage">添加学生 </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
                

<h2 class="mbx">学生信息 &gt; 学生班级信息</h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">添加学生班级信息</a> </li>
</ul>

</div>
<div class="cztable">
	<form action="addClassMessageGradeTeacher?studentId=${student.studentId} " method="post">
	<input type="hidden" name="gradeId" value="${gradeteacher_message.grade.gradeId}"/>
    <table border="0" cellspacing="0" cellpadding="0" width="100%">

        <tr>
            <td width="91" align="right">学生姓名：</td>
            <td colspan="5">${student.studentName}&nbsp;</td>
        </tr>
        <tr>
            <td align="right">分配班级：</td>
            <td colspan="5">
            	<select name="classmessageId" id="classmessageId">
            	<c:forEach var="list" items="${requestScope.list}" >
				  <option value="${list.classmessageId }">${list.classmessageName }</option>
				</c:forEach>
				</select>
            </td>
        </tr>
        <tr>
            <td align="right">班级职务：</td>
            <td colspan="5">
            	<select name="postId" id="postId">
            	<c:forEach var="post_list" items="${requestScope.post_list}" >
				  <option value="${post_list.postId }">${post_list.postName }</option>
				</c:forEach>
				</select>
            </td>
        </tr>
         <tr>
            <td colspan="5" style="text-align: center;">
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