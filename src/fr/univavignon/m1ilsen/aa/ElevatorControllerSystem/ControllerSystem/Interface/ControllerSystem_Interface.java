package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Interface;

import java.util.Arrays;
import java.util.HashMap;
import javax.swing.text.TabableView;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

public interface ControllerSystem_Interface {
	
		
	public void choseLevel();	
	public void callAtLevel(int level, int sens,UserSimulation user);	
	public void goToLevel(int etage,UserSimulation user);
	
	
}
