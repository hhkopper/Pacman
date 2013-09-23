package pacman.alusta;

import java.util.Scanner;

public class Pelialusta {

    private Peliruutu[][] pelialusta;
    private int korkeus;
    private int leveys;

    public Pelialusta(int leveys, int korkeus) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelialusta = new Peliruutu[korkeus][leveys];

//        korkeus tulee olla 21 ja leveys 19, ei vielä kovakoodata
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public Peliruutu getPeliruutu(int i, int j) {
        return this.pelialusta[j][i];
    }

    public void luoPelialusta() throws Exception {
        for (int i = 0; i <= korkeus - 1; i++) {
            for (int j = 0; j <= leveys - 1; j++) {
                this.pelialusta[i][j] = new Peliruutu(j, i);
                this.pelialusta[i][j].setRuudunTyyppi(1);
                this.pelialusta[i][j].setOnkoMan(false);
                this.pelialusta[i][j].setOnkoHaamu(false);
                this.pelialusta[i][j].setOnkoPallo(false);
            }
        }
        rakennaSeinatJaLuoPisteet();
    }

    public void rakennaSeinatJaLuoPisteet() throws Exception {
        Scanner lukija = new Scanner(this.getClass().getResourceAsStream("Kentta"));
        int y = 0;

        while (lukija.hasNextLine()) {
            for (int x = 0; x < 19; x++) {
                asetaSeinatJaPistepallot(lukija, y, x);
            }
            y++;
        }
        lukija.close();
    }

    private void asetaSeinatJaPistepallot(Scanner lukija, int y, int x) {
        int arvo =lukija.nextInt();
        
        if (arvo == 0) {
            this.pelialusta[y][x].setRuudunTyyppi(0);
        } else if(arvo == 2) {
            this.pelialusta[y][x].setRuudunTyyppi(2);
            this.pelialusta[y][x].setOnkoExtraPallo(true);
        } else if(arvo == 1) {
            this.pelialusta[y][x].setOnkoPallo(true);
        } else {
            this.pelialusta[y][x].setRuudunTyyppi(3);
        }
        
    }

    public String toString() {
        return "Korkeus:" + this.korkeus + ", leveys:" + this.leveys;
    }
}
