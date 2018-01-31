package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.core.Servos;

public final class CubesDrop {
    private Servos servo;

    public CubesDrop(Servos servo){this.servo = servo;}

    public void setPower(double power){
        if(power <= 0.25 && power >= -0.25) power = 0;
        if(power < -0.25) power = -1;
        if(power > 0.25) power = 1;

        servo.leftDropServo.setPower(power);
        servo.rightDropServo.setPower(power);
    }

    public void drop(Gamepad gp){
        setPower(gp.right_trigger - gp.left_trigger);
    }

}
