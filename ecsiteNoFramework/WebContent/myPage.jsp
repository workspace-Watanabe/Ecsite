<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/stylesheet.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script  src="js/test.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>

		<div>
			<c:if test="${requestScope.message != null}">
				<c:out value="${requestScope.message}">
				</c:out>
			</c:if>
			<c:if test="${empty buyItemList} == null">
				<h3>ご購入情報はありません</h3>
			</c:if>

			<c:if test="${not empty buyItemList}">
				<h3>ご購入情報は以下になります</h3>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>
					<c:forEach items="${buyItemList}" var="item">
						<tr>
							<td><c:out value="${item.itemName}"/></td>
							<td><c:out value="${item.totalPrice}"/></td>
							<td><c:out value="${item.totalCount}"/></td>
							<td><c:out value="${item.payment}"/></td>
							<td><c:out value="${item.insert_date}"/></td>
						</tr>
					</c:forEach>
				</table>

				<form action = "MyPage" method="POST">
					<input type="hidden" name="delete" value="1">
					<input type="submit" value="削除">
				</form>
			</c:if>

			<div id="text-right">
				<p>Homeへ戻る場合は<a href="home.jsp">こちら</a></p>
				<p>ログアウトする場合は<a href="" id="logout">こちら</a></p>
			</div>
		</div>

		<form action = "Logout" id="form4" method="POST">
		</form>
	</div>
</body>
</html>