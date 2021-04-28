package hangmangame.extras;

import java.awt.event.*;
import javax.swing.*;
import cs102.hangman.HangmanModel;

/**
 * @author Metehan Saçakçý
 * @version 11.04.2020
 * HangmanLetterButtonsController
 */
public class HangmanLetterButtonsController implements ActionListener
{
   //properties
   HangmanModel hangmanModel;

   //constructors
   public HangmanLetterButtonsController( HangmanModel hangmanModel )
   {
      //It should maintain a reference to the hangman model (passed in via its constructor).
      this.hangmanModel = hangmanModel;
   }
   
   //methods
   //In the actionPerformed method it should get the letter of the button that was pressed and pass it to the tryThis method of the hangman object, then disable the button. 
   @Override
   public void actionPerformed( ActionEvent event )
   {
      if( !(hangmanModel.isGameOver()))
      {
         //use the event source to decide which button. Confirm that you can play the game using this keyboard.
         JButton b = ( (JButton) event.getSource() );
         char letter = b.getText().charAt( 0 );
         hangmanModel.tryThis( letter );
         if( hangmanModel.getNumOfIncorrectTries() <= 5 && !hangmanModel.isGameOver() )
         {
            b.setEnabled( false );
         }   
      }   
   }   
}   