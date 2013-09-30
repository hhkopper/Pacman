package pacman;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pacman.gui.Kayttoliittyma;
import pacman.peli.Pacman;

public class Main {

    public static void main(String[] args) throws Exception {  
//        
//        int b = -1;
//        String nimi = "";
//        while (b < 0) {
//            nimi = JOptionPane.showInputDialog("Uusi ennatys! Kirjoita nimesi: ");
//            if (nimi.length() > 0) {
//                b++;
//            }
//        }
//        
        Pacman peli = new Pacman();
        Kayttoliittyma kayttis = new Kayttoliittyma(peli);
        
        SwingUtilities.invokeLater(kayttis);

        while (kayttis.getPaivitettava() == null) {
            try {
                Thread.sleep(0,5);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        peli.setPaivitettava(kayttis.getPaivitettava());
        peli.start();

    }
}
