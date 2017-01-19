<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@page import="java.util.*" %>
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
	<script src="js/checkUserNameAjax.js" type="text/javascript"></script>
	<script src="../js/checkUserNameAjax.js" type="text/javascript"></script>
	<%
		//登录验证
		Object admin_message = session.getAttribute("admin_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
<title>信工学生管理系统- 管理员</title>

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
                   辅导员：${admin_message.adminName }欢迎您！
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
                            <a href="LeaveStudentListAdmin">学生请假信息 </a>
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
<h2 class="mbx">管理员信息 &gt;管理员信息</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">管理员资料</a></li>
</ul>

</div>
<div class="cztable">
    
    <table border="0" cellspacing="0" cellpadding="0" width="100%">
    		<tr>
                <td align="center" colspan="4"><label style="color: red;">管理员资料</label></td>
            </tr>
     		<tr>
                <td align="right">登录名称：</td>
            	<td>${admin_message.users.userName }&nbsp;</td>
            	<td width="91" align="right">登录密码：</td>
	            <td>${admin_message.users.userPwd }&nbsp;<label style="color: red;">(加密后)</label></td>
            </tr>
	       	<tr>
	            <td align="right">管理员名字：</td>
            	<td align="left">${admin_message.adminName }&nbsp;</td>
	            <td align="right">权限：</td>
            	<td align="left">${admin_message.users.jurisdiction.jurisdictionName }&nbsp;</td>
        	</tr>
        	<tr>
       		  <td colspan="4" align="left" valign="middle">
                	<input type="button" name="button2" id="button2" value="修改管理员资料" class="input2" onClick="show_message();" />
              </td>
        	</tr>
    </table>
    
    <br/>
    <br/>
                
      <form action="update_admin?adminId=${admin_message.adminId }&userId=${admin_message.users.userId }&jurisdictionId=${admin_message.users.jurisdiction.jurisdictionId }" method=post name="form1" id="form1" onSubmit="return update_admin()">
    	<table id="update_show" border="0" cellspacing="0" cellpadding="0" width="100%" style="visibility:hidden">
	    	<tr>
	            <td colspan="4" align="center"><label style="color: red;">修改管理员资料</label>&nbsp;</td>
	        </tr>
	          
	        <tr>
                <td align="right">管理员名字：</td>
            	<td>
           		<input type="text" name="adminName" id="adminName" value="${admin_message.adminName }" onFocus="clearText(this)" onBlur="clearText(this)" maxlength="10">&nbsp; 
           		</td> 
           		<td align="right">用户权限：</td>
            	<td>
           		<label style="color: red;">${admin_message.users.jurisdiction.jurisdictionName }</label>	&nbsp; 
           		</td>              	
           	</tr>
	        
            <tr>
                <td align="right">登录名称：</td>
            	<td>
            		<input type="text" name="userName" id="userName" value="${admin_message.users.userName }"  maxlength="10" onChange="return checkName()"/>&nbsp;
            	</td>
            	<td align="right">新的登录密码：</td>
            	<td align="left">
            		<input type="text" name="userPwd" id="userPwd" value="" maxlength="10">&nbsp;            	
            	</td>
            </tr> 
            
            <tr>
                <td align="right">QQ号码：</td>
            	<td>
            		<input type="text" name="qqnumber" id="qqnumber" value="${admin_message.qqnumber }"  maxlength="10" onChange="return checkName()"/>&nbsp;
            	</td>
            	<td align="right">电话号码：</td>
            	<td align="left">
            		<input type="text" name="phone" id="phone" value="${admin_message.phone }"  maxlength="10" onChange="return checkName()"/>&nbsp;          	
            	</td>
            </tr>           	
        	<tr>
       		  <td colspan="4" align="left" valign="middle">
                	<input type="submit" name="Submit" value="确定修改" id="id_ok" class="input2"> 
                	<input type="button" name="Submit" value="收起" id="none_show" class="input2" onClick="none_message()">             
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