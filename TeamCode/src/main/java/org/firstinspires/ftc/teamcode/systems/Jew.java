package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.Hardware;

public final class Jew {
    private final Servo jewServo;
    private final ColorSensor colorSensor;

    public Jew(Hardware hw) {
        this.jewServo = hw.servos.jewServo;
        this.colorSensor = hw.sensors.colorSensor;
    }

    public void setOpen(boolean open) {
        if (open) {
            jewServo.setPosition(1);
        } else {
            jewServo.setPosition(0);
        }
    }

    public double getPosition() {
        return jewServo.getPosition();
    }

    public enum Color {
        RED,
        BLUE,
    }

    public Color getColor() {
        final int red = colorSensor.red();
        final int blue = colorSensor.blue();

        if (blue > red) {
            return Color.BLUE;
        } else {
            return Color.RED;
        }
    }
}
