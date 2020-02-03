/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.objectmapping.BasicJsonMapper;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bville.sampleproj.services.IBachussService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import javax.ws.rs.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bart
 */
@RestController
//@EnableAutoConfiguration
public class BachussRest {
    @Autowired
    BasicJsonMapper mapper;

    static Logger log = Logger.getLogger(BachussRest.class.getName());
    
    @Autowired
    IBachussService bachussBodyService;

    public BachussRest() {
       // this.<error> = "/flora/{idZZ}";
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        log.info("sayHello() REQUEST");
        return "Greetings from Spring Boot 99 !";
    }

}
