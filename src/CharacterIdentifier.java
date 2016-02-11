
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

import javax.swing.JTextArea;
import java.util.Scanner;

public class CharacterIdentifier extends JFrame implements ActionListener
{
	public CharacterIdentifier() {
	}
	 
	/*public static void main(String[] args) {

		CharacterIdentifier categories = new CharacterIdentifier();
		categories.run();
<<<<<<< HEAD
		//hex.run();
	}
	

||||||| merged common ancestors
		//hex.run();
	  }

=======
	  }
	*/
	 
>>>>>>> bea70a46b0c86d84aaeb430d7a3739febdedb0e6
	  public void run() {
		
		  //file to be parsed
		String csvFile = "/Users/sdu17/Documents/JavaWorkspace/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
<<<<<<< HEAD
		//String cvsSplitBy = ",";
||||||| merged common ancestors
		String cvsSplitBy = ",";
=======
		String SplitBy = ",";
>>>>>>> bea70a46b0c86d84aaeb430d7a3739febdedb0e6
		
		
		try {
			//file reader
			br = new BufferedReader(new FileReader(csvFile));
			String line = br.readLine();
			
			
			//read file line by line - change how split 
			while ((line = br.readLine()) != null) 
				{
			     // use comma as separator, read every line
				String[] category = line.split(",");

				//print every line
				System.out.println(category[0]);
				System.out.println(line);
				}
		
			
			JTextArea input = new JTextArea("Input character here");
			Container c = getContentPane();
			c.add(input, BorderLayout.CENTER);
			
			} catch (FileNotFoundException e) 
				{
				e.printStackTrace();
				} 
		
			catch (IOException e) 
				{
				e.printStackTrace();
				} 
		
			finally 
			{
				if (br != null) 
				{
					try 
					{
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
			
		//CAN'T ACCESS OUTPUT EVEN WITH RETURN?
			System.out.println(a.convert(input));
		   
			/*take in input 
		   * run function with input 
		   * TextArea.setText to output of function (from convert character)
	  } */
}

