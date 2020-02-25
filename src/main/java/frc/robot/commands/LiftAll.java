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

    /// Robot.lift.driveLift(Robot.m_oi.interpretHatState(Robot.m_oi.rightFStick,
    /// 0,180,0.2,-.2));//don't change speeds It'll mess up dirver
    if (Robot.m_oi.getButtonReleased(Robot.m_oi.rightFStick, FStickMap.B1)) {
      if (Robot.lift.Running == false) {
        Robot.lift.Running = true;
      } else {
        Robot.lift.Running = false;
      }
    }
    if (Robot.lift.Running) {
      Robot.lift.intake(Robot.m_oi.getAxis(Robot.m_oi.leftFStick, FStickMap.SLIDER, Robot.m_oi.LEFT_FSTICK_DEADBAND));
    } else {
      Robot.lift.intake(0);
    }
    if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B2))
      Robot.lift.LiftUp(0.3);
    else if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B3))
      Robot.lift.LiftUp(-0.3);
    else {
      Robot.lift.LiftUp(0);
    }
    if (Robot.m_oi.getTState(Robot.m_oi.rightFStick))
      Robot.lift.shooting(Robot.m_oi.getShootSpeed(Robot.m_oi.rightFStick, Robot.m_oi.RIGHT_FSTICK_DEADBAND));
    else
      Robot.lift.shooting(0);
    if (Robot.m_oi.getButtonPressed(Robot.m_oi.rightFStick, FStickMap.B5)) {
      Robot.lift.Witch(1.0);
    }
    else{
      Robot.lift.Witch(0.0);
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
