// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants.OperatorConstants;

/** Add your docs here. */
public class SwerveMods {

    public int moduleNumber;
    private double angleOffset;
    private TalonFX mAngleMotor;
    private TalonFX mDriveMotor;
    private TalonSRX angleEncoder;
    private double lastAngle;
    
    private SwerveModuleConstants constants;
    

    public SwerveMods(int moduleNumber, double angleOffset, TalonFX angleMotor, TalonFX driveMotor, TalonSRX angleEncoder) {
        this.moduleNumber = moduleNumber;
        this.constants = constants;
        angleOffset = angleOffset;
        
        mAngleMotor = new TalonFX( moduleNumber.angleMotorID); 
        mDriveMotor = new TalonFX( moduleNumber.driveMotorID);
        angleEncoder = new TalonSRX( moduleNumber.angleEncoderID);
        lastAngle = GetState().angle;

    
    
    }

    public void setDesiredState(SwerveModuleState desiredState, boolean isOpenLoop) {



        TalonFXConfiguration angleConfig = new TalonFXConfiguration();
        TalonFXConfiguration driveConfig = new TalonFXConfiguration();

        mAngleMotor.configAllSettings(angleConfig);
        mDriveMotor.configAllSettings(driveConfig);

        mAngleMotor.setInverted(moduleNumber.angleMotorInverted);
        mDriveMotor.setInverted(moduleNumber.driveMotorInverted);

        lastAngle = GetState().angle;
    }
}