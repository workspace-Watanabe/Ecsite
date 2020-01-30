<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div id = "header">
	</div>

	<div id ="main">
		<div id ="top">
			<p>BuyItemConfirm</p>
		</div>

		<form>
		<table>
			<tr>
				<td>商品名</td>
				<td>${buyItem_name}</td>
			</tr>

			<tr>
				<td>値段</td>
				<td>${total_price}</td>
			</tr>

			<tr>
				<td>購入個数</td>
				<td>${count}</td>
			</tr>

			<tr>
				<td>支払い方法</td>
				<td>${pay}</td>
			</tr>

			<tr>
				<td><br></td>
			</tr>

			<tr>
				<td><input type="button" value="戻る" id="buyItemButton"></td>
				<td><input type="button" value="完了" id="buyItemCompleteButton"></td>
			</tr>
		</table>
		</form>

		<div>
			<p>前画面に戻る場合は<a href="home.jsp">こちら</a></p>
			<p>マイページは<a href="myPage.jsp">こちら</a></p>
		</div>
	</div>
	<div id = "footer">
	</div>
	<form action="buyItem.jsp" id="form1" method="GET"></form>
	<form action="BuyItemComfirm" id="form2" method="POST"></form>
</body>
</html>