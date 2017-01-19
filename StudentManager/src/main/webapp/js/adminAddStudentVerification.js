
/**
	管理员添加学生信息.jsp输入认证
**/

//修改验证
function addStudentAdmin(){
	if(document.getElementById("userName").value == ""){
		alert("登录帐号不能为空");
		return false;
	}
	
	
	/*if(document.getElementById("userPwd").value =="") {
		alert("登录密码不能为空");
		return false;
	}*/
	
	if(document.getElementById("studentNumber").value!=document.getElementById("userName").value) {
		alert("学籍号和登录帐号需要一致");
		return false;
	}
	if(document.getElementById("studentNumber").value == ""){
		alert("学籍号不能为空");
		return false;
	}
	if(document.getElementById("dateTime").value == ""){
		alert("入读时间不能为空");
		return false;
	}
	
	if(document.getElementById("phoneNumber").value == ""){
		alert("手机号码不能为空");
		return false;
	}
	/*if(document.getElementById("homePhone").value == ""){
		alert("家庭电话不能为空");
		return false;
	}*/
	if(document.getElementById("qqNumber").value == ""){
		alert("QQ号码不能为空");
		return false;
	}
	if(document.getElementById("email").value == ""){
		alert("电子邮箱不能为空");
		return false;
	}
	if(document.getElementById("address").value == ""){
		alert("联系地址不能为空");
		return false;
	}
	if(!/\b[0-9]+\b/.test(document.getElementById("studentNumber").value)) {
		alert("学籍号只能为数字");
		return false;
	}
	if(!/\b[0-9]+\b/.test(document.getElementById("userName").value)) {
		alert("登录帐号只能为数字");
		return false;
	}
	if(/\b[0-9]+\b/.test(document.getElementById("address").value)) {
		alert("联系地址不能为数字");
		return false;
	}
	if(!/\b[0-9]+\b/.test(document.getElementById("qqNumber").value)) {
		alert("QQ号码只能为数字");
		return false;
	}
	if(!/\b[0-9]+\b/.test(document.getElementById("phoneNumber").value)) {
		alert("手机号码只能为数字");
		return false;
	}
	/*if(!/\b[0-9]+\b/.test(document.getElementById("homePhone").value)) {
		alert("家庭电话号码只能为数字");
		return false;
	}*/
	if(document.getElementById("studentName").value==""){
		alert("学生姓名不能为空");
		return false;
	}
	return true;
}
/**
* @param reqType
* @param url
* @param async
* @param resFun
* @param parameter
* @returns {___anonymous_request}
* @author heyimtaeyang
*/

function httpRequest(reqType,url,async,resFun,parameter){	
		var request = null;
		var rs = null;
		if( window.XMLHttpRequest ){		//非IE浏览器，创建XMLHttpRequest对象
			request = new XMLHttpRequest();
		}else if( window.ActiveXObject ){	//IE浏览器，创建XMLHttpRequest对象
			var arrSignatures = ["Msxml2.XMLHTTP", "Microsoft.XMLHTTP", "Microsoft.XMLHTTP", "MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP"];		
			for( var i = 0; i < arrSignatures.length; i++ ){
				request = new ActiveXObject( arrSignatures[i] );
				if( request || typeof( request ) == "object" )
					break;
			}
		}
		if( request || typeof( request ) == "object" ){
			if(reqType.toLowerCase()=="post"){		//以POST方式提交
				request.open(reqType, url, true);	//打开服务器连接
				//设置MIME类型
				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				request.onreadystatechange = resFun;//设置处理响应的回调函数
				parameter = encodeURI(parameter);	//将参数字符串进行编码
				request.send(parameter);			//发送请求
			}
			else{									//以GET方式提交
				url = url+"?"+parameter;			//重新设置URL，GET方式需要在URL中附带请求参数
				request.open(reqType, url, true);	//打开服务器连接
				request.onreadystatechange = resFun;//响应回调函数
				request.send(null);					//发送请求
			}
		}
		else{
			alert( "该浏览器不支持Ajax！" );
		}	
		return request;
	}
	function checkName(){
		var name=document.getElementById("userName").value;
			//请求参数
		    request=httpRequest("post","servlet/CheckUsers.servlet?userName="+name,true,callbackFunc);//调用Ajax提交请求方法  
		    if(document.getElementById("userName").value == ""){
				alert("学院名称不能为空");
				return false;
			}
		    
		    if(document.getElementById("imgShow_WU_FILE_0").src== ""){
				alert("图片不能为空");
				return false;
			}
		    if(document.getElementById("userPwd").value =="") {
				alert("登录密码不能为空");
				return false;
			}
			
			if(document.getElementById("studentNumber").value!=document.getElementById("userName").value) {
				alert("学籍号和登录帐号需要一致");
				return false;
			}
			if(document.getElementById("studentNumber").value == ""){
				alert("学籍号不能为空");
				return false;
			}
			if(document.getElementById("dateTime").value == ""){
				alert("入读时间不能为空");
				return false;
			}
			
			if(document.getElementById("phoneNumber").value == ""){
				alert("手机号码不能为空");
				return false;
			}
			/*if(document.getElementById("homePhone").value == ""){
				alert("家庭电话不能为空");
				return false;
			}*/
			if(document.getElementById("qqNumber").value == ""){
				alert("QQ号码不能为空");
				return false;
			}
			if(document.getElementById("email").value == ""){
				alert("电子邮箱不能为空");
				return false;
			}
			if(document.getElementById("address").value == ""){
				alert("联系地址不能为空");
				return false;
			}
			if(!/\b[0-9]+\b/.test(document.getElementById("studentNumber").value)) {
				alert("学籍号只能为数字");
				return false;
			}
			if(!/\b[0-9]+\b/.test(document.getElementById("userName").value)) {
				alert("登录帐号只能为数字");
				return false;
			}
			if(/\b[0-9]+\b/.test(document.getElementById("address").value)) {
				alert("联系地址不能为数字");
				return false;
			}
			if(!/\b[0-9]+\b/.test(document.getElementById("qqNumber").value)) {
				alert("QQ号码只能为数字");
				return false;
			}
			if(!/\b[0-9]+\b/.test(document.getElementById("phoneNumber").value)) {
				alert("手机号码只能为数字");
				return false;
			}
			/*if(!/\b[0-9]+\b/.test(document.getElementById("homePhone").value)) {
				alert("家庭电话号码只能为数字");
				return false;
			}*/
			if(document.getElementById("studentName").value==""){
				alert("学生姓名不能为空");
				return false;
			}
		    if(rs == true){
		    	return true;
		    }else if (rs == false) {
		    	return false;
			}
		  
	}
	//响应的回调函数admin添加学院页面
	function callbackFunc(){
		if( request.readyState==4 ){ 
    	 	if( request.status == 200 ){   	
    	 		
    	 		//获得从服务器端返回的XML信息，noIterance为XML中的元素 
    	 		var noIterance=request.responseXML.getElementsByTagName("noIterance");
        		//获得从服务器端返回的XML信息，iterance为XML中的元素 
        		var iterance=request.responseXML.getElementsByTagName("iterance");
        		if(typeof(noIterance)!="undefined"&& noIterance.length>0){   
	         		alert("该登录帐号可以录入！");
	         		request=false;
	         		rs = true;
	         		return true;
        		}
        		if(typeof(iterance)!="undefined"&& iterance.length>0){
	         		alert("该登录帐号已存在，请重新输入！");
	         		document.getElementById("userName").focus();
	         		request=false;
	         		rs = false;
	         		return false;
        		}
        		
			}
		}
	}
