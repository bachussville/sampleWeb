/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

import com.bville.sampleproj.persistence.FloraDto;
import com.bville.sampleproj.services.Flora;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bart
 */
@Component
public class FloraClassMapper extends BasicOrikaMapper<Flora, FloraDto>{

    public FloraClassMapper() {
        super(Flora.class, FloraDto.class);
    }

    
    @Override
    protected ClassMapBuilder getMapperDefinition() {
        return mapperFactory
                .classMap(Flora.class, FloraDto.class)
                .field("name", "defaultName")
                .byDefault();
    }

    @Override
    protected Class getClassForSource() {
        return Flora.class;
    }

    @Override
    protected Class getClassForTarget() {
        return FloraDto.class;
    }

    
    
    
    
}
