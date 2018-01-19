package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "Gyro Test", group = "Tests")


public final class GyroTest extends RobotOpMode {

    @Override
    public void runOpMode(){

        startRobot();

        robot.sensors.calibrate();
        while (robot.sensors.calibrating()){
            setStatus("Gyro calibrating");
            update();
        }

        setStatus("Gyro calibrated");

        waitForStart();

        while (opModeIsActive()){
            int heading = robot.sensors.getHeading();

            telemetry.addData("Gyro", heading);
            update();
        }
    }
}
