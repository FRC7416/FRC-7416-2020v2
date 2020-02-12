/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import io.github.pseudoresonance.pixy2api.*;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import java.util.ArrayList;
import frc.robot.commands.ColorCensor;

/**
 * Add your docs here.
 */
public class ColorHelper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Pixy2 pixycam= Pixy2.createInstance(Pixy2.LinkType.SPI);
  
  public ArrayList<Block> getBlock() {
    pixycam.getCCC().getBlocks( false , 15, 2);
    ArrayList<Block> blocks = pixycam.getCCC().getBlocks(); 
    return blocks;
  }

  public void Resrt(){
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new ColorCensor());
  }
}
