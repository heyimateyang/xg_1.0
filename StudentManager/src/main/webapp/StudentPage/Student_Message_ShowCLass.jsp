<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="js/jBox/Skins/Blue/jbox.css" rel="stylesheet"  />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	
	
	
	
	 <%
		//登录验证
		Object admin_message = session.getAttribute("student_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
	%> 
<title>信工学生管理系统-学生</title>
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
               学生：${student_message.studentName }   欢迎您！ 
                      <a href="StudentquitSession">安全退出</a>
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
				   <a href="showPageSysteminformationStudent">系统公告</a>
				 </div>
				</div>
				<div class="cdlist">
					<div>
					<form action="showPageTeacherMessage" method="post" name="from1" id="from1">
					<input type="hidden" name="studentId" value="${student_message.studentId}"/>
						<a href="javascript:document:from1.submit();">咨询信息</a>
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
                        	<form action="class_ShowStudentMessage" method="post" id="from2" name="from2">
                        	<input type="hidden" name="studentId" value="${student_message.studentId}"/>
                            <a href="javascript:document:from2.submit();">我的信息</a>
                            </form>
                        </div>
                         <div>
                         	<form action="clasee_MessageStudent" method="post" id="from3" name="from3">
                        	<input type="hidden" name="classmessageId" value="${student_message.classmessage.classmessageId}"/>
                        	<input type="hidden" name="gradeId" value="${student_message.grade.gradeId}"/>
                            <a href="javascript:document:from3.submit();">班级信息</a>
                            </form>
                        </div>
                       
                        <div>
                        	<form action="ShowListCitation" method="post" id="from4" name="from4">
                        		<input type="hidden" name="studentId" value="${ student_message.studentId}"/>
                            	<a href="javascript:document:from4.submit();">获奖情况</a>
                        	</form>
                        </div>
                         <div>
                            <a href="addCitation">添加获奖情况 </a>
                        </div>
                    </div>
                    <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="http://jw.gzpyp.edu.cn/" target="_blank" >我的成绩</a>
                        </div>
                    </div>
                  
                </div>
            	</div>
            <div class="rightbox">
                

<h2 class="mbx">我的信息 &gt; 我的班级信息&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<label style="color: red;">本地上传图片和图片空间功能暂不开放</label></h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" href="#">学生班级信息</a></li>
</ul>

</div>
<div class="cztable">
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
            <td colspan="7"><label style="color: red;">学生办主任：</label></td>
        </tr>
        <c:forEach var="listAdmin" items="${requestScope.listAdmin}" >
        <tr>
                <td align="right">学生办主任：</td>
            	<td>${listAdmin.adminName }&nbsp;</td>
            	<td align="right">QQ号码：</td>
            	<td align="left">${listAdmin.qqnumber }&nbsp;</td>
            	<td align="right">手机号码：</td>
            	<td align="left">${listAdmin.phone }&nbsp;</td>
            	<td align="center">
            	<form action="SendMessageStudent" method="post" id="from6" name="from6">
                     <input type="hidden" name="adminId" value="${ listAdmin.adminId}"/>
                     <!-- <a href="javascript:document:from6.submit();" style="color: red;">发送信息</a> -->
                </form>
            	</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="7"><label style="color: red;">辅导员信息：</label></td>
       </tr>
       <c:forEach var="gradeteacher_message" items="${requestScope.gradeteacher_message}" >
       <tr>
                <td align="right">辅导员：</td>
            	<td>${gradeteacher_message.gradeteacherName }&nbsp;</td>
            	<td align="right">QQ号码：</td>
            	<td align="left">${gradeteacher_message.gradeteacherQqnumber }&nbsp;</td>
            	<td align="right">手机号码：</td>
            	<td align="left">${gradeteacher_message.gradeteacherPhone }&nbsp;</td>
            	<td align="center">
            		<form action="SendTeacher" method="post" id="from7" name="from7">
                     <input type="hidden" name="gradeteacherId" value="${ gradeteacher_message.gradeteacherId}"/>
                     <a href="javascript:document:from7.submit();" style="color: red;">发送信息</a>
                	</form>
            	</td>
       </tr> 
       </c:forEach>
       <tr>
            <td colspan="7"><label style="color: red;">辅导员助理信息：</label></td>
       </tr>
        
        <tr>
                <td align="right">辅导员助理：</td>
            	<td>${classmessage2.teacher.teacherName }&nbsp;</td>
            	<td align="right">QQ号码：</td>
            	<td align="left">${classmessage2.teacher.teacherQq }&nbsp;</td>
            	<td align="right">手机号码：</td>
            	<td align="left">${classmessage2.teacher.teacherPhone }&nbsp;</td>
            	<td align="center">
            		
            	</td>
       </tr> 
   
        <tr>
            <td colspan="7"><label style="color: red;">班级信息：</label></td>
        </tr>    
        <tr>
            <td width="91" align="right">班级名称：</td>
            <td colspan="6">${classmessageMessage.classmessageName }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级QQ群：</td>
            <td colspan="6">${classmessageMessage.classQqnumber } &nbsp;</td>
        </tr>
        <tr>
            <td align="right">班级宣传语：</td>
            <td colspan="6">${classmessageMessage.slogan }&nbsp;</td>
        </tr> 
        <tr>
            <td align="right">班级获得荣誉：</td>
            <td colspan="6">${classmessageMessage.classmessagehonor }</td>
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