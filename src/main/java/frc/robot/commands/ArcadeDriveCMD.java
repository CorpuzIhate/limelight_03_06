// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class ArcadeDriveCMD extends CommandBase {
  /** Creates a new ArcadeDriveCMD. */

  public final DriveTrainSub driveTrainSub;
  private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDriveCMD(DriveTrainSub driveTrainSub,//
    Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.driveTrainSub = driveTrainSub;
    addRequirements(driveTrainSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    System.out.println("ArcadeDriveCMD is running");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right =  realTimeSpeed - realTimeTurn;
    driveTrainSub.setMotors(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    System.out.println("ArcadeDriveCMD had ended");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
