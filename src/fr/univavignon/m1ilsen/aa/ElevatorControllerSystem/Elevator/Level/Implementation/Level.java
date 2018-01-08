package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Interface.i_Level;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Implementation.Sensor;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Sensor.Interface.i_sensor;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel.Implementation.*;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Interface.LevelListener;

public class Level implements i_Level {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private Sensor topSensor;
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private Sensor botSensor;
	/**
	 * 
	 */
	private int rank;
	/**
	 * 
	 */
	private int extraHeight;
	/**
	 * 
	 */
	private int height;
	/**
	 * 
	 */

	@SuppressWarnings("unused")
	public UserInterfaceLevel userInterface ;
	/**
	 * 
	 */
	private LevelListener listener;
	
	
	/**
	 * 
	 * @param extraHeight 
	 * @param listener 
	 * @param height 
	 * @param rank 
	 */
	public Level(int extraHeight, LevelListener listener, int rank, int height) { 
		this.rank=rank;
		this.height=height;
		this.extraHeight=extraHeight;
		this.botSensor= new Sensor(this,0);
		this.topSensor=new Sensor(this,1);
	 }
		
	public void setUserInterfaceLevel(UserInterfaceLevel userInterface )
	{
		this.userInterface=userInterface;
	}
	
	/**
	 * 
	 * @return 
	 */
	public int getExtraHeight() { 
		return extraHeight;
	 }
	/**
	 * 
	 * @return 
	 */
	public int getHeight() {
	 	 return height; 
	}
	/**
	 * 
	 * @param state 
	 * @param id 
	 */
	public void SensorSwitched(boolean state, int id) { 
		System.out.println("sensor");
		this.listener.LevelTrigger(this.rank*10+id, state);
	 }

}
