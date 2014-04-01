//CS201 Assignment 6
//Nicole Fella

/**
 * Implement Stack interface using instance of LinkedList to maintain data
 * @author nicole
 * 
 */
public class StackLL<T> implements Stack<T>
{
	/**
	 * The head of the list will represent the top of stack
	 */
	LinkedList<T> list = new LinkedList<T>();
	
	/**
	 * Operation push to add data (parameter) to top of stack
	 */
	public void push(T data)
	{
		//the head represents top of stack, so insert first to push
		this.list.insertFirst(data);
	}
	
	/**
	 * Operation pop to remove something from top of stack and return it
	 */
	public T pop()
	{
		//sore the data
		T localData = this.list.getFirst();
		//delete the data from the list
		this.list.deleteFirst();
		//return the stored data
		return localData;
		
	}
	
	/**
	 * Query which will check what is at top of stack
	 * @return what is at top of stack
	 */
	public T peek()
	{
		//the head represents top of stack, so get first to peek
		return this.list.getFirst();
	}
	
	/**
	 * Query if the Stack is empty or not
	 * @return boolean true or false
	 */
	public boolean isEmpty()
	{
		//check if the list is empty and return
		return this.list.isEmpty();
	}

}
