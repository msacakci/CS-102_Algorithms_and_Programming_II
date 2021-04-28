package hangmangame.extras;

import cs102.hangman.Hangman;
import cs102.hangman.HangmanModel;
import cs102.hangman.IHangmanView;
import java.awt.*;
/**
 * @author Metehan Saçakçý
 * @version 11.04.2020
 * HangmanLetterButtonControls
 */
public class HangmanLetterButtonControls extends LetterButtonControls 
   implements IHangmanView {
   
   public HangmanLetterButtonControls( HangmanModel hangman, int rows, int columns)
   {
      //create HangmanLetterButtonControls which extends LetterButtonControls and implements IHangmanView. 
      super( hangman.getAllLetters(), rows, columns);
   }
   
   //In the updateView method call the setEnabledAll & setDisabled( String letters) appropriately. 
   @Override 
   public void updateView( Hangman hangman) {
      if( !hangman.getUsedLetters().equals("") && !(hangman.isGameOver())) 
      {
         setDisabled(hangman.getUsedLetters());
      }
      if( hangman.isGameOver()) 
      {
         setEnabledAll(true);
      }
   }
}