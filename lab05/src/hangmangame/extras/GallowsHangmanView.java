package hangmangame.extras;

import javax.swing.JPanel;
import javax.swing.JTextField;
import cs102.hangman.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
import java.awt.*;

/**
 * @author Metehan Saçakçý
 * @version 12.04.2020
 * GallowsHangmanView
 */
public class GallowsHangmanView extends JPanel implements IHangmanView
{
   //constants
   final int HEIGHT = 300, WIDTH = 300, X = 0, Y = 20;
   final Font fount = new Font( "Times New Roman", Font.BOLD, 50);
   
   
   //properties
   HangmanModel hangmanModel;
   private Rectangle2D.Double[] rec;
   private Line2D.Double[] manLines;
   private Ellipse2D.Double manHead;
   private Shape[] man;
   int number;
   
   //constructor
   public GallowsHangmanView( HangmanModel hangmanModel)
   {            
     
      
      //Create a new class, GallowsHangmanView, which also extends JPanel and implements IHangmanView.
      super();
      number = 0;
      this.hangmanModel = hangmanModel;
      setPreferredSize( new Dimension ( HEIGHT, WIDTH ) );
      setBackground( Color.ORANGE);
      
      //for draw
      rec = new Rectangle2D.Double[4];
      manLines = new Line2D.Double[5];
      man = new Shape[6];
      
      //gallow
      rec[0] = new Rectangle2D.Double( 20 + X, 400 + Y, 200, 10 ); //bottom part
      rec[1] = new Rectangle2D.Double( 60 + X, 40 + Y, 20, 360 ); // v bottom
      rec[2] = new Rectangle2D.Double( 80 + X, 40 + Y, 120, 20 ); //top
      rec[3] = new Rectangle2D.Double( 194 + X, 60 + Y, 6, 30 ); //v top
      //making the stick human
      //head
      manHead = new Ellipse2D.Double(167 + X, 90 + Y, 60, 60);
      
      //the body
      manLines[0] = new Line2D.Double(manHead.getX() + (manHead.getWidth() / 2), 
                                      manHead.getY() + manHead.getHeight(), 
                                      manHead.getX() + (manHead.getWidth() / 2)
                                         ,manHead.getY() + manHead.getHeight() + 70);
      //leftLeg
      manLines[1] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() - 30, 
                                      manLines[0].getY2() + 60);
      //right leg
      manLines[2] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() + 30, 
                                      manLines[1].getY2()); 
      //left arm
      manLines[3] = new Line2D.Double(manLines[0].getX2(), 
                                      ((manLines[0].getY2() - manLines[0].getY1()) / 5) + manLines[0].getY1()
                                         , manLines[0].getX1() - 28, 
                                      ((manLines[0].getY2() - manLines[0].getY1()) / 4) + manLines[0].getY1() + 40);
      //right arm
      manLines[4] = new Line2D.Double(manLines[0].getX2(), manLines[3].getY1(), manLines[0].getX1() + 28, 
                                      manLines[3].getY2());
      
      //adding the stick human shapes to an array for easy use in paintComponent
      man[0] = manHead;
      for (int i = 1; i < man.length; i++)
      {
         man[i] = manLines[i - 1];
      }
      
   }
   
   //methods
   //You should override the JPanel's paintComponent( Graphics).
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;//we're using this to draw shapes
      int temp;
      
      //to draw the gallow using rectangles
      g2.setPaint(Color.black);
      for(int i = 0; i < rec.length; i++)
      {
         g2.fill(rec[i]);
      }
      
      //to draw the man based on the game state
      for(int i = number; i < hangmanModel.getNumOfIncorrectTries(); i++)
      {        
         g2.draw(man[ i ]);
      }
      number = getNumOfIncorrectTries();
   }
   
   //The updateView method will normally simply tell the view to repaint() itself.
   @Override
   public void updateView( Hangman hangman) 
   {
      repaint();
   }
   
   
}
