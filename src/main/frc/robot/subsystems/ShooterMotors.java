// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterMotors extends SubsystemBase {

    private CANSparkMax motorLeft, motorRight;

  /** Creates a new ShooterMotors. */
  public ShooterMotors() {
    motorLeft = new CANSparkMax(Constants.Motors.ID_SHOOTER_LEFT, MotorType.kBrushless);
    motorRight = new CANSparkMax(Constants.Motors.ID_SHOOTER_RIGHT, MotorType.kBrushless);

    motorLeft.restoreFactoryDefaults();
    motorRight.restoreFactoryDefaults();

    motorLeft.setInverted(false); //TODO determine inverted motors
    motorRight.setInverted(true);

    motorLeft.setSmartCurrentLimit(Constants.Motors.SMART_CURRENT_LIMIT);
    motorRight.setSmartCurrentLimit(Constants.Motors.SMART_CURRENT_LIMIT);
  }

    //start methods here:
    public void motorsStop() {
      motorLeft.set(0);
      motorRight.set(0);
    }
  
    public void setMotorSpeed(double speed) {
      motorLeft.set(speed);
      motorRight.set(speed); //one of these motors is inverted above, so they spin opposite
    }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
