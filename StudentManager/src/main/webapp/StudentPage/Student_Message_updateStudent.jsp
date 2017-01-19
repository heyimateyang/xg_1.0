<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script src="../js/StudentUpdateVerification.js" type="text/javascript"></script>
	<script src="js/StudentUpdateVerification.js" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

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
			    <h2 class="mbx">
			        我的信息&nbsp;&nbsp;&nbsp;&nbsp;</h2>
<div class="morebt">
    
<ul id="ulStudMsgHeadTab">
	<li>
	 <form action="class_ShowStudentMessage" method="post" id="from6" name="from6">
       <input type="hidden" name="studentId" value="${student_message.studentId}"/>
       <a href="javascript:document:from6.submit();" class="tab2">学生信息</a>
     </form>
	</li>
	<li><a class="tab2" >修改信息</a> </li>
</ul>

</div>
<div class="cztable">  
	<form action="update_Student" method="post" enctype="multipart/form-data" <!-- onSubmit="return update_student()" -->>
	<input type="hidden" name="studentId" value="${student_message.studentId}"/>
	<input type="hidden" name="userId" value="${student_message.users.userId}"/>
	<input type="hidden" name="picName" value="${student_message.headportrait }"/>
	<input type="hidden" name="studentName" value="${student_message.studentName }"/>
	<input type="hidden" name="sex" value="${student_message.sex}"/>
	<input type="hidden" name="nation" value="${student_message.nation}"/>
	<%-- <input type="hidden" name="height" value="${student_message.height}"/>
	<input type="hidden" name="weight" value="${student_message.weight}"/> --%>
	<input type="hidden" name="shcoolName" value="${student_message.shcoolName}"/>
	<%-- <input type="hidden" name="postId" value="${student_message.post.postId}"/> --%>
	<input type="hidden" name="classmessageId" value="${student_message.classmessage.classmessageId}"/>
	<%-- <input type="hidden" name="PoliticallandscapeId" value="${student_message.political.politicallandscapeId}"/> --%>
	<input type="hidden" name="PlaceofBirth" value="${student_message.placeofBirth}"/>
	<input type="hidden" name="birthday" value="${student_message.birthday}"/>
	
     <table width="100%" cellpadding="0" cellspacing="0">
    <tbody>
    	<tr>
            <td align="left" colspan="4" style="color: red;">登录信息：</td>
        </tr>
        <tr>
        <td align="right" colspan="4">
          <img id="pic_face"  height="160" width="120" src="studentHeadportrait/${student_message.headportrait }"  style="padding:2px 2px 5px; border:1px #ddd solid;"/>
        </td>
       </tr>
        <tr>
            <td align="right" width="80">登录帐号：</td>
            <td>${student_message.users.userName}&nbsp;</td>
            <td align="right" width="90">登录密码：</td>
            <td><input type="password" value="" name="userPwd" id="userPwd" maxlength="10"/>&nbsp;</td>
           
        </tr>
        
        <tr>
            <td align="right">学籍号：</td>
            <td colspan="4">${student_message.studentNumber }&nbsp;</td>
        </tr>
        <tr>
            <td align="left" colspan="4" style="color: red;">基本信息：</td>
        </tr>
      
        <tr>
            <td align="right">学生姓名：</td>
            <td>${student_message.studentName}&nbsp;</td>
            <td align="right">性别&nbsp;</td>
            <td>
            	
            	${student_message.sex }
            </td>
            
        
          </tr>
         <tr>
           <td align="right">民族：</td>
            <td>
            	${student_message.nation}&nbsp;
            </td>
            <td align="right">政治面貌：</td>
            <td>
            	<select name="PoliticallandscapeId">
                	<option value="6">群众</option>
                	<option value="7">团员</option>
                	<option value="8">中共预备党员</option>
                	<option value="9">中共党员</option>
                	<option value="10">入党积极份子</option>
                </select>
				
            </td>
        </tr>
        
        <tr>
           <td align="right">出生地：</td>
            <td>
            	${student_message.placeofBirth}&nbsp;
            </td>
            <td align="right">出生年月日：</td>
            <td>
            	${student_message.birthday}&nbsp;
            </td>
        </tr>
        
        <tr>
           <td align="right">身高：</td>
            <td>
            	<input type="text" value="${student_message.height}" name="height" id="height" />&nbsp;
            </td>
            <td align="right">体重：</td>
            <td>
            	<input type="text" value="${student_message.weight}" name="weight" id="weight" />&nbsp;
            </td>
        </tr>
        
        <tr>
            <td align="right">身份证号码：</td>
            <td colspan="3">${student_message.idcard}</td>
        </tr>
        
         <tr>
           <td align="right">在读学校：</td>
            <td>
            	${student_message.shcoolName }&nbsp;
            </td>
            <td align="right">所在班级：</td>
            <td>
            	
				${student_message.classmessage.classmessageName }
            </td>
        </tr>
        
       <tr>
            <td align="right">班级职务：</td>
            <td colspan="3">
            	<select name="postId">
                	<option value="14">学生</option>
                	<option value="15">班长</option>
                	<option value="16">团支书</option>
                	<option value="17">学习委员</option>
                	<option value="18">生活委员</option>
                	<option value="19">文娱委员</option>
                	<option value="20">宣传委员</option>
                	<option value="21">素拓委员</option>
                	<option value="22">心里委员</option>
                	<option value="23">体育委员</option>
                	<option value="24">青志委员</option>
                	<option value="25">副班长</option>
                </select>
            	
            </td>
        </tr>
        
        <tr>
            <td align="right">入学时间：</td>
            <td>${student_message.dateTime}</td>
             <td align="right">状态：</td>
            <td>
            	${student_message.state}
            </td>
        </tr>
        
        <tr>
            <td align="right">参加的社团：</td>
            <td><input type="text" value="${student_message.corporation}" name="corporation" id="corporation" placeholder="多个社团,用‘;’隔开"/></td>
            <td align="right">在社团的职位：</td>
            <td>
            	<input value="${student_message.corporationpost}" name="corporationpost" id="corporationpost" placeholder="多个社团,用‘;’隔开" />&nbsp;
            </td>
        </tr>
        
         <tr>
            <td align="right">兴趣：</td>
            <td><input type="text" value="${student_message.interest}" name="interest" id="interest" /></td>
            <td align="right">所在宿舍：</td>
            <td>
            	<input value="${student_message.dormitory}" name="dormitory" id="dormitory"  />&nbsp;
            </td>
        </tr>
        
        <tr>
            <td colspan="4" align="left" style="color: red;">联系方式:</td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td><input type="text" value="${student_message.phoneNumber}" name="phoneNumber" id="phoneNumber" maxlength="13"/></td>
            <td align="right">家庭电话号码：</td>
            <td><input type="text" value="${student_message.homePhone}" name="homePhone" id="homePhone" maxlength="15"/></td>
        </tr>
        <tr>
        	<td align="right">QQ：</td>
            <td><input type="text" value="${student_message.qqNumber}" name="qqNumber" id="qqNumber" maxlength="25"/></td>
            <td align="right">微信：</td>
            <td><input type="text" value="${student_message.weChat}" name="WeChat" id="WeChat" maxlength="20"/></td>
          </tr>
        <tr>
        	<td align="right">电子邮箱：</td>
            <td><input type="text" value="${student_message.email}" name="email" id="email" maxlength="30"/></td>
            <td align="right">联系地址：</td>
            <td><input type="text" value="${student_message.address}" name="address"  /></td>
            
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