package hangmangame.extras;

import cs102.hangman.HangmanModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author david
 */
public class HangmanGUIPanel extends JPanel {

   HangmanModel hm;
   
   
   //properties
   TextFieldControlPanel textFieldControlPanel;   
   NewGameButtonControl newGame;
   LabelsHangmanView labelsHangmanView;
   GallowsHangmanView gallowsHangmanView;
   HangmanLetterButtonControls letterButtons;
   
   
   public HangmanGUIPanel( HangmanModel hm) {
      this.hm = hm;
      setPreferredSize( new Dimension( 1000, 600) );
      setLayout( new BorderLayout() );
      setBackground(Color.YELLOW);

      // add controls and views here...
      //variables
      JPanel letterPanel;
      JPanel westPanel;
      JTextField textField;
      
      //panel code
      textField = new JTextField( 20);
      //create an instance of your new TextFieldControlPanel class (passing it the HangmanModel)
      textFieldControlPanel = new TextFieldControlPanel( hm,  textField );      
      //Add an instance of the NewGameButtonControl class to the "south" of your GUIHangmanPanel.
      newGame = new NewGameButtonControl( hm );
      //create a new instance of your LabelsHangmanView, add it to the HangmanModel as a view, and place it in the "west" of your panel.
      labelsHangmanView = new LabelsHangmanView( hm );
      //Create an instance of your GallowsHangmanView class, add it to the hangman model as a view, and place it in the center of the HangmanGUIPanel.
      gallowsHangmanView = new GallowsHangmanView ( hm );
      
      letterButtons = new HangmanLetterButtonControls( hm, 13, 2);
      
      letterButtons.addActionListener( new HangmanLetterButtonsController(hm));
      //west panel
//      westPanel = new JPanel();
//      westPanel.setPreferredSize( new Dimension( 300, 600) );
//      westPanel.setLayout( new BorderLayout() );
//      westPanel.setBackground( Color.RED );
      
//      //letter panel
//      letterPanel = new JPanel();
//      //letterPanel.setPreferredSize( new Dimension ( 200, 600 ));
//      letterPanel.setBorder(BorderFactory.createTitledBorder("Choose a letter..."));
//      letterPanel.setLayout( new GridLayout ( 13, 2 ));
//      for( char ch = 'a'; ch <= 'z'; ch++ )
//      {
//         letterPanel.add( new JButton ( "" + ch ));
//      }
//      //letterPanel.add( new JLabel( "Choose a letter..." ), BorderLayout.NORTH);
      hm.addView( labelsHangmanView);
      hm.addView( gallowsHangmanView);
      hm.addView( newGame);
      hm.addView( letterButtons);      
      
      add( textFieldControlPanel, BorderLayout.NORTH );
      add( newGame, BorderLayout.SOUTH );
      add( letterButtons, BorderLayout.EAST);      
      add( labelsHangmanView, BorderLayout.WEST );
      add( gallowsHangmanView, BorderLayout.CENTER );
   }
   
}
