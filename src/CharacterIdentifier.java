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
	JTextArea filler = new JTextArea();
	String hexU;
	ConvertCharacter b = new ConvertCharacter();
	String alpha;
	String description;
	String info2;
	
	public CharacterIdentifier() {
		
		
		//title of tool bar, size of window
		 setTitle("Character Identifier: enter your character in the field below");
		    setSize(1500, 1000);
		    
		    //closes window 
		    addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		    System.exit(0);
		      }
		    }); 
		 field.setHorizontalAlignment(SwingConstants.LEFT);
		 field.setToolTipText("Enter character here:");  
		 
		 //create container 
		 Container container;
		 container = getContentPane();
		 container.add(field, BorderLayout.NORTH);
		
		 //make button an event generator
		 ok.addActionListener(new ButtonListener());
		 
		 //create 2 panels, one for each textArea
		 //add button to panel
		 JPanel largefont = new JPanel();
		 largefont.setBackground(SystemColor.window);
		 JPanel button = new JPanel();
		 button.add(ok);
		 getContentPane().add(button);
		 JPanel fill = new JPanel();
		 fill.add(filler);
		 getContentPane().add(fill);
		 character.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		 largefont.add(character);
		 getContentPane().add(largefont);
		 container.setBackground(Color.WHITE);

		 container.add(largefont, BorderLayout.WEST);
		 container.add(button, BorderLayout.SOUTH);
		 filler.setBackground(SystemColor.window);
		 container.add(fill, BorderLayout.EAST);
		 
		 getContentPane().add(output, BorderLayout.CENTER);
		
	}

	  //event listener reaction
	  private class ButtonListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
	    	    
		    	//currently only one event generator so not necessary, but get source of event
		    	JButton src = (JButton) e.getSource();

		    	    if (src == ok) 
		    	    {	
		    	    	//get input from text field
		    	    	stringInput = field.getText(); 
			    	    char input = stringInput.charAt(0);
			    	 
			    	    //display text in larger font
			    	    character.setText("Character in larger font: " + "\n" + "\n" + "                 " + stringInput + "\n" + "\n");
			    	    character.setVisible(true);
			    	
			    	    //run "run" function and store output (csv information) in variable info 2
			    	    CharacterIdentifier categories = new CharacterIdentifier();
			    	    info2 = categories.run(input);
			    	   
			    	  //get information independent of CSV file using convert function
		    	        ConvertCharacter a = new ConvertCharacter();
		    	        info = a.convert(input) + "\n" + info2 ;
		    	        
		    	        //display all information in text area
		    	        output.setText("\n" + "   Here is the information regarding the character \"" + input + "\""  + "\n" + info);
		    	        output.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		    	        output.setBackground(Color.WHITE);
		    	       
		    	    }
		    }
	 }
	  
	//function to read CSV file and get corresponding alpha entity and description of input
	  public String run(char input) {
		
		//get hex of input
		hexU = b.getHex(input);
		
		String csvFile = "/Users/mzyin/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
		
		try {
			//file reader
			br = new BufferedReader(new FileReader(csvFile));
			String line;
			
			//read file line by line until there is nothing to read 
			while ((line = br.readLine()) != null) 
				{
					
			     //store items in each column into array
				String[] category = line.split(",");
				
				//remove white spaces
				category[1] = category[1].replaceAll("\\s","");
				category[3] = category[3].replaceAll("\\s","");
				
				//take out trailing and leading white space
				category[3] = category[3].trim();
				category[4] = category[4].trim();
				
				//compare hex from user input to hex in CSV file
				if (category[1].equals(hexU))
				{
					//if no alpha entity, display none
					if (category[3].equals(""))
					{
						alpha = "Alpha entity: none";
						description = ("Description:  " + category[4]);
						System.out.println(alpha + "\n" + description);
						break;
						
					}
					
					else
					
					//if there is an alpha entity
					{
						alpha = ("Alpha entity: " + category[3]);
						description = ("Description: " + category[4]);
						System.out.println(alpha + "\n" + description);
						break;
					}
				}
				
				
				//was a test to see if I could correctly access the columns of CSV file
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
		
		//output - alpha and description
		String csvInfo = alpha + "\n" + description;
		return csvInfo;
	  }  
	  
	  
}