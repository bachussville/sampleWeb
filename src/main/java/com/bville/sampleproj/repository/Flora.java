/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.repository;

/**
 *
 * @author Bart
 */
public class Flora {
    
    private String name;
    private Integer maxHeight;
    private Boolean canStandTheHeat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Boolean getCanStandTheHeat() {
        return canStandTheHeat;
    }

    public void setCanStandTheHeat(Boolean canStandTheHeat) {
        this.canStandTheHeat = canStandTheHeat;
    }
    
    
    
}
