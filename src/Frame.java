import java.awt.*;
import javax.swing.*;
	/*
	 * unfortunately this code is not actually used since the frame/panels are created in CharacterIdentifier
	 */
public class Frame extends JFrame
{
	  private Container c;

	  public Frame()
	  {
		c = this.getContentPane();
	  }

	  public void addPanel(JPanel p){
	    p.setPreferredSize(new Dimension(500,500));
	    //color background
	    p.setBackground(new Color(248,248,255));
	    //add panel to frame
	    c.add(p);
	  }

	  public void showFrame(){
	    this.pack();
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	  

}

