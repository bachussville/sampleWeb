/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author Bart
 */
@Service
public class FloraService implements IFloraService {

    @Override
    public Flora getFlora(String id) {
        Flora f = new Flora();
        f.setName("SomeFlora-" + id);
        return f;
    }

    @Override
    public Flora save(Flora toSave) {

        Flora f = toSave;
        return f;
    }

}
