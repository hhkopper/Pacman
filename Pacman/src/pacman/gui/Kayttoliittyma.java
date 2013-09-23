package pacman.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import pacman.peli.Pacman;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Pacman peli;
    
    public Kayttoliittyma(Pacman pacman) {
        this.peli = pacman;
        this.piirtoalusta = new Piirtoalusta(peli, 30);
    }

    @Override
    public void run() {
        frame = new JFrame("Pacman");
        frame.setPreferredSize(new Dimension(722, 660)); // 38 ruudun sivu        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli.getMan(),peli));
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
    
    
}
