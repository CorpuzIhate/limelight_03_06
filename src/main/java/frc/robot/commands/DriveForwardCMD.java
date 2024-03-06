// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class DriveForwardCMD extends CommandBase {

  private final DriveTrainSub driveTrainSub;
  private final double distance;
  private double encoderSetPoint;

  /** Creates a new DriveForwardCMD. */
  public DriveForwardCMD(DriveTrainSub driveTrainSub, double distance){

    this.driveTrainSub = driveTrainSub;
    this.distance = distance;

    addRequirements(driveTrainSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    encoderSetPoint = driveTrainSub.getEncoderMeters() + distance;
    System.out.println("DriveForwardCMD started!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    driveTrainSub.setMotors(0.5,0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrainSub.setMotors(0,0);

    System.out.println("DriveForwardCMD ended!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(driveTrainSub.getEncoderMeters() > encoderSetPoint)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
