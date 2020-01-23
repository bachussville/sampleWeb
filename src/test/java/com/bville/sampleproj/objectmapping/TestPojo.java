/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

/**
 *
 * @author Bart
 */
class TestPojo {
    private String aString;
    private Boolean aBoolean;
    private Integer anInteger;
    
    public static TestPojo getInstance(){
        TestPojo inst = new TestPojo();
        inst.aString = "aStringValue";
        inst.aBoolean = Boolean.FALSE;
        inst.anInteger = 13;
        
        return inst;
    }

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Integer getAnInteger() {
        return anInteger;
    }

    public void setAnInteger(Integer anInteger) {
        this.anInteger = anInteger;
    }
    
    
}
