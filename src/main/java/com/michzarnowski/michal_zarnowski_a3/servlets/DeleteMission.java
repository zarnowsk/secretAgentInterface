package com.michzarnowski.michal_zarnowski_a3.servlets;

import com.michzarnowski.michal_zarnowski_a3.model.MissionList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Http servlet handling removal of the mission list for specific agent. Once
 * required mission list is removed from the session, the user is dispatched
 * back to the home page.
 * @author Michal Zarnowski
 */
public class DeleteMission extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Retrieve mission lists from the session
        HttpSession session = request.getSession();
        ArrayList<MissionList> missionLists = 
                (ArrayList<MissionList>)session.getAttribute("missionLists");
        
        //Find the mission list belonging to required agent
        String agentName = request.getParameter("agent");
        MissionList tempMissionList = null;
        
        for (MissionList missionList : missionLists) {
            if (missionList.getAgent().equals(agentName)) {
                tempMissionList = missionList;
            }
        }
        
        //Remove required mission list from the ArrayList of all mission lists
        missionLists.remove(tempMissionList);
        
        //Re-set the session attribute
        session.setAttribute("missionLists", missionLists);
        
        /* Set request attribute with agent's name to display confirmation message
           on dispatched page */
        request.setAttribute("deletedAgent", agentName);
        
        //Dispatch back to index.jsp
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
