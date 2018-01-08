package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.Implementation.UserInterface;

//=============================================================================
// ▼ UserInterfaceLevel
// ----------------------------------------------------------------------------
//
//=============================================================================
public class UserInterfaceLevel extends UserInterface implements UserInterfaceLevelInterface, ElevatorListener
{
	private ControllerSystem controllerSystem;
	private Elevator elevator;

	private int elevatorLevel;

	//---------------------------------------------------------------------------
	// * Constructor
	//---------------------------------------------------------------------------
	public void createUserInterfaceShaft(ControllerSystem controllerSystem, Elevator elevator) {
		this.controllerSystem = controllerSystem;
		this.elevator = elevator;
		//elevator.addListener(this);
	}

	//---------------------------------------------------------------------------
	// * Get Elevator Current Level
	//---------------------------------------------------------------------------
	public int getElevatorCurrentLevel()
	{
		return elevatorLevel;
	}

	//---------------------------------------------------------------------------
	// * Move up command
	//---------------------------------------------------------------------------
	public void moveUp()
	{
		controllerSystem.callAtLevel(elevatorLevel, 1); // true = up
	}

	//---------------------------------------------------------------------------
	// * Move down command
	//---------------------------------------------------------------------------
	public void moveDown()
	{
		controllerSystem.callAtLevel(elevatorLevel, -1); // false = down
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
}
