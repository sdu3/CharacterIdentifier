import java.awt.Color;
import javax.swing.JFrame;

/*import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This code is the driver. It creates the window/frame, a character identifier object (which has most of our functions), 
 * and runs the function "run," which currently prints out all things in the csv file
 */

public class CiDriver
{
		public static void main(String[] args)
		 {
			//creates and shows frame
			JFrame d = new CharacterIdentifier();
		    d.show();
		    d.setBackground(Color.WHITE);
				    
		    //read csv
			   //CharacterIdentifier categories = new CharacterIdentifier();
			   //categories.run();
					
					/*convert character
					ConvertCharacter a = new ConvertCharacter();
					char input = 'é';
					
				//CAN'T ACCESS OUTPUT EVEN WITH RETURN?
					System.out.println(a.convert(input));
					*/
				   
				    //d.addPanel(categories);
					
				 }
}