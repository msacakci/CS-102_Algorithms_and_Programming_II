package hangmangame.extras;

import javax.swing.JPanel;
import javax.swing.JTextField;
import cs102.hangman.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Metehan Saçakçý
 * @version 11.04.2020
 * TextFieldControlPanel
 */
public class TextFieldControlPanel extends JPanel implements ActionListener
{
   //properties
   JPanel panel;
   Hangman hangman;
   //The class should also have a JTextField property.
   JTextField textField;
   
   //constructors
   //Its constructor should take a reference to a Hangman object and simply store it in a property.
   public TextFieldControlPanel( Hangman hangman, JTextField textField )
   {
      //super();
      this.hangman = hangman;
      this.textField = textField;
      //Add an ActionListener to the TextField.
      textField.addActionListener( this );
      
      add( textField );
   }   
   //methods   
   public void actionPerformed( ActionEvent event )
   {
      //The listener (event handler) should get the text from the TextField and, for each letter in the text, call the Hangman (model) object's tryThis method. 
      //Process the textfield
      if( event.getSource() == textField )
      {
         for( int index = 0; index < textField.getText().length(); index++ )
         {
            hangman.tryThis( textField.getText().charAt( index ));
         }
         //After processing all the letters it should clear the TextField.
         textField.setText( "");
      }   
   }   
}   