package org.firstinspires.ftc.teamcode.sean;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * An OpMode containing only code to run a drive of two solid wheels.
 * The motors should be named <code>left</code> and <code>right</code> in the configuration.
 * This can be run standalone, or it can be extended.
 * If it is extended, the child OpMode’s <code>init</code> and <code>loop</code> methods
 * <i>must</i> call <code>super.init()</code> and <code>super.loop()</code> respectively.
 */
// This OpMode REQUIRES TankDrive.java to be in the same folder as it!
@TeleOp
public class TwoWheelDrive extends TankDrive {
    @Override
    public void init() {
        left = new DcMotor[] {
                hardwareMap.get(DcMotor.class, "left")
        };
        right = new DcMotor[] {
                hardwareMap.get(DcMotor.class, "right")
        };
    }
}
