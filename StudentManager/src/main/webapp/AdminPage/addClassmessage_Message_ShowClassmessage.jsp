<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<SCRIPT language=javascript src="js/AdminUpdateVerification.js"></script>
	<SCRIPT language=javascript src="../js/AdminUpdateVerification.js"></script>
	<link href="js/jBox/Skins/Blue/jbox.css" rel="stylesheet"  />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />	
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
	
	<link rel="stylesheet" href="editor/themes/default/default.css" />
	<link rel="stylesheet" href="editor/plugins/code/prettify.css" />
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
<title>信工学生管理系统-管理员</title>
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
                

<h2 class="mbx">班级详细信息 &gt; 班级详细信息</h2>
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2">班级详细信息</a> </li>
    <li><a href="StudentPageClassmessId?classmessageId=${classmessage_message.classmessageId }" class="tab2">班级所属学生信息</a> </li>
</ul>

</div>
<div class="cztable">
	
    <table border="0" cellspacing="0" cellpadding="0" width="100%">

        <tr>
            <td width="91" align="right">班级名字：</td>
            <td colspan="5">${classmessage_message.classmessageName} </td>
        </tr>
        <tr>
            <td width="91" align="right">所属年级：</td>
            <td colspan="5">
            	${classmessage_message.grade.gradeName }
            </td>
        </tr>
        <tr>
            <td width="91" align="right">所属专业：</td>
            <td colspan="5">
            	${classmessage_message.profession.professionName } 
            </td>
        </tr>
        <tr>
            <td width="91" align="right">所属学院：</td>
            <td colspan="5">
            	${classmessage_message.college.collegeName } 
            </td>
        </tr>
         <tr>
            <td width="91" align="right">辅导员助理：</td>
            <td colspan="5">
            	${classmessage_message.teacher.teacherName } 
            </td>
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
            <td width="91" align="right">班级口号：</td>
            <td colspan="5">
            	${classmessage_message.slogan }
            </td>
        </tr>
        <tr>
            <td width="91" align="right">班级Q群：</td>
            <td colspan="5">
            	${classmessage_message.classQqnumber }
            </td>
        </tr>
        <tr>
            <td width="91" align="right">班级所获荣誉：</td>
            <td colspan="5">
            	${classmessage_message.classmessagehonor }
            </td>
        </tr>
         <tr>
            <td colspan="5">
            	<input type="button" name="button2" id="button2" value="修改班级信息资料" class="input2" onClick="show_message();" />
            </td>
        </tr>
         
    </table>
    <form action="UpdateClassmessageAdmins" method="post">
    	<input type="hidden" name="classmessageId" value="${classmessage_message.classmessageId}"/>
    	<table id="update_show" border="0" cellspacing="0" cellpadding="0" width="100%" style="visibility:hidden">
    	<tr>
	            <td colspan="4" align="center"><label style="color: red;">修改班级资料</label>&nbsp;</td>
	    </tr>
    	<tr>
            <td width="91" align="right">班级名字：</td>
            <td colspan="5"><input type="text" id="classmessageName" name="classmessageName" value="${classmessage_message.classmessageName}" maxlength="20" onFocus="clearText(this)" onBlur="clearText(this)"/> </td>
        </tr>
        <tr>
            <td width="91" align="right">所属年级：</td>
            <td colspan="5">
            	<select name="gradeId" id="gradeId">
	            	<c:forEach var="listGrade" items="${requestScope.listGrade}" >
					  <option value="${listGrade.gradeId }">${listGrade.gradeName }</option>
					</c:forEach>
				</select>
            </td>
        </tr>
        <tr>
            <td width="91" align="right">所属专业：</td>
            <td colspan="5">
            	<select name="professionId" id="professionId">
	            	<c:forEach var="listProfession" items="${requestScope.listProfession}" >
					  <option value="${listProfession.professionId }">${listProfession.professionName }</option>
					</c:forEach>
				</select>
            </td>
        </tr>
       	
         <tr>
            <td width="91" align="right">班级口号：</td>
            <td colspan="5">
            	<input type="text" value="${classmessage_message.slogan}" id="slogan" name="slogan" maxlength="20" onFocus="clearText(this)" onBlur="clearText(this)"/>
            </td>
        </tr>
        <tr>
            <td width="91" align="right">班级Q群：</td>
            <td colspan="5">
            	<input type="text" value="${classmessage_message.classQqnumber }" id="classQqnumber" name="classQqnumber" maxlength="20" onFocus="clearText(this)" onBlur="clearText(this)"/>
            </td>
        </tr>
        <tr>
            <td width="91" align="right">班级所获荣誉：</td>
            <td colspan="5">
            	<textarea name="content1" id="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
            </td>
        </tr>
         <tr>
            <td colspan="5">
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