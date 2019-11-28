package com.michzarnowski.michal_zarnowski_a3.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Java bean class modeling Agent's list of missions.
 * Allows the user to set and retrieve agent assigned to a set
 * of missions, set and retrieve the list of missions and add
 * a mission to Agent's list.
 * @author Michal Zarnowski
 */
public class MissionList implements Serializable {
    
    private String agent;
    private ArrayList<Mission> missions;

    public MissionList() {
    }

    public MissionList(String agent, ArrayList<Mission> missions) {
        this.agent = agent;
        this.missions = missions;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }
    
    public void addMission(Mission mission) {
        missions.add(mission);
    }

}
