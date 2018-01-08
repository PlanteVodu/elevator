package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Sequencer.Sequencer;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

public class Request {
	 

	public int level; //requested level
	public int direction; //+1 = up / -1 = down
	public UserSimulation user;
	
	public Request(int etage,int direction, UserSimulation userSimulation){		
		this.level=level;
		this.direction=direction;			
		this.user = userSimulation;
		this.user.setEntranceTimeElevator(Sequencer.getCurrentTime());
	}
	
	public boolean equals(Request d) {
		if (d.level==this.level && d.direction==this.direction) {
			return true;	
		}	
			return false;		
	}

}