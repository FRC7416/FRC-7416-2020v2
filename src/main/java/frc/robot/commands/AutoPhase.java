/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoPhase extends Command {

  public AutoPhase() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  // Use timer to divide time for different instruction during autonomous
  @Override
  protected void execute() {
    if (frc.robot.Robot.time() < 2.5){
      Robot.drivetrain.driveArcade(-0.5,0);
  
    }
    else if(frc.robot.Robot.time() < 3)
      Robot.drivetrain.driveArcade(0, 0.5);
    else if(frc.robot.Robot.time()<3.5){
      Robot.lift.shooting(0.5);
      Robot.drivetrain.driveArcade(0, 0);
    }
    else if(frc.robot.Robot.time()<11.5){
      Robot.lift.BallRoll(-0.6);
      Robot.lift.shooting(0.5);
    }
    else if(frc.robot.Robot.time()<(12)){
      Robot.drivetrain.driveArcade(1, 0);
      Robot.lift.BallRoll(0);
      Robot.lift.shooting(0);
    }
    else{
      Robot.drivetrain.driveArcade(0, 0);
      Robot.lift.BallRoll(0);
      Robot.lift.shooting(0);
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
