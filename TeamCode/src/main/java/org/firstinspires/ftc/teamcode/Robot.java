package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class Robot {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private final double DEGREES_TO_TICKS = 537.7 / 360.0; //this is for 5023 Yellow Jacket, check this

    private DcMotor cameraMotor;

    public Robot() {

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        frontRight = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backLeft = hardwareMap.get(DcMotor.class, "backLeftMotor");
        backRight = hardwareMap.get(DcMotor.class, "backRightMotor");

        cameraMotor = hardwareMap.get(DcMotor.class, "cameraMotor");

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

    public void turnCamera(int degrees) {
        if (degrees > 0) {
            cameraMotor.setPower(1.0);
        } else {
            cameraMotor.setPower(-1.0);
        }

        cameraMotor.setTargetPosition(cameraMotor.getCurrentPosition() + degrees * DEGREES_TO_TICKS);
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