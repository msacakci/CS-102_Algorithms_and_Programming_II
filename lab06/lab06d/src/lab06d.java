/**
 * @author Metehan Saçakçý
 * @version 28.04.2020
 * 
 */
public class lab06d
{
   public static void increasingNum(int start, String out, int n, int temp) 
    { 
      
        // If number becomes N-digit, print it 
        if (n == 0) 
        { 
            System.out.print(out + " "); 
            //return; 
        } 
   
        // start from (prev digit + 1) till 9 
        for (int i = start; i <= 9; i++) 
        { 
            // current digit to number 
            String str;
            str = out + Integer.toString(i); 
   
            // for next digit 
            if( ( n == 1 && i % 2 == 0 ) || ( n == temp && i > 0 ) || ( n != 1 && n != temp ) )
               increasingNum(i + 1, str, n - 1, temp);             
        } 
    } 
   
   public static void main( String[] args )
   {
      int digit;
      digit = 3;
      
      int temp;
      temp = digit;
      
      increasingNum( 0, "", 3, temp); 
   }   

}   