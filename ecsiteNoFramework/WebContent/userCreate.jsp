<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-3.4.1.min.js"></script>
<script  src="js/test.js"></script>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserCreate画面</title>
</head>
<body>
	<div id="header"></div>

	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>

		<div>

			<form action="SignUp" method="POST">
				<table>

					<tr>
						<td><label>ログインID:</label></td>
						<td><input type="text" name="loginId" value=""></td>
					</tr>

					<tr>
						<td><label>ログインPASS:</label></td>
						<td><input type="password" name="loginPass" value=""></td>
					</tr>

					<tr>
						<td><label>ユーザー名:</label></td>
						<td><input type="text" name="userName" value=""></td>
					</tr>


				</table>
				<input type="submit" value="登録">
			</form>

			<div>
				<span>前画面に戻る場合は</span>
				<a href="" id="home">こちら</a>
			</div>

			<form action = "Home" id="form5" method="POST"></form>

		</div>
	</div>
</body>
</html>