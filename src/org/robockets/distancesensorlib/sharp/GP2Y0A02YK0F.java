package org.robockets.distancesensorlib.sharp;

import org.robockets.distancesensorlib.DistanceMeasurementConverter;
import org.robockets.distancesensorlib.DistanceSensor;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * GP2Y0A02YK0F distance sensor by Sharp
 * 
 * <ul>
 * <li>Range: 20-150 centimeters</li>
 * <li>Formula: 306.439 + measured voltage * (-512.611 + measured voltage * (382.268 + measured voltage * (-129.893 + measured voltage * 16.2537)))</li>
 * <li><a href="https://www.sparkfun.com/datasheets/Sensors/Infrared/gp2y0a02yk_e.pdf">Datasheet</a></li>
 * </ul>
 */
public class GP2Y0A02YK0F extends DistanceSensor {
	public GP2Y0A02YK0F(AnalogInput sensor) {
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
