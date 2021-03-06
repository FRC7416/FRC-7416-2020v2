/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static final int LEFT_MAIN_MOTOR = 7;
  public static final int RIGHT_MAIN_MOTOR = 8;
  public static final int LIFT_MOTOR = 6;
  public static final int INTAKE_MOTOR = 5;
  public static final int SHOOT_MOTOR = 0;
  public static final int WINCH_MOTOR = 1;
  public static final int COLOR_SPINNER_MOTOR = 4;
  public static final int BALL_ROLL_MOTOR = 2;

}
