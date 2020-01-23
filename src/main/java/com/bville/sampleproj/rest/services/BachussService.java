/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.rest.services;

import com.bville.sampleproj.repository.Flora;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bart
 */
@Service
public class BachussService implements IBachussService{
    
    public Flora getFlora(String id){
        Flora f = new Flora();
        f.setName("SomeFlora-" + id);
        return f;
    }
            
    
    
}
