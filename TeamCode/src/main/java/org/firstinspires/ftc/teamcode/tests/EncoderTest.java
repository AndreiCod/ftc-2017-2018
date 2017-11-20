package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.AutoOpMode;

@Autonomous(name = "EncoderTest", group = "Tests")
public class EncoderTest extends OpMode {
    private DcMotor motor;
    private static final int MOTOR_REV = 560;

    @Override
    public void init(){
        motor = hardwareMap.dcMotor.get("Motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void start(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setTargetPosition(MOTOR_REV*5);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
        while(motor.isBusy());
        motor.setPower(0);
    }

    @Override
    public void loop(){}
}
