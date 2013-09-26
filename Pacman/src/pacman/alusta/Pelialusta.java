package pacman.alusta;

import java.util.Scanner;

/**
 * Pelialusta luokassa luodaan pelialusta.
 * 
 * @author Hanna
 */
public class Pelialusta {

    private Peliruutu[][] pelialusta;
    private int korkeus;
    private int leveys;

    public Pelialusta(int leveys, int korkeus) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.pelialusta = new Peliruutu[korkeus][leveys];
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

    /**
     * Luodaan pelialusta, joka puodostuu peliruuduista.
     * Alustetaan jokaiselle ruudulle alustava tieto.
     * 
     * @throws Exception
     */
    public void luoPelialusta() {
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

    /**
     * Käydään läpi tekstitiedosto kenttä
     * 
     * @throws Exception
     */
    public void rakennaSeinatJaLuoPisteet() {
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

    
    /**
     * Luetaan Kentta tiedostosta arvo ja sen perusteella annetaan Pelialusta peliruuduille tarvittavat tiedot.
     * x ja y kertovat käsiteltävän peliruudun koordinaatit.
     * @param Scanner lukija
     * @param int y
     * @param int x
     */
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
}