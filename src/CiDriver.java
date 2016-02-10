import java.awt.EventQueue;

public class CiDriver
{
		 public static void main(String[] args)
		 {
					//creates frame
				    Frame d = new Frame();
				   
				   CharacterIdentifier categories = new CharacterIdentifier();
					categories.run();
				   
				   //add panel & frame
				    d.addPanel(categories);
					 d.showFrame();
				 }

}
