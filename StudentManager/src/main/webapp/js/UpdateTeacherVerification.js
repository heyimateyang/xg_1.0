
/**
	管理员修改班级辅导员输入认证
**/

function verificationInput() {
	
	/*if(document.getElementById("userPwd").value == ""){
		alert("新密码不能为空");
		return false;
	}*/
	if(document.getElementById("workNumber").value!=document.getElementById("userName").value){
		alert("登录帐号和工号必须一致");
		return false;
	}
	return true;
}

//文本框默认值
function clearText(field){
	if (field.defaultValue == field.value) field.value = '';
	 else if (field.value =='') field.value = field.defaultValue;
}


