/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Bart
 */
@Entity
public class FloraDto extends BaseDto {
    
    @Id
    private String id;
    
    private String defaultName;
    
    private Integer maxHeight;
    private Boolean canStandTheHeat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
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
