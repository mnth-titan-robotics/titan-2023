package frc.robot;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
 

public class ClawSyst {
    
    private Victor Claw;

    public ClawSyst() {
    
    this.Claw = new Victor(RobotConstants.CLAW);
    

    }

    public void update(double clawCoStickR) {
        this.Claw.set(clawCoStickR);
    }
}
