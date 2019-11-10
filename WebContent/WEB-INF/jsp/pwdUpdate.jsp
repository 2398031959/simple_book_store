<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生密码修改页面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	function checkUpdate(){
		var upwd=$("#upwd").val();
		if(upwd==""){
			alert("密码不能为空");
			return false;
		}
		alert("修改成功！");
		return true;
	}
</script>
<body>
	<div class="container">
		<div class="row" style="margin-top: 10px">
			<div class="col-md-11 col-md-offset-1">
				<h1>欢迎进入学生主界面</h1>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-11 col-md-offset-1">
				<ul class="list-inline">
					<li><h4>
							<a href="${pageContext.request.contextPath}/listBook1?key=all">图书借阅</a>
						</h4></li>
					<li><h4>
							<a
								href="${pageContext.request.contextPath}/pwdUpdate">密码修改</a>
						</h4></li>
					<li><h4>
							<a href="${pageContext.request.contextPath}/logout">退出登录</a>
						</h4></li>
				</ul>
			</div>
		</div>
		<div class="row" style="margin-top: 10px">
			<div class="col-md-11 col-md-offset-1">
				<form method="post"
					action="${pageContext.request.contextPath}/updatePwd"
					onsubmit="return checkUpdate()">
					<div class="form-group">
						<label>新密码：</label>
						<input type="hidden" name="uid" value="${loginUser.uid}"/>
						<input type="text" class="form-control"
							name="upwd" id="upwd">
					</div>
					<input type="submit" value="修改"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>