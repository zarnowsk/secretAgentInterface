<%-- 
    Document   : viewMissions
    Created on : 27-Nov-2019, 9:01:11 PM
    Author     : Michal Zarnowski
    Description: View missions page which allows the user to see all missions
                 for selected agent. User is informed if there are no current
                 missions for the selected agent. User is able to delete 
                 missions for selected agent if there are any.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%-- INITIAL VARIABLE SET UP --%>
<%-- Set variable agent with agent's name --%>
<c:set var="agent" value="${param.agent}" scope="request" />

<%-- Cycle through all mission lists inside the session, find the required 
     mission list based on agent's name, and set it as variable missionList --%>
<c:forEach var="tempMissionList" items="${sessionScope.missionLists}">
    <c:if test="${tempMissionList.agent.equals(agent)}">
        <c:set var="missionList" value="${tempMissionList}" scope="request" />
    </c:if>
</c:forEach>

<%-- Set variable missionCounter, used for numbered display of agent's missions --%>
<c:set var="missionCounter" value="0" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/main.css' />
        <title>Mission Log</title>
    </head>
    <body>
        <h1>Here are the missions for ${agent}</h1>

        <!-- Check if there is a mission list for required agent, if there
             isn't, display appropriate message -->
        <c:if test="${missionList == null}">
            <h2>There are no missions</h2>
        </c:if>

        <!-- Cycle through all missions inside agent's mission list and 
             display their details -->
        <c:forEach var="mission" items="${missionList.missions}">
            
            <!-- Increment mission counter for accurate display -->
            <c:set var="missionCounter" value="${missionCounter + 1}" />
            <h2>Mission ${missionCounter}: ${mission.name}</h2>
            Gadgets:
            <ul>
                <!-- Cycle through and display all mission gadgets -->
                <c:forEach var="gadget" items="${mission.gadgets}">
                    <li>${gadget.name}</li>                    
                    </c:forEach>
            </ul>
        </c:forEach>

        <!-- Check if there are missions being displayed, if so, allow the 
             user to delete them -->
        <c:if test="${missionCounter > 0}" >
            <br>
            <form action="DeleteMission.do" method="POST">
                <input type="hidden" name="agent" value="${agent}" >
                <%-- Using trim function for white spaces in agent's name --%>
                <input type="submit" value="Delete missions for ${fn:trim(agent)}" class="btn">
            </form>
            <br><br>
        </c:if>
            
        <!-- Return to home page -->
        <a href="index.jsp">Back to Home Page</a>
    </body>
</html>
