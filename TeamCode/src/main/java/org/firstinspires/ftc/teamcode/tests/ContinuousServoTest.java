package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.core.GamepadButton;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@Autonomous(name = "ContinuousServoTest", group = "Tests")

public final class ContinuousServoTest extends RobotOpMode {

    public void runOpMode(){
        startRobot();
        CRServo servo = hardwareMap.crservo.get("servo");

        waitForStart();
        while(opModeIsActive()){
            if(ui1.checkButtonHold(GamepadButton.A)){
                servo.setPower(1);
            }
            if(ui1.checkButtonHold(GamepadButton.B)){
                servo.setPower(-1);
            }
            if(ui1.checkButtonHold(GamepadButton.X)){
                servo.setPower(0);
            }
        }
    }
}
