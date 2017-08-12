<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="doLogin" method="post">
		<div>
			<div><span style="color: red;">${errorMessage}</span></div>
			<div>
				User Name: <input type="text" id="user_name" name="user_name" value="${user.username}"/>
			</div>
			<br />
			<div>
				Password: <input type="password" id="password" name="password" value="${user.password}" />
			</div>
			<br />
			<div>
				<input type="submit" value="submit" />
			</div>
		</div>

	</form>
	
</body>
</html>