import java.lang.*;
/*
 * This code takes in a character (currently the character is manually inputed in the code, not integrated with interface yet)
 * and outputs the Unicode, entities, Java code, and UTF-8
 */
public class ConvertCharacter
{

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
          String output = "\n" + "Decimal unicode: " + decUnicode + "\n"
        			+ "Hex unicode: " + hexUnicode
        			+  "\n"+ "Decimal entity: " 
        		  + decEntity + "\n" + "Hex entity: " + hexEntity + "\n"
        		  + "Java code:" + Java + "\n"
        		  + "UTF-8: "  + UTF;
          //System.out.println(output);
         
          return output;
     }
	 
	 public String getHex(char input)
     {   
          //convert char (input) to an int and temporarily store in i. This int is the decimal Unicode
          int  i = (int) input; 
          
          //convert int to Integer
          Integer o = new Integer(i);
          
          //this function converts the dec Unicode to the UTF-8 code
          String UTF = Integer.toHexString(o);
          
          //String hexUnicode= "0x00" + UTF;
          
         String hexUnicode="";
          
          //HOW TO GET HEX-UNICODE OUT OF LOOP? don't redefine with "String", also need to first initialize value
         
          //UTF-8
          if (UTF.length()==2)
          {
        	   hexUnicode= "0x00" + UTF;
          }
          
        //UTF-16
          if (UTF.length()==4)
          {
        	  hexUnicode= "0x" + UTF;
          }
         
          
          //final output
          return hexUnicode;
     }
}