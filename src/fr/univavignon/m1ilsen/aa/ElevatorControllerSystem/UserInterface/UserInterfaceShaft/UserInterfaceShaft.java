package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.Implementation.UserInterface;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel.UserInterfaceLevelInterface;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;

//=============================================================================
// ▼ UserInterfaceShaft
// ----------------------------------------------------------------------------
//
//=============================================================================
public class UserInterfaceShaft extends UserInterface implements UserInterfaceLevelInterface, ElevatorListener
{
	private ControllerSystem controllerSystem;
	private Elevator elevator;

	private int elevatorLevel;

	//---------------------------------------------------------------------------
	// * Constructor
	//---------------------------------------------------------------------------
	UserInterfaceShaft(ControllerSystem controllerSystem, Elevator elevator) {
		this.controllerSystem = controllerSystem;
		this.elevator = elevator;
	}

	//---------------------------------------------------------------------------
	// * Get Elevator Current Level
	//---------------------------------------------------------------------------
	public int getElevatorCurrentLevel()
	{
		return elevatorLevel;
	}

	//---------------------------------------------------------------------------
	// * Go at selected level command
	// Tell the Elevator to go to the selected level.
	//---------------------------------------------------------------------------
	public void selectLevel(int selectedLevel)
	{
		if(selectedLevel != elevatorLevel) {
			controllerSystem.goToLevel(selectedLevel);
		}
	}

	//---------------------------------------------------------------------------
	// * Elevator trigger
	// Update Elevator level.
	//---------------------------------------------------------------------------
	public void elevatorTrigger(int level)
	{
		this.elevatorLevel = level;
	}

	@Override
	public void ElevatorTrigger(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserInterfaceLevelInterface(ControllerSystem controllerSystem, Elevator elevator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
}
