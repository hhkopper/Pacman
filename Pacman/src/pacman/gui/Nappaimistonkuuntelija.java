package pacman.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;

public class Nappaimistonkuuntelija implements KeyListener {
    
    private Man pacman;
    
    public Nappaimistonkuuntelija(Man pacman) {
        this.pacman = pacman;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.pacman.setSuunta(Suunta.VASEN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.pacman.setSuunta(Suunta.OIKEA);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.pacman.setSuunta(Suunta.YLOS);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.pacman.setSuunta(Suunta.ALAS);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
