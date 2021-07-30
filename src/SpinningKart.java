/**
 *
 * @author Samir
 */

import javax.swing.JFrame;

public class SpinningKart 
{
    // Execute animation in JFrame
    public static void main( String args[] )
    {
        SpinningKartJPanel animation = new SpinningKartJPanel();
        
        JFrame window = new JFrame( "Spinning ARU-Kart" ); // set up window
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.add( animation ); // add panel to frame
        
        window.setSize(300, 300); // set window size so spinning kart is in the middle
        window.setVisible( true ); // display window
        
        animation.startAnimation(); // begin animation
    } // end main
} // end class SpinningKart
