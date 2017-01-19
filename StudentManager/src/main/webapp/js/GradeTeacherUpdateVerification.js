
/**
	admin_Message_index.jsp输入认证
**/

//修改验证
function login_pwd(){
	if(document.getElementById("userPwd").value == ""){
		alert("新密码不能为空");
		return false;
	}
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


