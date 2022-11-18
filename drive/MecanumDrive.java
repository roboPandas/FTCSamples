package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * An OpMode containing only code to run a drive of four mecanum wheels.
 * The motors should be named <code>frontLeft</code>, <code>frontRight</code>,
 * <code>backLeft</code>, and <code>backRight</code> in the configuration.
 * This can be run standalone, or it can be extended.
 * If it is extended, the child OpMode’s <code>init</code> and <code>loop</code> methods
 * <i>must</i> call <code>super.init()</code> and <code>super.loop()</code> respectively.
 */
@TeleOp
public class MecanumDrive extends OpMode {
    /**
     * Reduces the power of the whole drivetrain by the given factor.
     * Must be between -1 and 1.
     * If this is negative, the wheels will have their directions reversed, which is sometimes necessary.
     */
    private static final double SCALE_FACTOR = -0.8;
    private static final int[][] MULTIPLIERS = {
            {+1, +1},
            {+1, -1},
            {-1, +1},
            {-1, -1}
    }; // z doesn't need a multiplier since everything is +1
    private DcMotor[] all;

    @Override
    public void init() {
        all = new DcMotor[] {
                hardwareMap.get(DcMotor.class, "frontLeft"),
                hardwareMap.get(DcMotor.class, "frontRight"),
                hardwareMap.get(DcMotor.class, "backLeft"),
                hardwareMap.get(DcMotor.class, "backRight")
        };
    }

    @Override
    public void loop() {
        double x = -gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double z = -gamepad1.right_stick_x;

        double total = Math.abs(x) + Math.abs(y) + Math.abs(z);

        if (total == 0) { // prevent division by 0
            for (DcMotor motor : all) motor.setPower(0);
            return;
        }

        // Adjust input to never exceed 1
        double factor = Math.max(Math.hypot(x, y), Math.abs(z)) * SCALE_FACTOR / total;
        for (int i = 0; i < 4; i++) all[i].setPower(
                ((MULTIPLIERS[i][0] * x) + (MULTIPLIERS[i][1] * y) + z) * factor
        );
    }
}
