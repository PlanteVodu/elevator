package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Door.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Door.Interface.i_Door;

public class Door implements i_Door {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private boolean state;

	/**
	 * 
	 * @param state 
	 * @return 
	 */
	public void switchState(boolean state) { 
		this.state=state;
	 }

	/**
	 * 
	 */
	public Door() { 
		this.state=false;
	 } 

}
