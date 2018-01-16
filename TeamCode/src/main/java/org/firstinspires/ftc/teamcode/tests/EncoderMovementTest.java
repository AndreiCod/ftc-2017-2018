package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous (name = "Encoder Movement Test", group = "Autonomous")
public final class EncoderMovementTest extends RobotOpMode {

    @Override
    public void runOpMode(){
        startRobot();
        setStatus("pornim");
        update();
        waitForMs(1000);

        drive.moveToPosition("forwards", 50);
        setStatus("suntem pe drum");
        update();
        robot.motors.setPower(1, 1,1, 1);
        while(robot.motors.backRight.isBusy() && robot.motors.backLeft.isBusy() && robot.motors.frontRight.isBusy() && robot.motors.frontLeft.isBusy());
        robot.motors.setPower(0, 0, 0, 0);
        setStatus("pornim spre stanga");
        waitForMs(5000);
        update();
        drive.moveToPosition("left", 50);
        robot.motors.setPower(1, 1,1, 1);
        while(robot.motors.backRight.isBusy() && robot.motors.backLeft.isBusy() && robot.motors.frontRight.isBusy() && robot.motors.frontLeft.isBusy());
        robot.motors.setPower(0, 0, 0, 0);
        setStatus("am ajuns");
        update();

        waitForStart();

        while(opModeIsActive()){

        }

    }
}
