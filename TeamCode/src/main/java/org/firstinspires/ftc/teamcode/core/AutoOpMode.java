package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class AutoOpMode extends RobotOpMode {
    protected Sensors sensors;

    protected AutoOpMode() {
        sensors = new Sensors(hardwareMap);
    }

    @Override
    public void init() {}

    public void runOpMode() {}

    public void sleep(long milliseconds) {
        ElapsedTime timer = new ElapsedTime();
        while (timer.milliseconds() <= milliseconds && ) {
            setStatus("Sleeping...");
        }
    }
}
