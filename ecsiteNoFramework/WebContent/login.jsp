<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>LOGIN</p>
		</div>

		<div>
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<form action="Login" method="POST">
				<table>
					<tr>
						<td><label>ログインID:</label><input type="text" name="loginId"></td>
					</tr>
					<tr>

						<td><label>ログインパス:</label><input type="password"
							name="loginPass"></td>
					</tr>

				</table>
				<input type = "submit" value = "ログイン">
			</form>
			<br>

			<div>
				<span>新規ユーザー登録は <a href="userCreate.jsp">こちら</a>
				</span>
			</div>
		</div>
	</div>

	<div id="footer"></div>

</body>
</html>