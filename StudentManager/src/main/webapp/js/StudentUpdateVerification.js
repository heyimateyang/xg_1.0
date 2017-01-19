
/**
	学生修改信息输入认证
**/

//修改验证
function update_student(){
	/*if(document.getElementById("userPwd").value == ""){
		alert("新密码不能为空");
		return false;
	}*/
	if(document.getElementById("address").value == ""){
		alert("联系地址不能为空");
		return false;
	}
	if(document.getElementById("phoneNumber").value == ""){
		alert("手机号码不能为空");
		return false;
	}
	if(document.getElementById("email").value == ""){
		alert("电子邮件不能为空");
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
	if(!/\b[0-9]+\b/.test(document.getElementById("qqNumber").value)){
		alert("QQ号码只能为数字");
		return false;
	}
	
	return true;
}

//文本框默认值
function clearText(field){
	if (field.defaultValue == field.value) field.value = '';
	 else if (field.value =='') field.value = field.defaultValue;
}
