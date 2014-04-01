//CS201 Assignment 6
//Nicole Fella

import java.awt.Color;
import javax.swing.Box;
/**
 * @author nicole
 *
 */
public class IceCreamLine extends Box
{
	/**
	 * Instance fields
	 */
	private Queue<IceCreamCone> orderLine;
	
	/**
	 * Constructor
	 */
	public IceCreamLine()
	{
		//must call superclass with integer parameter
		super(1);
		//create new queueLL class for orderLine
		this.orderLine = new QueueLL();
	}
	
	/**
	 * Add order method will add a cone to the end of queue
	 */
	public void addOrder(IceCreamCone cone)
	{
		//adds an order to the end of queue
		this.orderLine.enqueue(cone);
		//adds cone
		add(cone);
		//to add component 
		validate();
		//repaint change -- ALWAYS REPAINT!!
		repaint();
	}
	
	/**
	 * Method adds random order to end of queue
	 */
	public void addRandomOrder()
	{
		addOrder(IceCreamCone.createRandomCone());
	}
	
	/**
	 * Checks that the queue is not empty
	 */
	public boolean hasOrder()
	{
		return !this.orderLine.isEmpty();
	}
	
	/**
	 * Get order from the beginning of queue
	 */
	public IceCreamCone getNextOrder()
	{
		//dequeue order and store in dequeuedCone
		IceCreamCone dequeuedCone = (IceCreamCone)this.orderLine.dequeue();
		
		//if there is a local cone
		if (dequeuedCone != null)
		{
			//remove it
			remove(dequeuedCone);
			//to remove component
			validate();
			//repaint change -- ALWAYS REPAINT!!
			repaint();
		}
		//return dequeued cone
		return dequeuedCone;
	}

}
