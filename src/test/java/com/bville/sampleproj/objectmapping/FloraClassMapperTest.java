/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

import com.bville.sampleproj.persistence.FloraDto;
import com.bville.sampleproj.services.Flora;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Bart
 */
public class FloraClassMapperTest {

    @Test
    void mapFloraToFloraDto() {
        FloraClassMapper instance = new FloraClassMapper();
        Flora source = new Flora();
        source.setId("S1");
        source.setName("S2");
        source.setMaxHeight(111);
        source.setCanStandTheHeat(Boolean.FALSE);

        FloraDto target = instance.mapToTargetClass(source);

        assertEquals("S1", target.getId());
        assertEquals("S2", target.getDefaultName());
        assertEquals(111, target.getMaxHeight().intValue());
        assertEquals(Boolean.FALSE, target.getCanStandTheHeat());

    }

    @Test
    void mapFloraDtoToFlora() {
        FloraClassMapper instance = new FloraClassMapper();
        FloraDto target = new FloraDto();
        target.setId("S1");
        target.setDefaultName("S2");
        target.setMaxHeight(111);
        target.setCanStandTheHeat(Boolean.FALSE);

        Flora source = instance.mapToSourceClass(target);

        assertEquals("S1", source.getId());
        assertEquals("S2", source.getName());
        assertEquals(111, source.getMaxHeight().intValue());
        assertEquals(Boolean.FALSE, source.getCanStandTheHeat());

    }    
}
