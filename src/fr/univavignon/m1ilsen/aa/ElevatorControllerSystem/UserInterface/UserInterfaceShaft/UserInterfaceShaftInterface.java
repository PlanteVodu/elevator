package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;

//=============================================================================
// ▼ UserInterfaceShaft
// ----------------------------------------------------------------------------
//
//=============================================================================
public interface UserInterfaceShaftInterface
{


	public void createUserInterfaceShaftInterface(ControllerSystem controllerSystem, Elevator elevator);

	public int getElevatorCurrentLevel();

	public void selectLevel(int selectedLevel);

	//public int elevatorCurrentLevelUpdated(int level); // ElevatorListener -> afficheur
}
