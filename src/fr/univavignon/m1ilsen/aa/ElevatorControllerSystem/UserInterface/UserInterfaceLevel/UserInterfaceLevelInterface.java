package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;

//=============================================================================
// ▼ UserInterfaceLevel
// ----------------------------------------------------------------------------
//
//=============================================================================
public interface UserInterfaceLevelInterface extends ElevatorListener
{
	public void createUserInterfaceLevelInterface(ControllerSystem controllerSystem, Elevator elevator);

	public int getElevatorCurrentLevel();

	public void moveUp();
	public void moveDown();

	//public int elevatorCurrentLevelUpdated(int level); // ElevatorListener -> boutons
}
