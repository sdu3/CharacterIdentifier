/*
 * this code reads the CSV file and prints it out (read CSV and print out part Maggie and I worked on together).
 * eventually it will also have an action listener (event generator = button, action listener = JPanel)
 * and upon the action event occurring, the "convert character" function will run and the info from 
 * the convert function's output will be placed in a JTextArea
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.applet.Applet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

//scanner files for reading CSV
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.util.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import javax.swing.JTextArea;

public class CharacterIdentifier extends JFrame implements ActionListener
{	
	//create variables
	JTextField field = new JTextField();
	char input;
	JTextArea character = new JTextArea();
	private JButton ok = new JButton("View information");
	String stringInput;
	JTextArea output = new JTextArea();
	String info;
	JLabel enter = new JLabel();
	JTextArea filler = new JTextArea();
	String hexU;
	ConvertCharacter b = new ConvertCharacter();
	
	public CharacterIdentifier() {
		enter.setLabelFor(field);
		
		//title of tool bar, size of window
		 setTitle("Character Identifier");
		    setSize(1500, 1000);
		    
		    //WHAT DOES THIS WINDOW LISTENER/ADAPTOR DO?
		    addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    System.exit(0);
		      }
		    }); 
		 field.setHorizontalAlignment(SwingConstants.LEFT);
		 
		 field.setToolTipText("Enter character here:");  
		 
		 //WHAT/WHERE ARE THESE CONTAINERS?
		 Container container;
		 container = getContentPane();
		 container.add(field, BorderLayout.NORTH);
		
		 //make button an event generator
		 ok.addActionListener(new ButtonListener());
		 
		 //add button to panel
		 //WHY ARE THERE 2 PANELS? 
		 JPanel largefont = new JPanel();
		 largefont.setBackground(SystemColor.window);
		 JPanel button = new JPanel();
		 button.add(ok);
		 getContentPane().add(button);
		 JPanel fill = new JPanel();
		 fill.add(filler);
		 getContentPane().add(fill);
		 character.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		 largefont.add(character);
		 getContentPane().add(largefont);
		 enter.setBackground(Color.LIGHT_GRAY);
		 enter.setVerticalAlignment(SwingConstants.BOTTOM);
		 enter.setHorizontalAlignment(SwingConstants.CENTER);
		 enter.setText("Enter character here");
		 container.setBackground(Color.WHITE);

		 container.add(largefont, BorderLayout.WEST);
		 container.add(button, BorderLayout.SOUTH);
		 container.add(enter, BorderLayout.CENTER); //how do i get this to show up under the input line?
		 filler.setBackground(SystemColor.window);
		 container.add(fill, BorderLayout.EAST);
		 output.setTabSize(10);
		 output.setWrapStyleWord(true);
		 output.setLineWrap(true);
		 output.setEditable(false);
		 getContentPane().add(output, BorderLayout.CENTER);
		
	}
	 

	  //action listener reaction
	  private class ButtonListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
	    	    
		    	//currently only one event generator so not necessary, but get source of event
		    	JButton src = (JButton) e.getSource();

		    	    if (src == ok) 
		    	    {	
		    	    	
		    	    	
		    	    	stringInput = field.getText(); 
			    	    char input = stringInput.charAt(0);
			    	    System.out.println("from button listener, input: " + input);
			    	    
			    	    character.setText("Character in larger font: " + stringInput);
			    	    character.setVisible(true);
			    	   
			    	    CharacterIdentifier categories = new CharacterIdentifier();
			    	    categories.run(input);
			    	    
			    	  //information independent of CSV file
		    	        ConvertCharacter a = new ConvertCharacter();
		    	        info = a.convert(input);
		    	        output.setText("Here is the information regarding the character \"" + input + "\"" + "\n" + info);
		    	        output.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		    	        output.setBackground(Color.WHITE);
		    	       
		    	    }
		    }
	 }
	  
	//function to read CSV file and print out contents
	  public void run(char input) {
		
		//get hex of input
		hexU = b.getHex(input);
		System.out.println("from run function" + hexU);
		String csvFile = "/Users/sdu17/Documents/JavaWorkspace/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
		//String SplitBy = ",";
		
		
		try {
			//file reader
			br = new BufferedReader(new FileReader(csvFile));
			String line;
			
			//read file line by line until there is nothing to read 
			while ((line = br.readLine()) != null) 
				{
					
			     // use comma as separator, read every line
				String[] category = line.split(",");
				
				//get input, get hex
				//CharacterIdentifier c = new CharacterIdentifier();
				//hexU = b.getHex(input);
				System.out.println("from try function" + hexU);
				
				//NOTHING MATCHES? E.G. POUND SIGN ISN'T SAME HEX
				if (category[1].equals(hexU))
				{
					System.out.println("alpha entity:" + category[3]);
					System.out.println("description:" + category[4]);
					break;
				}
				
				
				//to test see if can access appropriate columns of CSV file
				/*if (category.length==2)
				{
					System.out.println("hex:" + category[1]);
				}
				
				if (category.length==4)
				{
					System.out.println("hex:" + category[1]);
					System.out.println("alpha entity:" + category[3]);
				}
				
				if (category.length==5)
				{
					System.out.println("hex:" + category[1]);
					System.out.println("alpha entity:" + category[3]);
					System.out.println("description:" + category[4]);
				}
				*/
				
				}
			
			} catch (FileNotFoundException e) 
				{
				e.printStackTrace();
				} 
		//will print out upon error - catch own error
			catch (IOException e) 
				{
				e.printStackTrace();
				} 
		
		//runs after try
			finally 
			{
				if (br != null) 
				{
					try 
					{
						//closes reader
						br.close();
					} catch (IOException e) 
						{
						e.printStackTrace();
						}
				}
			}
	  }  
	  
	  public char getInput()
	  {
		stringInput = field.getText(); 
  	    char input = stringInput.charAt(0);
  	    return input;
	  }

}