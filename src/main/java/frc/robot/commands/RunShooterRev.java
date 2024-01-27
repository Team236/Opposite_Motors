// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterMotors;

public class RunShooterRev extends Command {

  private ShooterMotors shooterMotors;
  private double speed;

  /** Creates a new RunShooterFwd. */
  public RunShooterRev(ShooterMotors shooterMotors, double speed) {
    this.speed = speed;
    this.shooterMotors = shooterMotors;

    addRequirements(this.shooterMotors);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterMotors.setMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterMotors.motorsStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

