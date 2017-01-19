
/**
	管理员添加学生输入认证
**/

function verificationInput() {
	
	if(document.getElementById("userName").value == ""){
		alert("登录帐号不能为空");
		return false;
	}
	if(document.getElementById("userName").value!=document.getElementById("studentNumber").value){
		alert("登录帐号和学籍号必须一致");
		return false;
	}
	if(document.getElementById("studentNumber").value == ""){
		alert("学号不能为空");
		return false;
	}
	if(document.getElementById("studentName").value == ""){
		alert("学生姓名不能为空");
		return false;
	}
	if(document.getElementById("phoneNumber").value == ""){
		alert("手机号码不能为空");
		return false;
	}
	if(document.getElementById("homePhone").value == ""){
		alert("家庭电话不能为空");
		return false;
	}
	if(document.getElementById("qqNumber").value == ""){
		alert("QQ号码不能为空");
		return false;
	}
	if(document.getElementById("email").value == ""){
		alert("电子邮箱不能为空");
		return false;
	}
	if(document.getElementById("address").value== ""){
		alert("登陆地址不能为空");
		return false;
	}
	return true;
}



