/*Jacob Drinkwater
 * Call center simulation window
 * User can start the call center, then take calls.
 * 12/16/2019
 */




import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MultiThreadingTestApp implements ActionListener {
	
	
	
	JLabel titleLabel;				//Text beside userTextBox to show user where to type in items
	JButton startButton;					//Deletes one, several or all selected items from choreList 
	JButton takeCallButton;
	JButton finishedCallButton;
	JTextArea qCountLabel;
	CallManager callMgr;
	long startTime;
	long endTime;
	long finalTime;
	int seconds = 0;
	int callsFinished = 0;
	//Calls the createUI method 
	public MultiThreadingTestApp()
	{
		createUI();
	}
	
	// createUI - function (method in JAVA) to initialize the window
	public void createUI()
	{
	//set up the window 
	JFrame window = new JFrame("IT Call Center");
	window.setVisible(true);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setSize(300, 600); //width first, height second
	window.setLocationRelativeTo(null);
	window.setLayout(new FlowLayout());
	
	//create GUI components
	titleLabel = new JLabel("-Call Center-");
	
	qCountLabel = new JTextArea(30,20);
	
	startButton = new JButton("Start Call Center");
	takeCallButton = new JButton("Take Call");
	takeCallButton.setEnabled(false);
	finishedCallButton = new JButton("Finished Call");
	finishedCallButton.setEnabled(false);

	//change the font on the title label
	titleLabel.setFont(new Font("Segoe UI",1,20));
	
	//put components on the window
	window.add(titleLabel);



	window.add(startButton);
	window.add(takeCallButton);
	window.add(finishedCallButton);
	window.add(qCountLabel);
	qCountLabel.setText("Call Center Info");
	
	
	//add the listeners
	
	
	startButton.addActionListener(this);
	takeCallButton.addActionListener(this);
	finishedCallButton.addActionListener(this);
	
	}		

	   public static void main(String args[]) {
		   
		   
		   
			SwingUtilities.invokeLater(new Runnable() 
			{
				public void run() 
				{
					new MultiThreadingTestApp();
				}
			});   //end of the call to invoke later 
	     
	      
	     
	   } 
	   
	   
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource()== startButton)
			{
				callMgr = new CallManager(qCountLabel);
				callMgr.start();
				takeCallButton.setEnabled(true);
		  
			}
			if (e.getSource()==takeCallButton)
			{
				startTime = System.currentTimeMillis();
				qCountLabel.append("\nProcessing: " + callMgr.takeCall() + "\n");
				finishedCallButton.setEnabled(true);
				
			}
			if (e.getSource()==finishedCallButton)
			{
				endTime = System.currentTimeMillis();
				finalTime = (endTime - startTime)/1000;
				callsFinished++;
				qCountLabel.append("\n"+callMgr.finishedCall()+"\n");
				qCountLabel.append("call took " + finalTime + " second to complete");
				qCountLabel.append("\n"+callsFinished+ "calls finished" + "\n");
			}
			
		}
		
}





