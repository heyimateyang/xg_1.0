<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
			//登录验证
			Object admin_message = session.getAttribute("admin_message"); 
			if(admin_message==null){
				response.sendRedirect("404.html"); 
			} 
 	%>
 
 	
<title>信工管理系统—管理员</title>
	<link rel="stylesheet" href="../themes/default/default.css" />
	<link rel="stylesheet" href="../plugins/code/prettify.css" />
	<script charset="utf-8" src="../kindeditor.js"></script>
	<script charset="utf-8" src="../lang/zh_CN.js"></script>
	<script charset="utf-8" src="../plugins/code/prettify.js"></script>
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	
		
 	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
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
	   <a href="#">发布系统公告</a>
	 </div>
	</div>
	<div class="cdlist">
	<div>
	<a href="#">学生咨询信息</a>
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
                            <a href="GradeteacherPageAdmin">年级辅导员信息  </a>
                        </div>
                         <div>
                            <a href="TeacherPageAdmin">班级辅导员信息  </a>
                        </div>
                    </div> 
                    <div class="ta1">
                        <strong>添加信息</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                    	 <div>
                           <a href="addGradeTeacher">添加年级辅导员信息 </a>
                        </div>
                    	 <div>
                           <a href="addTeacherList">添加班级辅导员信息 </a>
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
                
    <h2 class="mbx">
        发布系统公告 &gt; 发布系统公告</h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" href="#">系统公告</a> </li>
           	<li><a class="tab2" href="#">发布公告</a> </li>
        </ul>
    </div>
    <div class="cztable">
	    <form name="example" method="post" action="demo.jsp">
		 <table width="100%" cellpadding="0" cellspacing="0">
	        <tr>
	            <td width="15%" align="right"><div align="right">公告标题： </div></td>
	            <td><input id="informationTitle" size="20" name="informationTitle" class="input_2"/></td>
	        </tr>
	      
	        
	        <tr>
	            <td width="15%" align="right"><div align="right">公告内容： </div></td>
	            <td>
	            	<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center">
	                <div align="center" >
	                    <input type="submit" value="提交" class="input2" />
	                </div>
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