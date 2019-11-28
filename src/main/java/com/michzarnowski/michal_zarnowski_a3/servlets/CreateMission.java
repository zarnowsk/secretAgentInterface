package com.michzarnowski.michal_zarnowski_a3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
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
        String[] gadgets = request.getParameterValues("gadgets");
        
        //Re-dispatch if mission title or agent name aren't valid
        if (missionTitle == null || missionTitle.length() == 0 ||
                agent == null || agent.length() == 0) {
            // IMPLEMENT !!!!
        }
        
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
