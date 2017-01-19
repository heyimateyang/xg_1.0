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
	<SCRIPT language=javascript src="js/AdminUpdateVerification.js"></script>
	<SCRIPT language=javascript src="../js/AdminUpdateVerification.js"></script>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />	
	
	<script src="../js/uploadPreview.js" type="text/javascript"></script>
	<script src="js/uploadPreview.js" type="text/javascript"></script>
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
<h2 class="mbx">更改辅导员助理信息 &gt;更改辅导员助理信息</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" href="TeacherByid?teacherId=${ teacher_message.teacherId}">班级辅导员资料</a></li>
    <li><a class="tab2">修改辅导员助理资料</a></li>
</ul>

</div>
<div class="cztable">
<form action="updateTeacherMessage" method="post" enctype="multipart/form-data">
<input type="hidden" name="teacherId" value="${teacher_message.teacherId }"/>
<input type="hidden" name="userId" value="${teacher_message.users.userId}"/>
<input type="hidden" name=picName value="${teacher_message.headportrait}"/>
    <table width="100%" cellpadding="0" cellspacing="0">
    	<tr>
            <td align="left" colspan="4" style="color: red;">基本资料：</td>
        </tr>
        <tr>
            <td align="right" width="80">姓名：</td>
            <td><input type="text" value="${teacher_message.teacherName }" id="teacherName" name="teacherName" maxlength="10"/></td>
            <td align="right" width="90">登录帐号：</td>
            <td><input value="${teacher_message.users.userName }" name="userName" id="userName" type="text" maxlength="10" readonly="readonly"/><label style="color: red;">不可修改</label></td>
            <td rowspan="9">
          	  <div align="center" style="text-align: center;">	没修改前</div>
            <div align="center">
            <img id="pic_face"  height="160" width="120" src="TeacherHeadportrait/${teacher_message.headportrait }"  style="padding:2px 2px 5px; border:1px #ddd solid;"/>
            <br/>
            修改预览
            <ul id="warp">
			  <li>
			    <input type="file" id="up_img_WU_FILE_0" name="myFile"/>
			    <img id="imgShow_WU_FILE_0" width="100" height="100" />
			  </li>
			</ul>
			</div> 
        </td>
         <tr>
         	<td align="right" width="80">新密码：</td>
         	<td><input value="" type="text" id="userPwd" name="userPwd" maxlength="10"/></td>
        	<td align="right" width="80">工号：</td>
        	<td><input value="${teacher_message.workNumber }" id="workNumber" name="workNumber" type="text" readonly="readonly"/><label style="color: red;">不可修改</label></td>
        </tr>
        <tr style="display: none;">
         	<td align="right">管理班级：</td>
            <td>       
            	<c:forEach var="list" items="${sessionScope.list}" >
				 	${list.classmessageName }<br/>
				</c:forEach>     
            	<%-- <input value="${teacher_message.classmessage.classmessageId }" name="classmessageId" id="classmessageId"/>	 --%>
            </td>
           
          </tr>
        
        <tr>
            <td colspan="4" align="left" style="color: red;">联系方式:</td>
        </tr>
        <tr>
            <td align="right">联系地址：</td>
            <td><input type="text" value="${teacher_message.teacherAddress}" id="teacherAddress" name="teacherAddress" maxlength="12"/></td>
            <td align="right">电话号码：</td>
            <td><input type="text" name="teacherPhone" id="teacherPhone" value="${teacher_message.teacherPhone }" maxlength="10"/></td>
        </tr>
        <tr>
        	<td align="right">QQ：</td>
            <td colspan="3"><input value="${teacher_message.teacherQq }" type="text" id="teacherQq" name="teacherQq" maxlength="10"/></td>
        </tr>
        
        <tr>
       	<td colspan="4" align="left" valign="middle" style="text-align: center;">
        	<input type="submit" name="Submit" value="确定修改" id="id_ok" class="input2" onClick="return confirm('确定修改吗?')">              
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