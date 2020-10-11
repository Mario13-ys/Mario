<%@ page language="java" pageEncoding= "utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>资源下载</title>
		<link rel="stylesheet" type="text/css" href="css/download.css">
	</head>
	<body>
		<h1>资源下载</h1>
		<div class="container">
			<c:forEach items= "${downloadList}" var="download">
				<ul>
					<li>
						<p class="name">${download.name}</p>
						<div class="pic-txt">
							<img class="img-area" src="${download.image}"/>
							<p class="txt-area">
								<span class="">${download.description}</span>
								<span class="tit-sub">
									<i class="space" >时间: ${download.time}</i>
									<i class="space">大小: ${download.sizeStr}</i>
									<i>星级:</i>
									<i class="stars">
										<span style="width:${download.star/5*100}%"></span>
									</i>
								</span>
							</p>
						</div>
						<a class="dl-btn"href= "download.do?id=${download.id}"title="点击下载">下载</a>
					</li>
				</ul>
			</c:forEach>
			<p class="back"><a href="main.jsp">返回首页</a></p>
		</div>
	</body>
</html>>
