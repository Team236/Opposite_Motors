// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorMotors extends SubsystemBase {

  private CANSparkMax motorLeft, motorRight;
  private DigitalInput topLimit, bottomLimit;
  private Boolean isTUnplugged = false;
  private Boolean isBUnplugged = false;

  /** Creates a new OpposingMotors. */
  public ElevatorMotors() {
    motorLeft = new CANSparkMax(Constants.Motors.ID_ELEV_LEFT, MotorType.kBrushless);
    motorRight = new CANSparkMax(Constants.Motors.ID_ELEV_RIGHT, MotorType.kBrushless);

    motorLeft.restoreFactoryDefaults();
    motorRight.restoreFactoryDefaults();

    motorLeft.setInverted(false); //TODO determine inverted motors
    motorRight.setInverted(true);

    motorLeft.setSmartCurrentLimit(Constants.Motors.SMART_CURRENT_LIMIT);
    motorRight.setSmartCurrentLimit(Constants.Motors.SMART_CURRENT_LIMIT);
     
try {
  topLimit = new DigitalInput(Constants.Limits.DIO_TOP_LIMIT);
} catch (Exception e) {
  // TODO: handle exception
    isTUnplugged = true;
    SmartDashboard.putBoolean("top limit unplugged: ", isTUnplugged);
}

try {
  bottomLimit = new DigitalInput(Constants.Limits.DIO_BOT_LIMIT);
} catch (Exception e) {
  // TODO: handle exception
    isBUnplugged = true;
    SmartDashboard.putBoolean("bottom limit unplugged: ", isBUnplugged);
}
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
public boolean isTLimit() {
  boolean atTLimit;
   if(isTUnplugged) {
    atTLimit = true;
   } else {
     atTLimit = !topLimit.get();
   }
   return atTLimit;
}

public boolean isBLimit() {
  boolean atBLimit;
   if(isBUnplugged) {
    atBLimit = true;
   } else {
     atBLimit = !bottomLimit.get();
   }
   return atBLimit;
   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
SmartDashboard.putBoolean("top limit hit: ", isTLimit());
SmartDashboard.putBoolean("bottom limit hit: ", isBLimit());
  }

}

