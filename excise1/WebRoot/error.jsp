<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<meta charset="utf-8">
    
    <title>出错啦</title>
    <link href="css/error.css" rel="stylesheet" />
	<script language="JavaScript" src="js/error.js"></script>
  </head>
  
  <body>
    <div id="errorDiv">
    	<div id="errorHint">
    		<p id="errorInfo">${info}</p>
    		<p><span id="leaveTime">20</span>秒后自动返回到登录页面</p>
    		<p>不能跳转，请<a href="login.html">点击这里</a></p>
    	</div>
    </div>
  </body>
</html>
