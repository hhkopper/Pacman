package pacman.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import pacman.peli.Ennatys;
import pacman.peli.Highscore;
import pacman.peli.Pacman;

/**
 * Pacmanin käyttöliittymä
 *
 * @author Hanna
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Pacman peli;
    private Nappaimistonkuuntelija nappaimistonkuuntelija;
    private Highscore highscore;
    private boolean ikkuna;

    public Kayttoliittyma(Pacman peli) {
        this.peli = peli;
        this.piirtoalusta = new Piirtoalusta(peli, 30, frame, this);
        this.nappaimistonkuuntelija = new Nappaimistonkuuntelija(this, peli);
        this.highscore = new Highscore();
        this.ikkuna = false;
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

    /**
     * Luodaan komponentit frameen ja lisätään näppäimistönkuuntelija.
     *
     * @param container
     */
    public void luoKomponentit(Container container) {
        container.add(piirtoalusta);
        frame.addKeyListener(nappaimistonkuuntelija);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }

    /**
     * Luodaan ja käynnitetään uusi peli.
     */
    public void uusiPeli() {
        peli = new Pacman();
        piirtoalusta.setPeli(peli);
        nappaimistonkuuntelija.setPeli(peli);
        peli.setPaivitettava(this.getPaivitettava());
        peli.start();
    }

    public void highscoreNimi() {
        if (this.ikkuna) {
            return;
        }
        this.ikkuna = true;
        int b = -1;
        String nimi = "";
        while (b < 0) {
            nimi = JOptionPane.showInputDialog("Uusi ennatys! Kirjoita nimesi: ");
            if (nimi.length() > 0) {
                b++;
            }
        }
        
        this.ikkuna = false;        
        this.highscore.lisaaEnnatys(nimi, peli.getPisteet());
        this.piirtoalusta.paivita();
    }
    
      public Highscore getHighscore() {
        return this.highscore;
    }
}