<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
		//登录验证
		Object admin_message = session.getAttribute("student_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
 	%>
 	<script type="text/javascript">
	    function validate(){
	        var page = document.getElementsByName("page")[0].value; 
	        if(page > <s:property value="#request.pageBean.totalPage"/>){
	            alert("你输入的页数大于最大页数，页面将跳转到首页！");
	            window.document.location.href = "ShowListCitation?studentId=${ student_message.studentId}";
	            return false;
	        }
	        return true;
	    }
	  
    </script>
<title>信工学生管理系统—学生</title>
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
        学生信息 &gt; 学生奖状信息</h2>
    <div class="morebt">
        <ul>
           	<li><a class="tab2" href="#">我的奖项列表</a> </li>
        </ul>
    </div>
    <div class="cztable">
	    <span id="table">
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
				           	<s:if test="#Citation.state==2">辅导员审批</s:if>
				           	<s:if test="#Citation.state==3">辅导员助理通过</s:if>
			            </th>  
			            <th scope="col"> 
			            	<%-- <form action="ShowCitation" method="post" id="from6" name="from6">
			            	 <input type="hidden" name="citationId" value="<s:property value="#Citation.citationId"/>"/> --%>
			            	 <a href="ShowCitation?citationId=<s:property value="#Citation.citationId"/>" style="color: red" >详情</a>/
			            	<!--  </form> -->
			            	 
			            	<!--  <form action="deleteStudentCitation" method="post" id="from7" name="from7"> -->
			            	<%--  <input type="hidden" name="citationId" value="<s:property value="#Citation.citationId"/>"/> --%>
			            	 <a href="deleteStudentCitation?citationId=<s:property value="#Citation.citationId"/>" style="color: red" onClick="return confirm('确定将此记录删除?')">删除</a>
			            	<!--  </form> -->
	                    	
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
            <a href="ShowListCitation?studentId=${ student_message.studentId}">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="ShowListCitation?page=<s:property value="#request.pageBean.currentPage - 1"/>&studentId=${student_message.studentId }">上一页</a>
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="ShowListCitation?page=<s:property value="#request.pageBean.currentPage + 1"/>&studentId=${student_message.studentId }">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="ShowListCitation?page=<s:property value="#request.pageBean.totalPage"/>&studentId=${student_message.studentId }">尾页</a>
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