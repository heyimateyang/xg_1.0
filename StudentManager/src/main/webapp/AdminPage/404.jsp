<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/404.css"/>
<link rel="stylesheet" href="../css/404.css"/>
<title>这个.. 页面没有找到！！！</title>
		
</head>
<body>
	<table border=0 cellpadding=0 cellspacing=0 width="100%" height="100%">
        <tr>
            <td align="center" style="padding-top:60px;"></td>
           	<td> <img src="../images/404_bg.png"/></td>
        </tr>
   	</table> 
    <br/>
    <br/>
    <br/>
    <form name="loading">
        <p><font color="gray">什么？你搞到服务器崩溃了！没事,正在帮你重新载入首页，请稍候.......</font></p>
        <p>
        <input type="text" name="chart" size="46" style="font-family:Arial;
        font-weight:bolder; color:gray;
        background-color:white; padding:0px; border-style:none;"/>
        <br/>
        <input type="text" name="percent" size="46" style="font-family:Arial;
        color:gray; text-align:center;
        border-width:medium; border-style:none;"/>
        <script>var bar = 0;
	        var line = "||";
	        var amount ="||";
	        count();
	        function count(){
	        	bar= bar+2;
	        	amount =amount + line;
	        	document.loading.chart.value=amount;
	        	document.loading.percent.value=bar+"%";
	        	if (bar<99){
	        		setTimeout("count()",35);
	        	}//这里修改载入时间
	        	else{window.location = "#";
	        	}//这里改成你的网站地址
	        }
        </script>
        </p>
	</form>
</body>
</html>