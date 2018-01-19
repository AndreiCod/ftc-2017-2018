package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "Encoder Position Test", group = "Tests")

public final class EncoderPositionTest extends RobotOpMode {
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    public void runOpMode(){
        frontLeft = hardwareMap.dcMotor.get("frontLeftMotor");
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRight = hardwareMap.dcMotor.get("frontRightMotor");
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft = hardwareMap.dcMotor.get("backLeftMotor");
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backRight = hardwareMap.dcMotor.get("backRightMotor");
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        int maxim = -1;
        while(opModeIsActive()){
            setStatus("running");

            telemetry.addData("frontleft", frontLeft.getCurrentPosition());
            telemetry.addData("frontright", frontRight.getCurrentPosition());
            telemetry.addData("backleft", backLeft.getCurrentPosition());
            telemetry.addData("backright", backRight.getCurrentPosition());
            telemetry.update();
        }

    }
}
