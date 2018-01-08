package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.i_Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Level.Implementation.Level;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Implementation.Shaft;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Shaft.Interface.i_Shaft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Elevator implements i_Elevator {

	
	public int botsensor;
	public int topsensor;
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
	public ArrayList<Level> listOfLevel;
	/**
	 * 
	 * @param numberOfLevel 
	 * @param listener 
	 * @param motorSpeed 
	 * @param height 
	 * @param extraHeight 
	 */
	public Elevator(int numberOfLevel, ElevatorListener listener, int motorSpeed, int height, int extraHeight) { 
		listOfLevel=new ArrayList<Level>(numberOfLevel);
		for(int i =0 ; i< numberOfLevel;i++)
		{
			Level temp= new Level(extraHeight,this,i,height);
			listOfLevel.add(temp);
		}
		this.shaft=new Shaft(motorSpeed);
		this.listener=listener;
	 }
	
	public void setListener(ElevatorListener listener)
	{
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
		System.out.println("yoyo");
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
		this.shaft.motor.switchState(state);
	}

}
