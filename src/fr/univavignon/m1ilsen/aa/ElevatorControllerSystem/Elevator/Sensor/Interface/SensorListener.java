package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Interface;

public interface SensorListener {

	/**
	 * 
	 * @param state 
	 * @param id 
	 */
	public void SensorSwitched(boolean state, int id);


}
