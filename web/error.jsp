<%-- 
    Document   : error
    Created on : Aug 19, 2019, 8:14:25 AM
    Author     : Unlucky Spider
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error Page</h1> <br>
        <font color="red">
        <h2> ${requestScope.ERROR} </h2>
        </font>
    </body>
</html>
