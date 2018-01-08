package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Interface;

public interface LevelListener {

	/**
	 * 
	 * @param id 
	 * @param state 
	 */
	public void LevelTrigger(int id, boolean state); 

}
