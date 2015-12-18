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
