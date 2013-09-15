package pacman.peli;

import java.util.ArrayList;
import java.util.Random;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;
import pacman.komponentit.Hedelma;

public class Pacman {

    private Man pacman;
    private Pelialusta alusta;
    private ArrayList<Haamu> haamut;
    private Pistelaskuri laskuri;

    public Pacman() throws Exception {
        alusta = new Pelialusta(21,19);
        alusta.luoPelialusta();
        pacman = new Man(11, 9, Suunta.OIKEA, alusta);
        pacman.luoManAlustalle();
        haamut = new ArrayList<Haamu>();
        laskuri = new Pistelaskuri();
    }

    public void luoHaamut() {
        Haamu red = new Haamu(9, 9, Suunta.YLOS, "RED", alusta);
        Haamu green = new Haamu(9, 9, Suunta.YLOS, "GREEN", alusta);
        Haamu blue = new Haamu(9, 9, Suunta.YLOS, "BLUE", alusta);
        Haamu orange = new Haamu(9, 9, Suunta.YLOS, "ORANGE", alusta);

        haamut.add(red);
        haamut.add(green);
        haamut.add(blue);
        haamut.add(orange);
    }

    public void kuoleekoHaamuTaiMan() {
        for (Haamu haamu : haamut) {
            if (alusta.getPeliruutu(haamu.getX(), haamu.getY()).getOnkoMan()) {
                if(haamu.getTyyppi().equals("heikko")){
                    haamu.palaaAlkuun();
                    laskuri.kasvata(200);
                } else {
                    pacman.palaaAlkuun();
                }                
            }
        }
    }
    
    public void arvoHedelma() {
        Random arpoja = new Random();
        int xKoordinaatti = arpoja.nextInt(20);
        int yKoordinaatti = arpoja.nextInt(18);
        
        if(alusta.getPeliruutu(xKoordinaatti, yKoordinaatti).getOnkoPistepallo() == false) {
            if(alusta.getPeliruutu(xKoordinaatti, yKoordinaatti).getRuudunTyyppi() == 1) {
                Hedelma hedelma = new Hedelma(xKoordinaatti, yKoordinaatti);
            }
        }
    }
}
