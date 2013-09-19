package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.peli.Pacman;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Pacman peli;
    private int ruudunSivu;

    public Piirtoalusta(Pacman peli, int sivu) {
        this.peli = peli;
        this.ruudunSivu = sivu;
        super.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        piirraMan(g);

        g.setColor(Color.BLUE);
        for (int y = 0; y < peli.getAlusta().getKorkeus(); y++) {
            for (int x = 0; x < peli.getAlusta().getLeveys(); x++) {
                piirraSeinatJaPallot(x, y, g);
            }
        }
        varitaHaamut(g);
        piirraPisteet(g);
//        if (peli.getPisteet() > 100) {
//            g.setColor(Color.PINK);
//            g.fillOval(peli.getHedelmanPaikka().getX() * this.ruudunSivu, peli.getHedelmanPaikka().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
//        }
//        for (int y = 0; y < peli.getAlusta().getKorkeus(); y++) {
//            for (int x = 0; x < peli.getAlusta().getLeveys(); x++) {
//                if (peli.getAlusta().getPeliruutu(x, y).getOnkoHedelma()) {
//                    g.setColor(Color.PINK);
//                    g.fillOval(peli.getHedelmanPaikka().getX() * this.ruudunSivu, peli.getHedelmanPaikka().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
//                }
//            }
//        }

    }

    @Override
    public void paivita() {
        repaint();
    }

    public void varitaHaamut(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(peli.getHaamuLista().get(0).getX() * this.ruudunSivu, peli.getHaamuLista().get(0).getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
        g.setColor(Color.MAGENTA);
        g.fillOval(peli.getHaamuLista().get(1).getX() * this.ruudunSivu, peli.getHaamuLista().get(1).getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
        g.setColor(Color.GREEN);
        g.fillOval(peli.getHaamuLista().get(2).getX() * this.ruudunSivu, peli.getHaamuLista().get(2).getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
        g.setColor(Color.RED);
        g.fillOval(peli.getHaamuLista().get(3).getX() * this.ruudunSivu, peli.getHaamuLista().get(3).getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraPistepallot(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 4;
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 2, this.ruudunSivu / 2);
    }

    private void piirraMan(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(peli.getMan().getX() * this.ruudunSivu, peli.getMan().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraSeinat(Graphics g, int x, int y) {
        g.fillRect(peli.getAlusta().getPeliruutu(x, y).getX() * this.ruudunSivu, peli.getAlusta().getPeliruutu(x, y).getY() * this.ruudunSivu,
                this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraSeinatJaPallot(int x, int y, Graphics g) {
        if (peli.getAlusta().getPeliruutu(x, y).getRuudunTyyppi() == 0) {
            piirraSeinat(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoPistepallo()) {
            piirraPistepallot(g, x, y);
        }
    }

    private void piirraPisteet(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(Integer.toString(peli.getPisteet()), 600, 30);
    }
}
