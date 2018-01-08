package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel.Interface;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

//=============================================================================
// ▼ UserInterfaceLevel
// ----------------------------------------------------------------------------
//
//=============================================================================
public interface i_UserInterfaceLevel extends ElevatorListener
{
	public void createUserInterfaceLevelInterface(ControllerSystem controllerSystem, Elevator elevator);

	public int getElevatorCurrentLevel();

	public void moveUp(UserSimulation userSimulation);
	public void moveDown(UserSimulation userSimulation);

	//public int elevatorCurrentLevelUpdated(int level); // ElevatorListener -> boutons
}
