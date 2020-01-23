/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.config.BConfig;
import com.bville.sampleproj.repository.Flora;
import com.bville.sampleproj.rest.services.BachussService;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.verify;
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
public class BachussControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    BachussService bs;
    
    @Captor
    ArgumentCaptor<String> arg;
    
    
    

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void getHello2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot 99 !")));
    }

    @Test
    public void getFloraById() throws Exception {
        Flora aFlora = new Flora();
        aFlora.setName("abc");
        when(bs.getFlora(arg.capture())).thenReturn(aFlora);
        
        mvc.perform(MockMvcRequestBuilders.get("/flora/88").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"name\":\"abc\",\"maxHeight\":null,\"canStandTheHeat\":null}")));
        
        assertEquals("88", arg.getValue());
        verify(bs).getFlora("88");
    }
}
