package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;

@TeleOp(name = "IntakePowerTest", group = "Tests")
public final class IntakePowerTest extends RobotOpMode {

    private DcMotor motor1 = null;
    private DcMotor motor2 = null;

    public void runOpMode(){
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");

        motor1.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()){
            double power = gamepad1.right_trigger - gamepad1.left_trigger;
            if(power < 0.1 && power > -0.1) power = 0;
            motor1.setPower(power);
            motor2.setPower(power);
            telemetry.addData("power", power);
            telemetry.update();
        }
    }
}
