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
  private VictorSP ShootMotor = new VictorSP(RobotMap.SHOOT_MOTOR);
  private VictorSP WitchMotor = new VictorSP(RobotMap.WITCH_MOTOR);
  public boolean Running = false;

  public Lift(){
    liftMotor.setInverted(true);
    IntakeMotor.setInverted(false);
    ShootMotor.setInverted(false);
  }
  
  public void driveLift(double speed)
  {
    liftMotor.set(speed);
  }

  public void LiftUp(double speed){
    liftMotor.set(speed);
  }
  public void intake(double speed){
    IntakeMotor.set(speed);
    
  }
  public void shooting(double speed){
    ShootMotor.set(speed);
  }

  public void Witch(double speed){
    WitchMotor.set(speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftAll());
  }

}
