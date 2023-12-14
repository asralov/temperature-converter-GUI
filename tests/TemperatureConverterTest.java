package tests;

// Author: Abrorjon Asralov
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TemperatureConverter;

public class TemperatureConverterTest {
	TemperatureConverter t = new TemperatureConverter();

	@Test
	public void CtoF() {
		assertEquals(212.0, TemperatureConverter.CtoF(100));
		assertEquals(98.6, TemperatureConverter.CtoF(37));
		assertEquals(32, TemperatureConverter.CtoF(0));
		assertEquals(0, TemperatureConverter.CtoF(-17.78));
		assertEquals(-40, TemperatureConverter.CtoF(-40));
	}

	@Test
	public void FtoC() {
		assertEquals(100.0, TemperatureConverter.FtoC(212.0));
		assertEquals(37, TemperatureConverter.FtoC(98.6));
		assertEquals(0, TemperatureConverter.FtoC(32));
		assertEquals(-17.8, TemperatureConverter.FtoC(0));
		assertEquals(-40, TemperatureConverter.FtoC(-40));
	}

}
