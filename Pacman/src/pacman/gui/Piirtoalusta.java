package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Piirtoalusta extends JPanel implements Paivitettava {

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
        g.fillOval(peli.getMan().getX() * this.ruudunSivu, peli.getMan().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);

        g.setColor(Color.BLUE);
        
        for (int i = 0; i < peli.getAlusta().getKorkeus(); i++) {
            for (int j = 0; j < peli.getAlusta().getLeveys(); j++) {
                if(peli.getAlusta().getPeliruutu(j, i).getRuudunTyyppi() == 0) {
                    g.fillRect(peli.getAlusta().getPeliruutu(j,i).getX() * this.ruudunSivu, peli.getAlusta().getPeliruutu(j,i).getY() * this.ruudunSivu, 
                            this.ruudunSivu, this.ruudunSivu);
                }
            }
        }
        
//        g.setColor(Color.CYAN);
//        g.fillOval(peli.getHaamuLista().get(0).getX()*this.ruudunSivu, peli.getHaamuLista().get(0).getY()*this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
//        g.setColor(Color.MAGENTA);
//        g.fillOval(peli.getHaamuLista().get(1).getX()*this.ruudunSivu, peli.getHaamuLista().get(1).getY()*this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
//        g.setColor(Color.GREEN);
//        g.fillOval(peli.getHaamuLista().get(2).getX()*this.ruudunSivu, peli.getHaamuLista().get(2).getY()*this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
//        g.setColor(Color.RED);
//        g.fillOval(peli.getHaamuLista().get(3).getX()*this.ruudunSivu, peli.getHaamuLista().get(3).getY()*this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    @Override
    public void paivita() {
        repaint();
    }
}
