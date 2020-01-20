/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.config.rest;

import com.bville.sampleproj.config.rest.services.IBodyService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bart
 */
@RestController
//@EnableAutoConfiguration
public class BachussRest {

    static Logger log = Logger.getLogger(BachussRest.class.getName());
    
    @Autowired
    IBodyService bachussBodyService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        log.info("sayHello() REQUEST");
        return "Greetings from Spring Boot 99 !";
    }

    @RequestMapping("/BachussBody/length")
    public String bachussBodyLength() {
        log.info("bachussBodyLength() REQUEST");
        return ""+ bachussBodyService.getLength(false);
    }
}
