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
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	
	
	<script src="js/LoginVerification.js" type="text/javascript"></script>
	<script src="../js/LoginVerification.js" type="text/javascript"></script>
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
			    <h2 class="mbx">我的信息 &gt; 我的获奖信息</h2>
<div class="morebt">
    
<ul id="ulStudMsgHeadTab">
	<li><a class="tab2" >添加获奖信息</a> </li>
</ul>

</div>
<div class="cztable">  
	<form action="upload" method="post" enctype="multipart/form-data"> 
	<input type="hidden" name="studentId" value="${student_message.studentId}"/>
	 <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td width="15%" align="right"><div align="right">奖项名称： </div></td>
            <td><input id="citationName" size="20" name="citationName" class="input_2"/></td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">颁奖单位： </div></td>
            <td><input id="citationTitle" size="20" name="citationTitle" class="input_2"/></td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">获奖时间： </div></td>
            <td><input id="citationDate" size="20" name="citationDate" class="input_2" class="Wdate" onClick="WdatePicker()"/></td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">奖项等级： </div></td>
            <td>
            	<select name="citationlevel" id="citationlevel">
				  <option value="校级">校级</option>
				  <option value="市级">市级</option>
				  <option value="省级">省级</option>
				  <option value="国家级">国家级</option>
				  <option value="国际级">国际级</option>
				</select>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">奖项图片： </div></td>
            <td>
                
                	 <ul id="warp" style="text-align: center;">
					  <li>
					    <input type="file" id="up_img_WU_FILE_0" name="myFile"/>
					    <img id="imgShow_WU_FILE_0" width="650" height="500" />
					  </li>
					</ul>
               
            </td>
        </tr>
        <tr>
            <td width="15%" align="right"><div align="right">获奖情况： </div></td>
            <td><textarea name="citationMessage" cols="110" rows="5" id="citationMessage" class="input_2" style="resize: none;"></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <div align="center" >
                    <input type="submit" value="提交" class="input2"/>
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