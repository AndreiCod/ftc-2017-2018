package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.core.Servos;

public final class CubesLift {
    private Servos servo;

    public CubesLift(Servos servo){this.servo = servo;}

    private void setPower(double power){
        servo.leftLiftServo.setPower(power);
        servo.rightLiftServo.setPower(power);
    }

    public void lift(Gamepad pula){
        if(pula.a){
            setPower(1);
            return;
        }
        if(pula.b) {
            setPower(-1);
            return;
        }

        setPower(0);
    }
}
