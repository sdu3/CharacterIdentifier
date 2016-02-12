
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
	JTextField field = new JTextField();
	String input;
	JTextArea character = new JTextArea();
	private JButton ok = new JButton("OK");
	
	public CharacterIdentifier() {
		 setTitle("Character Identifier");
		    setSize(1500, 1000);
		    addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        System.exit(0);
		      }
		    }); 
		 
		 field.setToolTipText("Enter character here:");   
		 Container container;
		 container = getContentPane();
		 container.add(field, BorderLayout.NORTH);
		
		
		 ok.addActionListener(new ButtonListener());
		 
		 JPanel c = new JPanel();
		 JPanel o = new JPanel();
		 o.add(ok);
		 getContentPane().add(o);
		 c.add(character);
		 getContentPane().add(c);
		 c.setPreferredSize(new Dimension(500,500));
		
		container.add(o, BorderLayout.SOUTH);
		container.add(c, BorderLayout.WEST);
		
	}
	 
	/*public static void main(String[] args) {
		CharacterIdentifier categories = new CharacterIdentifier();
		categories.run();
	  }
	*/
	
	  public void run() {
		
		//file to be parsed
		String csvFile = "/Users/mzyin/Downloads/com/mindprod/entities/entityfacts.csv";
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
		 
		ConvertCharacter a = new ConvertCharacter();
		char input = 'é';
		System.out.println(a.convert(input));

	  }  
	  
	  public static void main(String[] args){
					//creates frame
				    JFrame d = new CharacterIdentifier();
				    d.show();
				   
				    //read csv
				    
				   CharacterIdentifier categories = new CharacterIdentifier();
					categories.run();
					
					/*convert character
					ConvertCharacter a = new ConvertCharacter();
					char input = 'é';
					
				//CAN'T ACCESS OUTPUT EVEN WITH RETURN?
					System.out.println(a.convert(input));
					*/
				   
				   //add panel & frame
				    //d.addPanel(categories);
					//d.showFrame();
				 }
	  
	  private class ButtonListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		    	  JButton src = (JButton) e.getSource();

		    	    if (src == ok) 
		    	    {
		    	    	input = field.getText(); 
		    	    character.setText(input);
		    	    character.setVisible(true);
		    	    	
		    	    }
		    }
	 }

}

	 
	 //System.out.println(a.convert(input));
		
	  /*public void actionPerformed(ActionEvent event)
	  {
		  ConvertCharacter a = new ConvertCharacter();
			char input = 'é';
			
			System.out.println(a.convert(input));
		   
			/*take in input 
		   * run function with input 
		   * TextArea.setText to output of function (from convert character)
	  } */

