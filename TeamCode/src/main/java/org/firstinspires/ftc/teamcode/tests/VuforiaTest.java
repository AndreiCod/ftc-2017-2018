package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name="Vuforia Test", group ="Tests")
public class VuforiaTest extends LinearOpMode {
    VuforiaLocalizer vuforia;

    @Override public void runOpMode() {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AVVjWu3/////AAAAGdsr5gBC+UssmiGXoEvaSklmeAVfXdWZjUNR2gbOBgC0kp6Do6J3i1FIgwwlpWTgUgGtotRa+mZH5uJSNVWk5T8UMU7p38lmYOGRFOD5pXXJen9S2ltuwpR4C1QWHxQTHDxP6ubRgdEHj1K2Qhpw82ZPllmN7ZsAUacC7/AyPakH1L2O8aw7KBQr98D8HMPIC3GLuJQ2ZzWCNcll+LvP6YmIZcwH0U6CtwgDUTsVpJvcR2QFvFhbh972AAMZ2b7vuNmubrDHizY11qWico+9ovgN5ADLi2IztLhNZG3MLQLrsOa0wAKt4yMKPk2uV8JCTTVkZeqBhKaIPZMRTQuP3Lcvrco5PAi6jVRZ4WhGXhHc";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);

        waitForStart();

        relicTrackables.activate();

        while (opModeIsActive()) {

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

            if (vuMark == RelicRecoveryVuMark.UNKNOWN){
                telemetry.addData("Este orb", "saracu");
            }

            if (vuMark == RelicRecoveryVuMark.CENTER){
                telemetry.addData("Pe centru", "ca daca e stramb e rau");
            }

            if (vuMark == RelicRecoveryVuMark.LEFT){
                telemetry.addData("Stangaci", "baiatu");
            }
            if (vuMark == RelicRecoveryVuMark.RIGHT){
                telemetry.addData("E dreptaci", "baiatu");
            }

            telemetry.update();
        }
    }
}
