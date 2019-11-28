<%-- 
    Document   : index
    Created on : 27-Nov-2019, 7:47:46 PM
    Author     : Michal Zarnowski
    Description: Home page to the Spy App. This page allows the user to 
                 create a new mission or view current missions for the 
                 chosen agent.
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

        <!-- Allow the user to create a new mission -->
        <form action="createMission.jsp" method="GET">
            <input type="submit" value="Create a Mission">
        </form>

        <br>
        
        <h2>View Missions For</h2>

        <!-- Allow the user to view current missions for selected agent -->
        <form action="viewMissions.jsp" method="GET">
            Select an agent: <select>

                <!-- Using JSTL to retrieve context attribute holding agent
                     names and populate the drop down list-->
                <c:forEach var="agent" items="${agents}">
                <option value="${agent}">${agent}</option>                    
                </c:forEach>

            </select> <input type="submit" value="Go">
        </form>
        
    </body>
</html>
