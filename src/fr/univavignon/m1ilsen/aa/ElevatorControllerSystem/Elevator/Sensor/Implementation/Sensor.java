package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Interface.i_sensor;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Interface.SensorListener;

public class Sensor implements i_sensor {

	/**
	 * 
	 */
	private SensorListener listener;
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private boolean state;
	
	/**
	 * 
	 */
	public void SwitchState() { 
		state=!state;
		listener.SensorSwitched(state, id);
	 }
	/**
	 * 
	 * @param listener 
	 * @param id 
	 */
	public Sensor(SensorListener listener, int id) { 
		this.id=id;
		this.listener=listener;
	 } 

}
