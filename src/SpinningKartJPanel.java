
/**
 *
 * @author Samir
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpinningKartJPanel extends JPanel
{
    private final static String IMAGE_NAME = "kartAru"; // base kart's image name
    protected ImageIcon images[]; // array of images
    private final int TOTAL_IMAGES = 16; // number of images
    private int currentImage = 0; // current image index    
    private final int ANIMATION_DELAY = 100; // millisecond delay
    private final int width; // image width
    private final int height; // image height
    private Timer animationTimer; // Timer drives animation
   
    // Constructor initializes SpinningKartJPanel by loading images
    public SpinningKartJPanel() 
    {
        images = new ImageIcon[ TOTAL_IMAGES ];
        
        // Load 16 images
        for ( int count = 0; count < images.length; count++ )
            images[ count ] = new ImageIcon( getClass().getResource( "C1_ARU/" + IMAGE_NAME + count + ".png" ) );
        
        // All images have the same width and height
        width = images[ 0 ].getIconWidth(); // get icon width
        height = images[ 0 ].getIconHeight(); // get icon height   
    } // end SpinningKartJPanel constructor
   
    // Display current image
    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // call superclass paintComponent
        
        images[ currentImage ].paintIcon(this, g, 115, 100);
        
        // Set next image to be drawn only if Timer is running
        if ( animationTimer.isRunning() )
            currentImage = ( currentImage + 1 ) % TOTAL_IMAGES;
    } // end method paintComponent
    
    // Start animation, or restart if window is redisplayed
    public void startAnimation()
    {
        if ( animationTimer == null )
        {
            currentImage = 0; // display first image
            
            // Create timer
            animationTimer = new Timer ( ANIMATION_DELAY, new TimerHandler() );
            
            animationTimer.start(); // start Timer
        } // end if statement
        else // animationTimer already exists, restart animation
        {
            if ( ! animationTimer.isRunning() )
                animationTimer.restart();
        } // end else statement
    } // end method startAnimation
    
    // Stop animation Timer
    public void stopAnimation()
    {
        animationTimer.stop();
    } // end method stopAnimation
    
    // Return minimum size of animation
    @Override
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    } // end method getMinimumSize
    
    // Return preferred size of animation
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension( width, height );
    } // end method getPrefferedSize
    
    // Inner class to handle action events from Timer
    private class TimerHandler implements ActionListener
    {
        // Respond to Timer's event
        @Override
        public void actionPerformed( ActionEvent actionEvent )
        {
            repaint(); // repaint animator
        } // end method actionPerformed       
    } // end class TimerHandler
} // end class SpinningKartJPanel