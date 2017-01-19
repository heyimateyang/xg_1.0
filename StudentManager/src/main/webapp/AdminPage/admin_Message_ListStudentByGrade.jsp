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
		Object admin_message = session.getAttribute("admin_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
	<script type="text/javascript">
	    function validate(){
	        var page = document.getElementsByName("page")[0].value; 
	        var pages = document.getElementById("page").value;
	        if(page > <s:property value="#request.pageBean.totalPage"/>){
	            alert("你输入的页数大于最大页数，页面将跳转到首页！");
	            window.document.location.href = "StudentPageGrade?studentGradeName=${studentGradeName}";
	            return false;
	        }
	        if (page <= <s:property value="#request.pageBean.totalPage"/>) {
	        	window.document.location.href = "StudentPageGrade?studentGradeName=${studentGradeName}&page="+pages;
	            return false;
			}
	        return true;
	    }
	    
	   
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
                
    <h2 class="mbx">
       学生信息 &gt; 学生信息</h2>
       
    <div class="morebt">
        <ul>
            <li><a class="tab2" href="#">学生信息列表</a></li>  
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
                    	年级
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
			            <th scope="col"><s:property value="#Student.studentGradeName"/>级</th> 
			            <th scope="col"><s:property value="#Student.state"/></th> 
			            <th scope="col"> 
			            	<a href="findStudentById?studentId=<s:property value="#Student.studentId"/>" style="color: red">详情</a>/
			            	<a href="UpdateSutdentAdminIndex?studentId=<s:property value="#Student.studentId"/>" style="color: red">修改</a>/
	                    	<a href="deleteStudentAdmin?userId=<s:property value="#Student.users.userId"/>&studentId=<s:property value="#Student.studentId"/>" style="color: red" onclick="return confirm('确定将此记录删除?')">删除</a>
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
            <a href="StudentPageGrade?studentGradeName=${studentGradeName}">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="StudentPageGrade?page=<s:property value="#request.pageBean.currentPage - 1"/>&studentGradeName=${studentGradeName}">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="StudentPageGrade?page=<s:property value="#request.pageBean.currentPage + 1"/>&studentGradeName=${studentGradeName}">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="StudentPageGrade?page=<s:property value="#request.pageBean.totalPage"/>&studentGradeName=${studentGradeName}">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
    
    </center><br>
    
    <center>
        
        <form action="StudentPageGrade?gradeId=${gradeId}" onSubmit="return validate();">
            <font size="3">跳转至</font>
            <input type="text" size="2" name="page" id="page">页
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