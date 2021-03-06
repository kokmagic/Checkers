package sample;

public class Tile {
    int color;
    boolean queen;
    boolean light;
    boolean mustAttack;
    boolean globalAttack;

    public Tile(int color, boolean queen, boolean mustAttack, boolean globalAttack, boolean light) {
        this.queen = queen;
        this.color = color;
        this.mustAttack = mustAttack;
        this.light = light;
        this.globalAttack = globalAttack;
    }

    public Tile(int color) {
        this.queen = false;
        this.color = color;
        this.mustAttack = false;
        this.light = false;
        this.globalAttack = false;
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

    public boolean getLight() {
        return light;
    }

    public void setMustAttack(boolean mustAttack) {
        this.mustAttack = mustAttack;
    }

    public boolean getMustAttack() {
        return mustAttack;
    }

    public void setQueen(boolean queen) {
        this.queen = queen;
    }

    public boolean getQueen() {
        return queen;
    }

    public boolean getGlobalAttack() {
        return globalAttack;
    }

    public void setGlobalAttack(boolean globalAttack) { this.globalAttack = globalAttack; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile obj = (Tile) o;
        return color == obj.color && queen == obj.queen && mustAttack == obj.mustAttack && light == obj.light && globalAttack == obj.globalAttack;
    }

}
