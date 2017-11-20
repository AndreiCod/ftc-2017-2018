package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.DriveOpMode;
import org.firstinspires.ftc.teamcode.core.GamepadButtons;

@TeleOp(name="UI Test", group ="Tests")
public final class UITest extends DriveOpMode {
    @Override
    public final void loop() {
        driveWithGamepad();

        for (GamepadButtons button : GamepadButtons.values()) {
            telemetry.addData(button.toString(), ui1.checkButtonToggle(button));
        }

        telemetry.update();

        telemetry.addData("Left Bumper", ui1.gp.left_bumper);
        telemetry.addData("Right Bumper", ui1.gp.right_bumper);

        telemetry.update();
    }
}
