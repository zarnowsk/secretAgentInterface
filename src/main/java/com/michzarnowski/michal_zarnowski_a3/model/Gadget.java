package com.michzarnowski.michal_zarnowski_a3.model;

import java.io.Serializable;

/**
 * Java bean class representing Agent's gadget.
 * Allows user to set and retrieve the name of the gadget.
 * @author Michal Zarnowski
 */
public class Gadget implements Serializable {
    
    private String name;
    
    public Gadget() {
        
    }
    
    public Gadget(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
