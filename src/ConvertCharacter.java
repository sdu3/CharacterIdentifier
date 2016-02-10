import java.lang.*;

public class ConvertCharacter
{
	 public static void main(String[] args)
	 {
		ConvertCharacter a = new ConvertCharacter();
		char input = '@';
		//CAN'T CALL FUNCTION ON OBJECT?
		a.convert(input);
		//CAN'T ACCESS OUTPUT EVEN WITH RETURN?
		//System.out.println(output);
	 }
	
	 public static String convert(char input)
     {   
          //convert char to an int and store in i
          int  i = (int) input; 
          //System.out.println ("Decimal ASCII: " + i);
          
          //convert int to Integer
          Integer o = new Integer(i);
          String hexEntity = Integer.toHexString(o);
          
          //convert Integer to Hex
         //System.out.println("Hex ASCII: " + hexEntity); 
          //System.out.println ("Decimal entity: 0x" + hexEntity);
         
          String output = "Hex ASCII: " + hexEntity + "\n "+ "Decimal entity: 0x" + hexEntity + "\n ";
          return output;
     }
}
