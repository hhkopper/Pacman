
package pacman;
import javax.swing.SwingUtilities;
import pacman.hahmot.Man;
import pacman.Suunta;
import pacman.alusta.Kayttoliittyma;
import pacman.peli.Pacman;

public class Main {

    public static void main(String[] args) {
        Pacman pacman = new Pacman(20,20);
        
        Kayttoliittyma kayttis = new Kayttoliittyma(pacman, 20);
        SwingUtilities.invokeLater(kayttis);
        
        while (kayttis.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        
        
        
        pacman.setPaivitettava(kayttis.getPaivitettava());
        pacman.start();

        

    }
}
