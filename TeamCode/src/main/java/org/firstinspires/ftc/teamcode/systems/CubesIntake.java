package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.Motors;

public final class CubesIntake {
    private Motors motors;

    public CubesIntake(Motors motors) {
        this.motors = motors;
    }

    private double computePower(double power){
        double bestPower = 0;
        for(double i = -1.0; i <= 1.0; i += 0.5){
            if(Math.abs(power - i) < Math.abs(power - bestPower)) bestPower = i;
        }

        return bestPower;
    }
    public void intake(Gamepad plebea){
        double leftPower = plebea.left_stick_y;
        double rightPower = plebea.right_stick_y;
        leftPower = computePower(leftPower);
        rightPower = computePower(rightPower);
        motors.intakeMotors(leftPower, rightPower);
    }

    public void open(Gamepad ochinchin){
        if(ochinchin.x){
            motors.intakeOpen.setPower(1);
            return;
        }
        if(ochinchin.y){
            motors.intakeOpen.setPower(-1);
            return;
        }

        motors.intakeOpen.setPower(0);
    }
}
