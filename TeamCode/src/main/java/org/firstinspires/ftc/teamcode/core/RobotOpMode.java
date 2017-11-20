package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class RobotOpMode extends OpMode {
    protected Hardware hw;

    @Override
    public void init() {
        hw = new Hardware(hardwareMap);
    }

    protected void setStatus(String msg) {
        telemetry.addData("Status", msg);
    }

    protected void update() {
        telemetry.update();
    }
}
