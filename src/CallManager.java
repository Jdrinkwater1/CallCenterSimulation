import java.util.Random;

import javax.swing.*;


/**
 * @author Jacob
 * manages taking/ending/starting calls
 *12/16/2019
 */
public class CallManager implements Runnable {
	
	private int nowServing;
	private int count;
	JTextArea countlabel;
	Queue q1 = new Queue();
	public CallManager(JTextArea label)
	{
		countlabel = label;
		countlabel.setText("Call center started");
	}
	
	
	
	
	
	
	public void run() {
		System.out.println("running");
		String arr[] = {"My printer won't work","I can't log in", "My screen is frozen","Projector won't work","Computer won't turn on","mouse is broken"};
		try {
			for(int i = 0; i<6;i++)
			{
				
				Thread.sleep(2000);
				Random random = new Random();
				int rand =  random.nextInt(5);
				q1.enqueue(arr[rand]);
				System.out.println(q1.displayPos(i));
				countlabel.append("\n" + (i+1) + " calls in the queue");
				count++;
				System.out.println("Call: " + (i+1) + q1.displayPos(i));
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread interrupted");
		}
		
		countlabel.append("\n Call manager done");
	}
	public String takeCall()
	{
		String call = "Queue is empty";
		if(count>0 && nowServing < q1.length())
		{	
			call = q1.displayPos(nowServing);
			nowServing++;
		}
		return call;
	}
	public String finishedCall()
	{
		q1.dequeue();
		return "Removed call from queue.";
		
	}
	public void start()
	{
		
		Thread t = new Thread(this);
		t.start();
	}

}
