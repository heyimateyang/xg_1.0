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
	
	
	<link href="css/systemMessage.css" rel="stylesheet" type="text/css" />
	<link href="../css/systemMessage.css" rel="stylesheet" type="text/css" />

	 <%
		//登录验证
		Object admin_message = session.getAttribute("student_message"); 
		if(admin_message==null){
			response.sendRedirect("404.html"); 
		}
	%> 	
	<script type="text/javascript">
		function word(){
			document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
		}
	</script>
<title>信工学生管理系统—学生</title>
</head>
<body>

	 
    <div id="msg_win" style="display:block;top:490px;visibility:visible;opacity:1;">
	    <div class="icos"><a id="msg_min" title="最小化" href="javascript:void 0">_</a><a id="msg_close" title="关闭" href="javascript:void 0">×</a></div>
	    <div id="msg_title">系统公告：</div>
	    
	    <div id="msg_content">
	    	<table width="100%" cellpadding="0" cellspacing="0" style="font-size:  15px">
	    		<tr>
	    			<td>公告</td>
	    			<td>时间</td>
	    		</tr>
	    	<c:forEach var="list" items="${requestScope.list}" >
	    		<tr>
	    			<td><a href="showSysteminformationByIdStudent?informationId=${list.informationId }">${list.informationTitle }</a></td>
	    			<td>${list.informationDate }</td>		
	    		</tr>
	    	</c:forEach>
	    	</table>
	        
	    </div>
    </div>
    
    
	<%-- <s:property value="#request.mess" escape="false"/> --%>
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
	<li><a class="tab2" >学生信息</a> </li>
	<li><a class="tab2" href="UpdateStudent">修改信息</a> </li>
</ul>

</div>
<div class="cztable">  
	<form action="servlet/ExportWordServlet.servlet" method="post">
    <input type="submit" name="Word" value="导出文档" onclick="word()"/>
    <input type="hidden" id="tableInfo" name="tableInfo" value=""/>
    <span id="table">
     <table width="100%" cellpadding="0" cellspacing="0">
    	<tr>
            <td align="left" colspan="4" style="color: red;">登录信息：</td>
        </tr>
         <tr>
        <td align="right" rowspan="4">
          <img id="pic_face"  height="160" width="120" src="studentHeadportrait/${student_message.headportrait }"  style="padding:2px 2px 5px; border:1px #ddd solid;"/>
        </td>
       </tr>
        <tr>
            <td align="right" width="80">学生编号：</td>
            <td>${student_message.studentId }&nbsp;</td>
            <td align="right" width="90">登录帐号：</td>
            <td colspan="1">${student_message.users.userName }&nbsp;</td>
           
        </tr>
        
         <tr>
            <td align="left" colspan="4" style="color: red;">基本信息：</td>
        </tr>
       
        <tr>
        	
            <td align="right">学生姓名：</td>
            <td>${student_message.studentName }&nbsp;</td>
            <td align="right">学号：</td>
            <td>${student_message.studentNumber }&nbsp;</td>
           
        </tr>
        
        <tr>
        	
            <td align="right">性别：</td>
            <td>${student_message.sex }&nbsp;</td>
            <td align="right">民族：</td>
            <td>${student_message.nation }&nbsp;</td>
           
        </tr>
        
         <tr>
        	
            <td align="right">出生年月日：</td>
            <td>${student_message.birthday }&nbsp;</td>
            <td align="right">出生地：</td>
            <td>${student_message.placeofBirth }&nbsp;</td>
           
        </tr>
        
         <tr>
        	
            <td align="right">身高：</td>
            <td>${student_message.height }&nbsp;</td>
            <td align="right">体重：</td>
            <td>${student_message.weight }&nbsp;</td>
           
        </tr>
        
         <tr>
        	
            <td align="right">兴趣爱好：</td>
            <td colspan="3">${student_message.interest }&nbsp;
            	
            </td>

        </tr>
        
        <tr>
        	
            <td align="right">政治面貌：</td>
            <td colspan="3">${student_message.political.politicallandscape }&nbsp;
            	 <c:if test="${student_message.politicallandscapestate ==2}"><p style="color: red;">(没审批)</p></c:if>
				 <c:if test="${student_message.politicallandscapestate ==1}"><p style="color: red;">(审批通过)</p></c:if> 
            </td>
            
           
        </tr>
        
        <tr>
        	
            <td align="right">身份证号码：</td>
            <td colspan="3">${student_message.idcard }&nbsp;
            	
            </td>

        </tr>
        
        <tr>
            <td align="left" colspan="4" style="color: red;">学生在校信息：</td>
        </tr>
        
        <tr>
            <td align="right">在读学校：</td>
            <td colspan="3">${student_message.shcoolName }&nbsp;</td>
          </tr>
         <tr>
            <td align="right">在读专业：</td>
            <td>${student_message.classmessage.profession.professionName }&nbsp;</td>
            <td align="right">所属学院：</td>
            <td>${student_message.college.collegeName }&nbsp;</td>
        </tr>
        
         <tr>
         	<td align="right">所在年级：</td>
            <td>${student_message.studentGradeName }级&nbsp;</td>
            <td align="right">所在班级：</td>
            <td>${student_message.classmessage.classmessageName }&nbsp;</td>
          </tr>
          
          <tr>
        	
            <td align="right">班级职务：</td>
            <td colspan="3">${student_message.post.postName }&nbsp;</td>
            
           
        </tr>
        
        
        <tr>
            <td align="right">所在社团：</td>
            <td>${student_message.corporation}&nbsp;</td>
            <td align="right">所在社团职务：</td>
            <td>${student_message.corporationpost}&nbsp;</td>
        </tr>
        
       
          
        <tr>
            <td align="right">入学时间：</td>
            <td>${student_message.dateTime}&nbsp;</td>
            <td align="right">状态：</td>
            <td>${student_message.state}&nbsp;</td>
        </tr>
        
         <tr>
            <td align="right">所在宿舍：</td>
            <td colspan="3">${student_message.dormitory}&nbsp;</td>
        </tr>
        
        
        <tr>
            <td colspan="4" align="left" style="color: red;">联系方式:</td>
        </tr>
        <tr>
            <td align="right">手机号码：</td>
            <td>${student_message.phoneNumber }</td>
            <td align="right">家庭电话号码：</td>
            <td>${student_message.homePhone }</td>
        </tr>
        <tr>
        	<td align="right">QQ：</td>
            <td>${student_message.qqNumber }</td>
            <td align="right">微信：</td>
            <td>${student_message.weChat }</td>
          </tr>
        <tr>
        	<td align="right">邮箱：</td>
            <td>${student_message.email }</td>
            <td align="right">联系地址：</td>
            <td>${student_message.address }</td>
        </tr>    
        
         <tr>
            <td  align="left" style="color: red;">学生备注:</td>
            <td colspan="3">${student_message.remarks }</td>
        </tr>  
         
    </table>
    </span>
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

	
	<script language="javascript">
    var Message={
    set: function() {//最小化与恢复状态切换
    var set=this.minbtn.status == 1?[0,1,'block',this.char[0],'最小化']:[1,0,'none',this.char[1],'恢复'];
    this.minbtn.status=set[0];
    this.win.style.borderBottomWidth=set[1];
    this.content.style.display =set[2];
    this.minbtn.innerHTML =set[3]
    this.minbtn.title = set[4];
    this.win.style.top = this.getY().top;
    },
    close: function() {//关闭
    this.win.style.display = 'none';
    window.onscroll = null;
    },
    setOpacity: function(x) {//设置透明度
    var v = x >= 100 ? '': 'Alpha(opacity=' + x + ')';
    this.win.style.visibility = x<=0?'hidden':'visible';//IE有绝对或相对定位内容不随父透明度变化的bug
    this.win.style.filter = v;
    this.win.style.opacity = x / 100;
    },
    show: function() {//渐显
    clearInterval(this.timer2);
    var me = this,fx = this.fx(0, 100, 0.1),t = 0;
    this.timer2 = setInterval(function() {
    t = fx();
    me.setOpacity(t[0]);
    if (t[1] == 0) {clearInterval(me.timer2) }
    },10);
    },
    fx: function(a, b, c) {//缓冲计算
    var cMath = Math[(a - b) > 0 ? "floor": "ceil"],c = c || 0.1;
    return function() {return [a += cMath((b - a) * c), a - b]}
    },
    getY: function() {//计算移动坐标
    var d = document,b = document.body, e = document.documentElement;
    var s = Math.max(b.scrollTop, e.scrollTop);
    var h = /BackCompat/i.test(document.compatMode)?b.clientHeight:e.clientHeight;
    var h2 = this.win.offsetHeight;
    return {foot: s + h + h2 + 2+'px',top: s + h - h2 - 2+'px'}
    },
    moveTo: function(y) {//移动动画
    clearInterval(this.timer);
    var me = this,a = parseInt(this.win.style.top)||0;
    var fx = this.fx(a, parseInt(y));
    var t = 0 ;
    this.timer = setInterval(function() {
    t = fx();
    me.win.style.top = t[0]+'px';
    if (t[1] == 0) {
    clearInterval(me.timer);
    me.bind();
    }
    },10);
    },
    bind:function (){//绑定窗口滚动条与大小变化事件
    var me=this,st,rt;
    window.onscroll = function() {
    clearTimeout(st);
    clearTimeout(me.timer2);
    me.setOpacity(0);
    st = setTimeout(function() {
    me.win.style.top = me.getY().top;
    me.show();
    },600);
    };
    window.onresize = function (){
    clearTimeout(rt);
    rt = setTimeout(function() {me.win.style.top = me.getY().top},100);
    }
    },
    init: function() {//创建HTML
    function $(id) {return document.getElementById(id)};
    this.win=$('msg_win');
    var set={minbtn: 'msg_min',closebtn: 'msg_close',title: 'msg_title',content: 'msg_content'};
    for (var Id in set) {this[Id] = $(set[Id])};
    var me = this;
    this.minbtn.onclick = function() {me.set();this.blur()};
    this.closebtn.onclick = function() {me.close()};
    this.char=navigator.userAgent.toLowerCase().indexOf('firefox')+1?['_','::','×']:['0','2','r'];//FF不支持webdings字体
    this.minbtn.innerHTML=this.char[0];
    this.closebtn.innerHTML=this.char[2];
    setTimeout(function() {//初始化最先位置
    me.win.style.display = 'block';
    me.win.style.top = me.getY().foot;
    me.moveTo(me.getY().top);
    },0);
    return this;
    }
    };
    Message.init();
    </script>
	