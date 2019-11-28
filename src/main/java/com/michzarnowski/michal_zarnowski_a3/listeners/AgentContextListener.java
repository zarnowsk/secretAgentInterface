package com.michzarnowski.michal_zarnowski_a3.listeners;

import com.michzarnowski.michal_zarnowski_a3.model.Gadget;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Context listener initializing gadget and agent parameters
 * as context attributes to be used within the life cycle of 
 * the application.
 * @author Michal Zarnowski
 */
public class AgentContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       
        //read in servlet context
        ServletContext context = sce.getServletContext();
        
        // GADGETS SET UP
        
        /*read the gadget context params and set up inside of an
          ArrayList of Gadgets*/
        String rawGadgets = context.getInitParameter("gadgets");
        String[] gadgetsArr = rawGadgets.split(":");
        
        ArrayList<Gadget> gadgets = new ArrayList<>();
        
        for (String gadget : gadgetsArr) {
            gadgets.add(new Gadget(gadget));
        }
        
        //set Gadget ArrayList as context attrbute
        context.setAttribute("gadgets", gadgets);
        
        // AGENTS SET UP
        
        /*read the agent context params and set up inside of an
          ArrayList of Strings representing agent names*/
        String rawAgents = context.getInitParameter("agents");
        String[] agentsArr = rawAgents.split(":");
        
        ArrayList<String> agents = new ArrayList<>();
        
        for(String agent : agentsArr) {
            agents.add(agent);
        }
        
        //set Gadget ArrayList as context attrbute
        context.setAttribute("agents", agents);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
        //No need to destroy anything
    }

}
