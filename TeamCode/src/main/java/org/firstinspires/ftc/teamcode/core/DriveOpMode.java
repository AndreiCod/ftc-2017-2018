package org.firstinspires.ftc.teamcode.core;

import org.firstinspires.ftc.teamcode.systems.Drive;

public abstract class DriveOpMode extends RobotOpMode {
    protected final UI ui1 = new UI(gamepad1), ui2 = new UI(gamepad2);;
    protected final Drive drive = new Drive(hw.motors);

    @Override
    public void init() {}

    protected void driveWithGamepad() {
        double x = ui1.gp.left_stick_x;
        double y = ui1.gp.left_stick_y;
        double z = ui2.gp.right_stick_x;

        drive.driveWithGamepad(x, y, z);
    }
}
