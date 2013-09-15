package pacman.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pacman.alusta.Pelialusta;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;

public class Pacman extends Timer implements ActionListener {

    private Pelialusta alusta;
    private int korkeus;
    private int leveys;
    private Man pacman;

    public Pacman(Pelialusta alusta) {
        super(1000, null);
        this.alusta = alusta;
        korkeus = alusta.getKorkeus();
        leveys = alusta.getLeveys();
        pacman = new Man(11, 9, Suunta.OIKEA, alusta);
        
        addActionListener(this);
        setInitialDelay(2000);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        pacman.liiku();
    }
}
