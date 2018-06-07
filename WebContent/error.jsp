<%--
  Created by IntelliJ IDEA.
  User: Syntaxer
  Date: 06/06/2018
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" isErrorPage="true" %>
<!DOCTYPE <!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Error</title>

    <link rel="stylesheet" href="/webjars/bootstrap-material-design/4.1.1/css/bootstrap-material-design.min.css">
    <script src="/webjars/bootstrap-material-design/4.1.1/js/bootstrap-material-design.min.js"></script>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>Error</h1>
        <h2><%=exception.getMessage()%></h2>
    </div>
</body>
</html>
<html>
