
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.Robot;

/**
 *Command that raises arm. It stops when the user releases the
 *upper limit switch or releases the button
 */
public class ArmUp extends Command {
	
    public ArmUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.armUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.upLimitSwitchPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.armStop();
    	new HoldArm().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
