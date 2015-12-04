package org.robockets.distancesensorlib.sharp;

import org.robockets.distancesensorlib.DistanceMeasurementConverter;
import org.robockets.distancesensorlib.DistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * GP2D120XJ00F distance sensor by Sharp
 * 
 * <ul>
 * <li>Range: 3-30 centimeters</li>
 * <li>Formula: 17.298 * measured voltage<sup>2</sup> - 66.8913 * measured voltage + 58.504</li>
 * <li><a href="https://www.sparkfun.com/datasheets/Sensors/Infrared/GP2D120XJ00F_SS.pdf">Datasheet</a></li>
 * </ul>
 */
public class GP2D120XJ00F extends DistanceSensor {
	public GP2D120XJ00F(AnalogInput sensor) {
		super(sensor);
	}
	
	@Override
	public double getDistanceCentimeters() {
		double voltage = sensor.getVoltage();
		return 306.439 + voltage * (-512.611 + voltage * (382.268 + voltage * (-129.893 + voltage * 16.2537)));
	}

	@Override
	public double getDistanceInches() {
		return DistanceMeasurementConverter.centimetersToInches(getDistanceCentimeters());
	}
}
