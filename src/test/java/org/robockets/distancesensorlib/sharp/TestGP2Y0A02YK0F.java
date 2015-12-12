package org.robockets.distancesensorlib.sharp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.AnalogInput;

public class TestGP2Y0A02YK0F {

	AnalogInput ai;
	GP2Y0A02YK0F sensor;
	
	@Before
	public void init() {
		ai = mock(AnalogInput.class);
		when(ai.getVoltage()).thenReturn(2.0);
		sensor = new GP2Y0A02YK0F(ai);
	}
	
	@Test
	public void testGetDistanceCentimeters() {
		assertEquals(sensor.getDistanceCentimeters(), 31.2041, 0.0001);
	}
}
