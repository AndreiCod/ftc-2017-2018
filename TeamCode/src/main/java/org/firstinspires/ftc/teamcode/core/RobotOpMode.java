package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public abstract class RobotOpMode extends OpMode {
    protected final Hardware hw;

    protected RobotOpMode() {
        hw = new Hardware(hardwareMap);
    }

    protected void setStatus(String msg) {
        telemetry.addData("Status", msg);
    }

    protected void update() {
        telemetry.update();
    }
}
