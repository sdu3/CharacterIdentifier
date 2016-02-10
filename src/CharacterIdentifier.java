
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
	public static void main(String[] args) {

		CharacterIdentifier categories = new CharacterIdentifier();
		//CharacterIdentifier hex = new CharacterIdentifier();
		categories.run();
		//hex.run();
	  }

	  public void run() {

		  //file to be parsed
		String csvFile = "/Users/sdu17/Documents/JavaWorkspace/CharacterIdentifier/entityfacts.csv";
		BufferedReader br = null;
		String SplitBy = ",";
		
		
		try {
			//file reader
			br = new BufferedReader(new FileReader(csvFile));
			String line = br.readLine();
			
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
	  }  
}

