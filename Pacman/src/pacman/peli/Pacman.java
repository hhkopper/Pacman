
package pacman.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pacman.Suunta;
import pacman.alusta.Paivitettava;
import pacman.alusta.Peliruutu;
import pacman.hahmot.Man;

public class Pacman extends Timer implements ActionListener {
    
    private int leveys;
    private int korkeus;
    private Man man;
    private Paivitettava paivitettava;
//    private Peliruutu[][] pelilauta;
    
    public Pacman(int leveys, int korkeus) {        
        super(1000, null);
        
        this.korkeus = korkeus;
        this.leveys = leveys;
//        this.pelilauta = new Peliruutu[leveys][korkeus];
        this.man = new Man(leveys/2, korkeus/2, Suunta.OIKEA);
        
        addActionListener(this);
        setInitialDelay(1/2);
        
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.man.liiku();
        
        this.paivitettava.paivita();
    }
    
    public Man getMan() {
        return this.man;
    }
    
    public int getKorkeus(){
        return this.korkeus;
    }
    
    public int getLeveys() {
        return this.leveys;
    }

    

    
    
    
    
}
