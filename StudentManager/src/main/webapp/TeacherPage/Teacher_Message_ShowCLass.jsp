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
<title>信工学生管理系统-辅导员助理</title>
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
                

<h2 class="mbx">学生信息 &gt; 学生班级信息</h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
     <li><a class="tab2" href="findStudentTeacherById?studentId=${student_admin_message.studentId }">学生个人资料</a> </li>
    <%-- <li><a class="tab2" href="StudentTeacherAchievementPage?studentId=${student_admin_message.studentId }">学生成绩</a> </li> --%>
    <li><a class="tab2" href="ShowListCitationTeacher?studentId=${student_admin_message.studentId }">学生获奖情况</a> </li>
    <li><a class="tab2">学生班级信息</a> </li>
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
            <td colspan="5">${student_admin_message.classmessage.classmessageName }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级QQ群：</td>
            <td colspan="5">${student_admin_message.classmessage.classQqnumber } &nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级宣传语：</td>
            <td colspan="5">${student_admin_message.classmessage.slogan }&nbsp;</td>
        </tr> 
        
         <tr>
            <td width="91" align="right">贫困生人数：</td>
            <td colspan="5">${list_Poor }人&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">班级总人数：</td>
            <td colspan="5">${list_total }人&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">班级男生人数：</td>
            <td colspan="5">${list_man }人&nbsp;</td>
        </tr>
         <tr>
            <td width="91" align="right">班级女生人数：</td>
            <td colspan="5">${list_Girl }人&nbsp;</td>
        </tr>
         <tr>
            <td width="91" align="right">班级团员人数：</td>
            <td colspan="5">${list_Members }人&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">预备党员人数：</td>
            <td colspan="5">${list_ReservePartyMember }人&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">党员人数：</td>
            <td colspan="5">${list_PartyMember }人&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">入党积极分子：</td>
            <td colspan="5">${list_PartyActivists }人&nbsp;</td>
        </tr>
            <tr>
                <td align="right">班级老师：</td>
            	<td>${teacher_message.teacherName }&nbsp;</td>
            	<td align="left">QQ号码：</td>
            	<td align="left">${teacher_message.teacherQq }&nbsp;</td>
            	<td align="left">手机号码：</td>
            	<td align="left">${teacher_message.teacherPhone }&nbsp;</td>
            </tr>
       	     <tr>
                <td align="right">年级辅导员：</td>
            	<td>${gradeteacher_message.gradeteacherName }&nbsp;</td>
            	<td align="left">QQ号码：</td>
            	<td align="left">${gradeteacher_message.gradeteacherQqnumber }&nbsp;</td>
            	<td align="left">手机号码：</td>
            	<td align="left">${gradeteacher_message.gradeteacherPhone }&nbsp;</td>
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