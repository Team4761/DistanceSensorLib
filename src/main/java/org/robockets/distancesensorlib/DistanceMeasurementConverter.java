package org.robockets.distancesensorlib;

/**
 * Class containing static methods for converting from one unit of length to
 * another. This class exists because some distance sensors report their
 * results in centimeters, but others in inches and it's better to not hardcode
 * the conversions in the {@link DistanceSensor} subclasses themselves.
 */
public class DistanceMeasurementConverter {
	/**
	 * Converts a certain value of centimeters into inches. One centimeter
	 * equals around 0.3937 inches so we use that here. Maybe someday there
	 * will be a way to choose how precise the calculation is so that you can
	 * use 0.<span style="text-decoration: overline">393700787401574803149606299212598425196850</span>
	 * instead...
	 * 
	 * @param centimeters Number of centimeters to convert into inches
	 * @return Equivalent distance of <code>centimeters</code> in inches 
	 */
	public static double centimetersToInches(double centimeters) {
		return centimeters * 0.3937;
	}
	
	/**
	 * Converts a certain value of centimeters into inches. One inch equals
	 * exactly 2.54 centimeters, so the conversion is easy.
	 * 
	 * @param inches Number of inches to convert into centimeters
	 * @return Equivalent distance of <code>inches</code> in centimeters
	 */
	public static double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}
}
