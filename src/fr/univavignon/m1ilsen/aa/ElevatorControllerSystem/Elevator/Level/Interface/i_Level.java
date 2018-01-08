package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Interface;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Interface.SensorListener;

public interface i_Level extends SensorListener {

	/**
	 * 
	 * @return 
	 */
	public int getHeight();

	/**
	 * 
	 * @return 
	 */
	public int getExtraHeight();

	/**
	 * 
	 * @param state 
	 * @param id 
	 */
	public void SensorSwitched(boolean state, int id);

}
