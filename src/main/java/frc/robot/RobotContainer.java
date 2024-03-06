// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDriveCMD;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveForwardCMD;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LockOnCMD;
import frc.robot.subsystems.DriveTrainSub;
import frc.robot.subsystems.LimeLightSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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

  

  // The robot's subsystems and commands are defined here...
  private final DriveTrainSub driveTrainSub = new DriveTrainSub();
  private final LimeLightSub limeLightSub = new LimeLightSub();
  private final LockOnCMD lockOnCMD = new LockOnCMD(driveTrainSub, limeLightSub );

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick joystick1 = new Joystick(0);
  private final JoystickButton LockOnButton = new JoystickButton(joystick1, 1);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driveTrainSub.setDefaultCommand(
      new ArcadeDriveCMD(driveTrainSub,() -> -joystick1.getRawAxis(1), () -> -joystick1.getRawAxis(3))
    );


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
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    
    LockOnButton.onTrue(lockOnCMD);
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */ 
  public Command getAutonomousCommand() 
  {
    // An example command will be run in autonomous
    return new SequentialCommandGroup(
        new DriveForwardCMD(driveTrainSub, 1.5 ));
  }
}
