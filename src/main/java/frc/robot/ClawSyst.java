package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Victor;

import edu.wpi.first.wpilibj.Encoder;

public class ClawSyst {
    public Encoder encoder;

    private Victor Claw;

    public ClawSyst() {

        this.Claw = new Victor(RobotConstants.CLAW);
        this.encoder = new edu.wpi.first.wpilibj.Encoder(8, 9);
        this.encoder.setDistancePerPulse(1.0/44.4);
        this.encoder.setMinRate(RobotConstants.CLAW_MIN_RATE);
    }

    public void update(double clawCoStickR) {
        this.Claw.set(clawCoStickR);
    }

    public double get_distance() {
        return this.encoder.getDistance();
    }

    public boolean clawOpened() {
        double offset = this.encoder.getDistance() - RobotConstants.OPEN_POSITION;
        return offset < RobotConstants.CLAW_THRESHOLD && offset > -RobotConstants.CLAW_THRESHOLD;
    }
    public boolean clawClosed() {
        double offset = this.encoder.getDistance() - RobotConstants.CLOSED_POSITION;
        return offset < RobotConstants.CLAW_THRESHOLD && offset > -RobotConstants.CLAW_THRESHOLD;
    }
    public void clawCalibration() {
        this.encoder.reset();
    }
}
