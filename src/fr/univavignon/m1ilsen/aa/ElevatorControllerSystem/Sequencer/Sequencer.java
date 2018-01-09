package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Sequencer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Measure.Measure;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

public class Sequencer {

	static long periode;
	static long duree;
	static int dilatation;
	static int contraction;
	static long ecoule;
	static long debut;
	static LinkedList<Process> process;
	static ArrayList<UserSimulation> userList;
	static Elevator elevator;
	static ControllerSystem controllerSystem;

	public static long getCurrentTime()
	{
		 return (System.currentTimeMillis()-debut)/dilatation*contraction;
	}
	/**
	 * @throws InterruptedException 
	 *
	 */
	public static void start(){ 
		debut=System.currentTimeMillis();
		ecoule=0;
		long temp=periode;
		
		try {
			BufferedWriter res=null; 
			File file = new File("Sortie.txt");
			if (!file.exists()) {
			     file.createNewFile();
			  }
			FileWriter fw = new FileWriter(file);
			res = new BufferedWriter(fw);

			System.out.print("en cours \n");
			do 
			{	
				if(ecoule==temp)
				{
					res.write("----------\n");
					res.write(""+ecoule/1000+" seconde\n");
					System.out.println(ecoule);
					/*for(int i=0;i<userList.size();++i)
					{
						userList.get(i).Trigger(userList.get(i).getCurrentLevel(),getCurrentTime() );
					}*/
					temp+=periode;
				}
				ecoule=(System.currentTimeMillis()-debut)/dilatation*contraction;
			
			}while(ecoule/1000<=duree/1000);
			res.write("----------\n");
			res.write("This is the end");
			res.close();
			for(int i =0 ; i< userList.size();i++)
			{
				userList.get(i).Display();
			}
			//Measure m = new Measure("stat.txt",userList);
			//m.allTime(userList);
			System.out.println("Finit");
		}
		catch (IOException e) {
		   e.printStackTrace();
		}
	}

	/**
	 * @param per
	 * @param dur
	 * @param listUser 
	 * @param dist
	 */
	public static void create( long per,long dur, int dil,int cont,Elevator ele,ControllerSystem cs, ArrayList<UserSimulation> listUser) 
	{ 
		periode=per;
		duree=dur;
		dilatation=dil;
		contraction=cont;
		elevator = ele;
		controllerSystem = cs;
		userList=listUser;
	} 
}
/*
BufferedWriter bw = null;
try {
String mycontent = "This String would be written" +
  " to the specified File";
  
File file = new File("C:/myfile.txt");


if (!file.exists()) {
   file.createNewFile();
}

FileWriter fw = new FileWriter(file);
bw = new BufferedWriter(fw);
bw.write(mycontent);
    System.out.println("File written Successfully");

} catch (IOException ioe) {
 ioe.printStackTrace();
}
finally
{ 
 try{
    if(bw!=null)
	 bw.close();
 }catch(Exception ex){
     System.out.println("Error in closing the BufferedWriter"+ex);
  }
}*/