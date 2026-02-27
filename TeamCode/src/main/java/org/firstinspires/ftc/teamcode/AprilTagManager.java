package org.firstinspires.ftc.teamcode;


import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;



public class AprilTagManager {

    private Position cameraPosition = new Position(DistanceUnit.INCH, 0, 0, 0, 0);
    private YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES, 0, -90, 0, 0);

    private AprilTagProcessor april;
    private VisionPortal vision;

    private List<AprilTagDetection> currentDetections;

    public AprilTagManager() {
        initAprilTag();
    }

    private void initAprilTag() {
        //create
        april = new AprilTagProcessor.Builder()
            .setCameraPose(cameraPosition, cameraOrientation)
            .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();
        //builder.setCamera() figure out what kind of camera we have
        builder.addProcessor(april);
        vision = builder.build();
    }

    public void updateDetections() {
        currentDetections = april.getDetections();
    }

    private int getCameraTurn() { //how much the camera needs to turn by in order to stay focused on an april tag
        //figure out which detection is the most accurate
        AprilTagDetection best = null;

        for (AprilTagDetection tag : currentDetections) {
            if (best != null) {
                
                if (tag.decisionMargin > best.decisionMargin) {
                    best = tag;
                }

            } else {
                best = tag;
            }
        }
        
        return best.ftcPose.bearing; //check if this rotates the correct way
    }
}