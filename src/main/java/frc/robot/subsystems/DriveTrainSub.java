// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.DriveTrainConstants;
import edu.wpi.first.wpilibj.Encoder;

import java.rmi.server.RemoteStub;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class DriveTrainSub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final TalonSRX rightBack = new TalonSRX(DriveTrainConstants.rightBackID);
  private final TalonSRX leftBack = new TalonSRX(DriveTrainConstants.leftBackID);
  private final VictorSPX rightFront = new VictorSPX(DriveTrainConstants.rightFrontID);
  private final VictorSPX leftFront = new VictorSPX(DriveTrainConstants.leftFrontID);

  private final Encoder rightBackEncoder = new Encoder(DriveTrainConstants.rightBackEncoderChannelA
  ,DriveTrainConstants.rightBackEncoderChannelB);

  private final Encoder leftBackEncoder = new Encoder(DriveTrainConstants.leftBackEncoderChannelA
  ,DriveTrainConstants.leftBackEncoderChannelB);

  private final Encoder rightFrontEncoder = new Encoder(DriveTrainConstants.rightFrontEncoderChannelA,
  DriveTrainConstants.rightFrontEncoderChannelB);

  private final Encoder leftFrontEncoder = new Encoder(DriveTrainConstants.leftFrontEncoderChannelA,
  DriveTrainConstants.leftFrontEncoderChannelB);

  private final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;


  public double getEncoderMeters()
  {
    return (leftBackEncoder.get() + -rightBackEncoder.get() + leftFrontEncoder.get() + -rightFrontEncoder.get() / 2);
  }
  

  public DriveTrainSub() {




  }

  /**
   * Example command factory method.
   *
   * @return a command

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



  public void setMotors(double leftSpeed, double rightSpeed)
  {
    leftBack.set(ControlMode.PercentOutput, leftSpeed);
    leftFront.set(ControlMode.PercentOutput, leftSpeed);


    rightFront.set(ControlMode.PercentOutput, -rightSpeed);
    rightBack.set(ControlMode.PercentOutput, -rightSpeed);
    
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
