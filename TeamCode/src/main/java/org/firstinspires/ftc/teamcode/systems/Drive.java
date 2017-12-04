package org.firstinspires.ftc.teamcode.systems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.Motors;

import static org.firstinspires.ftc.teamcode.core.Utility.clamp1;

public final class Drive {
    private Motors motors;

    public Drive(Motors motors) {
        this.motors = motors;
    }

    /// @param x gamepad1 X
    /// @param y gamepad1 y
    /// @param z gamepad2 x
    public void driveWithGamepad(double x, double y, double z) {
        motors.setPower(
                y - x + z,
                y + x - z,
                y + x + z,
                y - x - z
        );
    }

    public void printStatistics(Telemetry telemetry) {
        motors.printPower(telemetry);
    }
}
