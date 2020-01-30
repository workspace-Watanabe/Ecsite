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

	<div id = "main">
		<div id = "top">
			<p>BuyItemComplete</p>
		</div>

		<div>
			<p>購入手続きが完了致しました。</p>

		</div>
		<div>
			<a href="" id="myPage">マイページ</a><span>から購入履歴の確認が可能です。</span>
			<p>Homeへ戻る場合は<a href="home.jsp">こちら</a></p>
		</div>
	</div>

	<div id ="footer">
	</div>
	<form action="MyPage" method="POST" id="form3"></form>
</body>
</html>