<%-- 
    Document   : get_all_teams
    Created on : 3/06/2020, 06:03:16 PM
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${datos}" var="dato">
            <label>${dato[0]}</label><label>${dato[1]}</label>
        </c:forEach>
        <c:forEach items="${datos2}" var="dato2">
            <label>${dato2.id}</label><label>${dato2.name}</label>
        </c:forEach>
    </body>
</html>
