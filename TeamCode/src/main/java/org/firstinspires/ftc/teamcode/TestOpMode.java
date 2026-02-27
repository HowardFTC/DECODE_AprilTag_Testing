package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class TestOpMode extends LinearOpMode {
    
    private AprilTagManager april;
    private Robot robot;

    @Override
    public void runOpMode() {
        april = new AprilTagManager();
        robot = new Robot();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {

            april.updateDetections();
            robot.turnCamera(april.getCameraTurn());
        }
    }
}