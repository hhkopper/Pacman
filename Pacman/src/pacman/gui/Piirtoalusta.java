package pacman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pacman.hahmot.Haamu;
import pacman.hahmot.Suunta;
import pacman.peli.Pacman;

/**
 * Piirtoalusta piirtää pelikentän, haamut, manin, pisteet ja elämät.
 * 
* @author Hanna
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    /**
     * Peli, jonka kautta päästään käsiksi tarvittaviin elementteihin.
     */
    private Pacman peli;
    private int ruudunSivu;
    private JFrame frame;
    private String nimi;
    private Kayttoliittyma kayttis;

    /**
     * Konstruktorissa asetetaan kaikki tarvittavat arvot piirtoalustalle.
     *
     * @param peli
     * @param sivu
     * @param frame
     * @param kayttis
     */
    public Piirtoalusta(Pacman peli, int sivu, JFrame frame, Kayttoliittyma kayttis) {
        this.peli = peli;
        this.ruudunSivu = sivu;
        super.setBackground(Color.BLACK);
        this.frame = frame;
        this.nimi = "";
        this.kayttis = kayttis;
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
            piirraPeliKaynnissa(g);
        } else {
            piirraPeliPaattynyt(g);
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
    private void varitaHaamut(Graphics g) {

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

    /**
     * Piirretään haamut joiden tyyppi on heikko omalla tyylillä.
     *
     * @param g
     * @param haamu haamu joka piirretään.
     */
    private void piirraHeikotHaamut(Graphics g, Haamu haamu) {
        g.setColor(Color.BLUE);
        piirraHaamu(g, haamu);
    }

    /**
     *
     * @param g
     * @param haamu haamu, joka piirretään.
     */
    public void piirraHaamu(Graphics g, Haamu haamu) {
        g.fillOval(haamu.getX() * this.ruudunSivu, haamu.getY() * this.ruudunSivu, this.ruudunSivu, this.ruudunSivu);
    }

    /**
     * Piirretään man siten, että jokaista suuntaa kuvaa oma kuvansa.
     *
     * @param g
     */
    private void piirraMan(Graphics g) {
        if (peli.getMan().getSuunta() == Suunta.OIKEA) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("pacmanOikea.png"));
            piirraManinKuva(g, kuva);
        } else if (peli.getMan().getSuunta() == Suunta.VASEN) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("pacmanVasen.png"));
            piirraManinKuva(g, kuva);
        } else if (peli.getMan().getSuunta() == Suunta.YLOS) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("pacmanYlos.png"));
            piirraManinKuva(g, kuva);
        } else if (peli.getMan().getSuunta() == Suunta.ALAS) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("pacmanAlas.png"));
            piirraManinKuva(g, kuva);
        }

    }

    /**
     * Jos ruutu on tyyppiä seinä, piirretään seinä. Jos taas ruudussa on
     * pistepallo tai ekstrapistepallo piirretään palloa kuvaava ympyrä.
     *
     * @param x
     * @param y koordinaatti Y
     * @param g koordinaatti X
     */
    private void piirraSeinatJaPallot(int x, int y, Graphics g) {
        if (peli.getAlusta().getPeliruutu(x, y).getRuudunTyyppi() == 0) {
            piirraSeinat(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoPallo()) {
            piirraPistepallot(g, x, y);
        } else if (peli.getAlusta().getPeliruutu(x, y).getOnkoExtraPallo()) {
            piirraExtraPallo(g, x, y);
        }
    }

    /**
     * Piirretään pistepalloa kuvaava ympyrä.
     *
     * @param g
     * @param x koordinaatti X
     * @param y koordinaatti Y
     */
    private void piirraPistepallot(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 3;
        g.setColor(Color.yellow);
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 3, this.ruudunSivu / 3);
    }

    /**
     * Piirretään ekstrapistepalloa kuvaava ympyrä.
     *
     * @param g
     * @param x koordinaatti X
     * @param y koordinaatti Y
     */
    private void piirraExtraPallo(Graphics g, int x, int y) {
        int luku = this.ruudunSivu / 5;
        g.setColor(Color.yellow);
        g.fillOval((x * this.ruudunSivu) + luku, (y * this.ruudunSivu) + luku, this.ruudunSivu / 2, this.ruudunSivu / 2);
    }

    /**
     * Piirretään seinää kuvaava neliö.
     *
     * @param g
     * @param x koordinaatti X
     * @param y koordinaatti Y
     */
    private void piirraSeinat(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(peli.getAlusta().getPeliruutu(x, y).getX() * this.ruudunSivu, peli.getAlusta().getPeliruutu(x, y).getY() * this.ruudunSivu,
                this.ruudunSivu, this.ruudunSivu);
    }

    /**
     * Piirretään pelaajan pistemäärä.
     *
     * @param g
     */
    private void piirraPisteet(Graphics g) {
        Font peliFontti = new Font("Candara", Font.BOLD, 30);
        g.setFont(peliFontti);
        g.setColor(Color.GREEN);
        g.drawString(Integer.toString(peli.getLaskuri().getPisteet()), 600, 60);
    }

    /**
     * Piirretään elämiä kuvaavat sydämet.
     *
     * @param g
     */
    private void piirraElamat(Graphics g) {
        for (int i = 0; i < peli.getMan().getElamat(); i++) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("sydan.png"));
            g.drawImage(kuva.getImage(), 580 + (i * (kuva.getIconWidth() + 2)), 60 + kuva.getIconHeight(), frame);
        }
    }

    /**
     * Piirretään hedelmää kuvaava kirsikan kuva.
     *
     * @param g
     */
    private void piirraHedelma(Graphics g) {
        if (peli.getLaskuri().getPisteet() > 400) {
            ImageIcon kuva = new ImageIcon(this.getClass().getResource("kirsikka.png"));
            g.drawImage(kuva.getImage(), peli.getHedelmanPaikka().getX() * this.ruudunSivu, peli.getHedelmanPaikka().getY() * this.ruudunSivu, frame);
        }
    }

    /**
     * Piirretään teksti, joka kertoo onko peli voitettu vai hävitty.
     *
     * @param g
     */
    private void piirretaanTilanne(Graphics g) {
        if (peli.getTilanne()) {
            g.drawString("Voitit! Onneksi olkoon!", 200, 300);
        } else {
            g.drawString("Hävisit...", 200, 300);
        }
    }

    /**
     * Piirretään pelilauta kun peli on käynnissä.
     *
     * @param g
     */
    private void piirraPeliKaynnissa(Graphics g) {
        piirraElamat(g);
        piirraMan(g);
        for (int y = 0; y < peli.getAlusta().getKorkeus(); y++) {
            for (int x = 0; x < peli.getAlusta().getLeveys(); x++) {
                piirraSeinatJaPallot(x, y, g);
            }
        }
        piirraHedelma(g);
        varitaHaamut(g);
        piirraPisteet(g);
    }

    /**
     * Tarkistetaan onko uusi pistemäärä ennätys.
     */
    private void onkoEnnatys() {
        if (kayttis.getHighscore().tarkistaOnkoEnnatys(peli.getPisteet())) {
            kayttis.getHighscore().kirjaaEnnatys(peli.getPisteet());
        }
    }

    /**
     * Piirretään pelialusta, kun peli on päättynyt.
     *
     * @param g
     */
    private void piirraPeliPaattynyt(Graphics g) {
        g.setColor(Color.RED);
        Font peliFontti = new Font("Candara", Font.BOLD, 25);
        g.setFont(peliFontti);
        piirretaanTilanne(g);
        g.setColor(Color.RED);
        g.drawString("Pisteesi: " + peli.getLaskuri().getPisteet(), 200, 330);
        onkoEnnatys();
        g.drawString("Ennätyspisteet: " + kayttis.getHighscore().getParas(), 200, 390);
        g.drawString("Paina ENTER aloittaaksesi uuden pelin", 80, 500);
        paivita();
    }

    /**
     * Piirretään kuva.
     *
     * @param g
     * @param kuva kuva, mikä halutaan piirtää.
     */
    private void piirraManinKuva(Graphics g, ImageIcon kuva) {
        g.drawImage(kuva.getImage(), peli.getMan().getX() * this.ruudunSivu, peli.getMan().getY() * this.ruudunSivu, frame);
    }
}