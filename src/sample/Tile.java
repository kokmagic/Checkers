package sample;

public class Tile {
    int color;
    boolean queen;
    boolean light;
    boolean mustAttack;

    public Tile(int color, boolean queen) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getCodeWord() {
        if (color == 1) return "Черная";
        if (color == 2) return "Белая";
        return "Ничего";
    }
}
