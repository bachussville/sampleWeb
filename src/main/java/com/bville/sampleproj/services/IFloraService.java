/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.services;

import com.bville.sampleproj.persistence.FloraDto;

/**
 *
 * @author Bart
 */
public interface IFloraService {
    public FloraDto getFlora(String id);
    public FloraDto save(FloraDto toSave);
}
