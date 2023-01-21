package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class DriveSyst {
    private Victor Motor_FLD;
    private Victor Motor_BLD;
    private Victor Motor_FRD;
    private Victor Motor_BRD;

    public DriveSyst() {
        // set up for motors
        this.Motor_FLD = new Victor(RobotConstants.MOTOR_CHANNEL_FLD);
        this.Motor_BLD = new Victor(RobotConstants.MOTOR_CHANNEL_BLD);
        this.Motor_FRD = new Victor(RobotConstants.MOTOR_CHANNEL_FRD);
        this.Motor_BRD = new Victor(RobotConstants.MOTOR_CHANNEL_BRD);

        // set for inversions for motors
        this.Motor_FLD.setInverted(RobotConstants.MOTOR_INVERT_L);
        this.Motor_BLD.setInverted(RobotConstants.MOTOR_INVERT_L);
        this.Motor_FRD.setInverted(RobotConstants.MOTOR_INVERT_R);
        this.Motor_BRD.setInverted(RobotConstants.MOTOR_INVERT_R);
    }

    public void update(double leftDriveStick, double rightDriveStick) {
        this.Motor_BLD.set(leftDriveStick);
        this.Motor_BRD.set(rightDriveStick);
        this.Motor_FLD.set(leftDriveStick);
        this.Motor_FRD.set(rightDriveStick);

    }
}
