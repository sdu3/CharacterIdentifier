
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
	
	public CharacterIdentifier() {
		
		//title of tool bar, size of window
		 setTitle("Character Identifier");
		    setSize(1500, 1000);
		    
		    //WHAT DOES THIS WINDOW LISTENER/ADAPTOR DO?
		    addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    }); 
		 
		 field.setToolTipText("Enter character here:");  
		 
		 //WHAT/WHERE ARE THESE CONTAINERS?
		 Container container;
		 container = getContentPane();
		 container.add(field, BorderLayout.NORTH);
		
		 //make button an event generator
		 ok.addActionListener(new ButtonListener());
		 
		 //add button to panel
		 //WHY ARE THERE 2 PANELS? 
		 JPanel c = new JPanel();
		 JPanel o = new JPanel();
		 o.add(ok);
		 getContentPane().add(o);
		 character.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		 c.add(character);
		 getContentPane().add(c);
		 c.setPreferredSize(new Dimension(500,500));
		
		container.add(o, BorderLayout.SOUTH);
		container.add(c, BorderLayout.WEST);
		output.setEditable(false);
		
		getContentPane().add(output, BorderLayout.CENTER);
		
	}
	 
	//function to read CSV file and print out contents
	  public void run() {
		
		//file to be parsed
		String csvFile = "/Users/sdu17/Documents/JavaWorkspace/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
		//String SplitBy = ",";
		
		
		try {
			//file reader
			br = new BufferedReader(new FileReader(csvFile));
			String line;
			
			//read file line by line
			while ((line = br.readLine()) != null) 
				{
			     // use comma as separator, read every line
				String[] category = line.split(",,");

				//print every line
				System.out.println("category:" + category[0]);
				
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
	 
	  //action listener reaction
	  private class ButtonListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	 
		    	//currently only one event generator so not necessary, but get source of event
		    	JButton src = (JButton) e.getSource();

		    	    if (src == ok) 
		    	    {
		    	    	stringInput = field.getText(); 
			    	    char input = stringInput.charAt(0);
			    	    System.out.println(input);
			    	    character.setText("Character in larger font: " + stringInput);
			    	    character.setVisible(true);
		    	    
		    	    ConvertCharacter a = new ConvertCharacter();
		    	    info = a.convert(input);
		    	    output.setText("Here is the information regarding the character \"" + input + "\"" + "\n" + info);
		    	    //System.out.println(a.convert(input));
		    	    	
		    	    }
		    }
	 }

}
