package pacman;

import javax.swing.SwingUtilities;
import pacman.gui.Kayttoliittyma;
import pacman.peli.Pacman;

public class Main {

    public static void main(String[] args) throws Exception {
        
        
        Pacman pacman = new Pacman();
        Kayttoliittyma kayttis = new Kayttoliittyma(pacman);
        
        SwingUtilities.invokeLater(kayttis);

        while (kayttis.getPaivitettava() == null) {
            try {
                Thread.sleep(0,5);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        pacman.setPaivitettava(kayttis.getPaivitettava());
        pacman.start();

//        Pelialusta alusta = new Pelialusta(19,21);
//        alusta.luoPelialusta();
////        
//        Haamu haamu = new Haamu(10, 9, Suunta.VASEN, "kaipio", alusta);
//        haamu.liiku();
//        System.out.println(haamu);
//        haamu.liiku();
//        System.out.println(haamu);
//        
//
//        for (int i = 0; i < alusta.getKorkeus(); i++) {
//            for (int j = 0; j < alusta.getLeveys(); j++) {
//                System.out.print(alusta.getPeliruutu(j, i).getRuudunTyyppi());
//            }
////            System.out.println("");
//        }
        
//        Man pacman = new Man(11,9, Suunta.OIKEA, alusta);
//        pacman.luoManAlustalle();
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
