package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Pneumatic {
    private DoubleSolenoid Solenoid_1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_1_A, RobotConstants.Solenoid_1_B);
    private DoubleSolenoid Solenoid_2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_2_A, RobotConstants.Solenoid_2_B);
    private DoubleSolenoid Solenoid_3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_3_A, RobotConstants.Solenoid_3_B);
    private DoubleSolenoid Solenoid_4 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.Solenoid_4_A, RobotConstants.Solenoid_4_B);

    public void update(DoubleSolenoid.Value armset1){
        Solenoid_1.set(armset1);
        Solenoid_2.set(armset1);
        Solenoid_3.set(armset1);
        Solenoid_4.set(armset1);
}
}
