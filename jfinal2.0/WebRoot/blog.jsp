<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 在页面表单中采用modelName.attrName形式为作为表单域的name -->
<form action="/blog/save" method="post">
<input name="blog.title" type="text">
<input name="blog.content" type="text">
<input value="提交" type="submit">
</form>
</body>
</html>