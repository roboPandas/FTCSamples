package org.firstinspires.ftc.teamcode.sean;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * An OpMode containing only code to run a drive of pairs of non-holonomic wheels.
 * A child OpMode’s <code>init</code> method must follow the specifications given in {@link #init()}.
 */
public abstract class TankDrive extends OpMode {
    /**
     * Reduces the power of the whole drivetrain by the given factor.
     * Must be between -1 and 1.
     * If this is negative, the wheels will have their directions reversed, which is sometimes necessary.
     */
    private static final double SCALE_FACTOR = -0.8;
    /** An array of all motors on the left side of the drivetrain. */
    protected DcMotor[] left;
    /** An array of all motors on the right side of the drivetrain. */
    protected DcMotor[] right;

    /**
     * This method must initialize {@link #left} and {@link #right}
     * with all motors on the left and right side (respectively) of the drivetrain.
     */
    @Override
    public abstract void init();

    /**
     * Checks the input of the left joystick’s vertical direction (for forward motion)
     * and the right joystick’s horizontal direction (for turning) and sets the motors to the necessary powers.
     */
    @Override
    public void loop() {
        double y = gamepad1.left_stick_y;
        double z = -gamepad1.right_stick_x;

        double total = Math.abs(y) + Math.abs(z);

        if (total == 0) { // prevent division by 0
            for (DcMotor motor : left) motor.setPower(0);
            for (DcMotor motor : right) motor.setPower(0);
            return;
        }

        // Adjust input to never exceed 1
        double factor = Math.hypot(z, y) * SCALE_FACTOR / total;
        for (DcMotor motor : left) motor.setPower((z + y) * factor);
        for (DcMotor motor : right) motor.setPower((z - y) * factor);
    }
}
