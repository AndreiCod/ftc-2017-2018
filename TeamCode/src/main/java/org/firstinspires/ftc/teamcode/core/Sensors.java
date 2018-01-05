package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.HardwareMap;

public final class Sensors {
    private ModernRoboticsI2cGyro gyro;
    Sensors(HardwareMap map) {
        //gyro = (ModernRoboticsI2cGyro)map.gyroSensor.get("gyro");
        //gyro.setHeadingMode(ModernRoboticsI2cGyro.HeadingMode.HEADING_CARTESIAN);
    }
}
