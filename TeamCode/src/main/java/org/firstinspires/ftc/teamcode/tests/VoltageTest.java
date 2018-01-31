package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "Voltage Test", group = "Tests")
public final class VoltageTest extends RobotOpMode {
    @Override
    public void runOpMode() {
        startRobot();

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Voltage", robot.getVoltage());
            update();
        }
    }
}
