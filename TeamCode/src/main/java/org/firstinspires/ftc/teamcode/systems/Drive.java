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
    private Motors motors;

    public Drive(Motors motors) {
        this.motors = motors;
    }

    /// @param x gamepad1 left X
    /// @param y gamepad1 left y
    /// @param z gamepad1 right x

    public void driveWithGamepad(Gamepad driver) {
        double x, y, z;

        x = -driver.left_stick_x;
        y = -driver.left_stick_y;
        z = -driver.right_stick_x;
        
        motors.setPower(
                y - x - z,
                y + x + z,
                y + x - z,
                y - x + z
        );
    }


    public void printStatistics(Telemetry telemetry) {
        motors.printPower(telemetry);
    }
}
