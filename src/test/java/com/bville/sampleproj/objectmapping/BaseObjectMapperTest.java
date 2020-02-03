/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bville.sampleproj.objectmapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.TestComponent;

/**
 *
 * @author Bart
 */
@TestComponent
class BaseObjectMapperTest {

    private static BasicJsonMapper mapper;
    private static TestPojo o;

    @BeforeAll
    static void beforeAll() {
        mapper = new BasicJsonMapper();
        o = TestPojo.getInstance();
    }

    @Test
    void testPojoToJson() {
        try {
            String jsonString = mapper.writeValueAsString(o);
            assertEquals("{\"aString\":\"aStringValue\",\"aBoolean\":false,\"anInteger\":13}", jsonString);
        } catch (JsonProcessingException ex) {
            fail("Unexpected exception: " + ex.getClass().getName());
        }
    }

    @Test
    void jsonToTestPojo() {
        TestPojo testPojoResult;
        try {
            testPojoResult = mapper.readValue(
                    "{\"aString\":\"aStringValue\",\"aBoolean\":false,\"anInteger\":13}", TestPojo.class
            );
            
            assertEquals("aStringValue", testPojoResult.getaString());
            assertEquals(false, testPojoResult.getaBoolean());
            assertEquals(13, testPojoResult.getAnInteger());
        } catch (IOException ex) {
            Logger.getLogger(BaseObjectMapperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
