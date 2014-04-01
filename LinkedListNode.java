//CS201 Assignment 6
//Nicole Fella

/**
 * Code taken from Assignment 5 - Linked Lists
 * @author nicole
 * Implement a generic LinkedListNode<T> class 
 * with two instance properties (data and next)
 */
public class LinkedListNode<T> 
{
	/**
	 * Instance properties (Data and Next)
	 */
	T data;
	LinkedListNode<T> next;
	
	/**
	 * Constructor, initialize instance fields to null
	 */
	public LinkedListNode()
	{
		data = null;
		next = null;
	}
	
	/**
	 * Get the data stored at this node
	 */
	public T getData()
	{
		return this.data;
	}
	
	/**
	 * Set the data for this node
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	
	/**
	 * Get (pointer to) next node
	 */
	public LinkedListNode<T> getNext()
	{
		return this.next;
	}
	
	/**
	 * Set the next pointer to passed node
	 */
	public void setNext(LinkedListNode<T> node)
	{
		this.next = node;
	}
	
	/**
	 * Returns a String representation of this node.
	 * Data must be converted into a String (use casting).
	 * Pointer will be represented by "->"
	 */
	public String toString()
	{		
		//if there is a pointer to another node
		if (this.next!=null)
			return (String)data + " -> ";
		//if 'next' is a null pointer
		else
			return (String)data; 
	}
	
}
