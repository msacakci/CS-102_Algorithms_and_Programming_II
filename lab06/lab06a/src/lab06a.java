/**
 * @author Metehan Saçakçý
 * @version 28.04.2020
 * Recursion e letter counter
 */
public class lab06a
{
   public static int eCounterRR( String someString, char searchedChar, int index)
   {
      if (index >= someString.length()) {
         return 0;
      }
      
      int count;
      if ( someString.charAt(index) == searchedChar )
      {
         count = 1;
      }
      else
      {
         count = 0;
      }   
      return count + eCounterRR( someString, searchedChar, index + 1);
                                     
   }
   public static void main ( String[] args )
   {
      //constants
      final int INDEX = 0;
      //variables
      
      //program code         
      System.out.println( eCounterRR( "hello friend, I hope you fine!", 'e', INDEX));
   }   
   
}   