package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import java.util.*;
import java.util.Date;

public class UserSimulation {

	// Time user waits for elevator
	long waitingTimeOutsideElevator;
	// Date when user enters elevator
	long entranceTimeElevator;
	// Date when user exits elevator
	long exitTime;

	// Where the user wants to go
	int levelToGo;

	// User currentLevel
	int currentLevel;

	// True = inElevator, false= outsideElevator
	boolean userState;

	// Elevator out user interact with
	Elevator elevator;

	public UserSimulation(Elevator elevator) {

		this.elevator = elevator;
		waitingTimeOutsideElevator = 0;
		entranceTimeElevator = 0;
		exitTime = 0;
	}

	// User's actions (outside and insinde Elevator)
	public void Trigger(int level, long date) {
		
		// Needs to be changed 

		if(this.levelToGo > currentLevel) {
			elevator.listOfLevel.get(level).userInterface.moveUp();
			elevator.shaft.userinterface.selectLevel(this.levelToGo);
		} else {
			elevator.listOfLevel.get(level).userInterface.moveDown();
			elevator.shaft.userinterface.selectLevel(this.levelToGo);
		}
		
	}

	// Displays every dates
	public void Display() {
		System.out.println("Waiting time outside elevator : " + waitingTimeOutsideElevator);
		System.out.println("entranceTimeElevator : " + entranceTimeElevator);
		System.out.println("exitTime : " + exitTime);
	}


/******************** dates' getter & setter *************************/

	public void setEntranceTimeElevator(long date) {
		this.entranceTimeElevator = date;
	}

	public long getEntranceTimeElevator() {
		return this.entranceTimeElevator;
	}

	public void setWaitingTimeOutsideElevator(long date) {
		this.waitingTimeOutsideElevator = date;
	}

	public long getWaitingTimeOutsideElevator() {
		return this.entranceTimeElevator;
	}

	public void setExitTime(long date) {
		this.exitTime = date;
	}

	public long getExitTime() {
		return this.exitTime;
	}

	public void setLevelToGo(int level){
		this.levelToGo = level;
	}

	public int getLevelToGo(){
		return this.levelToGo;
	}
	
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public long getCurrentLevel() {
		return this.currentLevel;
	}
}

/************************************************************************/