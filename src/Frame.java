import java.awt.*;
import javax.swing.*;
	
public class Frame extends JFrame
{
	  private Container c;

	  public Frame()
	  {
		c = this.getContentPane();
	  }

	  public void addPanel(JPanel p){
	    p.setPreferredSize(new Dimension(700,700));
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

<<<<<<< HEAD
}
||||||| merged common ancestors
}
>>>>>>> bd9ebc7fc54e02b2ad6ba11698d8f3c3040d55bd
=======
}
>>>>>>> bea70a46b0c86d84aaeb430d7a3739febdedb0e6
