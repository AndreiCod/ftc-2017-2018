package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public final class Servos {

    private final HardwareMap map;
    public CRServo leftLiftServo;
    public CRServo rightLiftServo;
    public CRServo leftDropServo;
    public CRServo rightDropServo;
    public Servo jewServo;

    private CRServo initCRServo(String name, DcMotorSimple.Direction direction){
        CRServo crServo = map.crservo.get(name);

        crServo.setPower(0);

        crServo.setDirection(direction);

        return crServo;
    }

    private Servo initServo(String name){
        Servo servo = map.servo.get(name);
        servo.setPosition(0);

        return servo;
    }

    Servos(HardwareMap map) {
        this.map = map;
        leftLiftServo = initCRServo("leftLiftServo", DcMotorSimple.Direction.FORWARD);
        rightLiftServo = initCRServo("rightLiftServo", DcMotorSimple.Direction.REVERSE);
        leftDropServo = initCRServo("leftDropServo", DcMotorSimple.Direction.FORWARD);
        rightDropServo = initCRServo("rightDropServo", DcMotorSimple.Direction.REVERSE);
        jewServo = initServo("jewServo");
    }
}
