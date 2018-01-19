package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;

public final class Motors {
    private final HardwareMap map;
    public final DcMotor frontLeft;
    public final DcMotor frontRight;
    public final DcMotor backLeft;
    public final DcMotor backRight;
    private final static double MAX_POWER = 0.78;

    private final static double TICKS_PER_ROTATION = 1120;
    private final static double WHEEL_CIRCUMFERENCE = 20.32 * Math.PI;
    private final static double RATIO = TICKS_PER_ROTATION / WHEEL_CIRCUMFERENCE;

    private static void setEncoderMode(DcMotor motor, boolean withEncoder) {
        if (withEncoder) {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        else
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setEncoders(boolean withEncoder){
        setEncoderMode(frontLeft, withEncoder);
        setEncoderMode(frontRight, withEncoder);
    }
    private DcMotor initMotor(String name) {
        DcMotor motor = map.dcMotor.get(name);

        motor.setPower(0);

        return motor;
    }

    Motors(HardwareMap map) {
        this.map = map;
        frontLeft = initMotor("frontLeftMotor");
        frontLeft.setDirection(Direction.REVERSE);

        frontRight = initMotor("frontRightMotor");
        frontRight.setDirection(Direction.FORWARD);
        
        backLeft = initMotor("backLeftMotor");
        backLeft.setDirection(Direction.REVERSE);

        backRight = initMotor("backRightMotor");
        backRight.setDirection(Direction.FORWARD);
    }

    public void setPower(double frontLeft, double frontRight, double backLeft, double backRight) {
        final double FRONT_LEFT = 1, FRONT_RIGHT = 1, BACK_LEFT = 1, BACK_RIGHT = 1;
        this.frontLeft.setPower(frontLeft * FRONT_LEFT * MAX_POWER);
        this.frontRight.setPower(frontRight * FRONT_RIGHT * MAX_POWER);
        this.backRight.setPower(backRight * BACK_RIGHT * MAX_POWER);
        this.backLeft.setPower(backLeft * BACK_LEFT * MAX_POWER);
    }

    public void printPower(Telemetry telemetry) {
        telemetry.addData("Front left", String.valueOf(frontLeft.getPower()));
        telemetry.addData("Front right", String.valueOf(frontRight.getPower()));
        telemetry.addData("Back left", String.valueOf(backLeft.getPower()));
        telemetry.addData("Back right", String.valueOf(backRight.getPower()));
    }

    public int getEncoderPosition(DcMotor motor){
        return motor.getCurrentPosition();
    }
}
