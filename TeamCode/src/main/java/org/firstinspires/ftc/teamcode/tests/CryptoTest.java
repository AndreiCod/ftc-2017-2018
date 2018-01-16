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


    private CryptoboxDetector backCryptoboxDetector = null;

    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        backCryptoboxDetector = new CryptoboxDetector();
        backCryptoboxDetector.init(hardwareMap.appContext, CameraViewDisplay.getInstance(), 0);

        backCryptoboxDetector.rotateMat = false;
        backCryptoboxDetector.detectionMode = CryptoboxDetector.CryptoboxDetectionMode.BLUE;
        //Optional Test Code to load images via Drawables
        //cryptoboxDetector.useImportedImage = true;
        //cryptoboxDetector.SetTestMat(com.qualcomm.ftcrobotcontroller.R.drawable.test_cv4);


        backCryptoboxDetector.enable();

        waitForStart();
        runtime.reset();
        while(opModeIsActive()){
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("isCryptoBoxDetected", backCryptoboxDetector.isCryptoBoxDetected());
            telemetry.addData("isColumnDetected ",  backCryptoboxDetector.isColumnDetected());

            telemetry.addData("Column Left ",  backCryptoboxDetector.getCryptoBoxLeftPosition());
            telemetry.addData("Column Center ",  backCryptoboxDetector.getCryptoBoxCenterPosition());
            telemetry.addData("Column Right ",  backCryptoboxDetector.getCryptoBoxRightPosition());

            telemetry.update();
        }

        backCryptoboxDetector.disable();
        telemetry.update();
    }
}
