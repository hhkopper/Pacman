package pacman.hahmot;

public enum Suunta {

    YLOS(-1, 0), 
    OIKEA(0, 1), 
    ALAS(1, 0), 
    VASEN(0, -1);
    
    private int x;
    private int y;

    private Suunta(int y, int x) {
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
