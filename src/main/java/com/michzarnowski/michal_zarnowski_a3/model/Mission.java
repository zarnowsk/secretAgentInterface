package com.michzarnowski.michal_zarnowski_a3.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Java bean class modeling Agent's mission.
 * Allows the user to set and retrieve mission name and a list of 
 * gadgets for the mission.
 * @author Michal Zarnowski
 */
public class Mission implements Serializable {
    
    private String name;
    private ArrayList<Gadget> gadgets;

    public Mission() {
    }

    public Mission(String name, ArrayList<Gadget> gadgets) {
        this.name = name;
        this.gadgets = gadgets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(ArrayList<Gadget> gadgets) {
        this.gadgets = gadgets;
    }
    
    

}
