import java.awt.EventQueue;

public class CiDriver
{
		 public static void main(String[] args)
		 {
					//creates frame
				    Frame d = new Frame();
				 //creates ShowFonts panel, creates everything in ShowFonts
				   CharacterIdentifier p = new CharacterIdentifier();
				   
				   //add panel & frame
				    d.addPanel(p);
					  
					  d.showFrame();
				 }

}
