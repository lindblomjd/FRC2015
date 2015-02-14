package org.usfirst.frc.team1781.robot;
 
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	//add variables here
	Talon leftMotor;
	Joystick driverJoystick, liftOperatorJoystick;
	
	
	//initialize variables in RobotInit()
    public void robotInit() { 
    	leftMotor = new Talon(0);
    	driverJoystick = new Joystick(0);
    	liftOperatorJoystick = new Joystick(1);

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    /*
     * The following are the general functions used by our robot.
     * 
     */
    public void gripContainer()
    {
    	
    }
    
    public void releaseContainer()
    {
    	
    }
    
    public void liftTote()
    {
    	
    }
    
    public void lowerTote()
    {
    	
    }
    
    public void moveDistance(float distanceToMove)
    {
    	
    }
    
    public void rotate(float angleToRotate)
    {
    	
    }
    
    public void driveRobot()
    {
    	
    }
}
