<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍修改页面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	function checkUpdate() {
		var bname = $("#bname").val();
		var btype = $("#btype").val();
		var bamount = $("#bamount").val();
		if (bname == "") {
			alert("书名不能为空");
			return false;
		}
		if (btype == "0") {
			alert("请选择类型");
			return false;
		}
		if(isNaN(parseInt(bamount))){
			alert("数量必须为整数");
			return false;
		}
		alert("修改成功");
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
					action="${pageContext.request.contextPath}/updateBook"
					onsubmit="return checkUpdate()">
					<div class="form-group">
						<label>书名：</label>
						<input type="hidden" name="bid" value="${oldBook.bid}"/>
						<input type="text" class="form-control"
							name="bname" id="bname" value="${oldBook.bname}">
					</div>
					<div class="form-group">
						<label>类型：</label><select class="form-control" name="btype"
							id="btype">
							<option value="0">请选择</option>
							<c:forEach items="${book_types}" var="book_type">
								<c:if test="${oldBook.btype eq book_type.tid}">
									<option value="${book_type.tid}" selected="selected">${book_type.tname}</option>
								</c:if>
								<c:if test="${oldBook.btype ne book_type.tid}">
									<option value="${book_type.tid}">${book_type.tname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>数量：</label><input type="text" class="form-control"
							name="bamount" id="bamount" value="${oldBook.bamount}">
					</div>
					<div class="form-group">
						<input type="submit" class="form-control" value="修改">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>