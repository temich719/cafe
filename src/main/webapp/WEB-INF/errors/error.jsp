<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>
            Error!
        </h1>
        <br><br>
        <span style="font-size:30px;color:red;">
            ${requestScope.error}
        </span>
    </body>
</html>