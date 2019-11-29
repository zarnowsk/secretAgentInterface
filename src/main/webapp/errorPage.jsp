<%-- 
    Document   : errorPage
    Created on : 28-Nov-2019, 8:26:28 PM
    Author     : Michal Zarnowski
    Description: Error page displayed when the mission title or agent name 
                 aren't received by the servlet.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/errorPage.css' />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Oops something went wrong!</h1>
        <h2>Please try again with a mission title and agent name</h2>
        <br><br>
        <a href="index.jsp">Try again</a>
    </body>
</html>
