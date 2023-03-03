package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
        return this.pilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_L) * 0.6;
    }

    public double rightDriveStick() {
        return this.pilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_R) * 0.6;
    }

    public double clawCoStickR() {
        return this.copilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_R) * 1;
    }

    public double armCoStickL() {
        return this.copilot_joy.getRawAxis(RobotConstants.CONTROLLER_DRIVE_CHANNEL_L) * .6;
    }

    public DoubleSolenoid.Value armset1(){
        return this.copilot_joy.getRawButton(6)?
        DoubleSolenoid.Value.kForward:
        (this.copilot_joy.getRawButton(5)?
        DoubleSolenoid.Value.kReverse:
        DoubleSolenoid.Value.kOff);
        }
}  
