package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.disnodeteam.dogecv.detectors.GlyphDetector;

@Autonomous(name="GlyphDetector Test", group ="Tests")
public class GlyphDetectorTest extends LinearOpMode {

    @Override public void runOpMode() {
        GlyphDetector detector = new GlyphDetector();
        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("Distanta ", detector.getChosenGlyphOffset());
            telemetry.update();
        }

    }
}
