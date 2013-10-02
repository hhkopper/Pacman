//package pacman.gui;
//
//import javax.swing.JOptionPane;
//import pacman.peli.Highscore;
//import pacman.peli.Pacman;
//
//public class HighscorenKasittelija {
//
//    private boolean ikkuna;
//    private Piirtoalusta alusta;
//    private Pacman peli;
//    private Highscore highscore;
//
//    public HighscorenKasittelija(Piirtoalusta alusta, Pacman peli, Highscore highscore) {
//        this.ikkuna = false;
//        this.alusta = alusta;
//        this.peli = peli;
//        this.highscore = highscore;
//    }
//
//    public void highscoreNimi() {
//        if (this.ikkuna) {
//            return;
//        }
//        this.ikkuna = true;
//        int b = -1;
//        String nimi = "";
//        while (b < 0) {
//            nimi = JOptionPane.showInputDialog("Uusi ennatys! Kirjoita nimesi: ");
//            if (nimi.length() > 0) {
//                b++;
//            }
//        }
//        this.ikkuna = false;
//        this.highscore.lisaaEnnatys(nimi, peli.getPisteet());
//    }
//}
