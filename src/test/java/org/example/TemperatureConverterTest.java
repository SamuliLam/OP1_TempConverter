package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();


    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.01);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.01);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.01);
    }

    @Test
    public void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));
        assertFalse(converter.isExtremeTemperature(20));
        assertTrue(converter.isExtremeTemperature(60));
    }

    @Test
    public void kelvinToCel() {
        assertEquals(0.0, TemperatureConverter.kelvinToCel(273.15f), 0.001f);
        assertEquals(-273.15, TemperatureConverter.kelvinToCel(0), 0.001f);
    }
}
