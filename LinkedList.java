//CS201 Assignment 6
//Nicole Fella

/**
 * Code taken from Assignment 5 - Linked Lists
 * @author nicole
 * Implement generic LinkedList<T> class with one instance property(head).
 * It will only keep track of the head... that is all. 
 */
public class LinkedList<T> 
{
	/**
	 * Instance property (head)
	 */
	LinkedListNode<T> head;
	
	/**
	 * Constructor, initialize the instance field head to null
	 */
	public LinkedList()
	{
		head = null;
	}
	
	/**
	 * Get data stored in the head of the list.
	 */
	public T getFirst()
	{
		return getFirstNode().getData();
	}
	
	/**
	 * Get the head node of the list
	 */
	public LinkedListNode<T> getFirstNode()
	{
		return this.head;
	}
	
	/** 
	 * Get data stored in the tail node of the list
	 */
	public T getLast()
	{
		return getLastNode().getData();
	}
	
	/**
	 * Get the tail node of the list
	 */
	public LinkedListNode<T> getLastNode()
	{
		//create a currentNode variable, initialized with head pointer
		LinkedListNode<T> currentNode = this.head;
		//account for special case if the head is the only node
		if (this.head==null)
			return this.head;
		//assuming that the next node is not null
		while(currentNode.getNext() != null)
			currentNode = currentNode.getNext();
		//once the next node is null, return the current node
		return currentNode;
	}
	/**
     * Insert a new node with data at the head of the list.
     **/
    public void insertFirst( T data )
    {
        //create a new linkedListNode
        LinkedListNode<T> newNode = new LinkedListNode<T>();
        //assign that node some data
        newNode.setData(data);
        //point new node where current pointer is
        newNode.setNext(head);
        //set head pointer to this new node
        this.head = newNode;
          
    }
       
    /**
     * Insert a new node with data after currentNode
     **/
    public void insertAfter( LinkedListNode<T> currentNode, T data )
    {
        //create a new linkedListNode
        LinkedListNode<T> newNode = new LinkedListNode<T>();
        //assign that node some data
        newNode.setData(data);
        //point new node where current pointer is
        newNode.setNext(currentNode.getNext());
        //set head pointer to this new node
        currentNode.setNext(newNode);
    }
       
    /**
     * Insert a new node with data at the tail of the list.
     **/
    public void insertLast( T data )
    {
    	//account for special case when head is the only node
    	if (getLastNode()==this.head)
    		insertFirst(data);
    	
        //create a new linkedListNode
        LinkedListNode<T> newNode = new LinkedListNode<T>();
        //assign that node some data
        newNode.setData(data);
        //point last node to new node
        this.getLastNode().setNext(newNode);
    }
       
    /**
     * Remove head node
     **/
    public void deleteFirst()
    {
        //change the pointer of the head pointer
        this.head = this.head.getNext();
    }
       
    /**
     * Remove tail node
     **/
    public void deleteLast()
    {
    	//create a currentNode variable, initialized with head pointer
    	LinkedListNode<T> currentNode = this.head;
    	//assuming that the next next node node is not null
    	while (currentNode.getNext().getNext() != null)
    		currentNode = currentNode.getNext();
    	//once the next next node is null, set next pointer to null
    	currentNode.setNext(null);
    }
       
    /**
     * Remove node following currentNode
     * If no node exists (i.e., currentNode is the tail), do nothing
     **/
    public void deleteNext( LinkedListNode<T> currentNode )
    {
        //update pointer of the current node to the next next
        currentNode.setNext(currentNode.getNext().getNext());
    }
       
    /**
     * Compute the size of this list.
     **/
    public int size()
    {    	
    	//initialize a counter to measure the size of the list
        int sizeVar = 0;
        //create local node variable to update in while loop
        LinkedListNode<T> localNode = getFirstNode();
          
        //update counter while there are still nodes
        while(localNode != null)
        {
            sizeVar += 1;
            localNode = localNode.getNext();
        }
          
        return sizeVar;
    }
       
    /**
     * Check if list is empty.
     * @return true if list contains no items.
     **/
    public boolean isEmpty()
    {
        if (this.head == null)
            return true;
        else
            return false;
              
    }
       
    /**
     * Return a String representation of the list.
     **/
    public String toString()
    {    	
    	//initialize String variable to return 
    	String listString = "";
    	//create local node variable to update in while loop
        LinkedListNode<T> localNode = getFirstNode();
        
        //concatenate String of all nodes in list
        while(localNode != null)
        {
            listString += localNode.toString();
            localNode = localNode.getNext();
        }
        
        //return the string to the method
        return listString;
    } 
}
