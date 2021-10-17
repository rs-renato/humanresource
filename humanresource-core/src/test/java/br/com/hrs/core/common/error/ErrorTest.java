package br.com.hrs.core.common.error;

import br.com.hrs.core.exception.HrsBusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ErrorTest {

    @Test
    void testMandatory(){
        Exception exception = assertThrows(HrsBusinessException.class, () -> Error.of("property").when(FIELD.MANDATORY).trows());
        assertEquals("property is mandatory", exception.getMessage());
    }

    @Test
    void testNotFound(){
        Exception exception = assertThrows(HrsBusinessException.class, () -> Error.of("property").when(FIELD.NOT_FOUND).trows());
        assertEquals("property not found", exception.getMessage());
    }

    @Test
    void testNotFound2(){
        Exception exception = assertThrows(HrsBusinessException.class, () -> Error.of("property").when(FIELD.NOT_FOUND).on("object").trows());
        assertEquals("property not found on object", exception.getMessage());
    }
}