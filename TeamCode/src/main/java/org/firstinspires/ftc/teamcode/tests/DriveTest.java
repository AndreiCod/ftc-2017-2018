package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.DriveOpMode;

@TeleOp(name="Basic: Linear OpMode", group="Tests")
public final class DriveTest extends DriveOpMode {
    @Override
    public void loop() {
        driveWithGamepad();
    }
}
