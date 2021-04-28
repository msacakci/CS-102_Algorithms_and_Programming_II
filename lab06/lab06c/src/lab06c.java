import java.util.*;

/**
 * @author Metehan Saçakçý
 * @version 28.04.2020
 * sort array
 */
public class lab06c
{
   public static boolean isSorted( ArrayList<String> list, int index, boolean sorted )
   {    
      //if index passes the list size return current situtation.
      if( index == list.size() )
      {
         return sorted; 
      }
      //else if there is a wrong alphabetic problem sorted will be false.
      else if ( list.get( index - 1 ).compareTo(list.get(index)) > 0 )
      {
         sorted = false;
         
      }   
      return isSorted( list, index + 1, sorted );
  
   }
   
   public static void main( String[] args )
   {
      //variables
      ArrayList<String> example;
      ArrayList<String> exampleSecond;
      
      example = new ArrayList<String>();
      example.add( "Adana" );
      example.add( "Bursa" );
      example.add( "Ceylan" );
      example.add( "Edirne" );
      
      System.out.println( "Example 1 -- " + isSorted( example, 1, true ));
      
      exampleSecond = new ArrayList<String>();
      exampleSecond.add( "Adana" );
      exampleSecond.add( "Ceylan");
      exampleSecond.add( "Bursa" );
      exampleSecond.add( "Edirne");  
      
      System.out.println( "Example 2 -- " + isSorted( exampleSecond, 1, true ));
      
   }   
}   