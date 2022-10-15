package org.firstinspires.ftc.teamcode.sean;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * An OpMode containing only code to run a drive of four solid wheels.
 * The motors should be named <code>frontLeft</code>, <code>frontRight</code>,
 * <code>backLeft</code>, and <code>backRight</code> in the configuration.
 * This can be run standalone, or it can be extended.
 * If it is extended, the child OpMode’s <code>init</code> and <code>loop</code> methods
 * <i>must</i> call <code>super.init()</code> and <code>super.loop()</code> respectively.
 */
// This OpMode REQUIRES TankDrive.java to be in the same folder as it!
@TeleOp
public class FourWheelDrive extends TankDrive {
    @Override
    public void init() {
        left = new DcMotor[] {
                hardwareMap.get(DcMotor.class, "frontLeft"),
                hardwareMap.get(DcMotor.class, "backLeft")
        };
        right = new DcMotor[] {
                hardwareMap.get(DcMotor.class, "frontRight"),
                hardwareMap.get(DcMotor.class, "backRight")
        };
    }
}