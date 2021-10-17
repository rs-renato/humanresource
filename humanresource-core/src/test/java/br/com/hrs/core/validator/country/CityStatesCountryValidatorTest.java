package br.com.hrs.core.validator.country;

import br.com.hrs.core.exception.HrsBusinessException;
import br.com.hrs.core.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CityStatesCountryValidatorTest {

    CityStatesCountryValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CityStatesCountryValidator();
    }

    @ParameterizedTest(name = "{displayName} - [{index} - {arguments}]")
    @ValueSource(strings = {"Brazil","Germany","Italy"})
    void validate(String name) {
        Country country = new Country.Builder().name(name).build();
        assertDoesNotThrow(() -> validator.validate(country));
    }

    @ParameterizedTest(name = "{displayName} - [{index} - {arguments}]")
    @ValueSource(strings = {"MONACO","VATICAN","VATICAN"})
    void cityStateNotAllowed(String name) {
        Country country = new Country.Builder().name(name).build();
        Exception exception = assertThrows(HrsBusinessException.class,() -> validator.validate(country));
        assertEquals("City-States are not allowed", exception.getMessage());
    }

    @Test
    void nullCountry() {
        Exception exception = assertThrows(HrsBusinessException.class,() -> validator.validate((Country) null));
        assertEquals("Country is mandatory", exception.getMessage());
    }
}