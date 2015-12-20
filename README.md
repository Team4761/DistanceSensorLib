# DistanceSensorLib [![Build Status](https://travis-ci.org/Team4761/DistanceSensorLib.svg)](https://travis-ci.org/Team4761/DistanceSensorLib)

DistanceSensorLib is a library for using distance sensors in WPILib.

## Using the Library
Make an instance of the class for your distance sensor:
```java
GP2Y0A02YK0F sensor = new GP2Y0A02YK0F(new AnalogInput(2));
```
This code creates GP2Y0A02YK0F distance sensor on port 2. In general, the distance sensor constructor only needs an AnalogInput as an argument, however you should look at the Javadocs for the specific sensor you wish to use. Some have special requirements.

Now, you can read distances from the object. Try to read distances:
```java
sensor.getDistanceCentimeters(); //Double representing distance in centimeters
sensor.getDistanceInches(); //Double representing distance in centimeters
```

If you need to work with the AnalogInput directly, you can get it with the `getAnalogInput` method:
```java
sensor.getAnalogInput().getVoltage();
```

## Supported Sensors
###Maxbotix
* LV-MaxSonar-EZ0
* LV-MaxSonar-EZ1
* LV-MaxSonar-EZ2
* LV-MaxSonar-EZ3
* LV-MaxSonar-EZ4

### Sharp
* GP2D120XJ00F
* GP2Y0A02YK0F

## Supporting More Sensors
Quick guide for adding more distance sensors to the library. If the instructions don't make sense then take a look at the source code for one of the existing sensor classes, or create a new issue with the "new distance sensor" label.

###The Class
* Should be called `org.robockets.distancesensorlib.<MANUFACTURER>.<MODELNAME>`
  * For example, the Sharp GP2D120XJ00F would be `org.robockets.distancesensorlib.sharp.GP2D120XJ00F`
* Should extend `org.robockets.distancesensorlib.DistanceSensor`

###The Constructor
* Should include a call to `super(AnalogInput)`
* Should at the very least take an `edu.wpi.first.wpilibj.AnalogInput` for an argument. More arguments can be used if the sensor needs more information

###The `getDistance...()` Methods
* The method that calculates the distance from a voltage value should be the method for the unit of measurement that the sensors datasheet uses
  * For example, the [Sharp GP2D120XJ00F datasheet](https://www.sparkfun.com/datasheets/Sensors/Infrared/GP2D120XJ00F_SS.pdf) uses centimeters, so [`getDistanceCentimeters()`](https://github.com/Team4761/DistanceSensorLib/blob/master/src/main/java/org/robockets/distancesensorlib/sharp/GP2D120XJ00F.java#L23) is the method that does all the hard work
* The other method should use `org.robockets.distancesensorlib.DistanceMeasurementConverter` to convert the value from the previous method and return that
  * Since the [Sharp GP2D120XJ00F datasheet](https://www.sparkfun.com/datasheets/Sensors/Infrared/GP2D120XJ00F_SS.pdf) uses centimeters instead of inches, the [`getDistanceInches()`](https://github.com/Team4761/DistanceSensorLib/blob/master/src/main/java/org/robockets/distancesensorlib/sharp/GP2D120XJ00F.java#L33) method simply calls `getDistanceCentimeters()` and converts that to inches

###The Documentation
* At the very least, add a Javadoc for the class with the sensor's range, the formula being used to calculate distances, and a link to a datasheet.

###The Tests
* Please add a class with JUnit tests for your sensor. You should at least add one test that gives your class different voltage values and checks the returned value
  * [Example](https://github.com/Team4761/DistanceSensorLib/blob/master/src/test/java/org/robockets/distancesensorlib/sharp/TestGP2Y0A02YK0F.java) of using Mockito to test `AnalogInput`s without an actual robot.
* File for the test class should be in the same package as the main class, but in the [test](https://github.com/Team4761/DistanceSensorLib/tree/master/src/test/java/org/robockets/distancesensorlib) directory instead of [main](https://github.com/Team4761/DistanceSensorLib/tree/master/src/main/java/org/robockets/distancesensorlib)
* The test class should have the same name as the main class it tests, but with the word `Test` on the beginning
