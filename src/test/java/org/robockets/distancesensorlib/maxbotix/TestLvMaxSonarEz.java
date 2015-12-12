package org.robockets.distancesensorlib.maxbotix;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.AnalogInput;

public class TestLvMaxSonarEz {
	
	AnalogInput ai;
	LvMaxSonarEz sensor;
	
	@Before
	public void init() {
		ai = mock(AnalogInput.class);
		when(ai.getVoltage()).thenReturn(2.0);
		sensor = new LvMaxSonarEz(ai, 5.0);
	}
	
	@Test
	public void testGetDistanceInches() {
		//When voltage = 2.0 then the distance in inches should be 204.8 since 2.0 / (5.0 / 512) = 204.8
		assertEquals(sensor.getDistanceInches(), 204.8, 0.0);
	}

}
