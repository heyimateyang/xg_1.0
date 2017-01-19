
/**
	login.jsp输入认证
**/

function verificationInput() {
	
	if(document.getElementById("userName").value == ""){
		alert("登录名字不能为空");
		return false;
	}
	
	if(document.getElementById("userPwd").value == ""){
		alert("登录密码不能为空");
		return false;
	}
	
	if(document.getElementById("imgShow_WU_FILE_0").src== null){
		alert("图片不能为空");
		return false;
	}
	
	if(document.getElementById("validateCode")== ""){
		alert("验证码不能为空");
		return false;
	}
	
	/*if(!/\b[0-9]+\b/.test(document.getElementById("userName").value)) {
		alert("登录名字只能为数字");
		return false;
	}*/
	
	return true;
}



