package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation;

public class Request {
	 

	public int level; //requested level
	public int direction; //+1 = up / -1 = down
	
	public Request(int etage,int direction){		
		this.level=level;
		this.direction=direction;			
	}
	
	public boolean equals(Request d) {
		if (d.level==this.level && d.direction==this.direction) {
			return true;	
		}	
			return false;		
	}

}