package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class AutoOpMode extends RobotOpMode {
    protected Sensors sensors;

    protected AutoOpMode() {
        super();
        sensors = new Sensors(hardwareMap);
    }

    private boolean isRunning = true;

    public void sleep(long milliseconds) {
        ElapsedTime timer = new ElapsedTime();
        while (timer.milliseconds() <= milliseconds && isRunning) {
            setStatus("Sleeping...");
        }
    }
}
