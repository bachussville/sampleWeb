/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.services;

import com.bville.sampleproj.persistence.FloraDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bart
 */
@Service
public class FloraService implements IFloraService {

    @Override
    public FloraDto getFlora(String id) {
        FloraDto f = new FloraDto();
        f.setDefaultName("SomeFlora-" + id);
        return f;
    }

    @Override
    public FloraDto save(FloraDto toSave) {

        FloraDto f = toSave;
        return f;
    }

}
