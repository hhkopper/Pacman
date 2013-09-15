package pacman.peli;

import pacman.alusta.Pelialusta;
import pacman.hahmot.Haamu;
import pacman.hahmot.Man;
import pacman.hahmot.Suunta;



public class Pacman{
    private Man pacman;
    private Haamu haamu;

    public Pacman(Pelialusta alusta) {
        pacman = new Man(11,9,Suunta.OIKEA, alusta);
    }
    
    public void kuoleekoMan() {
    }
}
