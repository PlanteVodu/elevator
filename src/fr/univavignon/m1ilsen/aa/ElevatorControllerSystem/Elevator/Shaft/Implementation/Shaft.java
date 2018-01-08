package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Interface.i_Shaft;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Door.Implementation.Door;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Door.Interface.i_Door;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Motor.Implementation.Motor;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Motor.Interface.i_Motor;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft.Implementation.*;

public class Shaft implements i_Shaft {

	/**
	 * 
	 */
	public Door door;
	/**
	 * 
	 */
	public Motor motor;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	public UserInterfaceShaft userinterface;
	
	/**
	 * 
	 * @param speed 
	 */
	public Shaft(int speed) { 
		this.door=new Door();
		this.motor=new Motor(speed);
		//this.userinterface=new UserInterfaceShaft();
	 }
	
	public void setUserInterfaceShaft(UserInterfaceShaft userinterface)
	{
		this.userinterface=userinterface;
	}
	/**
	 * 
	 * @param state 
	 * @return 
	 */
	public void switchMotorState(int state) { 
		this.motor.switchState(state);
	}
	/**
	 * 
	 * @return 
	 */
	public int getMotorSpeed() { 
		return motor.getSpeed();
	 }
	/**
	 * 
	 * @param state 
	 * @return 
	 */
	public void switchDoorState(boolean state) { 
		this.door.switchState(state);
		
	 } 

}
