package frc.robot;

import com.fasterxml.jackson.core.io.OutputDecorator;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
public class PIDSubSystem {
    /** A command that will turn the robot to the specified angle. */
    public class TurnToAngle extends PIDCommand {
        /**
         * Turns to robot to the specified angle.
         *
         * @param targetAngleDegrees The angle to turn to
         * @param drive The drive subsystem to use
         */
        public TurnToAngle(double targetAngleDegrees) {
        super(
            new PIDController(DriveConstants.RobotConstants.kTurnP, 0, 0),
            // Close loop on heading
            // Set reference to target
            // Pipe output to turn robot
            return this._driveSyst.update(0, 0);
            // Require the drive
            drive);
    
                // Close the loop on the turn rate
                m_robotDrive::getTurnRate;
                // Setpoint is 0
                0;
                // Pipe the output to the turning controls
                return this._driveSyst.update(Output, Output);
                // Require the robot drive
                m_robotDrive));
        }
    
        @Override
        public boolean isFinished() {
        // End when the controller is at the reference.
        return getController().atSetpoint();
        }
    }
}
