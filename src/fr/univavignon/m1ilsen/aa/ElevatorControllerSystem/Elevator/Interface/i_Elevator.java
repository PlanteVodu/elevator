package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Interface.LevelListener;

public interface i_Elevator extends LevelListener {

	/**
	 * 
	 * @return 
	 */
	public int getMotorSpeed();

	/**
	 * 
	 * @return 
	 */
	public int getLevelHeight();

	/**
	 * 
	 * @return 
	 */
	public int getLevelExtraHeight();

	/**
	 * 
	 * @return 
	 */
	public int getNumberOfLevel();

	/**
	 * 
	 * @param state 
	 */
	public void switchMotorState(int state);

	/**
	 * 
	 * @param id 
	 * @param state 
	 */
	public void LevelTrigger(int id, boolean state); 

}
