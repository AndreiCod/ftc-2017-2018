package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public final class Sensors {
    private GyroSensor gyro;
    Sensors(HardwareMap map) {
        gyro = map.gyroSensor.get("gyro");
    }
}
