package org.robockets.distancesensorlib.maxbotix;

import org.robockets.distancesensorlib.DistanceMeasurementConverter;
import org.robockets.distancesensorlib.DistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Distance sensor in the LV-MaxSonar-EZ series by MaxBotix. Supports the EZ0,
 * EZ1, EZ2, EZ3, and EZ4. The only important difference between the sensors
 * in this series is the beam pattern.
 * 
 * <ul>
 * <li>Range: 0-645 centimeters</li>
 * <li>measured voltage / (supplied voltage / 512)</li>
 * <li><a href="http://maxbotix.com/documents/LV-MaxSonar-EZ_Datasheet.pdf">Datasheet</a></li>
 * </ul>
 */
public class LvMaxSonarEz extends DistanceSensor {
	private final double voltagePerInch;
	
	/**
	 * @param sensor AnalogInput for the port this sensor is attached to
	 * @param voltage Voltage being provided to the sensor. This sensor returns
	 * accurate results for voltages from around 3.something to 5.0 volts.
	 */
	public LvMaxSonarEz(AnalogInput sensor, double voltage) {
		//TODO: Check minimum voltage. Pretty sure it isn't three.
		super(sensor);
		if (voltage < 3 || voltage > 5) {
			throw new IllegalArgumentException("Voltage must be between 3 and 5 (what the roboRIO can output)");
		}
		voltagePerInch = voltage / 512; //Calculates voltage scaling ((5.0V/512) = 0.009766V per inch)
	}

	@Override
	public double getDistanceCentimeters() {
		return DistanceMeasurementConverter.inchesToCentimeters(getDistanceInches());
	}

	@Override
	public double getDistanceInches() {
		return sensor.getVoltage() / voltagePerInch;
	}
}
