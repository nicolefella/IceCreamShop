//CS201 Assignment 6
//Nicole Fella

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * IceCreamCone class extends JComponent and is responsible for painting the IceCreamCones.
 * It uses a Stack ADT implement multiple scoops.
 */
public class IceCreamCone extends JComponent
{
	/**
	 * Class properties
	 */
	public static final String[] FLAVORS = {"vanilla", "strawberry", "blueberry", "chocolate"};
	public static final Color [] PAINT_COLORS = {Color.WHITE, Color.PINK, Color.BLUE, new Color(102,51,0)};
	public static final int CONE_WIDTH= 40;
	public static final int CONE_HEIGHT = 70;
	public static final int SCOOP_DIAMETER = 60;
	public static final int SCOOP_OVERLAP = 10;
	
	/**
	 * Instance properties
	 */
	private StackLL<Integer> scoopStack;
	
	/**
	 * Constructor creates a new Stack of integers
	 */
	public IceCreamCone()
	{
		scoopStack = new StackLL<Integer>();	
	}
	
	/**
	 * Adds flavor index of scoop to the top stack
	 */
	public void addScoop(String flavor)
	{
		//find the flavor index and store in Integer
		Integer flavorIndex = findFlavorIndex(flavor);
		//push a scoop with that flavorIndex
		this.scoopStack.push(flavorIndex);
	}
	/**
	 * checks if the cone has scoops (if it is not empty)
	 */
	public boolean hasScoop()
	{
		return !this.scoopStack.isEmpty();
	}
	
	/**
	 * Method pops the top scoop
	 */
	public String popTopScoop()
	{
		//if there are no scoops, value for flavor popped is "none"
		if (this.scoopStack.isEmpty())
		{
			return "none";
		}
		//need to cast as Integer then convert back to int value to get flavor stored at that index
		return FLAVORS[(Integer)this.scoopStack.pop().intValue()];
	}
	
	/**
	 * Given a flavor, returns the corresponding index in FLAVORS.
	 * Valid parameter values: "none" or one of the FLAVORS.
	 * If invalid parameter is passed, defaults to -1.
	 */
	private int findFlavorIndex(String flavor)
	{
		//if none, ignoring case
		if (flavor.toLowerCase().equals("none"))
			//flag of -1 indicates none
			return -1;
		else
		{
			//for each allowed flavor
			for (int i=0; i<FLAVORS.length; i++)
			{
				//if found match, ignoring case
				if(flavor.toLowerCase().equals(FLAVORS[i]))
					//found flavor index
					return i;
			}
		}
		//invalid parameter passed -- default -1
		return -1;
	}
	
	/**
	 * Paint method to draw the ice cream cone
	 */
	public void paint (Graphics g)
	{
		//draw cone
		paintCone(g);
		//draw scoop
		paintScoops(g);
	}
	
	/**
	 * Paint the stack of scoops (will call helper method paintScoop())  
	 */
	public void paintScoops(Graphics g)
	{
		//upper left x is the center minus half the diameter
		int width = getWidth()/2 - SCOOP_DIAMETER/2;
		
		// upper left y accounts for cone height and a bit of overlap
		int height = getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + SCOOP_OVERLAP;
		
		//create new stack
		StackLL<Integer> localStack = new StackLL<Integer>();
		
		//get flavor index values from scoopStack and reverse copy them into localStack
		while(!this.scoopStack.isEmpty())
		{
			localStack.push(this.scoopStack.pop());
		}
		
		//use localStack values to reverse copy back into scoopStack
		//this essentially paints the scoopStack
		while(!localStack.isEmpty())
		{
			//store local scoop's flavor index
			Integer localScoopFlavorIndex = localStack.pop();
			
			//use flavor index to paint scoop
			paintScoop(g, localScoopFlavorIndex.intValue(), width, height);
			
			//update height to account for new scoops
			height = height - SCOOP_DIAMETER + SCOOP_OVERLAP;
			
			//push localStack value back onto scoopStack
			this.scoopStack.push(localScoopFlavorIndex);
		}
	}
	
	/**
	 * Paint the cone
	 **/
	public void paintCone(Graphics g)
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		
		// center bottom point
		xPoints[0] = getWidth() / 2;
		yPoints[0] = getHeight();
		
		// upper left point
		xPoints[1] = xPoints[0] - (CONE_WIDTH/2);
		yPoints[1] = yPoints[0] - CONE_HEIGHT;
		
		// upper right point
		xPoints[2] = xPoints[0] + (CONE_WIDTH/2);
		yPoints[2] = yPoints[0] - CONE_HEIGHT;
		
		// set the paint color
		g.setColor( Color.YELLOW );
		
		// draw triangle
		g.fillPolygon( xPoints, yPoints, 3 );
	}
	
	/**
	 * Paint the individual scoop
	 **/
	public void paintScoop(Graphics g, int flavorIndex, int width, int height)
	{
		if ( flavorIndex != -1 )
		{
			// set the paint color based on the flavor
			g.setColor( PAINT_COLORS[ flavorIndex ] );
		
			// fill oval (upper left x, upper left y, width, height)
			g.fillOval( width, height, SCOOP_DIAMETER, SCOOP_DIAMETER);
		}
	}
	
	/**
	 * Create Random Ice cream cone (with max 4 flavors)
	 */
	public static IceCreamCone createRandomCone()
	{
		//create a random cone
		IceCreamCone randomCone = new IceCreamCone();
		//generate the number of scoops
		for (int scoops=0; scoops<1+Math.random()*3; scoops++)
		{
			//for each scoop, create random flavor for scoop
			randomCone.addScoop(FLAVORS[((int)Math.floor(Math.random()*FLAVORS.length))]);
			
		}
		//return random cone
		return randomCone;
	}
	
}
