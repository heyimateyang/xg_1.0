
/**
	admin_Message_index.jsp输入认证
**/

//修改验证
function update_admin(){
	if(document.getElementById("adminName").value == ""){
		alert("管理员名字不能为空");
		return false;
	}
	if(document.getElementById("userName").value == ""){
		alert("登录名字不能为空");
		return false;
	}
	if(document.getElementById("userPwd").value == ""){
		alert("新密码不能为空");
		return false;
	}
	
	return true;
}

// 显示函数 
function show_message() {
	document.getElementById("update_show").style.visibility="visible"; 
	document.getElementById("button2").style.display ='none';
}

function none_message() {
	document.getElementById("update_show").style.visibility ='hidden';
	document.getElementById("button2").style.display ='inline';
}

//文本框默认值
function clearText(field){
	if (field.defaultValue == field.value) field.value = '';
	 else if (field.value =='') field.value = field.defaultValue;
}


