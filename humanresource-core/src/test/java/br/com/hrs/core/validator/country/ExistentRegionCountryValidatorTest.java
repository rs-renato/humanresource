package br.com.hrs.core.validator.country;

import br.com.hrs.core.exception.HrsBusinessException;
import br.com.hrs.core.model.Country;
import br.com.hrs.core.validator.region.ExistentRegionValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExistentRegionCountryValidatorTest {

    @Mock
    ExistentRegionValidator regionValidator;

    ExistentRegionCountryValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ExistentRegionCountryValidator(regionValidator);
    }

    @Test
    void validate() {
        Country country = new Country.Builder().id("BR").build();
        assertDoesNotThrow(() -> validator.validate(country));
    }

    @Test
    void nullCountry() {
        Exception exception = assertThrows(HrsBusinessException.class,() -> validator.validate((Country) null));
        assertEquals("Country is mandatory", exception.getMessage());
    }
}