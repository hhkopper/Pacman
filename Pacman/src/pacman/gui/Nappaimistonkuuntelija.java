package pacman.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pacman.hahmot.Suunta;
import pacman.peli.Pacman;

/**
 * Pacmanin näppäimistönkuuntelija, joka muuttaa manin suuntaa pelaajan
 * näppäimistönpainallusten mukaisesti.
 *
 * @author Hanna
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Pacman peli;
    private Kayttoliittyma kayttis;

    public Nappaimistonkuuntelija(Kayttoliittyma kayttis, Pacman peli) {
        this.peli = peli;
        this.kayttis = kayttis;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Muutetaan manin suuntaa painamalla nuolinäppäimiä, tarkistetaan onko
     * uudessa suunnassa seinä. *
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Suunta vanhaSuunta = peli.getMan().getSuunta();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.getMan().setSuunta(Suunta.VASEN);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.getMan().setSuunta(Suunta.OIKEA);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            peli.getMan().setSuunta(Suunta.YLOS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.getMan().setSuunta(Suunta.ALAS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        }

        if (peli.getJatkuu() == false) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.kayttis.uusiPeli();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void setPeli(Pacman peli) {
        this.peli = peli;
    }

    /**
     *
     * Tarkistetaan onko uudessa suunnassa vastassa seinä, jos on muutetaan
     * suunnaksi vanha suunta, joka oli ennen kuin painettiin nuolinäppäintä.
     *
     * @param suunta kertoo vanhan suunnan
     */
    public void tarkistaOnkoSuunnassaSeina(Suunta suunta) {
        if (onkoSuunnassaSeina()) {
            peli.getMan().setSuunta(suunta);
        }
    }

    /**
     *
     * Katsotaan onko seuraava ruutu, johon man on liikkumassa, seinä. Jos on
     * palautetaan true jos ei palautetaan false.
     *
     * @return
     */
    public boolean onkoSuunnassaSeina() {
        Suunta suunta = peli.getMan().getSuunta();
        int x = peli.getMan().getX();
        int y = peli.getMan().getY();

        if (peli.getAlusta().getPeliruutu(x + suunta.getX(), y + suunta.getY()).getRuudunTyyppi() == 0) {
            return true;
        } else {
            return false;
        }
    }
}