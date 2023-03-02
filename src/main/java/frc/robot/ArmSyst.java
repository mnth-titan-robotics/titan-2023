package frc.robot;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class ArmSyst {
    private Victor Motor_ARM_1;
    private Victor Motor_ARM_2;

   
    public ArmSyst(){
        
        this.Motor_ARM_1 = new Victor(RobotConstants.Arm1);
        this.Motor_ARM_2 = new Victor(RobotConstants.Arm2);
        }

        public void update(double armCoStickL) {
        Motor_ARM_1.set(armCoStickL + .4);
        Motor_ARM_2.set(armCoStickL * -1 + .4);
        }

    }

