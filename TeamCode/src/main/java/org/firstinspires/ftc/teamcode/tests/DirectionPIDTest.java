package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.GamepadButton;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;
import org.firstinspires.ftc.teamcode.systems.PidUdpReceiver;

@Autonomous(name = "Direction PID test", group = "Tests")
public final class DirectionPIDTest extends RobotOpMode {
    private PidUdpReceiver receiver;

    /*
    private final void pid(int targetDirection, double distance){
        double lastDirectionError = 0;
        double lastPositionError = 0;

        resetTime();

        distance *= RATIO;

        robot.motors.setEncoders(true);

        do {
            double baseSpeed;


            // PID for speed
            {
                final double P = 1, I = 0, D = 0;
                final double P = receiver.getP(),
                        I = receiver.getI(),
                        D = receiver.getD();
                final double currentPosition = robot.motors.frontLeft.getCurrentPosition();
                final double error = (distance - currentPosition) / RATIO;
                final double lastError = lastPositionError;

                baseSpeed = (P * error + I * (error + lastError) + D * (error - lastError));
                telemetry.addData("P", P);
                telemetry.addData("I", I);
                telemetry.addData("D", D);
                telemetry.addData("atractia lui dorix?", currentPosition);
                telemetry.addData("sa rezolvat", error);
                lastPositionError = error;
            }

            telemetry.addData("Base speed", baseSpeed);
            update();

            // PID for drive
            {
                final double P = 0, I = 0, D = 0;
                final double heading = robot.sensors.getHeading();
                final double error = (heading - targetDirection) / 180;
                final double lastError = lastDirectionError;
                final double motorDif = (P * error) + (I * (error + lastError) + (D * (error - lastError)));

                double sum0 = baseSpeed + motorDif;
                double sum1 = baseSpeed - motorDif;

                robot.motors.drive(sum0, sum1, sum0, sum1);

                lastDirectionError = error;
            }

//            telemetry.addData("speed", baseSpeed);
  //          telemetry.update();
        } while (opModeIsActive() && robot.motors.frontLeft.getCurrentPosition() < distance
                                  && robot.motors.frontRight.getCurrentPosition() < distance);

        robot.motors.drive(0, 0, 0, 0);

        sleep(3000);
    }


    private final void rotateTo(int targetAngle){
        //1 0.65 0.3
        //final double P = 0.7, I = 0.67, D = 0.59;
        final double P = 0.7, I = 0.67, D = 0.59;

        double lastError = 0;

        final double startTime = getTime();

        robot.motors.setEncoders(true);

        do {
            final double heading = robot.sensors.getHeading();

            final double error = (heading - targetAngle) / 180;

            double motorDif = (P * error) + (I * (error + lastError) + (D * (error - lastError)));

            motorDif *= getPowerConstant();

            double sum0 = motorDif;
            double sum1 = - motorDif;
            robot.motors.drive(sum0, sum1, sum0, sum1);

            telemetry.addData("error",  error);
            robot.motors.printPower(telemetry);

            telemetry.update();

            lastError = error;

        } while (opModeIsActive() && getTime() - startTime < 5000);

        robot.motors.stop();
    }

    */

    @Override
    public void runOpMode(){
        startRobot();
        robot.motors.setEncoders(true);

        receiver = new PidUdpReceiver();
        receiver.beginListening();

        {
            setStatus("Gyro calibrating");
            update();

            robot.sensors.calibrate();
            while (!isStopRequested() && robot.sensors.calibrating()) {
                sleep(50);
            }

            setStatus("Gyro calibrated");
            update();
        }

        waitForStart();

        resetTime();

        int targetAngle = 0;
        int lastAngle = 0;
        double time1 = 0, time2 = 0, time3 = 0, time4 = 0;
        resetTime();

        final double delay = 250.0;
        while(opModeIsActive()){
            if(ui1.checkButtonHold(GamepadButton.A) && getTime() - time1 > delay){
                targetAngle += 5;
                time1 = getTime();
            }

            if(ui1.checkButtonHold(GamepadButton.X) && getTime() - time2 > delay){
                targetAngle -= 5;
                time2 = getTime();
            }

            telemetry.addData("Current", robot.sensors.getHeading());
            telemetry.addData("Target", targetAngle);
            telemetry.update();

            if(ui1.checkButtonHold(GamepadButton.B) && getTime() - time3 > delay){
                drive.rotateTo(targetAngle);
                time3 = getTime();
            }

            if(ui1.checkButtonHold(GamepadButton.Y) && getTime() - time4 > delay){
                final double P = receiver.getP(),
                    I = receiver.getI(),
                    D = receiver.getD();

                drive.driveWithCustomPid(100, P, I, D);
                waitForMs(1000);
                drive.driveWithCustomPid(-100, P, I, D);
                time4 = getTime();
            }
        }

        receiver.shutdown();
    }
}

