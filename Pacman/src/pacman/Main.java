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

    }
}
