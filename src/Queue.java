/**
 * 
 */

/**
 * @author Jacob Drinkwater
 *12/16/2019
 *manages the queue
 */
public class Queue {
	
	private int frontOfQueue,	//front of the queue 
				nextIndex,//next spot to enqueue to
				count;
	private String [] queue;	//the queue
	private final int MAX = 6;
	
	
	public Queue()
	{
		frontOfQueue = -1;	//queue is empty so no front
		nextIndex = 0;		//next element to be enqueued
		count = 0;
		queue = new String[MAX];
	}
	public String displayPos(int i)
	{
		return queue[i];
	}
	public void enqueue(String item)
	{
		if (nextIndex != frontOfQueue || count == 0)			//room in queue?
		{
			queue[nextIndex] = item;
			//was the queue empty?
			if(frontOfQueue == -1)		//if it was an empty queue, make it zero 
				frontOfQueue = 0;
			nextIndex++;
			count++;
			if(nextIndex >= MAX)	//wrap back to the start
			
				nextIndex = 0;
		}
		
			
	}
	
	public String dequeue()
	{
		String data = "";
		if (count > 0)		//someone to dequeue
		{
			data = queue[frontOfQueue];
			frontOfQueue++;
			count--;
			if(frontOfQueue >= MAX)
			{
				frontOfQueue = 0;
			}
		}
		return data;
	}
	
	public int length()
	{
		int lengthCount = 0;
		for(int i=0; i<MAX;i++)
		{
			if(queue[i] != null)
			{
				lengthCount++;
			}
		
		}
		return lengthCount;
	}
	public String toString()		//no dequeue so just print the queue has to change later
	{
		String result = "";
		if (count > 0)
		{
			int i = frontOfQueue;
			int numDone = 0;
			while (numDone < count)
			{
				result += queue[i] +  "  ";
				i++;
				if(i >= MAX)
					i=0;
				numDone++;
				
			}
			
			
			
		}
		return result;
	}
	
	
}
