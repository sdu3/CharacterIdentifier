/*
 * this code reads the CSV file and prints it out (read CSV and print out part Maggie and I worked on together).
 * eventually it will also have an action listener (event generator = button, action listener = JPanel)
 * and upon the action event occurring, the "convert character" function will run and the info from 
 * the convert function's output will be placed in a JTextArea
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.applet.Applet;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

//scanner files for reading CSV
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharacterIdentifier extends JPanel implements ActionListener
{
	public CharacterIdentifier() {
	}
	 
	/*public static void main(String[] args) {

		CharacterIdentifier categories = new CharacterIdentifier();
		categories.run();
	  }
	*/
	 
	  public void run() {
		
		  //file to be parsed
		String csvFile = "/Users/sdu17/Documents/JavaWorkspace/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
		String SplitBy = ",";
		
		
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
}

