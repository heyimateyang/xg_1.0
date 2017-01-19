<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
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
 	<script type="text/javascript">
	    function validate(){
	        var page = document.getElementsByName("page")[0].value; 
	        if(page > <s:property value="#request.pageBean.totalPage"/>){
	            alert("你输入的页数大于最大页数，页面将跳转到首页！");
	            window.document.location.href = "showNoReply?teacherId=${  teacher_message.teacherId}";
	            return false;
	        }
	        return true;
	    }
    </script>
<title>信安学生管理系统—助理辅导员</title>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
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
                   助理辅导员：${teacher_message.teacherName }欢迎您！
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
        咨询信息 &gt; 咨询信息</h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" href="#">咨询列表</a> </li>
           	 <li>
           		<form action="showYesReply" method="post" id="from8" name="from8">
                    <input type="hidden" name="teacherId" value="${teacher_message.teacherId }"/>
                      <a href="javascript:document:from8.submit();" class="tab2">已处理列表</a>
                </form>
           	 </li>
        </ul>
    </div>
    <div class="cztable">
	    <span id="table">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                       	信息编号                 
                    </th>
                    <th scope="col">
                       	信息标题                 
                    </th>
                    <th  scope="col"> 
                    	发送人 
                    </th>
                    <th  scope="col"> 
                    	发送日期 
                    </th>
                    <th  scope="col"> 
                    	处理辅导员
                    </th>
                     <th  scope="col"> 
                    	处理状态
                    </th>
                    <th scope="col">
       					
                    </th>
                </tr>
              
              <s:iterator value="#request.pageBean.list" id="Teachermessage">
			        <tr>
			            <th scope="col"><s:property value="#Teachermessage.teacherMessageId"/></th>
			            <th scope="col">
			            	<s:property value="#Teachermessage.teacherMessageTitle"/>
			            </th>
			             <th scope="col">
			            	<s:property value="#Teachermessage.student.studentName"/>
			            </th>
			            <th scope="col">
			            	<s:property value="#Teachermessage.teacherMessageDate"/>
			            </th>
			            <th scope="col">
			            	<s:property value="#Teachermessage.teacher.teacherName"/>
			            </th>
			            <th scope="col">
				            <s:if test="#Teachermessage.state==1">没处理</s:if>
				           	<s:if test="#Teachermessage.state==2">以处理</s:if> 	
			            </th>  
			            <th scope="col"> 
			            	<a href="findTeacherMessageTeacher?teacherMessageId=<s:property value="#Teachermessage.teacherMessageId"/>&studentId=<s:property value="#Teachermessage.student.studentId"/>" style="color: red" >详情</a>
                   		</th>       
			        </tr>
      			</s:iterator>
            </tbody>
        </table>
        </span>
    </div>

            </div>
        </div>
        
      <center>
    
        <font size="3">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="3">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>
        
        <s:if test="#request.pageBean.currentPage == 1">
           	 首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="showNoReply?teacherId=${  teacher_message.teacherId}">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="showNoReply?page=<s:property value="#request.pageBean.currentPage - 1"/>&teacherId=${  teacher_message.teacherId}">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="showNoReply?page=<s:property value="#request.pageBean.currentPage + 1"/>&teacherId=${  teacher_message.teacherId}">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="showNoReply?page=<s:property value="#request.pageBean.totalPage"/>&teacherId=${  teacher_message.teacherId}">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    
    <center>
        
        <form action="showNoReply?gradeId=${ teacher_message.grade.gradeId}&teacherId=${  teacher_message.teacherId}" onsubmit="return validate();">
            <font size="3">跳转至</font>
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
    </center>
        
        <div class="footer">
            <p>
            	学生管理系统
            </p>
        </div>
    </div>
</body>
</html>