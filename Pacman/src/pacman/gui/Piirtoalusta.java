package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import pacman.hahmot.Haamu;
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
//        g.setColor(Color.BLUE);
        for (int y = 0; y < peli.getAlusta().getKorkeus(); y++) {
            for (int x = 0; x < peli.getAlusta().getLeveys(); x++) {
                piirraSeinatJaPallot(x, y, g);
            }
        }
        varitaHaamut(g);
        piirraPisteet(g);
        piirraHedelma(g);
    }

    @Override
    public void paivita() {
        repaint();
    }

    public void varitaHaamut(Graphics g) {

        for (Haamu haamu : peli.getHaamuLista()) {
            if (haamu.getTyyppi().equals("vahva")) {
                if (haamu.getNimi().equals("red")) {
                    g.setColor(Color.RED);
                    g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
                } else if (haamu.getNimi().equals("green")) {
                    g.setColor(Color.GREEN);
                    g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
                } else if (haamu.getNimi().equals("magenta")) {
                    g.setColor(Color.MAGENTA);
                    g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
                } else if (haamu.getNimi().equals("cyan")) {
                    g.setColor(Color.CYAN);
                    g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
                }
            } else {
                    piirraHeikotHaamut(g, haamu);
            }
        }
    }

    private void piirraPistepallot(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 3;
        g.setColor(Color.yellow);
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 3, this.ruudunSivu / 3);
    }

    private void piirraMan(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(peli.getMan().getX() * this.ruudunSivu, peli.getMan().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraSeinat(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(peli.getAlusta().getPeliruutu(x, y).getX() * this.ruudunSivu, peli.getAlusta().getPeliruutu(x, y).getY() * this.ruudunSivu,
                this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraSeinatJaPallot(int x, int y, Graphics g) {
        if (peli.getAlusta().getPeliruutu(x, y).getRuudunTyyppi() == 0) {
            piirraSeinat(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoPallo()) {
            piirraPistepallot(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoExtraPallo()) {
            int luku = this.ruudunSivu / 5;
            g.setColor(Color.yellow);
            g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 2, this.ruudunSivu / 2);
        }
    }

    private void piirraPisteet(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(Integer.toString(peli.getPisteet()), 600, 30);
    }

    private void piirraHeikotHaamut(Graphics g, Haamu haamu) {
        g.setColor(Color.BLUE);
        g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    private void piirraHedelma(Graphics g) {
        if (peli.getPisteet() > 400) {
            g.setColor(Color.PINK);
            g.fillOval(peli.getHedelmanPaikka().getX() * this.ruudunSivu, peli.getHedelmanPaikka().getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
        }
    }
}
