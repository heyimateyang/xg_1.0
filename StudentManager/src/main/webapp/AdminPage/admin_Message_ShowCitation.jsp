<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			Object admin_message = session.getAttribute("admin_message"); 
			if(admin_message==null){
				response.sendRedirect("404.html"); 
			}
	%> 	
<title>信工学生管理系统—管理员</title>
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
                    管理员：${admin_message.adminName }欢迎您！
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
			    <h2 class="mbx">学生信息 &gt; 学生获奖信息</h2>
<div class="morebt">
    
<ul id="ulStudMsgHeadTab">
	<li><a class="tab2" >学生获奖信息</a> </li>
	<li><a class="tab2" href="ShowListCitationAdmin?studentId=${student_admin_message.studentId }">学生奖项列表</a> </li>
</ul>

</div>
<div class="cztable">
	 
	 <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" align="right"><div align="right">奖项名称： </div></td>
            <td style="text-align: center;">${citatio_message.citationTitle }</td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">颁奖单位： </div></td>
            <td>${citatio_message.citationTitle }</td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">获奖时间： </div></td>
            <td>${citatio_message.citationDate }</td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">奖项等级： </div></td>
            <td>
            	${ citatio_message.citationlevel}
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">奖项图片： </div></td>
            <td>
                	 <div align="center"><img height="650" width="500" alt="奖状图片" src="${pageContext.request.contextPath}/CitationImage/${citatio_message.citationImg}"/></div>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">获项内容： </div></td>
            <td>${citatio_message.citationMessage }</td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">审批情况： </div></td>
            <td>
            	<c:if test="${citatio_message.state==0 }">
            		<label style="color: red;">没通过审批</label>
            	</c:if>
            	<c:if test="${citatio_message.state==1 }">
            		<label style="color: red;">通过审批</label>
            	</c:if>
            </td>
        </tr>
        <tr>
        
          <td style="text-align: center;" colspan="4"> 
          	<form action="UpdateCitationAdmin?citationId=${ citatio_message.citationId}&judgeId=1&studentId=${citatio_message.student.studentId }" method="post">
          		<input type="submit" name="Submit" value="审批通过" id="id_ok" class="input2" onClick="return confirm('确定通过审批吗?')">
          	</form> 
          </td>
        </tr>
        <tr>
        	<td style="text-align: center;" colspan="4">
        	<form action="UpdateCitationAdmin?citationId=${ citatio_message.citationId}&judgeId=2&studentId=${citatio_message.student.studentId }" method="post">
          		<input type="submit" name="Submit" value="审批不通过" id="id_ok" class="input2" onClick="return confirm('确定不通过审批吗?')">
          	</form> 
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