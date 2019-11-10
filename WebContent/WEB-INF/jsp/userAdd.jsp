<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加页面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	function checkAdd(){
		var uname=$("#uname").val();
		var upwd=$("#upwd").val();
		var uidentity=$("#uidentity").val();
		if(uname==""||upwd==""){
			alert("用户名和密码都不能为空");
			return false;
		}if(uidentity=="0"){
			alert("请选择身份");
			return false;
		}
		alert("添加成功");
		return true;
	}
</script>
<body>
	<div class="container">
		<div class="row" style="margin-top: 10px">
			<div class="col-md-11 col-md-offset-1">
				<h1>欢迎进入管理员主界面</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-11 col-md-offset-1">
				<ul class="list-inline">
					<li><h4>
							<a href="${pageContext.request.contextPath}/listBook?key=all">图书管理</a>
						</h4></li>
					<li><h4>
							<a href="${pageContext.request.contextPath}/listStudent?key=all">学生管理</a>
						</h4></li>
					<li><h4>
							<a href="${pageContext.request.contextPath}/logout">退出登录</a>
						</h4></li>
				</ul>
			</div>
		</div>
		<div class="row" style="margin-top: 10px">
			<div class="col-md-4 col-md-offset-1">
				<form method="post"
					action="${pageContext.request.contextPath}/addUser"
					onsubmit="return checkAdd()">
					<div class="form-group">
						<label>用户名：</label><input type="text" class="form-control"
							name="uname" id="uname">
					</div>
					<div class="form-group">
						<label>密码：</label><input type="password" class="form-control"
							name="upwd" id="upwd">
					</div>
					<div class="form-group">
						<label>身份：</label><select class="form-control" name="uidentity"
							id="uidentity">
							<option value="0">请选择</option>
							<c:forEach items="${identitys}" var="identity">
								<option value="${identity.iid}">${identity.iname}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<input type="submit" class="form-control" value="添加">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>