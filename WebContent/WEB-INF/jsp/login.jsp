<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	function checkLogin(){
		var uname=$("#uname").val();
		var upwd=$("#upwd").val();
		var uidentity=$("#uidentity").val();
		if(uname==""||upwd==""){
			alert("用户名和密码都不能为空");
			return false;
		}
		if(uidentity==0){
			alert("请选择身份");
			return false;
		}
		return true;
	}
</script>
<body>
	<div style="width: 300px;margin:50px auto;color:red;">${msg}</div>
	<div style="width: 300px;margin:0px auto;">
		<form method="post" action="${pageContext.request.contextPath}/toMain.action" onsubmit="return checkLogin()">
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
					<c:forEach items="${uis}" var="ui">
						<option value="${ui.iid}">${ui.iname}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<input type="submit" class="form-control" value="登录">
			</div>
		</form>
	</div>
</body>
</html>