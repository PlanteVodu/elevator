package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Motor.Interface;

public interface i_Motor {

	/**
	 * 
	 * @param state 
	 */
	public void switchState(int state);

	/**
	 * 
	 * @return 
	 */
	public int getSpeed(); 

}
