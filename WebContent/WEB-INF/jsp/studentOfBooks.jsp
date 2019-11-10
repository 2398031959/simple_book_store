<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生借阅图书主界面</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script type="text/javascript">
	
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
							<a href="${pageContext.request.contextPath}/pwdUpdate">密码修改</a>
						</h4></li>
					<li><h4>
							<a href="${pageContext.request.contextPath}/logout">退出登录</a>
						</h4></li>
				</ul>
			</div>
			<div class="col-md-11 col-md-offset-1">
				<form method="post" class="form-inline"
					action="${pageContext.request.contextPath}/listBook1?key=search">
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
			<div class="row">
				<div class="col-md-6 col-md-offset-1" style="margin-top: 20px;">
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
								<td><c:if test="${dicts ne null}">
										<c:forEach items="${dicts}" var="dict">
											<c:if test="${dict.bookid eq book.bid}">
												<a
													href="${pageContext.request.contextPath}/returnBook?dId=${dict.dId}"><Button
														class="btn btn-info">归还</Button></a>
												<c:set var="exitId" value="0"></c:set>
											</c:if>
										</c:forEach>
										<c:if test="${exitId ne 0}">
											<a
												href="${pageContext.request.contextPath}/borrowBook?bookid=${book.bid}&userid=${loginUser.uid}"><Button
													class="btn btn-info">借阅</Button></a>
										</c:if>
										<c:set var="exitId" value="1"></c:set>
									</c:if> <c:if test="${dicts eq null}">
										<a
											href="${pageContext.request.contextPath}/borrowBook?bookid=${book.bid}&userid=${loginUser.uid}"><Button
												class="btn btn-info">借阅</Button></a>
									</c:if></td>
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
									<a href="listBook1?PageNum=1&key=skip">首页 </a>
									<c:choose>
										<c:when test="${pageBook.hasPreviousPage }">
											<a href="listBook1?PageNum=${pageBook.pageNum-1}&key=skip">上一页
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
												<a href="listBook1?PageNum=${item}&key=skip">${item}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${!pageBook.isLastPage }">
											<a href="listBook1?PageNum=${pageBook.pageNum+1}&key=skip">下一页
											</a>
											<a href="listBook1?PageNum=${pageBook.lastPage}&key=skip">尾页</a>
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
	</div>
</body>
</html>