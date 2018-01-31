package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public final class Hardware {
    public final Motors motors;
    public final Sensors sensors;
    public final Servos servos;

    private final VoltageSensor voltageSensor;
    private double voltage = 12;

    public Hardware(HardwareMap map) {
        motors = new Motors(map);
        sensors = new Sensors(map);
        servos = new Servos(map);
        voltageSensor = map.voltageSensor.iterator().next();
    }

    public double getVoltage() {
        return voltage;
    }

    public void resetVoltage() {
        voltage = voltageSensor.getVoltage();
    }
}
