
package pacman.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    
    public Kayttoliittyma() {
        
    }

    @Override
    public void run() {
        frame = new JFrame("PAcman");
        frame.setPreferredSize(new Dimension(21,19));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
}
