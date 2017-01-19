<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF">

<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="../css/login.css">
<SCRIPT language=javascript src="js/LoginVerification.js"></script>
<SCRIPT language=javascript src="../js/LoginVerification.js"></script>
<title>信工学生管理系统</title>
<script type="text/javascript">
    //刷新验证码
    function changeImg(){
        document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/servlet/DrawImage.servlet?"+Math.random();
    }
</script>
</head>
<body>



<form action="login" onsubmit="return verificationInput()" method="post" theme="simple">

<div class="login_main">

<p>
<span>学号登录</span> <input type="text" value="" class="input_01" onFocus="clearText(this)" placeholder="学号登录" name="userName" id="userName"/>
</p>
<p>
<span>密码</span> <input type="password" value="" class="input_01" onFocus="clearText(this)" placeholder="请输入登录密码" name="userPwd" id="userPwd"/>
</p>
<p>
<span>验证码</span><input type="text" name="validateCode" id="validateCode" class="input_01"/>
</p>
<div align="center">
  <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage.servlet" id="validateCodeImg" onclick="changeImg()">
  <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>          
</div>
<P></P>
<p><span></span><input type="submit" value="" class="input_02"/></p>
</div>
</form>
<div class="login_user"></div>
<div class="login_tit"><img src="images/login_tit.png"/></div>
</body>
</html>