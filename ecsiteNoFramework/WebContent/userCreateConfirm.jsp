<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>登録する内容は以下でよろしいですか。</h3>

	<form action="SignupComplete" method="POST">
	<table>

	<tr id="box">
		<td><label>ログインID:</label></td>
		<td>${sessionScope.loginId}</td>
	</tr>

	<tr>
		<td><label>パスワード:</label></td>
		<td>${sessionScope.loginPass}</td>
	</tr>

	<tr>
		<td><label>ユーザー名:</label></td>
		<td>${sessionScope.userName}</td>
	</tr>

	</table>
	<input type="submit" value="完了">
	</form>
</body>
</html>