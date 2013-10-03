package pacman.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
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
        this.highscore = new Highscore(this);
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
    private void luoKomponentit(Container container) {
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

    public Highscore getHighscore() {
        return this.highscore;
    }

    public void virheilmoitus(String virhe) {
        peli.stop();
        if (!ikkuna) {
            ikkuna = true;
            JFrame virheFrame = new JFrame("Virheilmoitus");
            virheFrame.setPreferredSize(new Dimension(400, 200));

            luoVirheenKomponentit(virheFrame.getContentPane(), virhe);

            virheFrame.pack();
            virheFrame.setVisible(true);
        }

    }

    private void luoVirheenKomponentit(Container container, String virhe) {
        container.setLayout(new BorderLayout());
        JButton ok = new JButton("OK");
        JLabel teksti = new JLabel(virhe);
        container.add(teksti);
        container.add(ok, BorderLayout.SOUTH);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.dispatchEvent(new WindowEvent(frame, Event.WINDOW_DESTROY));
            }
        });
        
    }
}