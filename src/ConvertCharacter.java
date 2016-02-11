import java.lang.*;

public class ConvertCharacter
{
	/*public static void main(String[] args)
	 {
		ConvertCharacter a = new ConvertCharacter();
		
		char input = 'é';
		
	//why did I have to put the function in the print statement to print it? why did print "output" not work?
		System.out.println(a.convert(input));
	 }
	*/
	 
	
	 public String convert(char input)
     {   
          //convert char to an int and store in i
          int  i = (int) input; 
          int Unicode = i;
          
          //convert int to Integer
          Integer o = new Integer(i);
          Integer decUnicode = o;
          String UTF = Integer.toHexString(o);
          String decEntity = "&#"+o;
          String hexEntity = "&#x00" + UTF;
          String Java = "\\u00" + UTF;
          String hexUnicode= "0x00" + UTF;
          
          //convert Integer to Hex
         //System.out.println("Hex ASCII: " + hexEntity); 
          //System.out.println ("Decimal entity: 0x" + hexEntity);
         
          String output = "Character: " + input + "\n" + "decimal Unicode: " + decUnicode + "\n"
        			+ "hex Unicode: " + hexUnicode
        			+  "\n "+ "Decimal entity: " 
        		  + decEntity + "\n " + "Hex entity: " + hexEntity + "\n"
        		  + "Java code:" + Java + "\n"
        		  + "UTF-8: "  + UTF;
          //System.out.println(output);
          return output;
     }
}
