package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@TeleOp(name = "CompleteDriveTest", group = "Tests")
public final class CompleteDriveTest extends RobotOpMode {

    @Override
    public void runOpMode(){
        startRobot();

        robot.motors.setEncoders(false);

        waitForStart();

        while(opModeIsActive()) {
            // DRIVE
            drive.driveWithGamepad(gamepad1);

            robot.motors.printPower(telemetry);

            //CUBES INTAKE
            cubesIntake.intake(gamepad2);

            //CUBES DROP
            cubesDrop.drop(gamepad2);

            telemetry.addData("power", gamepad2.right_trigger - gamepad2.left_trigger);
            telemetry.update();
            //CUBES LIFT
            cubesLift.lift(gamepad2);

            //CUBES OPEN

            cubesIntake.open(gamepad2);
     }
    }
}
