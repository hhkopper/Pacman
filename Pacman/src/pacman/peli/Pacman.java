package pacman.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import pacman.alusta.Pelialusta;
import pacman.alusta.Peliruutu;
import pacman.gui.Paivitettava;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;
import pacman.komponentit.Hedelma;

public class Pacman extends Timer implements ActionListener {

    private Man man;
    private Pelialusta alusta;
    private ArrayList<Haamu> haamut;
    private Pistelaskuri laskuri;
    private Random arpoja = new Random();
    private ArrayList<Peliruutu> hedelmanPaikat;
    private Paivitettava paivitettava;
    private boolean jatkuu;

    public Pacman() throws Exception {
        super(1000, null);
        alusta = new Pelialusta(19, 21);
        alusta.luoPelialusta();
        man = new Man(9, 11, Suunta.OIKEA, alusta);
        man.luoManAlustalle();
        haamut = new ArrayList<Haamu>();
        this.luoHaamut();
        laskuri = new Pistelaskuri();
        this.hedelmanPaikat = new ArrayList<Peliruutu>();
        this.jatkuu = true;

        addActionListener(this);
        setInitialDelay(2000);
    }

    public void luoHaamut() {
        Haamu red = new Haamu(8, 9, Suunta.YLOS, "RED", alusta);
        Haamu green = new Haamu(9, 9, Suunta.YLOS, "GREEN", alusta);
        Haamu blue = new Haamu(10, 9, Suunta.YLOS, "BLUE", alusta);
        Haamu orange = new Haamu(9, 8, Suunta.YLOS, "ORANGE", alusta);

        haamut.add(red);
        haamut.add(green);
        haamut.add(blue);
        haamut.add(orange);
    }

    public Man getMan() {
        return this.man;
    }

    public Pelialusta getAlusta() {
        return this.alusta;
    }

    public ArrayList<Haamu> getHaamuLista() {
        return this.haamut;
    }
    
    public void manSyoPistepallo() {
        if(alusta.getPeliruutu(man.getX(), man.getY()).getOnkoPistepallo()) {
            alusta.getPeliruutu(man.getX(), man.getY()).setOnkoPistepallo(false);
            laskuri.kasvata(10);
            System.out.println(laskuri.getPisteet());
        }
    }

    public void kuoleekoHaamuTaiMan() {
        for (Haamu haamu : haamut) {
            if (alusta.getPeliruutu(haamu.getX(), haamu.getY()).getOnkoMan()) {
                if (haamu.getTyyppi().equals("heikko")) {
                    haamu.palaaAlkuun();
                    laskuri.kasvata(200);
                } else {
                    man.palaaAlkuun();
                    man.vahennaElama();
                }
            }
        }
    }

    public void arvoHedelma() {
        Hedelma arvottuHedelma = new Hedelma(arpoja.nextInt(alusta.getKorkeus()), arpoja.nextInt(alusta.getLeveys()));

        while (true) {
            if (man.osuuHedelmaan(arvottuHedelma)) {
                arvottuHedelma = new Hedelma(arpoja.nextInt(alusta.getKorkeus()), arpoja.nextInt(alusta.getLeveys()));

                laskuri.kasvata(arvottuHedelma.getArvo());
            }
        }
    }

    public void etsiHedelmanPaikat() {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 19; j++) {
                Peliruutu ruutu = alusta.getPeliruutu(i, j);
                if (ruutu.getRuudunTyyppi() == 1 && ruutu.getOnkoPistepallo() == false) {
                    hedelmanPaikat.add(ruutu);
                }
            }
        }
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Haamu haamu : haamut) {
            haamu.liiku();
        }
        kuoleekoHaamuTaiMan();
        this.man.liiku();
        manSyoPistepallo();
        kuoleekoHaamuTaiMan();
        if (man.getElamat() == 0) {
            jatkuu = false;
        }
        this.paivitettava.paivita();
        setDelay(1000);
        
        if(!jatkuu) {
            this.stop();
        }
    }
}
