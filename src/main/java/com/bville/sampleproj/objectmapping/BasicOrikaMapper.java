/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bart
 */
@Component
public abstract class BasicOrikaMapper<S, T> {

    private Class sClass, tClass;
    MapperFactory mapperFactory;
    boolean registrationRequired = true;

    public BasicOrikaMapper(Class<S> sCl, Class<T> tCl) {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        sClass = sCl;
        tClass = tCl;
    }

    abstract protected ClassMapBuilder getMapperDefinition();

    abstract protected Class getClassForSource();

    abstract protected Class getClassForTarget();

    private void runRegistration() {
        if (registrationRequired) {
            getMapperDefinition().register();
            registrationRequired = false;
        }
    }

    public T mapToTargetClass(S s) {
        runRegistration();
        return (T) mapperFactory.getMapperFacade().map(s, getClassForTarget());
    }

    public S mapToSourceClass(T t) {
        runRegistration();
        return (S) mapperFactory.getMapperFacade().map(t, getClassForSource());
    }
}
