<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
		//登录验证
		Object admin_message = session.getAttribute("gradeteacher_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
 	<script type="text/javascript">
	    function validate(){
	        var page = document.getElementsByName("page")[0].value; 
	        if(page > <s:property value="#request.pageBean.totalPage"/>){
	            alert("你输入的页数大于最大页数，页面将跳转到首页！");
	            window.document.location.href = "showNoReply?gradeteacherId=${  gradeteacher_message.gradeteacherId}";
	            return false;
	        }
	        return true;
	    }
    </script>
<title>信安学生管理系统—辅导员</title>
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
                   辅导员：${gradeteacher_message.gradeteacherName }欢迎您！
                     <a href="GradeTeacherquitSession">安全退出</a>
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
				   <a href="showPageSysteminformationGradeTeacher">系统公告</a>
				 </div>
				 <div>
				    <form action="showNoReply" method="post" name="from2" id="from2">
						<input type="hidden" name="gradeteacherId" value="${gradeteacher_message.gradeteacherId }"/>
						<a href="javascript:document:from2.submit();">学生咨询信息</a>
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
                           <form action="ShowGradeTeacher" method="post" name="from1" id="from1">
							<input type="hidden" name="gradeteacherId" value="${gradeteacher_message.gradeteacherId }"/>
								<a href="javascript:document:from1.submit();">辅导员信息</a>
							</form>
                        </div>
                        
                        
                    </div>  
                    <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="StudentPageGradeTeacher">学生信息 </a>
                        </div>
                        <div>
                            <a href="AddSutdentGradeTeacherPage">添加学生 </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        咨询信息 &gt; 咨询信息</h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" href="showNoReply?gradeteacherId=${gradeteacher_message.gradeteacherId }">咨询列表</a> </li>
           	 <li>
           		<form action="showYesReply" method="post" id="from8" name="from8">
                    <input type="hidden" name="gradeteacherId" value="${gradeteacher_message.gradeteacherId }"/>
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
              
              <s:iterator value="#request.pageBean.list" id="Teacherreply">
			        <tr>
			            <th scope="col"><s:property value="#Teacherreply.teacherReplyId"/></th>
			            <th scope="col">
			            	<s:property value="#Teacherreply.replyTitle"/>
			            </th>
			             <th scope="col">
			            	<s:property value="#Teacherreply.student.studentName"/>
			            </th>
			            <th scope="col">
			            	<s:property value="#Teacherreply.replyDate"/>
			            </th>
			            <th scope="col">
			            	<s:property value="#Teacherreply.gradeteacher.gradeteacherName"/>
			            </th>
			            <th scope="col">
				            	已处理
			            </th>  
			            <th scope="col"> 
			            	<a href="OkReply?teacherMessageId=<s:property value="#Teacherreply.teachermessage.teacherMessageId"/>&gradeteacherId=<s:property value="#Teacherreply.gradeteacher.gradeteacherId"/>" style="color: red" >详情</a>
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
            <a href="showNoReply?page=<s:property value="#request.pageBean.currentPage - 1"/>&gradeteacherId=${  gradeteacher_message.gradeteacherId}">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="showNoReply?page=<s:property value="#request.pageBean.currentPage + 1"/>&gradeteacherId=${  gradeteacher_message.gradeteacherId}">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="showNoReply?page=<s:property value="#request.pageBean.totalPage"/>&gradeteacherId=${  gradeteacher_message.gradeteacherId}">尾页</a>
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