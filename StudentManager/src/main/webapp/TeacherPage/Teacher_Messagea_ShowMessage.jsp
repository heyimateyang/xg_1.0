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
			Object admin_message = session.getAttribute("teacher_message"); 
			if(admin_message==null){
				response.sendRedirect("404.html"); 
			} 
 	%>
 	
 	
 	
<title>信工学生管理系统—助理辅导员</title>
	<link rel="stylesheet" href="../editor/themes/default/default.css" />
	<link rel="stylesheet" href="../editor/plugins/code/prettify.css" />
	<script charset="utf-8" src="../editor/kindeditor.js"></script>
	<script charset="utf-8" src="../editor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="../editor/plugins/code/prettify.js"></script>
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../editor/plugins/code/prettify.css',
				uploadJson : '../editor/jsp/upload_json.jsp',
				fileManagerJson : '../editor/jsp/file_manager_json.jsp',
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
           <div class="bgh">
            <div class="page" id="page">
            <div id="logo">
            	<a>
                	<img src="images/logo.png" alt="" width="300" height="67" />
                </a>
            </div>
                <div class="topxx">
                   助理辅导员：${teacher_message.teacherName }欢迎您！
                     <a href="TeacherquitSession">安全退出</a>
                </div>
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
                            <a href="TeacherByid?teacherId=${ teacher_message.teacherId}">班级辅导员信息  </a>
                        </div>
                        
                    </div> 
                      <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="findStudentScroeTeacher?gradeId=${ teacher_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩</a>
                        </div>
                        <div>
                            <a href="StudentPageTeacher?gradeId=${ teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">学生信息 </a>
                        </div>
                    </div> 
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        系统公告 &gt; 系统公告&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<label style="color: red;">本地上传图片和图片空间功能暂不开放</label></h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" href="showPageSysteminformationAdmin">系统公告</a> </li>
        </ul>
    </div>
    <div class="cztable">
		 <table width="100%" cellpadding="0" cellspacing="0">
	        <tr>
	            <td width="15%" align="right"><div align="right">公告标题： </div></td>
	            <td style="text-align: center;font-size: 19px">${systeminformationMessage.informationTitle }</td>
	        </tr>
	        <tr>
	            <td width="15%" align="right"><div align="right">发布日期： </div></td>
	            <td style="font-size: 19px">${systeminformationMessage.informationDate }</td>
	        </tr>
	      
	        
	        <tr>
	            <td width="15%" align="right"><div align="right">公告内容： </div></td>
	            <td>
	            	${systeminformationMessage.informationMessage}
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