<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<SCRIPT language=javascript src="js/GradeTeacherUpdateVerification.js"></script>
	<SCRIPT language=javascript src="../js/GradeTeacherUpdateVerification.js"></script>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />	
	
	<script src="../js/uploadPreview.js" type="text/javascript"></script>
	<script src="js/uploadPreview.js" type="text/javascript"></script>
	
	<script src="../js/addGradeTeacherVerification.js" type="text/javascript"></script>
	<script src="js/addGradeTeacherVerification.js" type="text/javascript"></script>
	
	<script src="js/checkGradeTeacherAjax.js" type="text/javascript"></script>	
	<script src="../js/checkGradeTeacherAjax.js" type="text/javascript"></script>
	 <%
		//登录验证
		Object admin_message = session.getAttribute("admin_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		} 
 	%> 
<title>信工学生管理系统-管理员</title>

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
<h2 class="mbx">辅导员信息 &gt;添加辅导员信息</h2> 
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">添加辅导员资料</a></li>
</ul>

</div>
<div class="cztable">
	<form action="addGradeTeacherAdmin" method="post" enctype="multipart/form-data" onSubmit="return checkName()">
    <table width="100%" cellpadding="0" cellspacing="0">
    <tbody>
    	<tr>
            <td align="left" colspan="4" style="color: red;">登录信息：</td>
        </tr>
        <tr>
            <td align="right" width="80">登录帐号：</td>
            <td><input type="text" id="userName" name="userName" maxlength="10" onChange="return checkName()"/></td>
            <td align="right" width="90">登录密码：</td>
            <td><input type="password" id="userPwd" name="userPwd" maxlength="10"/></td>
            <td rowspan="9" style="text-align: center;">
            辅导员照片<label style="color: red;">(必须选择图片)</label>
	             <div align="center">
	            	<ul id="warp">
					  <li>
					    <input type="file" id="up_img_WU_FILE_0" name="myFile"/>
					    <img id="imgShow_WU_FILE_0" width="160" height="120" />
					  </li>
					</ul>
	            </div> 
            </td>
        </tr>
        <tr>
            <td align="right" width="80">辅导员名字：</td>
            <td ><input type="text" id="gradeteacherName" name="gradeteacherName" maxlength="10"/></td>
            <td align="right" width="80">辅导员工号：</td>
            <td ><input type="text" id="workNumber" name="workNumber" maxlength="10"/></td>
        </tr>
        <!-- <tr>
            <td align="left" colspan="4" style="color: red;">教学信息：</td>
        </tr> -->
        <%-- <tr>
            <td align="right">教学年级：</td>
            <td>
            	<select name="gradeId" id="gradeId" onBlur="return checkGradeTeacherName()">
            	<c:forEach var="list_grade" items="${requestScope.list_grade}" >
				  <option value="${list_grade.gradeId }">${list_grade.gradeName }</option>
				</c:forEach>
				</select>
            </td>
            <td align="right">所属学院：</td>
            <td>
            	<select name="collegeId" id="collegeId" onBlur="return checkGradeTeacherName()">
            	<c:forEach var="list_college" items="${requestScope.list_college}" >
				  <option value="${list_college.collegeId }">${list_college.collegeName }</option>
				</c:forEach>
				</select>
            </td>
        </tr> --%>
        <tr>
            <td align="left" colspan="4" style="color: red;">联系方式：</td>
        </tr>
         <tr>
            <td align="right">联系地址：</td>
            <td><input type="text" id="address" name="address" maxlength="20"/></td>
            <td align="right">电话号码：</td>
            <td><input type="text" id="gradeteacherPhone" name="gradeteacherPhone" maxlength="20"/></td>
        </tr>
         <tr>
         	<td  align="right">QQ号码：</td>
            <td colspan="3"><input type="text" id="gradeteacherQqnumber" name="gradeteacherQqnumber" maxlength="20"/></td>
         </tr>
          <tr>
            <td colspan="4" style="text-align: center;">
            	<input type="submit" name="Submit" value="确定添加" id="id_ok" class="input2"  onclick="return confirm('确定添加吗?')"> 
            </td>
        </tr>
        <tbody>
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