package org.firstinspires.ftc.teamcode;

public class Robot {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public Robot() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRight = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeft = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRight = hardwareMap.get(DcMotor.class, "backRightMotor");

    }

    

    public void driveTo(Pose3D position) {
        //TODO
    }

    public void driveTo(YawPitchRollAngles orient) {
        //TODO
    }

    public void driveTo(Position position) {
        //TODO
    }

    public DcMotor getFrontLeftMotor() {
        return frontLeft;
    }

    public DcMotor getFrontRightMotor() {
        return frontRight;
    }

    public DcMotor getBackLeftMotor() {
        return backLeft;
    }

    public DcMotor getBackRightMotor() {
        return backRight;
    }

}