package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.Motors;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous (name = "Encoder Movement Test", group = "Tests")
public final class EncoderMovementTest extends RobotOpMode {

    private final double P = 0.8, I = 0.3, D = 3;
    @Override
    public void runOpMode(){
        startRobot();
        setStatus("pornim");
        update();

        waitForStart();

        final Motors motors = robot.motors;

        motors.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motors.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //drive.moveToPosition("forwards", 50);
        setStatus("suntem pe drum");
        update();
        motors.drive(1, 1,1, 1);

        while(motors.backRight.isBusy() && motors.backLeft.isBusy() && opModeIsActive()){
            telemetry.addData("backleft", motors.backLeft.getCurrentPosition());
            telemetry.addData("backright", motors.backRight.getCurrentPosition());
            update();
        };

       // telemetry.addData("frontleft", motors.frontLeft.getCurrentPosition());
       // telemetry.addData("frontright", motors.frontRight.getCurrentPosition());

        motors.drive(0, 0, 0, 0);
        sleep(1000);
        setStatus("pornim spre stanga");
        update();

        //drive.moveToPosition("left", 50);
        motors.drive(1, 1,1, 1);

        while(motors.backRight.isBusy() && motors.backLeft.isBusy() && opModeIsActive());
        motors.drive(0, 0, 0, 0);

        //telemetry.addData("frontleft", motors.frontLeft.getCurrentPosition());
        //telemetry.addData("frontright", motors.frontRight.getCurrentPosition());
        telemetry.addData("backleft", motors.backLeft.getCurrentPosition());
        telemetry.addData("backright", motors.backRight.getCurrentPosition());
        update();
        motors.drive(0, 0, 0, 0);
        sleep(1000);

        setStatus("am ajuns");
        /*
        motors.setEncoders(false);
        int current_angle = robot.sensors.getHeading();
        int target_angle = current_angle - 180;
        double error = target_angle - current_angle;
        double lastError = 0;
        double timp = getRuntime();
        while(getRuntime() - timp < 3000 && opModeIsActive()){
            current_angle = robot.sensors.getHeading();
            lastError = error;
            error = target_angle - current_angle;
            double motorCorrection = ( P * error + I*(error + lastError) + D *(error - lastError)) / (180.0 * (P + I + D));
            telemetry.addData("eroare", error);
            telemetry.update();
            motors.correct(motorCorrection);
        }
        update();
        */
    }
}
