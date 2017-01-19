<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
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
                           <a href="showPageSysteminformationTeacher">系统公告  </a>
                        </div>
					 </div>
					 <div class="cdlist">
				<%-- 	     <div>
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
                      <%--   <div>
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
                
<h2 class="mbx">学生信息 &gt; 学生个人资料 &nbsp;&nbsp;&nbsp;</h2>      
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" href="#">学生个人资料</a> </li>
   <%--  <li><a class="tab2" href="StudentTeacherAchievementPage?studentId=${student_admin_message.studentId }">学生成绩</a> </li> --%>
    <li><a class="tab2" href="ShowListCitationTeacher?studentId=${student_admin_message.studentId }">学生获奖情况</a> </li>
    <li><a class="tab2" href="clasee_MessageTeacher?gradeId=${student_admin_message.grade.gradeId }&classmessageId=${student_admin_message.classmessage.classmessageId}">学生班级信息</a> </li>
    
   
</ul>

</div>
<div class="cztable">
	<form action="servlet/ExportWordServlet.servlet" method="post">
	<input type="submit" name="Word" value="导出文档" onClick="word()"/>
	<input type="hidden" id="tableInfo" name="tableInfo" value=""/>
	<span id="table">
    <table width="100%" cellpadding="0" cellspacing="0">
    	<tr>
            <td align="left" colspan="4" style="color: red;">登录信息：
            <c:if test="${student_admin_message.studentstate==1 }">帐号启用</c:if>
            <c:if test="${student_admin_message.studentstate==2 }">帐号禁用</c:if>
            </td>
        </tr>
            <tr>
        <td align="right" colspan="4">
          <img id="pic_face"  height="160" width="120" src="studentHeadportrait/${student_admin_message.headportrait }"  style="padding:2px 2px 5px; border:1px #ddd solid;"/>
        </td>
       </tr>
        
        <tr>
            <td align="right" width="80">学生编号：</td>
            <td>${student_admin_message.studentId }&nbsp;</td>
            <td align="right" width="90">登录帐号：</td>
            <td colspan="1">${student_admin_message.users.userName }&nbsp;</td>
           
        </tr>
        
         <tr>
            <td align="left" colspan="4" style="color: red;">基本信息：</td>
        </tr>
      
        <tr>
        	
            <td align="right">学生姓名：</td>
            <td>${student_admin_message.studentName }&nbsp;</td>
            <td align="right">学号：</td>
            <td>${student_admin_message.studentNumber }&nbsp;</td>
           
        </tr>
        
        <tr>
        	
            <td align="right">性别：</td>
            <td>${student_admin_message.sex }&nbsp;</td>
            <td align="right">民族：</td>
            <td>${student_admin_message.nation }&nbsp;</td>
           
        </tr>
        
         <tr>
        	
            <td align="right">出生年月日：</td>
            <td>${student_admin_message.birthday }&nbsp;</td>
            <td align="right">出生地：</td>
            <td>${student_admin_message.placeofBirth }&nbsp;</td>
           
        </tr>
        
         <tr>
        	
            <td align="right">身高：</td>
            <td>${student_admin_message.height }&nbsp;</td>
            <td align="right">体重：</td>
            <td>${student_admin_message.weight }&nbsp;</td>
           
        </tr>
        <tr>
        	
            <td align="right">是否贫困生：</td>
            <td colspan="3">
            <c:if test="${student_admin_message.poor ==2}"><p style="color: red;">否</p></c:if>
			<c:if test="${student_admin_message.poor ==1}"><p style="color: red;">是</p></c:if> 	
            </td>

        </tr>
        
         <tr>
        	
            <td align="right">兴趣爱好：</td>
            <td colspan="3">${student_admin_message.interest }&nbsp;
            	
            </td>

        </tr>
        
        <tr>
        	
            <td align="right">政治面貌：</td>
            <td colspan="3">
            	${student_admin_message.political.politicallandscape }&nbsp;
            	
            	 <a href="updateSutdentPoliticallTeacher?studentId=${student_admin_message.studentId }" style="color: blue;" onclick="return confirm('确定审批通过吗?')">点击进行审批</a><br/> 
            	 
            	 <c:if test="${student_admin_message.politicallandscapestate ==4}"><p style="color: red;">(没审批)</p></c:if>
            	 <c:if test="${student_admin_message.politicallandscapestate ==3}"><p style="color: red;">(辅导员助理审批通过)</p></c:if>
            	 <c:if test="${student_admin_message.politicallandscapestate ==2}"><p style="color: red;">(辅导员审批通过)</p></c:if>
				 <c:if test="${student_admin_message.politicallandscapestate ==1}"><p style="color: red;">(审批通过)</p></c:if> 
				 
            </td>
            
           
        </tr>
        
        <tr>
        	
            <td align="right">身份证号码：</td>
            <td colspan="3">${student_admin_message.idcard }&nbsp;
            	
            </td>

        </tr>
        
        <tr>
            <td align="left" colspan="4" style="color: red;">学生在校信息：</td>
        </tr>
        
        <tr>
            <td align="right">在读学校：</td>
            <td colspan="3">${student_admin_message.shcoolName }&nbsp;</td>
          </tr>
         <tr>
            <td align="right">在读专业：</td>
            <td>${student_admin_message.classmessage.profession.professionName }&nbsp;</td>
            <td align="right">所属学院：</td>
            <td>${student_admin_message.college.collegeName }&nbsp;</td>
        </tr>
        
         <tr>
         	<td align="right">所在年级：</td>
            <td>${student_admin_message.studentGradeName }级&nbsp;</td>
            <td align="right">所在班级：</td>
            <td>${student_admin_message.classmessage.classmessageName }&nbsp;</td>
          </tr>
          
          <tr>
        	
            <td align="right">班级职务：</td>
            <td colspan="3">${student_admin_message.post.postName }&nbsp;</td>
            
           
        </tr>
        
        
        <tr>
            <td align="right">所在社团：</td>
            <td>${student_admin_message.corporation}&nbsp;</td>
            <td align="right">所在社团职务：</td>
            <td>${student_admin_message.corporationpost}&nbsp;</td>
        </tr>
          
        <tr>
            <td align="right">入学时间：</td>
            <td>${student_admin_message.dateTime}&nbsp;</td>
            <td align="right">状态：</td>
            <td>${student_admin_message.state}&nbsp;</td>
        </tr>
        
         <tr>
            <td align="right">所在宿舍：</td>
            <td colspan="3">${student_admin_message.dormitory}&nbsp;</td>
        </tr>
        
        
        <tr>
            <td colspan="4" align="left" style="color: red;">联系方式:</td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td>${student_admin_message.phoneNumber }</td>
            <td align="right">家庭电话号码：</td>
            <td>${student_admin_message.homePhone }</td>
        </tr>
        <tr>
        	<td align="right">QQ：</td>
            <td>${student_admin_message.qqNumber }</td>
            <td align="right">微信：</td>
            <td>${student_admin_message.weChat }</td>
          </tr>
        <tr>
        	<td align="right">邮箱：</td>
            <td>${student_admin_message.email }</td>
            <td align="right">联系地址：</td>
            <td>${student_admin_message.address }</td>
        </tr>    
        
         <tr>
            <td  align="left" style="color: red;">学生备注:</td>
            <td colspan="3">${student_admin_message.remarks }</td>
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