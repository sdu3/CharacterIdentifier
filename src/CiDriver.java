import java.awt.Color;
import javax.swing.JFrame;

/*import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * This code is the driver. 
 * It creates a JFrame with all our interface components
 * and initiates the action event listening.
 * the button triggers everything else
 */

public class CiDriver
{
		public static void main(String[] args)
		 {
			//creates and shows frame
			JFrame d = new CharacterIdentifier();
		    d.show();
		    d.setBackground(Color.WHITE);
		   }

}