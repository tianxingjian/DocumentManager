<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		用户名: <input type="text" name="user_id" id="user_id"><br /> 密
		码: <input type="password" name="pwd" id="pwd"><br /> <input
			type="submit" value="登陆" />
	</form>
	<div>
		<s:property value="msg" />
	</div>
</body>
</html>