package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;

public final class Motors {
    private final HardwareMap map;
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final DcMotor backLeft;
    private final DcMotor backRight;

    private final static double MAX_POWER = 0.87;

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
        frontRight.setDirection(Direction.REVERSE);
        backLeft = initMotor("backLeftMotor");
        backRight = initMotor("backRightMotor");
        backRight.setDirection(Direction.REVERSE);
    }

    public void setPower(double frontLeft, double frontRight, double backLeft, double backRight) {
        this.frontLeft.setPower(frontLeft * MAX_POWER);
        this.frontRight.setPower(frontRight * MAX_POWER);
        this.backLeft.setPower(backLeft * MAX_POWER);
        this.backRight.setPower(backRight * MAX_POWER);
    }

    public void printPower(Telemetry telemetry) {
        telemetry.addData("Front left", String.valueOf(frontLeft.getPower()));
        telemetry.addData("Front right", String.valueOf(frontRight.getPower()));
        telemetry.addData("Back left", String.valueOf(backLeft.getPower()));
        telemetry.addData("Back right", String.valueOf(backRight.getPower()));
    }
}
