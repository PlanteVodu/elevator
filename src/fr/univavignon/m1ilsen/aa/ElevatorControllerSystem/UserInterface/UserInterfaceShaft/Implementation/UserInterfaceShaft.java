package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft.Implementation;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft.Interface.*;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;

//=============================================================================
// ▼ UserInterfaceShaft
// ----------------------------------------------------------------------------
//
//=============================================================================
public class UserInterfaceShaft 
implements i_UserInterfaceShaft, ElevatorListener
{
	private ControllerSystem controllerSystem;
	private Elevator elevator;

	private int elevatorLevel;

	//---------------------------------------------------------------------------
	// * Constructor
	//---------------------------------------------------------------------------
	public UserInterfaceShaft(ControllerSystem controllerSystem, Elevator elevator) {
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
	public void selectLevel(int selectedLevel, UserSimulation user)
	{
		if(selectedLevel != elevatorLevel) {
			controllerSystem.goToLevel(selectedLevel,user);
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
}
