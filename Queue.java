//CS201 Assignment6
//Nicole Fella

/**
 * Interface for ADT Queue which is FIFO
 * @author nicole
 * This interface will include operations enqueue and dequeue.
 * It will also support queries peek and empty
 */
public interface Queue<T> 
{
	/**
	 * Operation enqueue data (parameter) to end of queue
	 */
	public void enqueue(T data);
	
	/**
	 * Operation to dequeue data from the beginning of the queue
	 */
	public T dequeue();
	
	/**
	 * Query which will check what is at the beginning of the queue
	 * @return what is at the beginning of the queue
	 */
	public T peek();
	
	/**
	 * Query if the Stack is empty or not
	 * @return boolean true or false
	 */
	public boolean isEmpty();


}
