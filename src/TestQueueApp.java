/**
 * 
 */

/**
 * @author s_taylor
 *
 */
public class TestQueueApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"My printer won't work","I can't log in", "My screen is frozen","Projector won't work","Computer won't turn on","mouse is broken"};
		Queue q = new Queue();
		q.enqueue("hi");
		q.enqueue(arr[3]);
		System.out.println(q.length());
		//System.out.println(q);
		//for (int i = 1; i <= 10; i++)
		//{
		//	q.enqueue("Person" + i);
		//	System.out.println(q);
		//}

	}

}
