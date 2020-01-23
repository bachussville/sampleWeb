/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.rest.services;

import com.bville.sampleproj.repository.Flora;

/**
 *
 * @author Bart
 */

public interface IBachussService {

    public Flora getFlora(String id);
}
