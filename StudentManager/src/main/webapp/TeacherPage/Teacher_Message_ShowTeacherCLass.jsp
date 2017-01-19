<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 	<script type="text/javascript">
	    function word(){
			document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
		}
    </script>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="js/jBox/Skins/Blue/jbox.css" rel="stylesheet"  />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
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
                

<h2 class="mbx">班级辅导员信息 &gt; 班级辅导员教学班级</h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
  	<li><a class="tab2" onClick="" href="TeacherPage/Teacher_Message_index.jsp">班级辅导员资料</a></li>
    <li><a class="tab2"  >教学班级</a></li>
</ul>

</div>
<div class="cztable">
	<form action="servlet/ExportWordServlet.servlet" method="post">
	<input type="submit" name="Word" value="导出文档" onClick="word()"/>
	<input type="hidden" id="tableInfo" name="tableInfo" value=""/>
	<span id="table">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">

        <tr>
            <td width="91" align="right">班级名称：</td>
            <td colspan="5">${classmessage_teacher.classmessageName }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级QQ群：</td>
            <td colspan="5">${classmessage_teacher.classQqnumber } &nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级宣传语：</td>
            <td colspan="5">${classmessage_teacher.slogan }&nbsp;</td>
        </tr> 
            
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