/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.config.BConfig;
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

    @Captor
    ArgumentCaptor<String> stringArgCaptor;

    @Captor
    ArgumentCaptor<Flora> floraArgCaptor;

    @Test
    public void getFloraById() throws Exception {
        Flora aFlora = new Flora();
        aFlora.setName("abc");

        when(floraService.getFlora(stringArgCaptor.capture())).thenReturn(aFlora);

        mvc.perform(MockMvcRequestBuilders.get("/flora/88").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":null,\"name\":\"abc\",\"maxHeight\":null,\"canStandTheHeat\":null}")));

        assertEquals("88", stringArgCaptor.getValue());
    }

    @Test
    public void saveFlora() throws Exception {
        Flora aFlora = new Flora();
        aFlora.setName("abc");
        Flora nextFlora = new Flora();
        nextFlora.setId("myId");

        when(floraService.save(floraArgCaptor.capture())).thenReturn(nextFlora);

        mvc.perform(MockMvcRequestBuilders.put("/flora")
                .content("{\"name\":\"abc\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":\"myId\",\"name\":null,\"maxHeight\":null,\"canStandTheHeat\":null}")))
                ;

        assertNull(floraArgCaptor.getValue().getId());

    }
}
