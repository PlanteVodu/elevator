package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft.Interface;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

//=============================================================================
// ▼ UserInterfaceShaft
// ----------------------------------------------------------------------------
//
//=============================================================================
public interface i_UserInterfaceShaft
{
	public int getElevatorCurrentLevel();

	public void selectLevel(int selectedLevel, UserSimulation user);

	//public int elevatorCurrentLevelUpdated(int level); // ElevatorListener -> afficheur
}
