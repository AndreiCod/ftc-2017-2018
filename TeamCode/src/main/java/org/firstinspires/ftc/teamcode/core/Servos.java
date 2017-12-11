package org.firstinspires.ftc.teamcode.core;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public final class Servos {
    /// Servos for cube grabber.
    ///private final Servo[] cube;

    private Servo bottomLeftServo = null;
    private Servo bottomRightServo = null;
    private Servo upperLeftServo = null;
    private Servo upperRightServo = null;

    Servos(HardwareMap map) {
        //cube = new Servo[4];

        bottomLeftServo = map.servo.get("bottomLeftServo");
        bottomRightServo = map.servo.get("bottomRightServo");
        upperLeftServo = map.servo.get("upperLeftServo");
        upperRightServo = map.servo.get("upperRightServo");

        /*for (int i = 0; i < 4; ++i)
            cube[i] = map.servo.get("cubeServo" + i);

        for (int i = 0; i < 2; ++i)
            cube[i].setDirection(Servo.Direction.REVERSE);
        */
    }

    public void grabUpperServos(){
        upperRightServo.setPosition(0);
        upperLeftServo.setPosition(0);
    }

    public void releaseUpperServos(){
        upperRightServo.setPosition(0);
        upperLeftServo.setPosition(0);
    }

    public void grabBottomServos(){
        bottomRightServo.setPosition(0);
        bottomLeftServo.setPosition(0);
    }

    public void releaseBottomServos(){
        bottomRightServo.setPosition(0);
        bottomLeftServo.setPosition(0);
    }

    /*public void setCubeServos(double position) {
        for (Servo s : cube) {
            s.setPosition(position);
        }
    }*/

}
