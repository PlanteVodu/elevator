package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation;

import java.util.ArrayList;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Interface.ControllerSystem_Interface;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;


public class ControllerSystem implements ControllerSystem_Interface,ElevatorListener
{
	//sens ==> 1 pour monter ,-1 pour descendre
	
	//Toutes les demandes des utilisateurs
	public ArrayList<Request> calledLevel;	
	
	//l'objet contient l'étage et le sens 
	public Request demande;
	
	//l'objet Elevator
	public Elevator elevator;
	
	//position actuelle de l'ascenseur 
	public int currentLevel;
	
	//algorithm d'optimisation choisi
	String algorithm;
	
	//Demande en cours de traitement
	Request currentRequest;
	
	//Constructeur qui sélectionne l'algorithme et donne l'objet Elevator
	public ControllerSystem(String algo, Elevator elevator)
	{
		this.algorithm = algo;
		this.elevator = elevator;
	}
	
	
	//Ajouter une demande depuis l'extérieur de l'ascenseur.
	@Override
	public void callAtLevel(int level,int sens)
	{
		boolean exist=false;
			
		demande = new Request(level, sens);
		//si la demmande exist deja on ne stock pas la commande
		for (int i = 0; i < calledLevel.size(); i++)
		{
			if (demande.equals(calledLevel.get(i)))
			{
				
				exist=true;
			}
		}
		//si la commande n'exist pas on l'ajoute dans notre liste
		if (!exist)
		{		
		
		calledLevel.add(demande);
		}
	}

	
	//Ajouter une demande depuis l'intérieur de l'ascenseur.
	@Override
	public void goToLevel(int level)
	{
		//boolean qui nous permet savoir si la commande exist deja ou pas
		boolean exist=false;			
		demande = new Request(level, 0);
		
		//si la demande exist deja on ne stock pas la commande
		for (int i = 0; i < calledLevel.size(); i++)
		{
			if (demande.equals(calledLevel.get(i)))
			{				
				exist=true;
			}
		}
		//si la commande n'exist pas on l'ajoute a notre liste
		if (!exist)
		{			
		calledLevel.add(demande);
		}
	 }

	
	//Sélectionne la demande à traiter
	@Override
	public void choseLevel()
	{
		int maxint=100;
		//stocke la variable qui stock l'indice de la commande la plus optimiser à traiter
		int stocki=0;
		//algorithm short job first
		if (algorithm=="SJF")
		{
			
		
			//trouver la commande la plus optimisé avec l'algorithm SJF
			for (int i = 0; i < calledLevel.size(); i++)
			{
				if (Math.abs((calledLevel.get(i).level) - currentLevel)<maxint)
				{
					maxint= Math.abs((calledLevel.get(i).level) - currentLevel);
					stocki=i;
				}			
			}
			//on recupere la commande la plus optimser pour la traiter
			currentRequest=calledLevel.get(stocki);
			
			/*on teste si l'etage actuel est plus grand que la cammande en cours on move vers le bas
			 * sinon on move vers le haut
			 */
			if (currentLevel > currentRequest.level)
			{
				elevator.switchMotorState(-1);
			}else 
				elevator.switchMotorState(+1);
			
		}else
			//algorithm first in first out
		if (algorithm=="FIFO")
			{	
				//on execute toujour la 1ere commande car c'est la premiere
				currentRequest=calledLevel.get(0);
					
					if (currentLevel > currentRequest.level)
					{
						elevator.switchMotorState(-1);
					}else 
						elevator.switchMotorState(+1);
			}
			
		}
	
	//Fonction trigger par l'ascenseur quand il change d'étage
	@Override
	public void  ElevatorTrigger(int level)
	{
		//l'etage actuel recuper par l'ascensseur
		currentLevel=level;
		
		choseLevel();
		//si on arrive à l'etage souhaiter on arrete l'asensseur
		if (currentLevel==currentRequest.level) 
		{
			//stopper l'ascensseur
			elevator.switchMotorState(0);
			//si la position de l'ascensseur = a la demande en cour on arrete l'ascenssuer et on suprime la demande
			calledLevel.remove(currentRequest);
					
		}
	}
	
}
