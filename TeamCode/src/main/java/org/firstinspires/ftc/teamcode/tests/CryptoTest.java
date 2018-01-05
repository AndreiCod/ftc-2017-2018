package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.core.RobotOpMode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.detectors.*;
import com.qualcomm.robotcore.util.ElapsedTime;


import java.io.IOException;


@Autonomous(name = "CryptoTest", group = "tests")
public class CryptoTest extends RobotOpMode {
    private ElapsedTime runtime = new ElapsedTime();


    private CryptoboxDetector cryptoboxDetector = null;

    public void runOpMode(){
        telemetry.addData("Status", "Initialized");


        cryptoboxDetector = new CryptoboxDetector();
        cryptoboxDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance());

        cryptoboxDetector.rotateMat = false;

        //Optional Test Code to load images via Drawables
        //cryptoboxDetector.useImportedImage = true;
        //cryptoboxDetector.SetTestMat(com.qualcomm.ftcrobotcontroller.R.drawable.test_cv4);

        cryptoboxDetector.enable();

        waitForStart();
        runtime.reset();
        while(opModeIsActive()){
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("isCryptoBoxDetected", cryptoboxDetector.isCryptoBoxDetected());
            telemetry.addData("isColumnDetected ",  cryptoboxDetector.isColumnDetected());

            telemetry.addData("Column Left ",  cryptoboxDetector.getCryptoBoxLeftPosition());
            telemetry.addData("Column Center ",  cryptoboxDetector.getCryptoBoxCenterPosition());
            telemetry.addData("Column Right ",  cryptoboxDetector.getCryptoBoxRightPosition());
        }


        cryptoboxDetector.disable();
    }
}
