package org.robockets.distancesensorlib.sharp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import edu.wpi.first.wpilibj.AnalogInput;

public class TestGP2D120XJ00F {
	
	@Test
	public void testGetDistanceCentimetersNegativeFilter() {
		//If a voltage being plugged into the formula results in a negative value, return should be 0
		AnalogInput ai = mock(AnalogInput.class);
		when(ai.getVoltage()).thenReturn(2.0);
		GP2D120XJ00F sensor = new GP2D120XJ00F(ai);
		assertEquals(sensor.getDistanceCentimeters(), 0.0, 0.0);
	}
	
	@Test
	public void testGetDistanceCentimeters() {
		//Test with regular voltages
		AnalogInput ai = mock(AnalogInput.class);
		when(ai.getVoltage()).thenReturn(3.0);
		GP2D120XJ00F sensor = new GP2D120XJ00F(ai);
		assertEquals(sensor.getDistanceCentimeters(), 13.5120, 0.0001);
	}

}
