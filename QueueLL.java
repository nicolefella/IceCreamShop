//CS201 Assignment6
//Nicole Fella

/**
 * Implement Queue interface using instance of LinkedList to maintain data
 * @author nicole
 *
 */
public class QueueLL<T> implements Queue<T>
{
	/**
	 * The head of the list will represent the beginning of queue
	 */
	LinkedList<T> queue = new LinkedList<T>();
	
	/**
	 * Operation enqueue data (parameter) to end of queue
	 */
	public void enqueue(T data)
	{
		//the tail is the end of queue, so insertLast to enqueue
		this.queue.insertLast(data);
	}
	
	/**
	 * Operation to dequeue data from the beginning of the queue
	 */
	public T dequeue()
	{
		//store data from beginning of queue
		T localData = this.queue.getFirst();
		//dequeue by deleting first 
		this.queue.deleteFirst();
		//return stored data
		return localData;
	}
	
	/**
	 * Query which will check what is at the beginning of the queue
	 * @return what is at the beginning of the queue
	 */
	public T peek()
	{
		//the head is the beginning of queue, so getFirst to peek
		return (T)this.queue.getFirst();
	}
	
	/**
	 * Query if the Stack is empty or not
	 * @return boolean true or false
	 */
	public boolean isEmpty()
	{
		//return whether the queue is empty of not 
		return this.queue.isEmpty();
	}

}
