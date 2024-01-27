// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorMotors;

public class RunElevatorDown extends Command {
  private ElevatorMotors elevatorMotors;
  private double speed;

  /** Creates a new RunElevatorDown. */
  public RunElevatorDown(ElevatorMotors elevatorMotors, double speed) {
    this.speed = speed;
    this.elevatorMotors = elevatorMotors; 
    
    addRequirements(this.elevatorMotors);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevatorMotors.setMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevatorMotors.motorsStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   //return false;
  return (elevatorMotors.isBLimit() || elevatorMotors.isTLimit());
  }
}
