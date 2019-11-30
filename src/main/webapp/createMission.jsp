<%-- 
    Document   : createMission
    Created on : 27-Nov-2019, 7:50:30 PM
    Author     : Michal Zarnowski
    Description: Create mission page which allows the user to create a new
                 mission with the following attributes entered by the user:
                 mission title, the agent, gadgets for the mission.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/main.css' />
        <title>Create New Mission</title>
    </head>
    <body>
        <h1>Create a Mission</h1>

        <!-- Input form for mission details -->
        <form action="CreateMission.do" method="POST">

            Mission Title: <input type="text" name="missionTitle" class="input" required><br>
            Select the agent: <select name="agent" class="select-field">

                <!-- Using JSTL to retrieve context attribute holding agent
                     names and populate the drop down list-->
                <c:forEach var="agent" items="${agents}">
                    <option value="${agent}">${agent}</option>                    
                </c:forEach>

            </select>

            <h2>Select the Gadgets</h2>
            
            <div id="gadgetList">

            <!-- Using JSTL to retrieve context attribute holding gadgets
                 and populate the checkboxes-->
            <c:forEach var="gadget" items="${gadgets}">
                <input type="checkbox" name="gadgets" value="${gadget.name}"> ${gadget.name}
                <br>
            </c:forEach>

            <!-- Optional mission gadget entry field -->
            Other Gadget <input type="text" name="gadgets" class="input">
            </div>
            
            <br><br>
            
            <!-- Submit button -->
            <input type="submit" value="Create Mission" class="btn">

        </form>

    </body>
</html>
