package org.usfirst.frc.team1781.robot;

import edu.wpi.first.wpilibj.DigitalInput;
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

	// add variables here
	Talon frontLeftMotor;
	Talon frontRightMotor;
	Talon rearLeftMotor;
	Talon rearRightMotor;
	
	Talon leftMotor;
	Talon pulleymotor;
	Talon CollectiveRightMotor, CollectiveLeftMotor;
	Joystick driverJoystick, liftOperatorJoystick;
	DigitalInput RSensor, LSensor;
	Talon pivotMotor;
	DigitalInput digitalInputCW;
	DigitalInput digitalInputCCW;
	DigitalInput digitalInputCWBackUp;
	DigitalInput digitalInputCCWBackUp;

	// initialize variables in RobotInit()
	public void robotInit() {
		
		frontLeftMotor = new Talon(1);
    	frontRightMotor = new Talon(2);
    	rearLeftMotor = new Talon(5);
    	rearRightMotor = new Talon(8);
    	driverJoystick = new Joystick(0);
    	liftOperatorJoystick = new Joystick(1);
		
		leftMotor = new Talon(0);
		pulleymotor = new Talon(1);
		driverJoystick = new Joystick(0);
		liftOperatorJoystick = new Joystick(1);
		RSensor = new DigitalInput(1);
		LSensor = new DigitalInput(2);

		pivotMotor = new Talon(4);
		digitalInputCW = new DigitalInput(4);
		digitalInputCCW = new DigitalInput(5);
		digitalInputCWBackUp = new DigitalInput(6);
		digitalInputCCWBackUp = new DigitalInput(7);

		CollectiveRightMotor = new Talon(2);
		CollectiveLeftMotor = new Talon(3);

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
	 */
	public void gripContainer() {

	}

	public void releaseContainer() {

	}

	public void pullContainer() {
		if (liftOperatorJoystick.getRawButton(3) == true) {
			CollectiveRightMotor.set(-1); // counter clockwise
			CollectiveLeftMotor.set(1); // clockwise
		} else {
			CollectiveRightMotor.set(0); // stops
			CollectiveLeftMotor.set(0);
		}
	}

	public void pushContainer() {
		if (liftOperatorJoystick.getRawButton(4) == true) {
			CollectiveRightMotor.set(1); // counter clockwise
			CollectiveLeftMotor.set(-1); // clockwise
		} else {
			CollectiveRightMotor.set(0); // stops
			CollectiveLeftMotor.set(0);
		}
	}

	public void liftTote() {
		if (liftOperatorJoystick.getRawButton(2)) {
			pulleymotor.set(0.5);
			if (LSensor.get() == false && RSensor.get() == true) {
				pulleymotor.set(0);
			}
		}
		if (liftOperatorJoystick.getRawButton(3)) {
			pulleymotor.set(0.5);
			if (LSensor.get() == true && RSensor.get() == true) {
				pulleymotor.set(0);
			}
		}
	}

	public void lowerTote() {
		if (liftOperatorJoystick.getRawButton(1) && LSensor.get() == true
				|| LSensor.get() == false) {
			pulleymotor.set(-0.5);
			if (LSensor.get() == true && RSensor.get() == false) {
				pulleymotor.set(0);
			}
		}
		if (liftOperatorJoystick.getRawButton(2) && LSensor.get() == true) {
			pulleymotor.set(-0.5);
			if (LSensor.get() == false && RSensor.get() == true) {
				pulleymotor.set(0);
			}
		}
	}

	public void moveDistance(float distanceToMove) {

	}

	public void rotate(float angleToRotate) {

	}

	public void driveRobot() {
		
		double FLMV = ((driverJoystick.getY())+(driverJoystick.getX()));
    	if (FLMV<-1)
    	{
    		FLMV = -1;
    	}
    	if (FLMV>1)
    	{
    		FLMV = 1;
    	}
    	double FRMV = (-driverJoystick.getY()+(driverJoystick.getX()));
    	if (FRMV<-1)
    	{
    		FRMV =-1;
    	}
    	if (FRMV>1)
    	{
    		FRMV = 1;
    	}
    	
    	double RLMV = ((driverJoystick.getY())+(driverJoystick.getX()));
    	if (RLMV<-1)
    	{
    		RLMV = -1;
    	}
    	if (RLMV>1)
    	{
    		RLMV = 1;
    	}
    	double RRMV = (-driverJoystick.getY()+(driverJoystick.getX()));
    	if (RRMV<-1)
    	{
    		RRMV =-1;
    	}
    	if (RRMV>1)
    	{
    		RRMV = 1;
    	}
    	
    	System.out.println(driverJoystick.getX()+";"+driverJoystick.getY()+";"+FLMV+"/"+FRMV);
    	
    	frontLeftMotor.set(FLMV*.5);
    	rearLeftMotor.set(RLMV*.5);
    	frontRightMotor.set(FRMV*.5);
    	rearRightMotor.set(RRMV*.5);
    
    	/*frontLeftMotor.set(-(driverJoystick.getX()));
    	rearLeftMotor.set(-(driverJoystick.getX()));
    	frontRightMotor.set(-(driverJoystick.getX()));
    	rearRightMotor.set(-(driverJoystick.getX()));*/

	}

	public void pivotFoward() {
		if (digitalInputCCW.get() == false
				&& digitalInputCCWBackUp.get() == false) {
			pivotMotor.set(-0.25);
		} else if (digitalInputCCW.get() == true
				|| digitalInputCCWBackUp.get() == true) {
			pivotMotor.set(0);
		}
		/*
		 * else if (digitalInputCCW.get() == true && digitalInputCCWBackUp.get()
		 * == true) { pivotMotor.set(0); }
		 */
		else {
			pivotMotor.set(0);
		}
	}

	public void pivotTurn() {
		if (digitalInputCW.get() == false
				&& digitalInputCWBackUp.get() == false) {
			pivotMotor.set(0.25);
		} else if (digitalInputCW.get() == true
				|| digitalInputCWBackUp.get() == true) {
			pivotMotor.set(0);
		}
		/*
		 * else if (digitalInputCW.get() == true && digitalInputCWBackUp.get()
		 * == true) { pivotMotor.set(0); }
		 */
		else {
			pivotMotor.set(0);
		}
	}
}
