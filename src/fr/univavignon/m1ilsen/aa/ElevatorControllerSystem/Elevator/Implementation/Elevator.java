package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.i_Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Implementation.Level;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Implementation.Shaft;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Interface.i_Shaft;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.Implementation.UserInterface;

import java.util.LinkedList;
import java.util.List;

public class Elevator implements i_Elevator {

	
	private int botsensor;
	private int topsensor;
	/**
	 * 
	 */
	private ElevatorListener listener;
	/**
	 * 
	 */
	public Shaft shaft;
	/**
	 * 
	 */
	public List<Level> listOfLevel;
	/**
	 * 
	 * @param numberOfLevel 
	 * @param listener 
	 * @param motorSpeed 
	 * @param height 
	 * @param extraHeight 
	 */
	public Elevator(int numberOfLevel, ElevatorListener listener, int motorSpeed, int height, int extraHeight) { 
		listOfLevel=new LinkedList<Level>();
		Level temp= new Level(extraHeight,this,0,height);
		listOfLevel.add(temp);
		this.shaft=new Shaft(motorSpeed);
		this.listener=listener;
	 }
	/**
	 * 
	 * @return 
	 */
	public int getLevelHeight() { 
		return this.listOfLevel.get(1).getHeight();
	 }
	/**
	 * 
	 * @return 
	 */
	public int getMotorSpeed() { 
		return this.shaft.getMotorSpeed();
	 }
	/**
	 * 
	 * @return 
	 */
	public int getLevelExtraHeight() { 
		return this.listOfLevel.get(1).getExtraHeight();
	 }
	
	/**
	 * 
	 * @return 
	 */
	public int getNumberOfLevel() { 
		return this.listOfLevel.size();
	 }

	/**
	 * 
	 * @param id 
	 * @param state 
	 */
	public void LevelTrigger(int id, boolean state) {
		if(state==false)
		{
			if(id%10==1)topsensor=9999;
			else botsensor=9999;	
		}
		else
		{
			if(id%10==1)topsensor=id/10;
			else botsensor=id/10;	
		}
		if(botsensor==topsensor)
		{
			this.listener.ElevatorTrigger(topsensor);
		}
	 }

	@Override
	public void switchMotorState(int state) {
		// TODO Auto-generated method stub
		
	}

}
