package org.robockets.distancesensorlib;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDistanceMeasurementConverter {

	@Test
	public void testInchesToCentimeters() {
		assertEquals(DistanceMeasurementConverter.inchesToCentimeters(0), 0.0, 0.0);
		assertEquals(DistanceMeasurementConverter.inchesToCentimeters(10), 25.4, 0.0);
		assertEquals(DistanceMeasurementConverter.inchesToCentimeters(15.15), 38.481, 0.0);
	}

	@Test
	public void testCentimetersToInches() {
		assertEquals(DistanceMeasurementConverter.centimetersToInches(0), 0.0, 0.0);
		assertEquals(DistanceMeasurementConverter.centimetersToInches(10), 3.937, 0.0);
		assertEquals(DistanceMeasurementConverter.centimetersToInches(15.15), 5.964555, 0.0);
	}

}
