
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "Pinpoint Test", group = "Testing")

public class PinpointTest extends OpMode {

    private GoBildaPinpointDriver pinpoint;

    @Override
    public void init() {

        pinpoint = hardwareMap.get(
                GoBildaPinpointDriver.class,
                "pinpoint"
        );

        pinpoint.resetPosAndIMU();

        telemetry.addLine("Pinpoint Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {

        // Update Pinpoint
        pinpoint.update();

        // Get position
        Pose2D pose = pinpoint.getPosition();

        // Extract values
        double x = pose.getX(DistanceUnit.MM);
        double y = pose.getY(DistanceUnit.MM);
        double heading = pose.getHeading(AngleUnit.DEGREES);

        // Send readings to Driver Hub
        telemetry.addLine("===== PINPOINT TEST =====");

        telemetry.addData("X Position", "%.2f mm", x);
        telemetry.addData("Y Position", "%.2f mm", y);
        telemetry.addData("Heading", "%.2f degrees", heading);

        telemetry.addData("Status", "Receiving Data");

        telemetry.update();
    }
}

