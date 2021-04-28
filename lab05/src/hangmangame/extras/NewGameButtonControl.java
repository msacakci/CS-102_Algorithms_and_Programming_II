package hangmangame.extras;

import cs102.hangman.Hangman;
import cs102.hangman.HangmanModel;
import cs102.hangman.IHangmanView;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Metehan Saçakçý
 * @version 11.04.2020
 * NewGameButtonControl
 */
public class NewGameButtonControl extends JButton implements IHangmanView
{
   //properties
   private HangmanModel hangman;
   
   //contructor
   public NewGameButtonControl( HangmanModel hangman)
   {
      //create another class, NewGameButtonControl.
      setEnabled( false);
      //set the button's text to "New Game" and add an ActionListener which calls the HangmanModel's initNewGame() method.
      setText( "New Game");
      this.hangman = hangman;
      addActionListener( new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            hangman.initNewGame();          
            setEnabled(false);
         }
      });
   }
   //The simplest way to do this is to make the control a view too, in other words, have the NewGameButtonControl implement IHangmanView too. 
   @Override
   public void updateView( Hangman hangman) 
   {
      //Disable the button in its ActionListener, but in the updateView method if the game is over, re-enable it.
      if( hangman.isGameOver())
         setEnabled( true);
   }
}