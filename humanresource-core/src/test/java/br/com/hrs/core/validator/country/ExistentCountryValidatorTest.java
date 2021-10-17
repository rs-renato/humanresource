package br.com.hrs.core.validator.country;

import br.com.hrs.core.exception.HrsBusinessException;
import br.com.hrs.core.model.Country;
import br.com.hrs.core.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExistentCountryValidatorTest {

    @Mock
    CountryRepository countryRepository;

    ExistentCountryValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ExistentCountryValidator(countryRepository);
    }

    @Test
    void validate() {
        when(countryRepository.existsById("BR")).thenReturn(true);
        Country country = new Country.Builder().id("BR").build();
        assertDoesNotThrow(() -> validator.validate(country));
        verify(countryRepository).existsById("BR");
    }

    @Test
    void countryNotFound() {
        when(countryRepository.existsById("BR")).thenReturn(false);
        Country country = new Country.Builder().id("BR").build();
        Exception exception = assertThrows(HrsBusinessException.class,() -> validator.validate(country));
        assertEquals("Country does not exist", exception.getMessage());
        verify(countryRepository).existsById("BR");
    }

    @Test
    void nullCountry() {
        Exception exception = assertThrows(HrsBusinessException.class,() -> validator.validate((Country) null));
        assertEquals("Country is mandatory", exception.getMessage());
    }
}