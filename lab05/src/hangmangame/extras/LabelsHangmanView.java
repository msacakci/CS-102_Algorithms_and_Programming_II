package hangmangame.extras;

import java.awt.*;
import cs102.hangman.*;
import javax.swing.*;

/**
 * @author Metehan Saçakçý
 * @version 11.04.2020
 * LabelsHangmanView
 */
public class LabelsHangmanView extends JPanel implements IHangmanView
{
   //properties
   Hangman hangman;
   //It will need JLabel's for each item you wish to show
   JLabel numOfIncorrectTries;
   JLabel knownSoFar;
   JLabel usedLetters;
   JLabel lost;
      
   //constructors
   public LabelsHangmanView( Hangman hangman)
   {
      super();
      this.hangman = hangman;
      this.setLayout( new FlowLayout ( ));
      this.setPreferredSize( new Dimension ( 200, 200 ));
      this.setBackground(Color.cyan);
      
      numOfIncorrectTries = new JLabel("");
      knownSoFar = new JLabel("");
      usedLetters = new JLabel("");
      lost = new JLabel("");  
      
      numOfIncorrectTries.setPreferredSize( new Dimension( 150, 100));
      knownSoFar.setPreferredSize( new Dimension( 150, 100));
      usedLetters.setPreferredSize( new Dimension( 150, 100));
      lost.setPreferredSize( new Dimension( 150, 100));
      
      add( numOfIncorrectTries );
      add( knownSoFar );
      add( usedLetters );
      add( lost );           
   }   
   
   //methods
   //updateView(Hangman) method, query the Hangman object for the required information and update the JLabel's accordingly.
   @Override
   public void updateView( Hangman hangman)
   {
      numOfIncorrectTries.setText( "Num of incorrect tries: " + hangman.getNumOfIncorrectTries() );
      if( !hangman.isGameOver())
      {
         knownSoFar.setText( "So for you have: " + "\n" + hangman.getKnownSoFar() );
      }
      else
      {
         knownSoFar.setText( "The word was: " + "\n" + hangman.getKnownSoFar() );
      }   
      usedLetters.setText ( "So far you used: " + hangman.getUsedLetters());
      if( hangman.getNumOfIncorrectTries() == 6 )
      {
         lost.setText( "You lost friend, sorry."); 
      }  
      else if( hangman.getNumOfIncorrectTries() < 6 && !hangman.hasLost() && hangman.isGameOver() )
      {
         lost.setText( "WELL DONE friend.");
      }
      else
      {
         lost.setText( "");
      }   
   }   
   

}   