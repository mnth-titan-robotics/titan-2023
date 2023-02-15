package frc.robot;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

import org.ejml.dense.row.linsol.qr.SolvePseudoInverseQrp_DDRM;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class ArmSyst {
    private Victor Motor_ARM_1;
    private Victor Motor_ARM_2;
    private DoubleSolenoid Solenoid_1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_1_A, RobotConstants.Solenoid_1_B);
    private DoubleSolenoid Solenoid_2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_2_A, RobotConstants.Solenoid_2_B);
    private DoubleSolenoid Solenoid_3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_3_A, RobotConstants.Solenoid_3_B);
    private DoubleSolenoid Solenoid_4 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_4_A, RobotConstants.Solenoid_4_B);

   
    public ArmSyst(){
        
        this.Motor_ARM_1 = new Victor(RobotConstants.Arm1);
        this.Motor_ARM_2 = new Victor(RobotConstants.Arm2);
        }

        public void update(double armCoStickL) {
        Motor_ARM_1.set(armCoStickL);
        Motor_ARM_2.set(armCoStickL);
        }

        public void update(DoubleSolenoid.Value armset1){
            Solenoid_1.set(armset1);
            Solenoid_2.set(armset1);
            Solenoid_3.set(armset1);
            Solenoid_4.set(armset1);
    }
}
