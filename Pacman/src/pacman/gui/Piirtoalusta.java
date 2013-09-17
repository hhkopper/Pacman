
package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Piirtoalusta extends JPanel implements Paivitettava{
    private Pacman peli;
    private int ruudunSivu;
    
    public Piirtoalusta(Pacman peli) {
        this.peli = peli;
        this.ruudunSivu = 38;
        super.setBackground(Color.BLACK);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(peli.getMan().getY()*this.ruudunSivu, peli.getMan().getX()*this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    @Override
    public void paivita() {
        repaint();
    }
    
}
