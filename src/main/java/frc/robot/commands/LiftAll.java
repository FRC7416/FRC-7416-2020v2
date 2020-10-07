/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.FStickMap;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class LiftAll extends Command {
  public LiftAll() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ///Code for the intake, press to turn on or off, with slider setting the speed.
    if (Robot.m_oi.getButtonReleased(Robot.m_oi.leftFStick, FStickMap.B5)) {
      if (Robot.lift.Running == false) 
        Robot.lift.Running = true;
      else
        Robot.lift.Running = false;
    }
    if (Robot.lift.Running)
      Robot.lift.intake(Robot.m_oi.getAxis(Robot.m_oi.leftFStick, FStickMap.SLIDER, Robot.m_oi.LEFT_FSTICK_DEADBAND));
    else 
      Robot.lift.intake(0);

    ///Ball Roll Motor code, trigger type
    if(Robot.m_oi.getButtonPressed(Robot.m_oi.leftFStick, FStickMap.TRIGGER)){
      if (Robot.m_oi.getAxis(Robot.m_oi.leftFStick, FStickMap.SLIDER, Robot.m_oi.LEFT_FSTICK_DEADBAND)>0)
        Robot.lift.BallRoll(-0.6);
      else
        Robot.lift.BallRoll(0.6);
    }
    else{
      Robot.lift.BallRoll(0);
    }
    ///Hook lift motor code, constant speed,hold to move
    if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B2))
      Robot.lift.LiftUp(0.3);
    else if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B3))
      Robot.lift.LiftUp(-0.3);
    else {
      Robot.lift.LiftUp(0);
    }
    ///Fly Wheel Motor code, shoot with the speed given by slider, hold to shoot
    if (Robot.m_oi.getTState(Robot.m_oi.rightFStick))
      Robot.lift.shooting(Robot.m_oi.getShootSpeed(Robot.m_oi.rightFStick, Robot.m_oi.RIGHT_FSTICK_DEADBAND));
    else
      Robot.lift.shooting(0);
    
    /// Code for Winch motor, hold to move
    if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B4)) {
      Robot.lift.Winch(1.0);
    }
    else if(Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick,FStickMap.B5)){
      Robot.lift.Winch(-1.0);
    }
    else{
      Robot.lift.Winch(0.0);
    }

    ///Code for Color Wheel motor, hold to move
    if(Robot.m_oi.getButtonPressed(Robot.m_oi.leftFStick, FStickMap.B2)){
      Robot.lift.CWheel(0.3);
    }
    else if(Robot.m_oi.getButtonPressed(Robot.m_oi.leftFStick, FStickMap.B3)){
      Robot.lift.CWheel(-0.3);
    }
    else{
      Robot.lift.CWheel(0.0);
    }
    ///Ball Roll Motor Engine, chaangable speed with on/off mode
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
