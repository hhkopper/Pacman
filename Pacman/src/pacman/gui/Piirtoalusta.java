package pacman.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pacman.hahmot.Haamu;
import pacman.peli.Pacman;

/**
 * Piirtoalusta piirtää pelikentän, haamut, manin, pisteet ja elämät.
 *
 * @author Hanna
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    
    private Pacman peli;
    private int ruudunSivu;
    private JFrame frame;
    
    public Piirtoalusta(Pacman peli, int sivu, JFrame frame) {
        this.peli = peli;
        this.ruudunSivu = sivu;
        super.setBackground(Color.BLACK);
        this.frame = frame;
    }

    /**
     * Piirtää pelialustan ja sen komponentit.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (peli.getJatkuu()) {
            piirraMan(g);
            for (int y = 0; y < peli.getAlusta().getKorkeus(); y++) {
                for (int x = 0; x < peli.getAlusta().getLeveys(); x++) {
                    piirraSeinatJaPallot(x, y, g);
                }
            }
            varitaHaamut(g);
            piirraPisteet(g);
            piirraHedelma(g);
            piirraElamat(g);
        } else {
            g.setColor(Color.RED);
            if (peli.getTilanne()) {
                g.drawString("Voitit! Onneksi olkoon!", 255, 320);
            } else {
                g.drawString("Hävisit...", 255, 300);
            }
            g.drawString("Pisteesi: " + peli.getLaskuri().getPisteet(), 255, 330);
        }
    }

    /**
     * Piirtää uudelleen kentän
     */
    @Override
    public void paivita() {
        repaint();
    }

    /**
     * Värittää jokaisen haamun omalla värillään, kun haamut ovat vahvoja.
     * Värittää haamut sinisiksi, kun ovat heikkoja.
     *
     * @param g
     */
    public void varitaHaamut(Graphics g) {
        
        for (Haamu haamu : peli.getHaamuLista()) {
            if (haamu.getTyyppi().equals("vahva")) {
                if (haamu.getNimi().equals("red")) {
                    g.setColor(Color.RED);
                    piirraHaamu(g, haamu);
                } else if (haamu.getNimi().equals("green")) {
                    g.setColor(Color.GREEN);
                    piirraHaamu(g, haamu);
                } else if (haamu.getNimi().equals("magenta")) {
                    g.setColor(Color.MAGENTA);
                    piirraHaamu(g, haamu);
                } else if (haamu.getNimi().equals("cyan")) {
                    g.setColor(Color.CYAN);
                    piirraHaamu(g, haamu);
                }
            } else {
                piirraHeikotHaamut(g, haamu);
            }
        }
    }
    
    public void setPeli(Pacman peli) {
        this.peli = peli;
    }
    
    private void piirraHeikotHaamut(Graphics g, Haamu haamu) {
        g.setColor(Color.BLUE);
        piirraHaamu(g, haamu);
    }
    
    private void piirraHaamu(Graphics g, Haamu haamu) {
        g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }
    
    private void piirraMan(Graphics g) {
        
        ImageIcon kuva = new ImageIcon(this.getClass().getResource("pacman.png"));
        g.drawImage(kuva.getImage(), peli.getMan().getX() * this.ruudunSivu, peli.getMan().getY() * this.ruudunSivu, frame);
    }
    
    private void piirraSeinatJaPallot(int x, int y, Graphics g) {
        if (peli.getAlusta().getPeliruutu(x, y).getRuudunTyyppi() == 0) {
            piirraSeinat(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoPallo()) {
            piirraPistepallot(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoExtraPallo()) {
            piirraExtraPallo(g, x, y);
        }
    }
    
    private void piirraPistepallot(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 3;
        g.setColor(Color.yellow);
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 3, this.ruudunSivu / 3);
    }
    
    private void piirraExtraPallo(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 5;
        g.setColor(Color.yellow);
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 2, this.ruudunSivu / 2);
    }
    
    private void piirraSeinat(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(peli.getAlusta().getPeliruutu(x, y).getX() * this.ruudunSivu, peli.getAlusta().getPeliruutu(x, y).getY() * this.ruudunSivu,
                this.ruudunSivu, this.ruudunSivu);
    }
    
    private void piirraPisteet(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(Integer.toString(peli.getLaskuri().getPisteet()), 600, 30);
    }
    
    private void piirraElamat(Graphics g) {
        for (int i = 0; i < peli.getMan().getElamat(); i++) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("sydan.png"));
            g.drawImage(kuva.getImage(), 580 + (i * (kuva.getIconWidth() + 2)), 60 + kuva.getIconHeight(), frame);
        }
    }
    
    private void piirraHedelma(Graphics g) {
        if (peli.getLaskuri().getPisteet() > 400) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("kirsikka.png"));
            g.drawImage(kuva.getImage(), peli.getHedelmanPaikka().getX() * this.ruudunSivu, peli.getHedelmanPaikka().getY() * this.ruudunSivu, frame);
        }
    }
}
