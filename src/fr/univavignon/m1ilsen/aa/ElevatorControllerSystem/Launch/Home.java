package fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Launch;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.ControllerSystem.Implementation.ControllerSystem;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Implementation.Elevator;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Elevator.Interface.ElevatorListener;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.Sequencer.Sequencer;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceLevel.Implementation.UserInterfaceLevel;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserInterface.UserInterfaceShaft.Implementation.UserInterfaceShaft;
import fr.univavignon.m1ilsen.aa.ElevatorControllerSystem.UserSimulation.Implementation.UserSimulation;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener {
	JPanel paneConfig;
	JPanel paneMeasure;
	JButton btnReset;
	JButton btnStart;
	JSpinner optionSpeed;
	JSpinner optionNbLevel;
	JSpinner optionSimTime;
	JSpinner optionDiala;
	JSpinner optionContra;
	JSpinner optionHeight;
	JSpinner optionInterval;
	JRadioButton rdbtnSjf;
	JRadioButton rdbtnFifo;
	ElevatorListener elevatorlistener;
	JScrollPane scrollPane ;
	JTextArea textArea;
	JSpinner optionUser;
	int totalLevel;
	int totalUser;
	ArrayList<UserSimulation> listUser;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public Home()
	{
		setResizable(false);
		setTitle("Elevator Controller System");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	setSize(1000,800);
	  	setLocationRelativeTo(null);  
		
		JPanel paneTitle = new JPanel();
		paneTitle.setBackground(new Color(51, 102, 204));
		paneTitle.setBounds(0, 0, 994, 56);
		getContentPane().add(paneTitle);
		paneTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("Bienvenu dans notre ECS (Elevator Controller System)");
		lblTitle.setBounds(167, 12, 637, 26);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTitle.setBackground(new Color(255, 255, 255));
		paneTitle.add(lblTitle);
		
		/* Configuration Panel*/
		JPanel paneConfig = new JPanel();
		paneConfig.setBackground(new Color(255, 255, 255));
		paneConfig.setBounds(0, 56, 626, 668);
		getContentPane().add(paneConfig);
		paneConfig.setLayout(null);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBackground(new Color(51, 102, 204));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setOpaque(true);
		btnReset.setBounds(106, 595, 144, 46);
		btnReset.addActionListener(this);
		paneConfig.add(btnReset);
		
		btnStart= new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(361, 595, 144, 46);
		btnStart.setBackground(new Color(51, 102, 204));
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.addActionListener(this);
		paneConfig.add(btnStart);
		
		JLabel lblSpeed = new JLabel("Vitesse d'ascenseur :");
		lblSpeed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSpeed.setBounds(25, 11, 144, 38);
		paneConfig.add(lblSpeed);
		
		optionSpeed = new JSpinner();
		optionSpeed.setModel(new SpinnerNumberModel(1, 1, 1000000, 1));
		optionSpeed.setBounds(208, 17, 95, 28);
		paneConfig.add(optionSpeed);
		
		JLabel lblTempDeSimulation = new JLabel("Dur\u00E9e de simulation :");
		lblTempDeSimulation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempDeSimulation.setBounds(26, 207, 154, 38);
		paneConfig.add(lblTempDeSimulation);
		
		optionSimTime = new JSpinner();
		optionSimTime.setModel(new SpinnerNumberModel(1, 1, 1000000, 1));
		optionSimTime.setBounds(209, 213, 95, 28);
		paneConfig.add(optionSimTime);
		
		JLabel lblmaxspeed = new JLabel("cm/s");
		lblmaxspeed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxspeed.setBounds(325, 16, 73, 28);
		paneConfig.add(lblmaxspeed);
		
		JLabel lblmaxsim = new JLabel("s");
		lblmaxsim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxsim.setBounds(327, 215, 95, 23);
		paneConfig.add(lblmaxsim);
		
		JLabel lblTempEnRel = new JLabel("Dilatation du temp :");
		lblTempEnRel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTempEnRel.setBounds(25, 256, 144, 38);
		paneConfig.add(lblTempEnRel);
		
		optionDiala = new JSpinner();
		optionDiala.setModel(new SpinnerNumberModel(1, 1, 1000000, 1));
		optionDiala.setBounds(209, 262, 95, 28);
		paneConfig.add(optionDiala);
		
		JLabel lblMaxReal = new JLabel("s");
		lblMaxReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxReal.setBounds(327, 259, 85, 28);
		paneConfig.add(lblMaxReal);
		
		JLabel lblHeight = new JLabel("Hauteur d'\u00E9tage :");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeight.setBounds(26, 109, 126, 38);
		paneConfig.add(lblHeight);
		
		optionHeight = new JSpinner();
		optionHeight.setModel(new SpinnerNumberModel(100, 100, 1000000, 1));
		optionHeight.setBounds(209, 115, 95, 28);
		paneConfig.add(optionHeight);
		
		JLabel lblmaxheight = new JLabel("cm");
		lblmaxheight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblmaxheight.setBounds(327, 114, 85, 28);
		paneConfig.add(lblmaxheight);
		
		optionInterval = new JSpinner();
		optionInterval.setModel(new SpinnerNumberModel(30, 30, 1000000, 1));
		optionInterval.setBounds(209, 164, 95, 28);
		paneConfig.add(optionInterval);
		
		JLabel lblmaxinterval = new JLabel("cm");
		lblmaxinterval.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxinterval.setBounds(327, 163, 85, 28);
		paneConfig.add(lblmaxinterval);
		
		JLabel lblInterval = new JLabel("Hauteur entre l'\u00E9tage :");
		lblInterval.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInterval.setBounds(26, 158, 165, 38);
		paneConfig.add(lblInterval);
		
		JLabel lblAlgorithme = new JLabel("Algorithme :");
		lblAlgorithme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlgorithme.setBounds(25, 385, 95, 38);
		paneConfig.add(lblAlgorithme);
		
		rdbtnSjf = new JRadioButton("SJF");
		rdbtnSjf.setSelected(true);
		rdbtnSjf.setBounds(208, 394, 109, 23);
		rdbtnSjf.addActionListener(this);
		paneConfig.add(rdbtnSjf);
		
		rdbtnFifo = new JRadioButton("FIFO");
		rdbtnFifo.setBounds(340, 394, 109, 23);
		rdbtnFifo.addActionListener(this);
		paneConfig.add(rdbtnFifo);
		
		JLabel lblNbLvl = new JLabel("Nombre d'\u00E9tage :");
		lblNbLvl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNbLvl.setBounds(25, 60, 126, 38);
		paneConfig.add(lblNbLvl);
		
		optionNbLevel = new JSpinner();
		optionNbLevel.setModel(new SpinnerNumberModel(1, 1, 1000000, 1));
		optionNbLevel.setBounds(208, 66, 95, 28);
		paneConfig.add(optionNbLevel);
		
		JLabel lblContractionDuTemp = new JLabel("Contraction du temp :");
		lblContractionDuTemp.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblContractionDuTemp.setBounds(25, 300, 144, 38);
		paneConfig.add(lblContractionDuTemp);
		
		optionContra = new JSpinner();
		optionContra.setBounds(209, 306, 95, 28);
		optionContra.setModel(new SpinnerNumberModel(1,1,1000000,1));
		paneConfig.add(optionContra);
		
		JLabel label_1 = new JLabel("s");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(327, 303, 85, 28);
		paneConfig.add(label_1);
		
		JLabel lblNbUser = new JLabel("Nombre d'utilisateur :");
		lblNbUser.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNbUser.setBounds(25, 346, 155, 38);
		paneConfig.add(lblNbUser);
		
		optionUser = new JSpinner();
		optionUser.setBounds(208, 352, 95, 28);
		optionUser.setModel(new SpinnerNumberModel(1,1,1000000,1));
		paneConfig.add(optionUser);
			
		
		/* Measure Panel*/
		JPanel paneMeasure = new JPanel();
		paneMeasure.setBackground(new Color(204, 204, 204));
		paneMeasure.setBounds(626, 56, 368, 668);
		getContentPane().add(paneMeasure);
		paneMeasure.setLayout(null);
		
		textArea = new JTextArea ();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0, 0, 368, 668);
		paneMeasure.add(scrollPane);
		
		/* FOOTER*/
		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(51, 102, 204));
		panelFooter.setBounds(0, 725, 994, 47);
		getContentPane().add(panelFooter);
		panelFooter.setLayout(null);
		
		JLabel lblFooter = new JLabel("Universit\u00E9 d'Avignon et des Pays de Vaucluse");
		lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFooter.setBounds(361, 3, 274, 17);
		lblFooter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFooter.setForeground(new Color(255, 255, 255));
		panelFooter.add(lblFooter);
		
		JLabel lblFooter2 = new JLabel("ILSEN-M1");
		lblFooter2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFooter2.setForeground(new Color(255, 255, 255));
		lblFooter2.setBackground(new Color(255, 255, 255));
		lblFooter2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFooter2.setBounds(466, 22, 52, 14);
		panelFooter.add(lblFooter2);
		
	}


	public void startSimulation() {
		// TODO Auto-generated method stub 
		textArea.append("Simulation commence....\n");
		int nbLevel=(int) optionNbLevel.getValue();
		int height=(int) optionHeight.getValue();
		int speed=(int) optionSpeed.getValue();
		int extraHeight=(int) optionInterval.getValue();
		//initialization 
		Elevator elevator=new Elevator(nbLevel,elevatorlistener,speed,height,extraHeight);
		
		String algo;
		if(rdbtnSjf.isSelected())
		{
			algo=rdbtnSjf.getText();
		}
		else
		{
			algo=rdbtnFifo.getText();
		}
		ControllerSystem controllerSystem = new ControllerSystem(algo,elevator);
		elevator.setListener(controllerSystem);
		for(int i = 0 ; i < elevator.listOfLevel.size();++i)
		{
			elevator.listOfLevel.get(i).setUserInterfaceLevel(new UserInterfaceLevel(controllerSystem,elevator));
		}
		elevator.shaft.setUserInterfaceShaft(new UserInterfaceShaft(controllerSystem,elevator));
		totalUser=(int)optionUser.getValue();
		listUser=new ArrayList<UserSimulation>(totalUser);
		for(int i = 0;i<totalUser;++i)
		{
			int currLevel=(int)(Math.random() * (int)optionNbLevel.getValue());
			int lvltogo=(int)(Math.random() * (int)optionNbLevel.getValue());
			UserSimulation user  = new UserSimulation(elevator);
			user.setCurrentLevel(currLevel);
			user.setLevelToGo(lvltogo);
			listUser.add(user);
		}

		Sequencer.create(1000, 60000, 1, 10,elevator,controllerSystem,listUser);
		
		Sequencer.start();		
	}


	public void reset() {
		// TODO Auto-generated method stub
		optionSpeed.setValue(1);
		optionSimTime.setValue(1);
		optionDiala.setValue(1);
		optionUser.setValue(1);
		optionContra.setValue(1);
		optionHeight.setValue(100);
		optionInterval.setValue(30);
		optionNbLevel.setValue(1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == btnReset){
			reset();
		} else if(source == btnStart){
			startSimulation();	
		}
		else if(source == rdbtnSjf )
		{
			rdbtnSjf.setSelected(true);
			rdbtnFifo.setSelected(false);
		}
		else if(source == rdbtnFifo )
		{
			rdbtnSjf.setSelected(false);
			rdbtnFifo.setSelected(true);
		}
	}
}
