package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.core.RobotOpMode;
import org.firstinspires.ftc.teamcode.systems.Jew;

@Autonomous(name = "Autonomy Far Red", group = "Autonomies")
final class AutonomyFarRed extends RobotOpMode {
    @Override
    public void runOpMode() {
        startRobot();


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AVVjWu3/////AAAAGdsr5gBC+UssmiGXoEvaSklmeAVfXdWZjUNR2gbOBgC0kp6Do6J3i1FIgwwlpWTgUgGtotRa+mZH5uJSNVWk5T8UMU7p38lmYOGRFOD5pXXJen9S2ltuwpR4C1QWHxQTHDxP6ubRgdEHj1K2Qhpw82ZPllmN7ZsAUacC7/AyPakH1L2O8aw7KBQr98D8HMPIC3GLuJQ2ZzWCNcll+LvP6YmIZcwH0U6CtwgDUTsVpJvcR2QFvFhbh972AAMZ2b7vuNmubrDHizY11qWico+9ovgN5ADLi2IztLhNZG3MLQLrsOa0wAKt4yMKPk2uV8JCTTVkZeqBhKaIPZMRTQuP3Lcvrco5PAi6jVRZ4WhGXhHc";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);



        waitForStart();




        jew.setOpen(true);

        if (jew.getColor() == Jew.Color.RED) {
            drive.rotateTo(+10);
        } else {
            drive.rotateTo(-10);
        }

        jew.setOpen(false);

        drive.rotateTo(90);




        relicTrackables.activate();

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.UNKNOWN;
        resetTime();

        while (opModeIsActive() && vuMark == RelicRecoveryVuMark.UNKNOWN && getTime() < 2000) {
            vuMark = RelicRecoveryVuMark.from(relicTemplate);
        }

        drive.rotateTo(0);
        waitForMs(200);

        switch(vuMark){
            case LEFT:
                drive.driveWithPid(-72.05);
                break;
            case CENTER:
                drive.driveWithPid(-91.44);
                break;
            case RIGHT:
                drive.driveWithPid(-110.82);
                break;
            default:
                drive.driveWithPid(-91.44);
                break;
        }

        waitForMs(200);

        drive.rotateTo(90);

        waitForMs(200);

        cubesDrop.setPower(1);
        waitForMs(200);
        cubesDrop.setPower(0);

    }
}
