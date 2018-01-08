package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Interface;

import java.util.Arrays;
import java.util.HashMap;
import javax.swing.text.TabableView;

public interface ControllerSystem_Interface {
	
		
	public void choseLevel();	
	public void callAtLevel(int level, int sens);	
	public void goToLevel(int etage);
	
	
}
