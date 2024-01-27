// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.RunElevatorDown;
import frc.robot.commands.RunElevatorUp;
import frc.robot.commands.RunShooterFwd;
import frc.robot.commands.RunShooterRev;
import frc.robot.subsystems.ElevatorMotors;
import frc.robot.subsystems.ShooterMotors;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  Joystick myJoystick = new Joystick(Constants.Controller.MY_JOYSTICK); //Thrustmaster

  // subsystem
  private final ElevatorMotors opposingMotors = new ElevatorMotors();
  private final ShooterMotors shooterMotors = new ShooterMotors();

  //commands
  private final RunElevatorUp runElevatorUp = new RunElevatorUp(opposingMotors, Constants.Motors.ELEV_UP_SPEED);
  private final RunElevatorDown runElevatorDown = new RunElevatorDown(opposingMotors, Constants.Motors.ELEV_DOWN_SPEED);
  private final RunShooterFwd runShooterFwd = new RunShooterFwd(shooterMotors, Constants.Motors.SHOOTER_FWD_SPEED);
  private final RunShooterRev runShooterRev = new RunShooterRev(shooterMotors, Constants.Motors.SHOOTER_REV_SPEED);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    JoystickButton trigger = new JoystickButton(myJoystick, Constants.Thrustmaster.TRIGGER);
    JoystickButton buttonMiddle = new JoystickButton(myJoystick, Constants.Thrustmaster.BUTTON_MIDDLE);
    JoystickButton buttonLeft = new JoystickButton(myJoystick, Constants.Thrustmaster.BUTTON_LEFT);
    JoystickButton buttonRight = new JoystickButton(myJoystick, Constants.Thrustmaster.BUTTON_RIGHT);

  //link buttons to commands:
    trigger.whileTrue(runElevatorUp);
    buttonMiddle.whileTrue(runElevatorDown);

    buttonRight.whileTrue(runShooterFwd);
    buttonLeft.whileTrue(runShooterRev);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
