import java.lang.*;
/*
 * This code takes in a character (currently the character is manually inputed in the code, not integrated with interface yet)
 * and outputs the Unicode, entities, Java code, and UTF-8
 */
public class ConvertCharacter
{
	/*can ignore - I used the following to test
	 * public static void main(String[] args)
	 {
		ConvertCharacter a = new ConvertCharacter();
		
		char input = 'é';
	
		System.out.println(a.convert(input));
	 }
	*/
	 
	
	 public String convert(char input)
     {   
          //convert char (input) to an int and temporarily store in i. This int is the decimal Unicode
          int  i = (int) input; 
          
          //convert int to Integer
          Integer o = new Integer(i);
          Integer decUnicode = o;
          
          //this function converts the dec Unicode to the UTF-8 code
          String UTF = Integer.toHexString(o);
          
          //all other info we want based on prefixes
          String decEntity = "&#"+o;
          String hexEntity = "&#x00" + UTF;
          String Java = "\\u00" + UTF;
          String hexUnicode= "0x00" + UTF;
          
          //final output
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
