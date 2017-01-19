
/**
	admin_Message_addAchievement.jsp输入认证
**/

//修改验证
function addAchievement(){
	if(document.getElementById("achievementName").value == ""){
		alert("科目不能为空");
		return false;
	}
	
	if(document.getElementById("achievementScore").value =="") {
		alert("分数不能为空");
		return false;
	}
	
	if(document.getElementById("achievementScore").value >151) {
		alert("分数超过150分");
		return false;
	}
	
	if(!/\b[0-9]+\b/.test(document.getElementById("achievementScore").value)) {
		alert("分数只能为数字");
		return false;
	}
	
	if(/\b[0-9]+\b/.test(document.getElementById("achievementName").value)) {
		alert("科目名称不能为数字");
		return false;
	}
	
	return true;
}

