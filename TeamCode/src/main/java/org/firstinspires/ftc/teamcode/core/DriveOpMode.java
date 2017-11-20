package org.firstinspires.ftc.teamcode.core;

import org.firstinspires.ftc.teamcode.systems.Drive;

public abstract class DriveOpMode extends RobotOpMode {
    protected UI ui1, ui2;
    protected Drive drive;

    @Override
    public void init() {
        super.init();

        ui1 = new UI(gamepad1);
        ui2 = new UI(gamepad2);
        drive = new Drive(hw.motors);
    }

    protected void driveWithGamepad() {
        double x = ui1.gp.left_stick_x;
        double y = ui1.gp.left_stick_y;
        double z = ui2.gp.right_stick_x;

        drive.driveWithGamepad(x, y, z);
    }
}
