package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.DriveOpMode;

@TeleOp(name="Drive Test", group="Tests")
public final class DriveTest extends DriveOpMode {
    @Override
    public void loop() {
        driveWithGamepad();
        drive.printStatistics(telemetry);
        telemetry.update();
    }
}
