package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Motor.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Motor.Interface.i_Motor;

public class Motor implements i_Motor {

	/**
	 * 
	 */
	private int state;
	/**
	 * 
	 */
	private int speed;
	/**
	 * 
	 * @param speed 
	 */
	public Motor(int speed) { 
		this.speed=speed;
		this.state=0;
	 }
	/**
	 * 
	 * @return 
	 */
	public int getSpeed() {
	 	 return speed*state; 
	}
	/**
	 * 
	 * @param state 
	 * @return 
	 */
	public void switchState(int state) { 
		this.state=state;
	 } 

}
