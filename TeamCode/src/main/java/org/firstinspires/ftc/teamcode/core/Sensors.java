package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public final class Sensors {
    private ModernRoboticsI2cGyro gyro;
    public ColorSensor colorSensor;

    Sensors(HardwareMap map) {
        gyro = (ModernRoboticsI2cGyro)map.gyroSensor.get("gyro");
        gyro.setHeadingMode(ModernRoboticsI2cGyro.HeadingMode.HEADING_CARTESIAN);

        colorSensor = map.colorSensor.get("jewColor");
        colorSensor.enableLed(true);
    }

    public int getHeading(){
        int heading = gyro.getIntegratedZValue();

        return heading;
    }

    public void calibrate(){gyro.calibrate();}

    public boolean calibrating(){
        return gyro.isCalibrating();
    }
}
