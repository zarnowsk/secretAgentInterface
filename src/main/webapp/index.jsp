<%-- 
    Document   : index
    Created on : 27-Nov-2019, 7:47:46 PM
    Author     : Michal Zarnowski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spy App</title>
    </head>
    <body>
        <h1>Our Super Cool Spy App</h1>
        
        <h2>Create a Mission</h2>

        <form action="createMission.jsp" method="GET">
            <input type="submit" value="Create a Mission">
        </form>

        <br>
        
        <h2>View Missions For</h2>

        <form action="viewMissions.jsp" method="GET">
            Select an agent: <select>

                <c:forEach var="agent" items="${agents}">
                <option value="${agent}">${agent}</option>                    
                </c:forEach>

            </select> <input type="submit" value="Go">
        </form>
        
    </body>
</html>
