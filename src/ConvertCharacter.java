import java.lang.*;

public class ConvertCharacter
{
	 public static void main(String args[])
     {
          char input = '@';
          
          //convert char to an int and store in i
          int  i = (int) input; 
          System.out.println ("Decimal ASCII: " + i);
          
          //convert int to Integer
          Integer o = new Integer(i);
          String hexEntity = Integer.toHexString(o);
          
          //convert Integer to Hex
          System.out.println("Hex ASCII: " + hexEntity); 
          System.out.println ("Decimal entity: 0x" + hexEntity);
         
     }
}
