//CS201 Assignment 6
//Nicole Fella

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * IceCreamLineManager extends JPanel. 
 * This class tests IceCreamLine by offering buttons to add a random order
 * to the queue or remove the first order.
 * @author nicole
 *
 */
public class IceCreamLineManager extends JPanel
{
	/**
	 * Instance fields
	 */
	private IceCreamLine line;
	
	/**
	 * Constructor initializes layout
	 */
	public IceCreamLineManager()
	{
		//call super constructor to create new BorderLayout
		super(new BorderLayout());
		//set background color
		setBackground(Color.LIGHT_GRAY);
		//instantiate new IceCreamLine and place pane in center
		this.line = new IceCreamLine();
		add(this.line, "Center");
		//add control panel to North of pane
		add(createControlPanel(), "North");
	}
	
	/**
	 * This method creates a control panel with two buttons
	 */
	public JPanel createControlPanel()
	{
		//create panel to be returned with GridLayout to place buttons one above the other
		JPanel controlPanel = new JPanel(new GridLayout(2,1));
		//add NewOrderButton to the panel
		controlPanel.add(createNewOrderButton());
		//add RemoveNextButton to the panel
		controlPanel.add(createServeOrderButton());
		//return the panel to the method
		return controlPanel;
	}
	
	/**
	 * This method creates the NewOrderButton
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
				IceCreamLineManager.this.line.addRandomOrder();
			}
		});
		//return the button
		return newOrderButton;
	}
	
	/**
	 * This method creates RemoveNextButton
	 */
	public JButton createServeOrderButton()
	{
		//create new button with label "Serve Next Order"
		JButton removeNextButton = new JButton("Serve Next Order");
		//add action listener to button
		removeNextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//getNextOrder when button is pressed
				IceCreamLineManager.this.line.getNextOrder();
			}
		});
		//return button
		return removeNextButton;
	}
	
	/**
	 * Main Method
	 */
	public static void main(String[] args)
	{
		//create new frame
		JFrame iceCreamFrame = new JFrame("Ice Cream Line Manager");
		//set frame size
		iceCreamFrame.setSize(300,600);
		//add ice cream maker to the frame
		iceCreamFrame.add(new IceCreamLineManager());
		//set close operation
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make frame visible
		iceCreamFrame.setVisible(true);
	}
	
}
