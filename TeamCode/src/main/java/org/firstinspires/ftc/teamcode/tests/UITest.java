package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.GamepadButton;
import org.firstinspires.ftc.teamcode.core.UI;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name="UI Test", group ="Tests")
public final class UITest extends OpMode {
    private UI ui1, ui2;

    @Override
    public void init() {
        ui1 = new UI(gamepad1);
        ui2 = new UI(gamepad2);
    }

    @Override
    public final void loop() {
        //driveWithGamepad();

        for (GamepadButton button : GamepadButton.values()) {
            boolean pressed = ui1.checkButtonToggle(button);
            telemetry.addData(button.toString(), String.valueOf(pressed));
        }

        // Do not call telemetry.update, automatically called by FTC.
    }
}
