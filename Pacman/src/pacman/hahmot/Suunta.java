package pacman.hahmot;

public enum Suunta {

    YLOS(0, -1), 
    OIKEA(1, 0), 
    ALAS(0, 1), 
    VASEN(-1, 0);
    
    private int x;
    private int y;

    private Suunta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
