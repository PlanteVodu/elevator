package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Measure;

import java.util.*;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

import java.io.*;

public class Measure {

	public int userNumber;
	
	public String fileName;
	
	/**
	 * Constructor
	 * @param file fileName
	 * @param u list of users
	 */
	public Measure(String file, ArrayList<UserSimulation> u)
	{
		userNumber = u.size();
		fileName = file;
	}
	
	/**
	 * Getter of userNumber
	 * @return userNumber
	 */
	public int getUserNumber()
	{
		return userNumber;
	}
	
	/**
	 * Setter of userNumber
	 * @param userNumber
	 */
	public void setUserNumber(int userNumber)
	{
		this.userNumber = userNumber;
	}
	
	/**
	 * Getter of fileName
	 * @return fileName
	 */
	public String getFileName()
	{
		return fileName;
	}
	
	/**
	 * Setter of fileName
	 * @param fileName
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * Calculates and write in file all the statistics
	 * @param u list of users
	 */
	public void allTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		s += "Nombre d'utilisateurs : "+userNumber+" \n";
		s += waitingTime(u);
		s += "\n";
		s += actionTime(u);
		System.out.println(s);
		File f = new File(fileName);
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(s);
			fw.flush();
			fw.close();
		}
		catch(IOException e) {
			System.out.println("Erreur lors de l'ouverture du fichier");
		}
	}
	
	/**
	 * Calculate all the statistics of waiting outside of the elevator
	 * @param u list of users
	 * @return text with values
	 */
	public String waitingTime(ArrayList<UserSimulation> u)
	{
		String s = "Pour le temps d'attente hors de l'ascenseur : \n";
		s += maxWaitingTime(u);
		s += minWaitingTime(u);
		s += averageWaitingTime(u);
		s += medianWaitingTime(u);
		s += rangeWaitingTime(maxW(u),minW(u));
		return s;
	}
	
	/**
	 * Calculate all the statistics of waiting inside of the elevator
	 * @param u list of users
	 * @return text with values
	 */
	public String actionTime(ArrayList<UserSimulation> u)
	{
		String s = "Pour le temps d'attente dans l'ascenseur : \n";
		s += maxActionTime(u);
		s += minActionTime(u);
		s += averageActionTime(u);
		s += medianActionTime(u);
		s += rangeActionTime(maxA(u),minA(u));
		return s;
	}
	
	/**
	 * Calculate the maximum value of waiting outside
	 * @param u list of users
	 * @return the string with text and value
	 */
	public String maxWaitingTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long max = -100;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();
			if(res > max)
			{
				max = res;
			}
		}
		max = max/1000;
		s = "Valeur maximale : "+max+" secondes \n";
		return s;
	}
	
	/**
	 * Getter of maximum value of waiting outside
	 * @param u list of users
	 * @return
	 */
	public long maxW(ArrayList<UserSimulation> u)
	{
		long max = -100;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();
			if(res > max)
			{
				max = res;
			}
		}
		max = max/1000;
		return max;
	}
	
	/**
	 * Calculate the maximum value of waiting inside
	 * @param u list of users
	 * @return the string with text and value
	 */
	public String maxActionTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long max = -100;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();
			if(res > max)
			{
				max = res;
			}
		}
		max = max/1000;
		s = "Valeur maximale : "+max+" secondes \n";
		return s;
	}
	
	/**
	 * Getter of maximum value of waiting inside
	 * @param u list of users
	 * @return
	 */
	public long maxA(ArrayList<UserSimulation> u)
	{
		long max = -100;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();
			if(res > max)
			{
				max = res;
			}
		}
		max = max/1000;
		return max;
	}
	
	/**
	 * Calculate the minimum value of waiting outside
	 * @param u list of users
	 * @return
	 */
	public String minWaitingTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long min = 100000000;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();
			if(res < min)
			{
				min = res;
			}
		}
		min = min/1000;
		s = "Valeur minimale : "+min+" secondes \n";
		return s;
	}
	
	/**
	 * Getter of minimum value of waiting outside
	 * @param u
	 * @return
	 */
	public long minW(ArrayList<UserSimulation> u)
	{
		long min = 1000000000;
		for(int i = 0;i<userNumber;i++) 
		{
			long res = u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();
			if(res < min)
			{
				min = res;
			}
		}
		min = min/1000;
		return min;
	}
	
	/**
	 * Calculate the minimum value of waiting inside
	 * @param u list of users
	 * @return
	 */
	public String minActionTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long min = 1000000000;
		for(int i = 0;i<userNumber;i++)
		{
			long res = u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();
			if(res < min)
			{
				min = res;
			}
		}
		min = min/1000;
		s = "Valeur minimale : "+min+" secondes \n";
		return s;
	}
	
	/**
	 * Getter of minimum value of waiting inside
	 * @param u list of users
	 * @return
	 */
	public long minA(ArrayList<UserSimulation> u)
	{
		long min = 1000000000;
		for(int i = 0;i<userNumber;i++)
		{
			long res = u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();
			if(res < min)
			{
				min = res;
			}
		}
		min = min/1000;
		return min;
	}
	
	/**
	 * Calculate the average value of waiting outside
	 * @param u list of users
	 * @return
	 */
	public String averageWaitingTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long res = 0;
		for(int i = 0;i<userNumber;i++)
		{
			res += u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();
		}
		res = res/userNumber;
		res = res/1000;
		s = "Temps moyen d'attente : "+res+" secondes \n";
		return s;
	}
	
	/**
	 * Calculate the average value of waiting inside
	 * @param u list of users
	 * @return
	 */
	public String averageActionTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long res = 0;
		for(int i = 0;i<userNumber;i++)
		{
			res += u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();
		}
		res = res/userNumber;
		res = res/1000;
		s = "Temps moyen d'attente : "+res+" secondes \n";
		return s;
	}
	
	/**
	 * Calculate the median value of waiting outside
	 * @param u list of users
	 * @return
	 */
	public String medianWaitingTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long[] tab = new long[userNumber];
		long res = 0;
		for(int i = 0;i<userNumber;i++)
		{
			tab[i] = u.get(i).getEntranceTimeElevator() - u.get(i).getWaitingTimeOutsideElevator();	
		}
		Arrays.sort(tab);
		if(userNumber %2 == 1)
		{
			int middle = (userNumber/2)+1;
			res = tab[middle]/2;
		}
		else
		{
			int middle = (userNumber/2)-1;
			int middle2 = userNumber/2; 
			res = (tab[middle] + tab[middle2])/2;
		}
		res = res/1000;
		s += "Temps median d'attente : "+res+" secondes \n";
		return s;
	}
	
	/**
	 * Calculate the median value of waiting inside
	 * @param u list of users
	 * @return
	 */
	public String medianActionTime(ArrayList<UserSimulation> u)
	{
		String s = "";
		long[] tab = new long[userNumber];
		long res = 0;
		for(int i = 0;i<userNumber;i++)
		{
			tab[i] = u.get(i).getExitTime() - u.get(i).getEntranceTimeElevator();	
		}
		Arrays.sort(tab);
		if(userNumber %2 == 1)
		{
			int middle = (userNumber/2);
			res = tab[middle];
		}
		else
		{
			int middle = (userNumber/2)-1;
			int middle2 = (userNumber/2); 
			res = (tab[middle] + tab[middle2])/2;
		}
		res = res/1000;
		s += "Temps median d'attente : "+res+" secondes \n";
		return s;
	}
	
	/**
	 * Calculate the range value of waiting outside
	 * @param max
	 * @param min
	 * @return
	 */
	public String rangeWaitingTime(long max, long min)
	{
		String s = "";
		long res = max - min;
		s += "Il y a une etendue de : "+res+" secondes \n";
		return s;
	}
	
	/**
	 * Calculate the range value of waiting inside
	 * @param max
	 * @param min
	 * @return
	 */
	public String rangeActionTime(long max, long min)
	{
		String s = "";
		long res = max - min;
		s += "Il y a une etendue de : "+res+" secondes \n";
		return s;
	}
	

}
