/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.config.BConfig;
import com.bville.sampleproj.services.Flora;
import com.bville.sampleproj.services.BachussService;
import com.bville.sampleproj.services.FloraService;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.jupiter.api.Assertions;
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
    
    @MockBean
    FloraService floraService;
    
    @Captor
    ArgumentCaptor<String> arg;
    
    @Captor
    ArgumentCaptor<Flora> floraArgCaptor;    
    

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



}
