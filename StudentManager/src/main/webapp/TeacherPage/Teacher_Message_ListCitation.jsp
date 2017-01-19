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
	            window.document.location.href = "ShowListCitationTeacher?studentId=${student_admin_message.studentId }";
	            return false;
	        }
	        return true;
	    }
	    function word(){
			document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
		}
    </script>
<title>信工学生管理系统-辅导员助理</title>
	<link href="css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/ks.css"  rel="stylesheet" type="text/css" />
	<link href="../css/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../css/ks.css" rel="stylesheet" type="text/css" />
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
					   <a href="showPageSysteminformationTeacher">系统公告</a>
					 </div>
					</div>
					<%-- <div class="cdlist">
						<div>
						<a href="showNoReply?teacherId=${teacher_message.teacherId }">学生咨询信息</a>
						</div>
					</div> --%>
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                           <a href="TeacherByid?teacherId=${ teacher_message.teacherId}">辅导员助理信息  </a>
                        </div>
                        
                    </div> 
                      <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <%-- <div>
                            <a href="findStudentScroeTeacher?gradeId=${ teacher_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">查找学生成绩</a>
                        </div> --%>
                        <div>
                           <a href="StudentPageTeacher?teacherId=${teacher_message.teacherId }">学生信息 </a>
                        </div>
                    </div> 
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        学生信息 &gt; 学生获奖情况</h2>
    <div class="morebt">
        <ul>
             <li><a class="tab2" href="findStudentTeacherById?studentId=${student_admin_message.studentId }">学生个人资料</a> </li>
		    <%-- <li><a class="tab2" href="StudentTeacherAchievementPage?studentId=${student_admin_message.studentId }">学生成绩</a> </li> --%>
		    <li><a class="tab2">学生获奖情况</a> </li>
		   <%--  <li><a class="tab2" href="clasee_MessageTeacher?gradeId=${student_admin_message.grade.gradeId }&classmessageId=${teacher_message.classmessage.classmessageId}">学生班级信息</a> </li> --%>
        </ul>
    </div>
    <div class="cztable">
    	<form action="servlet/ExportWordServlet.servlet" method="post">
         <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                    <th scope="col">
                       	奖状编号                    
                    </th>
                    <th scope="col">
                       	 奖项名称                
                    </th>
                    <th  scope="col"> 
                    	状态 
                    </th>
                    <th scope="col">
       					
                    </th>
                </tr>
              
              <s:iterator value="#request.pageBean.list" id="Citation">
			        <tr>
			            <th scope="col"><s:property value="#Citation.citationId"/></th>
			            <th scope="col">
			            	<s:property value="#Citation.citationTitle"/>
			            </th>
			            <th scope="col">
				            <s:if test="#Citation.state==0">没审批</s:if>
				           	<s:if test="#Citation.state==1">审批通过</s:if> 	
				           	<s:if test="#Citation.state==2">辅导员审批通过</s:if>
				           	<s:if test="#Citation.state==3">辅导员助理审批通过</s:if> 	
			            </th>  
			            <th scope="col"> 
			            	 <s:if test="#Citation.state==0">
			            	 	
			            	 </s:if>	
				          
				           		<a href="SwhoCitationTeacher?citationId=<s:property value="#Citation.citationId"/>" style="color: red" >详情</a>
                   		</th>       
			        </tr>
      			</s:iterator>
            </tbody>
        </table>
        </form>
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
            <a href="ShowListCitationTeacher?studentId=${student_admin_message.studentId }">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="ShowListCitationTeacher?page=<s:property value="#request.pageBean.currentPage - 1"/>&studentId=${student_admin_message.studentId }">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="ShowListCitationTeacher?page=<s:property value="#request.pageBean.currentPage + 1"/>&studentId=${student_admin_message.studentId }">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="ShowListCitationTeacher?page=<s:property value="#request.pageBean.totalPage"/>&studentId=${student_admin_message.studentId }">尾页</a>
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