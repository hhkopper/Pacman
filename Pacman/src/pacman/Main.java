package pacman;

import javax.swing.SwingUtilities;
import pacman.hahmot.Man;
import pacman.Suunta;
import pacman.alusta.Kayttoliittyma;
import pacman.alusta.Pelialusta;
import pacman.peli.Pacman;

public class Main {

    public static void main(String[] args) {
        Pelialusta alusta = new Pelialusta();
        int luku = 0;

        alusta.luoPelialusta();
        alusta.rakennaSeinat();

        for (int i = 0; i < 21; i++) {
            System.out.println("");
            for (int j = 0; j < 19; j++) {
                System.out.print(alusta.getPeliruutu(i, j).getRuudunTyyppi());
                luku++;
            }
        }
        System.out.println("");
        System.out.println("luku on:" + luku);



    }
}
