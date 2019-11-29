package com.michzarnowski.michal_zarnowski_a3.servlets;

import com.michzarnowski.michal_zarnowski_a3.model.Gadget;
import com.michzarnowski.michal_zarnowski_a3.model.Mission;
import com.michzarnowski.michal_zarnowski_a3.model.MissionList;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Http servlet handling addition of mission to an agent. Mission parameters 
 * are required from requesting form and used to create a mission object. 
 * Mission is then added to agent's mission list and saved inside the session.
 * Request is then dispatched to viewMissions.jsp
 * @author Michal Zarnowski
 */
public class CreateMission extends HttpServlet {
    
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
        
        //Retrieve form parameters entered by the user inside createMission.jsp
        String missionTitle = request.getParameter("missionTitle");
        String agent = request.getParameter("agent");
        String[] rawGadgets = request.getParameterValues("gadgets");
        
        //Re-dispatch if mission title or agent name aren't valid
        if (missionTitle == null || missionTitle.length() == 0 ||
                agent == null || agent.length() == 0) {
            // IMPLEMENT !!!!
        }
        
        //Populate an ArrayList with mission gadgets
        ArrayList<Gadget> gadgets = new ArrayList<>();
        for (String gadget : rawGadgets) {
            if(gadget.trim().length() > 1) {
                gadgets.add(new Gadget(gadget.trim()));
            }
        }
        
        //Create new mission with acquired parameters
        Mission tempMission = new Mission(missionTitle, gadgets);
        
        //Retrieve mission lists from the session
        HttpSession session = request.getSession();
        ArrayList<MissionList> missionLists = 
                (ArrayList<MissionList>)session.getAttribute("missionLists");
        
        //Find mission list for required agent or create a new one
        MissionList tempMissionList = null;
        
        if (missionLists != null) {
            for (MissionList missionList : missionLists) {
                if (missionList.getAgent().equals(agent)) {
                    tempMissionList = missionList;
                }
            }
        } else {
            missionLists = new ArrayList<>();
        }
        
        //If agent's mission list wasn't inside the session, create a new one
        if (tempMissionList == null) {
            tempMissionList = new MissionList();
            tempMissionList.setAgent(agent);
            tempMissionList.setMissions(new ArrayList<Mission>());
        }

        //Add new mission to agent's list
        tempMissionList.addMission(tempMission);
        
        //Add new mission list to session's mission lists
        missionLists.add(tempMissionList);
        session.setAttribute("missionLists", missionLists);
        
        //Set request attribute agent to who's mission we've just added
        request.setAttribute("agent", agent);
        
        //Dispatch to viewMissions.jsp
        RequestDispatcher rd = request.getRequestDispatcher("viewMissions.jsp");
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
