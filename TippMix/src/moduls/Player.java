/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduls;

/**
 *
 * @author Szabina
 */
public class Player {

    private String name;
    private Integer power;
    private Integer TeamID;
    public Player(String name,int power,Integer TeamID) {
    this.name = name;
    this.power = power;
    this.TeamID = TeamID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the power
     */
    public Integer getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(Integer power) {
        this.power = power;
    }

    /**
     * @return the TeamID
     */
    public Integer getTeamID() {
        return TeamID;
    }

    /**
     * @param TeamID the TeamID to set
     */
    public void setTeamID(Integer TeamID) {
        this.TeamID = TeamID;
    }

    
}
