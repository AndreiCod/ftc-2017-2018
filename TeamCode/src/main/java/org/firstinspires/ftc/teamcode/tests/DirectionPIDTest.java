package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.core.Motors;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;



@Autonomous(name = "Direction PID test", group = "Tests")
public final class DirectionPIDTest extends RobotOpMode {



    private final void pid(int targetDirection, double baseSpeed){
        final double P = 2, I = 0.7, D = 12;
        double heading = robot.sensors.getHeading();
        double error = 0, lastError = 0;
        double motorDif = 0;
        double startTime = getTime();

        while (opModeIsActive() && getTime() - startTime<= 2000){
            heading = robot.sensors.getHeading();
            lastError = error;
            error = heading - targetDirection;
            error /= 180;
            error = -error;
            motorDif = (P * error) + (I * (error + lastError) + (D * (error - lastError)));
            robot.motors.setPower(baseSpeed + motorDif, baseSpeed - motorDif, baseSpeed + motorDif, baseSpeed - motorDif);
            telemetry.addData("I WANT TO FUCKING", "KMS");
            telemetry.addData("time", getTime() - startTime);
            telemetry.addData("gyro", heading);
            telemetry.addData("motorCorrection", motorDif);
            robot.motors.printPower(telemetry);
            update();
        }

        robot.motors.setPower(0, 0, 0, 0);
    }


    @Override
    public void runOpMode(){

        startRobot();
        robot.motors.setEncoders(true);

        robot.sensors.calibrate();
        while (robot.sensors.calibrating()){
            setStatus("Gyro calibrating");
            update();
        }

        setStatus("Gyro calibrated");
        update();

        waitForStart();

        resetTime();

//        pid(robot.sensors.getHeading(), 0.6);
//
//        waitForMs(200);

        pid(90, 0);



    }
}

