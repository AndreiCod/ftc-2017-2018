package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "Encoder Position Test", group = "Tests")

public final class EncoderPositionTest extends RobotOpMode {
    public void runOpMode(){
        startRobot();
        robot.motors.setEncoders(true);
        waitForStart();
        while(opModeIsActive()){
            setStatus("running");
            robot.motors.printPosition(telemetry, 0);
            telemetry.update();
        }

    }
}
