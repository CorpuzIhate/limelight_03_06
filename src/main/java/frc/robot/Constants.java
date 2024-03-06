// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    
    

  }
  public static class DriveTrainConstants
  {
    //update CAN IDS
    public static final int rightBackID = 1;
    public static final int leftBackID = 3;
    public static final int rightFrontID = 2;
    public static final int leftFrontID = 4; 

    public static final int rightBackEncoderChannelA = 0;
    public static final int rightBackEncoderChannelB = 1;

    public static final int leftBackEncoderChannelA = 1;
    public static final int leftBackEncoderChannelB = 3;

    public static final int rightFrontEncoderChannelA = 2;
    public static final int rightFrontEncoderChannelB = 2;

    public static final int leftFrontEncoderChannelA = 4;
    public static final int leftFrontEncoderChannelB = 4; 
 





  }
  public static class LimeLightConsants{

    public static final double Kp = -0.1f;

    public static final double minCommand = 0.05f;

    
    //d = (h2-h1) / tan(a1+a2)


    // how many degrees back is your limelight rotated from perfectly vertical?
    public static final double limelightMountAngleDegrees = 25.0; //a1

    // distance from the center of the Limelight lens to the floor
    public static double limelightLensHeightInches = 20.0;  //h1

    // distance from the target to the floor
    public static double goalHeightInches = 60.0; // h2 




  }
}
