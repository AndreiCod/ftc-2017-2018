package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.core.DriveOpMode;
import org.firstinspires.ftc.teamcode.core.GamepadButton;
import org.firstinspires.ftc.teamcode.systems.Cubes;

@TeleOp(name="Cube Grabber - Servo Test", group="Tests")
public final class CubeTest extends DriveOpMode {
    private Cubes cubes;

    @Override
    public void init() {
        super.init();
        //cubes = new Cubes(hw.servos);
    }

    @Override
    public void loop() {
        //if (ui1.checkButtonToggle(GamepadButton.A))
            //cubes.();
        //else
            //cubes.releaseCube();
    }
}
