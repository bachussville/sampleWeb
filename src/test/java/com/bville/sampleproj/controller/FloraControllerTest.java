/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.config.BConfig;
import com.bville.sampleproj.objectmapping.FloraClassMapper;
import com.bville.sampleproj.persistence.FloraDto;
import com.bville.sampleproj.services.Flora;
import com.bville.sampleproj.services.FloraService;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Bart
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(BachussRest.class)
@ContextConfiguration(classes = {BConfig.class})
public class FloraControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    FloraService floraService;

    @MockBean
    FloraClassMapper floraClassMapper;

    @Captor
    ArgumentCaptor<String> stringArgCaptor;

    @Captor
    ArgumentCaptor<FloraDto> floraDtoArgCaptor;
    
    @Captor
    ArgumentCaptor<Flora> floraArgCaptor;

    @Test
    public void getFloraById() throws Exception {
        Flora aFlora = new Flora();
        aFlora.setName("abc");
        
        FloraDto aFloraDto = new FloraDto();
        aFloraDto.setDefaultName("abc");

        when(floraService.getFlora(stringArgCaptor.capture())).thenReturn(aFloraDto);
        when(floraClassMapper.mapToTargetClass(floraArgCaptor.capture())).thenReturn(aFloraDto);
        when(floraClassMapper.mapToSourceClass(floraDtoArgCaptor.capture())).thenReturn(aFlora);

        mvc.perform(MockMvcRequestBuilders.get("/flora/88").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":null,\"name\":\"abc\",\"maxHeight\":null,\"canStandTheHeat\":null}")));

        assertEquals("88", stringArgCaptor.getValue());
    }

    @Test
    public void saveFlora() throws Exception {
        FloraDto aFloraDto = new FloraDto();
        aFloraDto.setDefaultName("abc_X1");
        FloraDto nextFloraDto = new FloraDto();
        nextFloraDto.setId("myId");
        
        Flora aFlora = new Flora();
        aFlora.setId("myId_X1");
        
        when(floraService.save(floraDtoArgCaptor.capture())).thenReturn(nextFloraDto);
        when(floraClassMapper.mapToTargetClass(floraArgCaptor.capture())).thenReturn(aFloraDto);
        when(floraClassMapper.mapToSourceClass(floraDtoArgCaptor.capture())).thenReturn(aFlora);

        mvc.perform(MockMvcRequestBuilders.put("/flora")
                .content("{\"name\":\"abc\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"myId_X1\",\"name\":null,\"maxHeight\":null,\"canStandTheHeat\":null}")));

        assertEquals("abc",floraArgCaptor.getValue().getName());
        assertEquals(nextFloraDto,floraDtoArgCaptor.getValue());

    }
}
