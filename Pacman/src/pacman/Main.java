package pacman;

import javax.swing.SwingUtilities;
import pacman.hahmot.Man;
import pacman.Suunta;
import pacman.alusta.Kayttoliittyma;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.peli.Pacman;

public class Main {

    public static void main(String[] args) throws Exception {

        Pelialusta alusta = new Pelialusta(21, 19);
        alusta.luoPelialusta();

        Man man = new Man(2, 2, Suunta.ALAS);
        man.luoManAlustalle(alusta);
        System.out.println(alusta.getPeliruutu(2, 2).getOnkoMan());
        Haamu haamu = new Haamu(2, 2, Suunta.OIKEA, "punainen");
        haamu.luoHaamuAlustalle(alusta);
        System.out.println(alusta.getPeliruutu(2, 2).getOnkoHaamu());

        man.tarkistaKuoleeko(alusta);
        System.out.println(man);


//        Pelialusta alusta = new Pelialusta(21,19);
//
//        alusta.luoPelialusta();
//        alusta.rakennaSeinat();
//        
//        for (int i = 0; i < alusta.getKorkeus(); i++) {
//            for (int j = 0; j < alusta.getLeveys(); j++) {
//                System.out.print(alusta.getPeliruutu(i, j).getRuudunTyyppi());
//            }
//            System.out.println("");
//        }
//        
//        Man pacman = new Man(11,9, Suunta.OIKEA);
//        pacman.luoManAlustalle(alusta);
//        
//        System.out.println(alusta.getPeliruutu(11, 9).getOnkoMan());
//        System.out.println(alusta.getPeliruutu(11, 9).getRuudunTyyppi());
//        
//        pacman.setSuunta(Suunta.OIKEA);
//        pacman.liiku(alusta);
//        
//        System.out.println(alusta.getPeliruutu(11, 9).getOnkoMan());
//        System.out.println(alusta.getPeliruutu(11, 9).getRuudunTyyppi());
//        
//        System.out.println(alusta.getPeliruutu(11, 10).getOnkoMan());
//        System.out.println(alusta.getPeliruutu(11, 10).getRuudunTyyppi());
    }
}
