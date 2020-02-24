/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.LiftAll;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSP liftMotor = new VictorSP(RobotMap.LIFT_MOTOR);
  private VictorSP IntakeMotor = new VictorSP(RobotMap.INTAKE_MOTOR);
  public boolean Running = false;

  public Lift(){
    liftMotor.setInverted(true);
    IntakeMotor.setInverted(false);
  }
  public void driveLift(double speed)
  {
    liftMotor.set(speed);
  }

  public void LiftUp(){
    liftMotor.set(0.6);
  }

  public void LiftDown(){
    liftMotor.set(-0.6);
  }

  public void intake(double speed){
    IntakeMotor.set(speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftAll());
  }
}
