package org.firstinspires.ftc.teamcode;

public class AprilTagManager {

    private Position cameraPosition = new Position(DistanceUnit.INCH, 0, 0, 0, 0);
    private YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES, 0, -90, 0, 0);

    private AprilTagProcessor april;
    private VisionPortal vision;

    public AprilTagManager() {
        
    }

    private void initAprilTag() {
        //create
        april = new AprilTagProcessor.Builder()
            .setCameraPose(cameraPosition, cameraOrientation);
            .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();

        builder.addProcessor(april);
        vision = builder.build();
    }
}