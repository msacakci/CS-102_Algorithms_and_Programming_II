/**
 * @author Metehan Saçakçý
 * @version 28.04.2020
 * to decimal counter
 */
public class lab06b
{
   public static void toDecimalR (int decimalNumber) 
   {       
      if ( decimalNumber == 1 )
      {
         System.out.print( 1 );
      }
      else if ( decimalNumber == 0 )
      {
         System.out.print( 0 );
      } 
      else if (decimalNumber > 0)  
      {   
         toDecimalR( decimalNumber / 2 );
         System.out.print( decimalNumber % 2 );
      }   
      
   }  
   public static void main( String[] args )
   {
      //System.out.println( toDecimalR( 100) );
      toDecimalR( 6 );
   }   
}   