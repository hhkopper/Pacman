package pacman.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;
import pacman.peli.Pacman;

public class Nappaimistonkuuntelija implements KeyListener {

    private Man man;
    private Pacman peli;

    public Nappaimistonkuuntelija(Man pacman, Pacman peli) {
        this.man = pacman;
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Muutetaan manin suuntaa painamalla nuolinäppäimiä, tarkistetaan onko uudessa suunnassa seinä.     * 
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Suunta vanhaSuunta = man.getSuunta();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.man.setSuunta(Suunta.VASEN);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.man.setSuunta(Suunta.OIKEA);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.man.setSuunta(Suunta.YLOS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.man.setSuunta(Suunta.ALAS);
            tarkistaOnkoSuunnassaSeina(vanhaSuunta);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     *
     * Tarkistetaan onko uudessa suunnassa vastassa seinä, jos on muutetaan suunnaksi vanha suunta, joka oli ennen kuin painettiin nuolinäppäintä.
     * 
     * @param suunta kertoo vanhan suunnan
     */
    public void tarkistaOnkoSuunnassaSeina(Suunta suunta) {
        if (onkoSuunnassaSeina()) {
                this.man.setSuunta(suunta);
            }
    }
    /**
     *
     * Katsotaan onko seuraava ruutu, johon man on liikkumassa, seinä. Jos on palautetaan true jos ei palautetaan false.
     * 
     * @return
     */
    public boolean onkoSuunnassaSeina() {
        Suunta suunta = man.getSuunta();
        int x = man.getX();
        int y = man.getY();

        if (peli.getAlusta().getPeliruutu(x + suunta.getX(), y + suunta.getY()).getRuudunTyyppi() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
