 <%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    	<meta charset = "utf-8">
    	<title>系统主页</title>
    	<link href="css/main.css" rel = "stylesheet" type="text/css"/>
  </head>
  
  <body>
    	<div id="container">
			<div id="header">
				<div id="rightTop">
					当前用户,<span>${currentUser.chrName}</span>&nbsp;[<a href="logout.do">安全退出</a>]
				</div>

				<div id="menu">
					<ul>
						<li><a href="#">首页</a></li>
						<li class="menuDiv"></li>
						<li><a href="getDownloadList.do">下载</a></li>
						<li class="menuDiv"></li>
						<li><a href="#">增加</a></li>
						<li class="menuDiv"></li>
						<li><a href="#">查询</a></li>
						<li class="menuDiv"></li>
						<li><a href="#">论坛</a></li>
						<li class="menuDiv"></li>
						<li><a href="#">关于</a></li>
					</ul>
				</div>
				<div id="banner"></div>
			</div>
		</div>
  </body>
</html>

