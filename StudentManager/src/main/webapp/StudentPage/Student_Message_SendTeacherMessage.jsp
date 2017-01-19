<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	<script src="../js/uploadPreview.js" type="text/javascript"></script>
	<script src="js/uploadPreview.js" type="text/javascript"></script>
	
	<script charset="utf-8" src="editor/kindeditor.js"></script>
	<script charset="utf-8" src="editor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="editor/plugins/code/prettify.js"></script>
	
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
	
	 <%
		//登录验证
		Object admin_message = session.getAttribute("student_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		} 
	%> 	
	
	
<title>信工学生管理系统—学生</title>
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
			    <h2 class="mbx">发送信息 &gt; 发送信息&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<label style="color: red;">本地上传图片和图片空间功能暂不开放</label></h2>
<div class="morebt">
    
<ul id="ulStudMsgHeadTab">
	<li><a class="tab2" >发送信息</a> </li>
</ul>

</div>
<div class="cztable">  
	<form action="addTeacherMessageStudent" method="post" enctype="multipart/form-data"> 
	<input type="hidden" name="studentId" value="${ student_message.studentId}"/>
	<input type="hidden" name="gradeteacherId" value="${ gradeteacherId}"/>
	<table width="100%" cellpadding="0" cellspacing="0">
	        <tr>
	            <td width="15%" align="right"><div align="right">信息标题： </div></td>
	            <td><input id="teacherMessageTitle" size="20" name="teacherMessageTitle" class="input_2"/></td>
	        </tr>
	      
	        
	        <tr>
	            <td width="15%" align="right"><div align="right">信息内容： </div></td>
	            <td>
	            	<textarea name="content1" id="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
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