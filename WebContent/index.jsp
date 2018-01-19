<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.handrinp.studexp.util.JSONUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StudEXP</title>
<link rel="stylesheet" type="text/css" href="css/styles.css" />
</head>
<body>
	<h1>Welcome to StudEXP!</h1>
	<form action="saveJSON" method="POST">
		<textarea rows="25" cols="80" id="json" name="json"><%=JSONUtils.load().toString(2)%></textarea><br />
		<textarea rows="25" cols="80" id="json" name="json2"><%=JSONUtils.loadExampleUser().toString(2)%></textarea><br />
		<input type="submit" value="Save" />
	</form>
</body>
</html>
