
package pacman.alusta;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import pacman.peli.Pacman;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Pacman pacman;
    private int sivunPituus;
    private Pelialusta pelialusta;
    
    public Kayttoliittyma(Pacman pacman, int sivunPituus) {
        this.pacman = pacman;
        this.sivunPituus = sivunPituus;
        this.pelialusta = new Pelialusta(this.pacman, this.sivunPituus);
    }

    @Override
    public void run() {
        this.frame = new JFrame("Pacman");
        int leveys = (pacman.getLeveys()+1)*this.sivunPituus+10;
        int korkeus = (pacman.getKorkeus()+2)*this.sivunPituus+10;
        
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.add(this.pelialusta);
        
        frame.addKeyListener(new Nappaimistonkuuntelija(this.pacman.getMan()));
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return this.pelialusta;
    }
    
}
