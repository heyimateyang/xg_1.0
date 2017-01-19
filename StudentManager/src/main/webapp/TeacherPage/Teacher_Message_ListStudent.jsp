<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
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
	            window.document.location.href = "StudentPageTeacher?teacherId=${ teacher_message.teacherId}";
	            return false;
	        }
	        return true;
	    }
	    function checkSelect() {
			var studentName = document.getElementById("studentName").value;
			if(studentName==""){
				alert("查询条件不能为空");
				return false;
			}
			return true;
		}
    </script>
	
<title>信工学生管理系统-辅导员助理</title>
</head>
<body>
<input type="hidden" id="gradeId" name="gradeId" value="${ teacher_message.grade.gradeId}"/>
<%-- <input type="hidden" id="classmessageId" name="classmessageId" value="${teacher_message.classmessage.classmessageId}"/> --%>
<div class="banner">
        <div class="bgh">
            <div class="page">
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
                           <a href="showPageSysteminformationTeacher">系统公告  </a>
                        </div>
					 </div>
					 <div class="cdlist">
		<%-- 			     <div>
	<a href="showNoReply?teacherId=${teacher_message.teacherId }">学生咨询信息</a>
	                     </div> --%>
					 </div>
				     <div class="ta1">
					  <strong>个人中心</strong>
					  <div class="leftbgbt">
					  </div>
					 </div>
					 <div class="cdlist">
					   <div>
					 <a
			href="TeacherByid?teacherId=${ teacher_message.teacherId}">辅导员助理信息
			         </a> 
					  </div>
					 </div>
				<div class="ta1">
					 <strong>教务中心</strong>
					 <div class="leftbgbt2">
					 </div>
				</div>
				     <div class="cdlist">	 
                        <%-- <div>
						<a href="findStudentScroeTeacher?gradeId=${teacher_message.grade.gradeId}&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩
						</a>
						</div> --%>
					    <div>
						<a href="StudentPageTeacher?teacherId=${teacher_message.teacherId }">学生信息 </a>
                        </div>
                    </div>
                  </div>
			  </div>
            <div class="rightbox">
                
    <h2 class="mbx">

       学生信息 &gt; 学生信息</h2>
       <!--  <form action="LikeStudentPageTeacher" method="post" onSubmit="return checkSelect()">
        
        
       	<div style="text-align: center;">
       		按学生名字查询(支持模糊查询)
       		<input name="studentName" id="studentName" type="text" />
       		<input name="" type="submit"  value="确定查询" />
       	</div>
       </form> -->
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="#">辅导员助理所管理班级学生信息列表</a></li>   
        </ul>
    </div>
    <div class="cztable">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                    	编号                   
                     </th>
                    <th scope="col"> 
                    	学生姓名                    
                    </th>
                    <th scope="col"> 
                    	学生学号
                    </th>
                    <th scope="col"> 
                    	状态
                    </th>
                    <th scope="col"> 
                    	
                    </th>
                </tr>
                <s:iterator value="#request.pageBean.list" id="Student">
           
			        <tr>
			            <th scope="col"><s:property value="#Student.studentId"/></th>
			            <th scope="col"><s:property value="#Student.studentName"/></th>
			            <th scope="col"><s:property value="#Student.studentNumber"/></th>  
			            <th scope="col"><s:property value="#Student.state"/></th> 
			            <th scope="col"> 
			            	<a href="findStudentTeacherById?studentId=<s:property value="#Student.studentId"/>" style="color: red">详情</a>
                   		</th>       
			        </tr>
      			</s:iterator>
            </tbody>
        </table>
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
            <a href="StudentPageTeacher?teacherId=${ teacher_message.teacherId}">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="StudentPageTeacher?page=<s:property value="#request.pageBean.currentPage - 1"/>&teacherId=${ teacher_message.teacherId}">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="StudentPageTeacher?page=<s:property value="#request.pageBean.currentPage + 1"/>&teacherId=${ teacher_message.teacherId}">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="StudentPageTeacher?page=<s:property value="#request.pageBean.totalPage"/>&teacherId=${ teacher_message.teacherId}">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    
        
        <div class="footer">
            <p>
            	学生管理系统
            </p>
        </div>
 </div>
</body>
</html>