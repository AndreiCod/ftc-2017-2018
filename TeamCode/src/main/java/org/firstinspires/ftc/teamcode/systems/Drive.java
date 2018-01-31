package org.firstinspires.ftc.teamcode.systems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.Motors;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;
import org.firstinspires.ftc.teamcode.core.Sensors;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;

import static org.firstinspires.ftc.teamcode.core.Utility.clamp1;

public final class Drive{
    private final static double TICKS_PER_MOTOR_ROTATION = 1120;
    private final static double RATIO = 2 * TICKS_PER_MOTOR_ROTATION / 100;

    private Motors motors;
    private Sensors sensors;

    public Drive(Motors motors, Sensors sensors) {
        this.motors = motors;
        this.sensors = sensors;
    }

    /// @param x gamepad1 left X
    /// @param y gamepad1 left y
    /// @param z gamepad1 right x
    public void driveWithGamepad(Gamepad driver) {
        double x, y, z;

        x = -driver.left_stick_x;
        y = -driver.left_stick_y;
        z = -driver.right_stick_x;
        
        motors.drive(
                y - x - z,
                y + x + z,
                y + x - z,
                y - x + z
        );
    }

    public void printStatistics(Telemetry telemetry) {
        motors.printPower(telemetry);
    }

    public void driveWithPid(double distance) {
        final double P = 1, I = 0, D = 0;
        driveWithCustomPid(distance, P, I, D);
    }

    public void driveWithCustomPid(double distance, double P, double I, double D){
        motors.setEncoders(true);
        distance *= RATIO;

        final double targetDirection = sensors.getHeading();
        double sgn = Math.signum(distance);

        distance = Math.abs(distance);

        double lastError = 0;

        while ((distance - Math.abs(motors.frontLeft.getCurrentPosition())) / RATIO > 60) {
            final double heading = sensors.getHeading();
            final double error = (heading - targetDirection) / 180;
            final double motorDif = (P * error) + (I * (error + lastError) + (D * (error - lastError)));

            double sum0 = sgn + motorDif;
            double sum1 = sgn - motorDif;

            sum0 *= 0.7;
            sum1 *= 0.7;

            lastError = error;

            motors.drive(sum0, sum1, sum0, sum1);
        }

        while (Math.abs(motors.frontLeft.getCurrentPosition()) < distance) {
            final double heading = sensors.getHeading();
            final double error = (heading - targetDirection) / 180;
            final double motorDif = (P * error) + (I * (error + lastError) + (D * (error - lastError)));

            double sum0 = sgn + motorDif;
            double sum1 = sgn - motorDif;
            sum0 *= 0.2;
            sum1 *= 0.2;

            lastError = error;

            motors.drive(sum0, sum1, sum0, sum1);
        }


        motors.drive(0, 0, 0, 0);
    }

    public void rotateTo(int daWae){
        int delta = daWae - sensors.getHeading();
        double sgn = Math.signum(delta);
        while(Math.abs(daWae - sensors.getHeading()) < 5){
            motors.drive(-0.2*sgn, 0.2*sgn, -0.2*sgn, 0.2*sgn);
        }

        motors.drive(0, 0, 0, 0);
    }
}
