<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body style="background-color: plum">
<h3>Error</h3>
<hr/>
<%=(request.getAttribute("errorMessage") !=null)
? (String) request.getAttribute("errorMessage")
: "unknown error"%>
<hr/>
<a href="controller">Return</a>
</body>
</html>