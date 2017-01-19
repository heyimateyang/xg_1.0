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
		/* ${pageContext.request.contextPath} */
 	%>
 	
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />	
	<script src="js/uploadPreview.js" type="text/javascript"></script>
	<script src="../js/uploadPreview.js" type="text/javascript"></script>	
	<script src="js/checkUserNameAjax.js" type="text/javascript"></script>
	<script src="../js/checkUserNameAjax.js" type="text/javascript"></script>	
	<script src="../js/adminAddStudentVerification.js" type="text/javascript"></script>
	<script src="js/adminAddStudentVerification.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	
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
                
<h2 class="mbx">更改学生信息 &gt; 更改学生个人资料 &nbsp;&nbsp;&nbsp;</h2>   
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" href="findStudentById?studentId=${student_admin_message.studentId }">学生个人资料</a> </li>
    <%-- <li><a class="tab2" href="StudentAchievementPage?studentId=${student_admin_message.studentId }">学生成绩</a> </li> --%>
    <li><a class="tab2" href="ShowListCitationAdmin?studentId=${student_admin_message.studentId }">学生获奖情况</a> </li>
    <li><a class="tab2" href="clasee_MessageAdmin?gradeId=${student_admin_message.grade.gradeId }&classmessageId=${student_admin_message.classmessage.classmessageId}">学生班级信息</a> </li>
</ul>

</div>

<div class="cztable">
<form action="updateStudentAdmin?studentId=${student_admin_message.studentId }&userId=${student_admin_message.users.userId}" method="post" enctype="multipart/form-data" onSubmit="return addStudentAdmin()">
   <input type="text" name="studentGradeName" value="${student_admin_message.studentGradeName}" style="display: none;"/>
   <input id="picName" name="picName" type="text" value="${student_admin_message.headportrait }" style="display: none;">
   <table width="100%" cellpadding="0" cellspacing="0">
    <tbody>
    	<tr>
            <td align="left" colspan="4" style="color: red;">登录信息：</td>
        </tr>
        <tr>
            <td align="right" width="80">登录帐号：</td>
            <td><input type="text" value="${student_admin_message.users.userName}" name="userName" id="userName" maxlength="10" onchange="checkName()"/>&nbsp;</td>
            <td align="right" width="90">登录密码：</td>
            <td><input type="password" value="" name="userPwd" id="userPwd" maxlength="10"/>&nbsp;</td>
            <td rowspan="19">
          	  <div align="center" style="text-align: center;">	没修改前</div>
            <div align="center">
            <img id="pic_face"  height="160" width="120" src="studentHeadportrait/${student_admin_message.headportrait }"  style="padding:2px 2px 5px; border:1px #ddd solid;"/>
            
            <br/>
            修改预览<label style="color: red;">(必须选择图片)</label>
            <ul id="warp">
			  <li>
			    <input type="file" id="up_img_WU_FILE_0" name="myFile"/>
			    <img id="imgShow_WU_FILE_0" width="100" height="100" />
			  </li>
			</ul>
			</div> 
            </td>
        </tr>
        <tr>
            <td align="right">学籍号：</td>
            <td colspan="4"><input type="text" value="${student_admin_message.studentNumber }" name="studentNumber" id="studentNumber" maxlength="10"/>&nbsp;</td>
        </tr>
        <tr>
            <td align="left" colspan="4" style="color: red;">基本信息：</td>
        </tr>
        <tr>
            <td align="right">学生姓名：</td>
            <td><input type="text" value="${student_admin_message.studentName}" name="studentName" id="studentName" maxlength="10"/>&nbsp;</td>
            <td align="right">性别&nbsp;</td>
            <td>
            	<select name="sex" id="sex">
            		<option value="男">男</option>
				    <option value="女">女</option>
            	</select>
            </td>
          </tr>
         <tr>
           <td align="right">民族：</td>
            <td>
            	<input value="${student_admin_message.nation}" name="nation" id="nation" maxlength="5"/>&nbsp;
            </td>
            <td align="right">政治面貌：</td>
            <td>
            	<select name="PoliticallandscapeId" id="PoliticallandscapeId">
            	<c:forEach var="list_politiacal" items="${requestScope.list_politiacal}" >
				  <option value="${list_politiacal.politicallandscapeId }">${list_politiacal.politicallandscape }</option>
				</c:forEach>
				</select>
            </td>
        </tr>
        
        <tr>
           <td align="right">出生地：</td>
            <td>
            	<input value="${student_admin_message.placeofBirth}" name="PlaceofBirth" id="PlaceofBirth" />&nbsp;
            </td>
            <td align="right">出生年月日：</td>
            <td>
            	<input value="${student_admin_message.birthday}" name="birthday" id="birthday" placeholder="格式：年/月/日" class="Wdate" onClick="WdatePicker()"/>&nbsp;
            </td>
        </tr>
        
        <tr>
           <td align="right">身高：</td>
            <td>
            	<input value="${student_admin_message.height}" name="height" id="height" />&nbsp;
            </td>
            <td align="right">体重：</td>
            <td>
            	<input value="${student_admin_message.weight}" name="weight" id="weight" />&nbsp;
            </td>
        </tr>
        <tr>
            <td align="right">是否贫困生：</td>
            <td colspan="3"><input name="poor" type="radio" value="1">是<input name="poor" type="radio" value="2">否</td>
        </tr>
        <tr>
            <td align="right">身份证号码：</td>
            <td colspan="3"><input type="text" value="${student_admin_message.idcard}" name="idcard" id="idcard" /></td>
        </tr>
        
         <tr>
           <td align="right">在读学校：</td>
            <td>
            	<input value="广州市番禺职业技术学院" name="shcoolName" id="shcoolName" readonly="readonly"/>&nbsp;
            </td>
            <td align="right">所在班级：</td>
            <td>
            	<select name="classmessageId" id="classmessageId">
            	<c:forEach var="list" items="${requestScope.list}" > 
				  <option value="${list.classmessageId }">${list.classmessageName }</option>
				</c:forEach>
				</select>
            </td>
        </tr>
        
       <tr>
            <td align="right">班级职务：</td>
            <td colspan="3">
            	<select name="postId" id="postId">
            	<c:forEach var="list_post" items="${requestScope.list_post}" >
				  <option value="${list_post.postId }">${list_post.postName }</option>
				</c:forEach>
				</select>
            </td>
        </tr>
        
        <tr>
            <td align="right">入学时间：</td>
            <td><input type="text" value="${student_admin_message.dateTime}" name="dateTime" id="dateTime" maxlength="10" placeholder="格式：年/月/日" class="Wdate" onClick="WdatePicker()"/></td>
             <td align="right">状态：</td>
            <td>
            	<select name="state" id="state">
				  <option value="在读">在读</option>
				  <option value="毕业">毕业</option>
				  <option value="休学">休学</option>
				</select>
            </td>
        </tr>
        
        <tr>
            <td align="right">参加的社团：</td>
            <td><input type="text" value="${student_admin_message.corporation}" name="corporation" id="corporation" placeholder="多个社团,用‘;’隔开"/></td>
            <td align="right">在社团的职位：</td>
            <td>
            	<input value="${student_admin_message.corporationpost}" name="corporationpost" id="corporationpost" placeholder="多个社团,用‘;’隔开" />&nbsp;
            </td>
        </tr>
        
         <tr>
            <td align="right">兴趣：</td>
            <td><input type="text" value="${student_admin_message.interest}" name="interest" id="interest" /></td>
            <td align="right">所在宿舍：</td>
            <td>
            	<input value="${student_admin_message.dormitory}" name="dormitory" id="dormitory"  />&nbsp;
            </td>
        </tr>
        
        <tr>
            <td colspan="4" align="left" style="color: red;">联系方式:</td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td><input type="text" value="${student_admin_message.phoneNumber}" name="phoneNumber" id="phoneNumber" maxlength="13"/></td>
            <td align="right">家庭电话号码：</td>
            <td><input type="text" value="${student_admin_message.homePhone}" name="homePhone" id="homePhone" maxlength="15"/></td>
        </tr>
        <tr>
        	<td align="right">QQ：</td>
            <td><input type="text" value="${student_admin_message.qqNumber}" name="qqNumber" id="qqNumber" maxlength="25"/></td>
            <td align="right">微信：</td>
            <td><input type="text" value="${student_admin_message.weChat}" name="WeChat" id="WeChat" maxlength="20"/></td>
          </tr>
        <tr>
        	<td align="right">电子邮箱：</td>
            <td><input type="text" value="${student_admin_message.email}" name="email" id="email" maxlength="30"/></td>
            <td align="right">联系地址：</td>
            <td><input type="text" value="${student_admin_message.address}" name="address" id="address" /></td>
            
        </tr>
        
         <tr>
            <td colspan="4" align="left" style="color: red;">备注信息:</td>
        </tr>
        <tr>
          
            <td colspan="4"> <textarea name="remarks" cols="95" rows="5" id="remarks" class="input_2" style="resize: none;">${student_admin_message.remarks}</textarea></td>
        </tr>
        
        <tr>
            <td colspan="5" style="text-align: center;">
            	<input type="submit" name="Submit" value="确定修改" id="id_ok" class="input2"> 
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