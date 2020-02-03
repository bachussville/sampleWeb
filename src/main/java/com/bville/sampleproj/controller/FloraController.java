/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.controller;

import com.bville.sampleproj.objectmapping.BasicJsonMapper;
import com.bville.sampleproj.objectmapping.FloraClassMapper;
import com.bville.sampleproj.persistence.FloraDto;
import com.bville.sampleproj.services.Flora;
import com.bville.sampleproj.services.IFloraService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.logging.Level;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Bart
 */
@RestController
//@EnableAutoConfiguration
public class FloraController {

    @Autowired
    BasicJsonMapper mapper;
    @Autowired
    FloraClassMapper floraClassMapper;

    static Logger log = Logger.getLogger(FloraController.class.getName());

    @Autowired
    IFloraService floraService;

    public FloraController() {
    }

    @RequestMapping("/flora/{floraId}")
    public String getFloraById(@PathVariable(value = "floraId") String id) throws JsonProcessingException {
        log.log(Level.INFO, "getFloraById() REQUEST with ID={0}", id);
        FloraDto floraDto = floraService.getFlora(id);
        return mapper.writeValueAsString(floraClassMapper.mapToSourceClass(floraDto));
    }

    @PutMapping(path = "/flora")
    public String saveFlora(@RequestBody Flora f) throws JsonProcessingException {
        log.log(Level.INFO, "saveFlora() - {0}", mapper.writeValueAsString(f));
        FloraDto floraDto = floraService.save(floraClassMapper.mapToTargetClass(f));
        return mapper.writeValueAsString(floraClassMapper.mapToSourceClass(floraDto));
    }

}
