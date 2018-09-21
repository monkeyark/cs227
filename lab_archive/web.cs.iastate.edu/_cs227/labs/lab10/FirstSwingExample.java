package lab10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Simple Swing demo illustrating use of the 
 * ActionListener interface to create a handler
 * for button clicks. Each time the button is clicked, 
 * the label is updated to show the total number of clicks. 
 * This class extends JPanel and encapsulates the state variables 
 * we need to maintain the count.  
 */
public class FirstSwingExample extends JPanel
{
  // Swing components
  
  /**
   * The button.
   */
  private JButton button;
  
  /**
   * Label describing number of times the button has been clicked.
   */
  private JLabel label;
  
  /**
   * The number of times the button has been clicked.
   */
  private int count;
  
  /**
   * Constructor creates all components that will
   * be contained in this panel.
   */
  public FirstSwingExample()
  {
    
    // create a label with some initial text, and
    // add it to the panel
    label = new JLabel("Push this button! ");
    this.add(label);
    
    // create a button and add an 
    // ActionListener to its list of listeners
    button = new JButton("Push me");
    button.addActionListener(new MyButtonHandler());
    
    // add the button to the panel
    this.add(button);    
  }
  
  /**
   * Entry point. This method should normally do 
   * nothing except (possibly) parse command-line
   * arguments and invoke a helper method for creating
   * and starting up the UI.
   */
  public static void main(String[] args)
  {
    // Boilerplate code for starting any Swing application
    Runnable r = new Runnable()
    {
      public void run()
      {
        createAndShow();
      }
    };
    SwingUtilities.invokeLater(r);
    System.out.println("Main thread exiting");
  }
  
  /**
   * Static helper method creates the frame and
   * makes it visible.
   */
  private static void createAndShow()
  {
    // create the frame, which corresponds to the actual window on the screen
    JFrame frame = new JFrame("First Swing Example");
    
    // create an instance of our JPanel subclass and 
    // add it to the frame
    frame.getContentPane().add(new FirstSwingExample());
    
    // give it a nonzero size
    frame.setSize(300, 100);
    
    // we want to shut down the application if the 
    // "close" button is pressed on the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // make the frame visible and start the UI machinery
    frame.setVisible(true);
  }

  /**
   * Inner class for handling button clicks.
   */
  private class MyButtonHandler implements ActionListener
  {
    @Override
    public void actionPerformed(ActionEvent event)
    {       
      ++count;
      label.setText("Pushed " + count + " times: ");
    }
  }
}