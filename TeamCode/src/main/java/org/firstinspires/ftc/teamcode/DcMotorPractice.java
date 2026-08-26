package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class DcMotorPractice extends OpMode {
    TestBench bench = new TestBench();
    @Override
    public void init() {
        bench.init(hardwareMap);
    }
    public void loop() {
//        if (gamepad2.a) {
//            bench.setMotorSpeed(0.5);
//        }
//        else {
//            bench.setMotorSpeed(0.0);
//        }
        double motorSpeed = gamepad2.left_stick_y;
        bench.setMotorSpeed(motorSpeed);
    }

}
