/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.config.rest.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author Bart
 */
@Service
public class BachussBodyService implements IBodyService{
    
    public long getLength(Boolean type){
        return 18000;
    }
            
    
    
}
