//CS201 Assignment6
//Nicole Fella

//awt imports
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//swing imports
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 * Ice Cream Shop Class has an order queue which the player must execute.
 * The player must build the orders and "serve" each order to the next in line. 
 * Each order should be checked if it is correct. 
 * If so, determine a point system to award points to the player.
 * If the order is incorrect, points should be subtracted. 
 * @author nicole
 *
 */
public class IceCreamShop extends JPanel
{
	/** 
	 * Class Fields
	 */
	public static final int CORRECT_MATCH_SCORE = 10;
	public static final int INCORRECT_MATCH_SCORE = 5;
	
	/**
	 * Instance fields
	 */
	private IceCreamLine line;
	private IceCreamMaker maker;
	private int score;
	private JLabel scoreLabel;
	
	/**
	 * Constructor initializes layout
	 */
	public IceCreamShop()
	{
		//call super constructor with new BorderLayout
		super(new BorderLayout());
		//create order panel to West of Pane
		add(createOrderPanel(), "West");
		//put ice cream maker at center of pane
		this.maker = new IceCreamMaker();
		add(this.maker, "Center");
		//add serve panel to north of pane
		add(createServePanel(), "North");
		//initialize score to be 0
		this.score=0;
		
	}

	/**
	 * This method creates the order panel which will have the queue displayed
	 * and the newOrderButton
	 */
	public JPanel createOrderPanel()
	{
		//create local panel with border layout
		JPanel orderPanel = new JPanel(new BorderLayout());
		//set background color
		setBackground(Color.BLACK);
		//add new order button to be south of order pane
		orderPanel.add(createNewOrderButton(), "South");
		//instantiate new ice cream line
		this.line = new IceCreamLine();
		//put this new line at center of order pane
		orderPanel.add(this.line, "Center");
		//return this panel
		return orderPanel;
	}

	/**
	 * This method creates teh new order button which will add 
	 * a random order to the end of queue when clicked
	 */
	public JButton createNewOrderButton()
	{
		//create local button with label "Add Random Order"
		JButton newOrderButton = new JButton("Add Random Order");
		//add action listener to the button
		newOrderButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//add random order when button is clicked
				IceCreamShop.this.line.addRandomOrder();
				repaint();
			}
		});
		//return the button
		return newOrderButton;
	}

	/**
	 * This method creates the serve panel which contains a 3 section pane.
	 * The first section (top most) will contain an instructions label for the IceCreamShop.
	 * The second section (middle) will contain the score label.
	 * The last section (bottom) will contain the serveButton. 
	 */
	public JPanel createServePanel()
	{
		//create a serve panel with two area grid layout so can put items in column
		JPanel servePanel = new JPanel(new GridLayout(3,1));
		//create instructions Label
		JLabel instructionsLabel = new JLabel("Make ice cream cones to match the next order (at the top). " +
				"If right, +10pts. If wrong, -5pts.");
		//add instructions label to the pane
		servePanel.add(instructionsLabel);
		//create new JLabel for scoreLabel
		this.scoreLabel = new JLabel();
		//add score label to pane
		servePanel.add(scoreLabel);
		//update score
		updateScore();
		//create new button withlabel "Serve the next order"
		JButton serveButton = new JButton("Serve the next order");
		//add action listener to this button 
		serveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				IceCreamShop.this.serveOrder();
				repaint();
			}
		});
		//add button to the pane
		servePanel.add(serveButton);
		//return pane
		return servePanel;
	}
	
	/**
	 * This method serves the orders which are made and will update scores.
	 * It must call the helper method correctMatch() to figure out scoring.
	 * Once orders are served, the maker must be reset.
	 */
	public void serveOrder()
	{
		//as long as there is an order
		if (this.line.hasOrder())
		{
			//if there is a correct match
			if (correctMatch(this.line.getNextOrder(), this.maker.getCone()))
			{
				//update score
				this.score += CORRECT_MATCH_SCORE;
			}
			//else there isn't a correct match
			else
			{
				//update score
				this.score -= INCORRECT_MATCH_SCORE;
			}
			//update score
			updateScore();
			//reset the maker
			this.maker.reset();
		}
	}
	
	/**
	 * Update score method keeps the scoreLabel updated
	 */
	public void updateScore()
	{
		this.scoreLabel.setText("Score: "+Integer.toString(this.score));
	}
	
	/**
	 * correctMatch check that the order cone and the player-made cone are the same.
	 * If they are the same, return true.
	 * This method tests for all the possible ways the cones are not the same.
	 */
	public boolean correctMatch(IceCreamCone orderCone, IceCreamCone madeCone)
	{
		//start with order cone having scoops
		while(orderCone.hasScoop())
		{
			//if the made cone does not have scoops when the order cone does
			if (!madeCone.hasScoop())
			{
				//this is not a correct match, so return false
				return false;
			}
			
			//if the cones do not have the same popped scoop
			if (!orderCone.popTopScoop().equals(madeCone.popTopScoop()))
			{
				//this is not a correct match, so return false
				return false;
			}
			
			
			
		}
		//once the orderCone does not have scoops, return if the madeCone has scoops
		//if the cone has scoops, this will return false
		return !madeCone.hasScoop();
	}

	/**
	 * Main Method
	 */
	public static void main(String[] args)
	{
		//create new frame
		JFrame iceCreamShopFrame = new JFrame("Ice cream cone maker");
		//set frame size
		iceCreamShopFrame.setSize(700,700);
		//add ice cream maker to the frame
		iceCreamShopFrame.add(new IceCreamShop());
		//set close operation
		iceCreamShopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make frame visible
		iceCreamShopFrame.setVisible(true);
	}
}
