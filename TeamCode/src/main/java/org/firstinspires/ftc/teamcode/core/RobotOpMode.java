package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.Drive;

public abstract class RobotOpMode extends LinearOpMode {
    protected Hardware robot;
    protected UI ui1, ui2;
    protected Drive drive;

    public void startRobot() {
        robot = new Hardware(hardwareMap);

        ui1 = new UI(gamepad1);
        ui2 = new UI(gamepad2);

        drive = new Drive(robot.motors);
    }

    private boolean isRunning = true;

    public void waitForMs(long milliseconds) {
        ElapsedTime timer = new ElapsedTime();
        while (timer.milliseconds() <= milliseconds && isRunning) {
            setStatus("Sleeping...");
            update();
        }
    }


    protected void setStatus(String msg) {
        telemetry.addData("Status", msg);
    }

    protected void update() {
        telemetry.update();
    }

}
