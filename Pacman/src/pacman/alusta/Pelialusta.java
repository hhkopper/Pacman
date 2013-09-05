
package pacman.alusta;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Pelialusta extends JPanel implements Paivitettava {
    private Pacman peli;
    private int palanSivunPituus;
    
    public Pelialusta(Pacman peli, int palanSivunPituus) {
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
        super.setBackground(Color.BLACK);        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(this.peli.getMan().getX()*this.palanSivunPituus, this.peli.getMan().getY()*this.palanSivunPituus, this.palanSivunPituus, this.palanSivunPituus);
        }

    @Override
    public void paivita() {
        repaint();
    }
    
    
}
