import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CiDriver
{
		public static void main(String[] args)
		 {
					//creates frame
				    Frame d = new Frame();
				   
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
					d.showFrame();
				 }

}
