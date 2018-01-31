package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.Motors;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;
import org.firstinspires.ftc.teamcode.systems.CubesIntake;

@Autonomous (name = "Intake Test", group = "Tests")
public final class IntakeTest extends RobotOpMode {

    @Override
    public void runOpMode(){
        startRobot();

        waitForStart();

        while (opModeIsActive()){
            cubesIntake.intake(gamepad2);
        }
    }
}
