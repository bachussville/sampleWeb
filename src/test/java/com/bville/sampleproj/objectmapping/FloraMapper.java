/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

import com.bville.sampleproj.repository.Flora;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Bart
 */
public class FloraMapper {
    private BaseObjectMapper mapper = new BaseObjectMapper();
    private final String jsonForFlora = "{\"name\":\"anyName\",\"maxHeight\":74,\"canStandTheHeat\":false}";
    
    @Test
    void toJson() throws JsonProcessingException{
        
        Flora f = new Flora();
        f.setName("anyName");
        f.setCanStandTheHeat(Boolean.FALSE);
        f.setMaxHeight(74);
        
        String json = mapper.writeValueAsString(f);
        Assertions.assertEquals(jsonForFlora,json);
    }
    
    @Test
    void toFlora() throws IOException{
      
        Flora inst = mapper.readValue(jsonForFlora, Flora.class);
        Assertions.assertEquals("anyName",inst.getName());
        Assertions.assertEquals(Integer.valueOf(74),inst.getMaxHeight());
        Assertions.assertEquals(Boolean.FALSE,inst.getCanStandTheHeat());
    }
    
        
}
