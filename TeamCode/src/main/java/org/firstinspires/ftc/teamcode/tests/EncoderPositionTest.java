package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "Encoder Position Test", group = "Tests")

public final class EncoderPositionTest extends RobotOpMode {
    private DcMotor motor = null;
    public void runOpMode(){
        motor = hardwareMap.dcMotor.get("motor");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        int maxim = -1;
        while(opModeIsActive()){
            setStatus("running");
            motor.setPower(1000000);
            maxim = Math.max(maxim, motor.getCurrentPosition());
            telemetry.addData("Pozitie", motor.getCurrentPosition());
            telemetry.addData("maxim", maxim);
            telemetry.update();
        }

    }
}
