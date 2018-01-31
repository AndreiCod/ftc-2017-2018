package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.systems.CubesDrop;
import org.firstinspires.ftc.teamcode.systems.CubesIntake;
import org.firstinspires.ftc.teamcode.systems.CubesLift;
import org.firstinspires.ftc.teamcode.systems.Drive;
import org.firstinspires.ftc.teamcode.systems.Jew;

import java.util.concurrent.TimeUnit;

public abstract class RobotOpMode extends LinearOpMode {
    protected Hardware robot;
    protected UI ui1, ui2;
    protected Drive drive;
    protected CubesIntake cubesIntake;
    protected CubesDrop cubesDrop;
    protected CubesLift cubesLift;
    protected Jew jew;

    public void startRobot() {
        robot = new Hardware(hardwareMap);

        ui1 = new UI(gamepad1);
        ui2 = new UI(gamepad2);

        drive = new Drive(robot.motors, robot.sensors);

        cubesIntake = new CubesIntake(robot.motors);
        cubesDrop = new CubesDrop(robot.servos);
        cubesLift = new CubesLift(robot.servos);

        jew = new Jew(robot);

        // Re-read battery voltage.
        robot.resetVoltage();
    }

    private boolean isRunning = true;

    public void waitForMs(long milliseconds) {
        ElapsedTime timer = new ElapsedTime();
        while (timer.milliseconds() <= milliseconds && isRunning) {
            setStatus("Sleeping...");
            update();
        }
    }


    public ElapsedTime runtime = new ElapsedTime();

    public void resetTime(){
        runtime.reset();
    }

    public double getTime(){
        return runtime.time(TimeUnit.MILLISECONDS);
    }

    protected void setStatus(String msg) {
        telemetry.addData("Status", msg);
    }

    protected void update() {
        telemetry.update();
    }

    public double getPowerConstant() {
        return 12 / robot.getVoltage();
    }
}
