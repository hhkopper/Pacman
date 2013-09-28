package pacman.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
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

    public Kayttoliittyma(Pacman peli) {
        this.peli = peli;
        this.piirtoalusta = new Piirtoalusta(peli, 30, frame);
        this.nappaimistonkuuntelija = new Nappaimistonkuuntelija(this, peli);
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
    public void uusiPeli(){
        this.peli = new Pacman();
        this.piirtoalusta.setPeli(peli);
        this.nappaimistonkuuntelija.setPeli(peli);
        peli.setPaivitettava(this.getPaivitettava());
        peli.start();
    }
}