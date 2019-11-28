<%-- 
    Document   : viewMissions
    Created on : 27-Nov-2019, 9:01:11 PM
    Author     : Michal Zarnowski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${agent == null}">
    <c:set var="agent" value="${param.agent}" scope="request" />
</c:if>
<c:forEach var="tempMissionList" items="${sessionScope.missionLists}">
    <c:if test="${tempMissionList.agent.equals(agent)}">
        <c:set var="missionList" value="${tempMissionList}" scope="request" />
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mission Log</title>
    </head>
    <body>
        <h1>Here are the missions for ${agent}</h1>

        <c:if test="${missionList == null}">
            <h2>There are no missions</h2>
        </c:if>

        <c:forEach var="mission" items="${missionList.missions}">
            <h2>${mission.name}</h2>
            Gadgets:
            <ul>
                <c:forEach var="gadget" items="${mission.gadgets}">
                    <li>${gadget.name}</li>                    
                </c:forEach>
            </ul>
        </c:forEach>
            
        <a href="index.jsp">Back to Home Page</a>
    </body>
</html>
