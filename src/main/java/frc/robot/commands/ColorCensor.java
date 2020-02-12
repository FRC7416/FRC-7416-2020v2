/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.subsystems.ColorHelper;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ColorCensor extends Command {
  public ColorCensor() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.colorHelper);
  }
  
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
     ColorHelper.pixycam.init( 1 );
    if(Robot.colorHelper.getBlock().size()>0){
        double xcoord = Robot.colorHelper.getBlock().get( 0 ).getX(); // x position 
        double ycoord = Robot.colorHelper.getBlock().get( 0 ).getY(); // y position 
        String data = Robot.colorHelper.getBlock().get( 0 ).toString(); // string containing target
        SmartDashboard.putBoolean( "present" , true );
        SmartDashboard.putNumber( "Xccord" ,xcoord);
        SmartDashboard.putNumber( "Ycoord" , ycoord);
        SmartDashboard.putString( "Data" , data );

    }
      else
        SmartDashboard.putBoolean( "present" , false );

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
