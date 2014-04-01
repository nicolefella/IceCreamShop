//CS201 Assignment 6
//Nicole Fella


/**
 * Interface for the ADT Stack which is LIFO
 * @author nicole
 * This interface will have operations push and pop.
 * It will also have queries peek and empty.
 */
public interface Stack<T>{
	/**
	 * Operation push to add data (parameter) to top of stack
	 */
	public void push(T data);
	
	/**
	 * Operation pop to remove something from top of stack 
	 */
	public T pop();
	
	/**
	 * Query which will check what is at top of stack
	 * @return what is at top of stack
	 */
	public T peek();
	
	/**
	 * Query if the Stack is empty or not
	 * @return boolean true or false
	 */
	public boolean isEmpty();
}
