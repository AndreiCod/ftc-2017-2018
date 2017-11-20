package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public final class Motors {
    private final HardwareMap map;
    public final DcMotor frontLeft;
    public final DcMotor frontRight;
    public final DcMotor backLeft;
    public final DcMotor backRight;

    public static void setEncoderMode(DcMotor motor, boolean withEncoder) {
        if (withEncoder)
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        else
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    private DcMotor initMotor(String name) {
        DcMotor motor = map.dcMotor.get(name);

        motor.setPower(0);

        return motor;
    }

    Motors(HardwareMap map) {
        this.map = map;
        frontLeft = initMotor("frontLeftMotor");
        frontRight = initMotor("frontRightMotor");
        backLeft = initMotor("backLeftMotor");
        backRight = initMotor("backRightMotor");
    }
}
