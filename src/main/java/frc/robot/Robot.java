// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the manifest
 * file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
    private OperatorInterface _Ops;
    private DriveSyst _driveSyst;
    private ClawSyst _clawSyst;
    private ArmSyst _ArmSyst;
    private Pneumatic _Pneumatic;
    private ADXRS450_Gyro gyro;

    /**
     * This function is run when the robot is first started up and should be used
     * for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        /**this.gyro = new ADXRS450_Gyro();
        this.gyro.calibrate();  */
        this._driveSyst = new DriveSyst();
        this._Ops = new OperatorInterface();
        this._clawSyst = new ClawSyst();
        this._ArmSyst = new ArmSyst();
        this._Pneumatic = new Pneumatic();
        System.out.println("Hello World");
        this._Pneumatic.update(Value.kReverse);
        this.gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS1);
    }

    /** This function is run once each time the robot enters autonomous mode. */
    @Override
    public void autonomousInit() {
        // zero the gyro
        gyro.calibrate(); 

        this._driveSyst.update(-0.51, -0.51);
        
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**this._driveSyst.update(0.25, -0.25);
        
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }*/
        this._driveSyst.update(0, 0);
        /**this._clawSyst.update(1);

        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this._ArmSyst.update(1);
        
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this._ArmSyst.update(0);
        this._Pneumatic.update(Value.kForward);

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this._clawSyst.update(-1);

        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this._clawSyst.update(0);
        this._ArmSyst.update(-.3);
        this._Pneumatic.update(Value.kReverse);


        

        this._driveSyst.update(0, 0);*/
    }

    /** This function is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {
        double angle = this.gyro.getAngle();
        if (angle > 2 && angle < 90) {
            this._driveSyst.update(-0.1, -0.1);
        }
        else if (angle < 358 && angle > 270) {
            this._driveSyst.update(0.1, 0.1);
        }
        else if (angle < 2 && angle > 358) {
            this._driveSyst.update(0, 0);
        }
    }

    /**
     * This function is called once each time the robot enters teleoperated mode.
     */
    @Override
    public void teleopInit() {
        System.out.println("Hello from teleopInit");
    }

    /** This function is called periodically during teleoperated mode. */
    @Override
    public void teleopPeriodic() {
        _driveSyst.update(_Ops.rightDriveStick(), _Ops.leftDriveStick());
        _clawSyst.update(_Ops.clawCoStickR());
        _ArmSyst.update(_Ops.armCoStickL());
        _Pneumatic.update(_Ops.armset1());
    }

    /** This function is called once each time the robot enters test mode. */
    @Override
    public void testInit() {
        this.gyro.calibrate();
    }

    /** This function is called periodically during test mode. */
    @Override
    public void testPeriodic() {
        if (this.gyro.isConnected()) {
            System.out.println("gyro is at rate:  " + this.gyro.getRate());
            System.out.println("gyro is at angle: " + this.gyro.getAngle());
        } else {
            System.out.println("gyro is not connected");
        }
    }
}
