<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理图书界面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	function tip(){
		var flag=confirm("确定删除吗?");
		return flag;
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
							<a href="${pageContext.request.contextPath}/listUser?key=all">学生管理</a>
						</h4></li>
					<li><h4>
							<a href="${pageContext.request.contextPath}/logout">退出登录</a>
						</h4></li>
				</ul>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-11 col-md-offset-1">
				<form method="post" class="form-inline"
					action="${pageContext.request.contextPath}/listBook?key=search">
					<div class="form-group">
						<label>书名：</label><input type="text" class="form-control"
							name="bname" id="bname" value="${searchBook.bname}">
					</div>
					<div class="form-group" style="margin-left: 50px;">
						<label>类型：</label><select class="form-control" name="btype"
							id="btype">
							<option value="0">请选择</option>
							<c:forEach items="${book_types}" var="book_type">
								<c:if test="${searchBook.btype eq book_type.tid}">
									<option value="${book_type.tid}" selected="selected">${book_type.tname}</option>
								</c:if>
								<c:if test="${searchBook.btype ne book_type.tid}">
									<option value="${book_type.tid}">${book_type.tname}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<input type="submit" class="form-control" value="查询"
						style="margin-left: 50px;">
				</form>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-11 col-md-offset-1">
				<a href="${pageContext.request.contextPath}/bookAdd"><Button class="btn btn-primary">新增</Button></a>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-6 col-md-offset-1">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<td>编号</td>
						<td>书名</td>
						<td>类型</td>
						<td>总数</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${pageBook.list}" var="book">
						<tr>
							<td>${book.bid}</td>
							<td>${book.bname}</td>
							<td>${book.book_type.tname}</td>
							<td>${book.bamount}</td>
							<td><a href="${pageContext.request.contextPath}/bookUpdate?bid=${book.bid}"><Button class="btn btn-info">修改</Button></a>
								<a href="${pageContext.request.contextPath}/deleteBook?bid=${book.bid}" onclick="return tip()"><Button class="btn btn-info">刪除</Button></a></td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row" style="margin-top: 10px;">
			<div class="col-md-6 col-md-offset-1 text-right">
				<c:choose>
					<c:when test="${pageBook.size > 0 }">
						<div>
							<div>
								<span>显示${pageBook.startRow }到${pageBook.endRow}共${pageBook.total}条</span>
								<a href="listBook?PageNum=1&key=skip">首页 </a>
								<c:choose>
									<c:when test="${pageBook.hasPreviousPage }">
										<a href="listBook?PageNum=${pageBook.pageNum-1}&key=skip">上一页
										</a>
									</c:when>
									<c:otherwise>
										<span>上一页</span>
									</c:otherwise>
								</c:choose>
								<c:forEach var="item" items="${pageBook.navigatepageNums}">
									<c:choose>
										<c:when test="${pageBook.pageNum == item }">
											<span class="current">${pageBook.pageNum}</span>
										</c:when>
										<c:otherwise>
											<a href="listBook?PageNum=${item}&key=skip">${item}</a>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${!pageBook.isLastPage }">
										<a href="listBook?PageNum=${pageBook.pageNum+1}&key=skip">下一页
										</a>
										<a href="listBook?PageNum=${pageBook.lastPage}&key=skip">尾页</a>
									</c:when>
									<c:otherwise>
										<span>下一页</span>
										<span>尾页</span>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>