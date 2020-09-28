package sample;

public class Tile {
    int color;
    boolean queen;
    boolean light;
    boolean mustAttack;

    public Tile(int color, boolean queen) {
        this.queen = queen;
        this.color = color;
        this.mustAttack = false;
        this.light = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getCodeWord() {
        if (color == 1) {
            if (queen) {
                if (light) return "Черная дамка подсвеченная";
                else return "Черная дамка";
            } else if (light) return "Черная подсвеченная";
            else return "Черная";
        }
        if (color == 2) {
            if (queen) {
                if (light) return "Белая дамка подсвеченная";
                else return "Белая дамка";
            } else if (light) return "Белая подсвеченная";
            else return "Белая";
        }
        if (color == 0 && light) return "Ничего подсвеченное";
        return "Ничего";
    }
    public void setLight(boolean light) {
        this.light = light;
    }
}
