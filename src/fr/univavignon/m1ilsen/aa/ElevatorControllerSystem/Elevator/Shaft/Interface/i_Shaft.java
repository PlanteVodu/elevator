package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Interface;

public interface i_Shaft {

	/**
	 * 
	 * @param state 
	 */
	public void switchMotorState(int state);

	/**
	 * 
	 * @param state 
	 */
	public void switchDoorState(boolean state);

	/**
	 * 
	 * @return 
	 */
	public int getMotorSpeed(); 

}
