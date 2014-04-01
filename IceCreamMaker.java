//CS201 Assignment 6
//Nicole Fella

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * Ice Cream Maker class extends JPanel and implements ActionListener.
 * This class uses the ice cream cone class to add and remove scoops from the cone.
 * @author nicole
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener
{
	/**
	 * Instance properties
	 */
	private IceCreamCone cone;
	private JButton[] flavorButtons;
	
	/**
	 * Constructor initializes  layout
	 */
	public IceCreamMaker()
	{
		super(new BorderLayout());
		
		setBackground(Color.LIGHT_GRAY);
		
		//add cone to the panel
		this.cone = new IceCreamCone();
		add(this.cone, "Center");
		
		//add menu panel to top of panel
		add(createMenuPanel(), "North");
	}
	
	/**
	 * Create Menu Panel which will contain flavor menu and trash button
	 */
	private JPanel createMenuPanel()
	{
		//create new menu panel
		JPanel menuPanel = new JPanel(new GridLayout(2,1));
		//add flavor menu to north of menu panel
		menuPanel.add(createFlavorMenu());
		//add trash button to south of menu panel
		menuPanel.add(createTrashButton());
		//return the menu panel
		return menuPanel;
	}
	
	/**
	 * Create flavor menu of buttons for each flavor
	 */
	public JPanel createFlavorMenu()
	{
		//use GridLayout to organize buttons in one row
		JPanel flavorPanel = new JPanel(new GridLayout(1,IceCreamCone.FLAVORS.length));
		
		//initialize flavor button array to contain number of flavors
		this.flavorButtons = new JButton[IceCreamCone.FLAVORS.length];
		
		//for each flavor, initialize button
		for (int i=0; i<flavorButtons.length; i++)
		{
			//button will represent given flavor at index
			this.flavorButtons[i] = new JButton(IceCreamCone.FLAVORS[i]);
			//button will contain color of given flavor at index
			this.flavorButtons[i].setBackground(IceCreamCone.PAINT_COLORS[i]);
			//add action listener to the button
			this.flavorButtons[i].addActionListener(this);
			//add button to the Panel (within the GridLayout)
			flavorPanel.add(this.flavorButtons[i]);
		}
		//return the panel
		return flavorPanel;
	}
	
	/**
	 * Create trash button which pops the top scoop
	 */
	public JButton createTrashButton()
	{
		//create trash button with label "Trash top scoop"
		JButton trashButton = new JButton("Oh no! Trash top scoop!");
		//add action listener to this button
		trashButton.addActionListener(new ActionListener(){
			//if an action is performed, pop the top scoop
			public void actionPerformed(ActionEvent e)
			{
				//pop the top of scoop when button is pressed
				IceCreamMaker.this.cone.popTopScoop();
				System.out.println("You are popping off the top scoop");
				//ALWAYS REPAINT!!!
				IceCreamMaker.this.cone.repaint();
			}
		});
		//return this trash button
		return trashButton;
	}
	
	/**
	 * This action performed method is used for the flavor buttons. 
	 * It will detect which button is pressed and add scoop accordingly
	 */
	public void actionPerformed(ActionEvent e)
	{
		//check all the buttons when a button is pressed
		for(int i=0; i<this.flavorButtons.length; i++)
		{
			//figure out which button was pressed
			if(e.getSource()== this.flavorButtons[i])
			{
				//add scoop of ice cream at given flavor
				this.cone.addScoop(IceCreamCone.FLAVORS[i]);
				System.out.println("Adding " + IceCreamCone.FLAVORS[i] + " flavor");
			}
		}
		//always repaint!!!
		this.cone.repaint();
	}
	
	/**
	 * Getter method to get the current cone
	 */
	public IceCreamCone getCone()
	{
		return this.cone;
	}
	
	/**
	 * Reset the cone so there are no scoops
	 */
	public void reset()
	{
		//if there are scoops on the cone
		while(this.cone.hasScoop())
		{
			//pop them off
			this.cone.popTopScoop();
		}
		
		//ALWAYS REPAINT
		repaint();
	}

	/**
	 * Main method
	 */
	public static void main(String[] args)
	{
		//create new frame
		JFrame iceCreamMakerFrame = new JFrame("Ice cream cone maker");
		//set frame size
		iceCreamMakerFrame.setSize(600,600);
		//add ice cream maker to the frame
		iceCreamMakerFrame.add(new IceCreamMaker());
		//set close operation
		iceCreamMakerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make frame visible
		iceCreamMakerFrame.setVisible(true);
	}
}
