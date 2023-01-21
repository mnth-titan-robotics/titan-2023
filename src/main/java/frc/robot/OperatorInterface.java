package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInterface {

    private Joystick pilot_joy;
    private Joystick copilot_joy;

    // setting up joysticks
    public OperatorInterface() {
        this.pilot_joy = new Joystick(RobotConstants.JOYSTICK_PORT_PILOT);
        this.copilot_joy = new Joystick(RobotConstants.JOYSTICK_PORT_COPILOT);
    }

    // driver joysticks set up
    public double leftDriveStick() {
        return this.pilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_L) * 0.4;
    }

    public double rightDriveStick() {
        return this.pilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_R) * 0.4;
    }

}
