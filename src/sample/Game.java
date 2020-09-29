package sample;

public class Game {
    static Tile[][] board = new Tile[8][8];
    static boolean blackTurn = true;
    static int previousX;
    static int previousY;
    static {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1) board[i][j] = new Tile(1, false);
            }
        }
        for (int i = 3; i <= 4; i++) {
            for (int j = 0; j <= 7; j++) {
                board[i][j] = new Tile(0, false);
            }
        }
        for (int i = 5; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1) board[i][j] = new Tile(2, false);
            }
        }
    }
    public static void turn(int x, int y) {
        int color = board[x][y].getColor();
        if (color == 1 && blackTurn && canMove(x, y)) {
            previousX = x;
            previousY = y;
        }
        if (color == 0 && board[x][y].getLight()) {
            board[previousX][previousY].setColor(0);
            if (blackTurn) board[x][y].setColor(1);
            else board[x][y].setColor(2);
            blackTurn = !blackTurn;
            clear();
        }
    }

    public static boolean canMoveLeft(int x, int y) {
        if (x == 0) return false;
        int color = board[x][y].getColor();
        int delta;
        if (color == 1) delta = 1;
        else delta = -1;
        if (board[x - 1][y + delta].getColor() == 0) {
            board[x - 1][y + delta].setLight(true);
            return true;
        }
        return false;
    }

    public static boolean canMoveRight(int x, int y) {
        if (x == 7) return false;
        int color = board[x][y].getColor();
        int delta;
        if (color == 1) delta = 1;
        else delta = -1;
        if (board[x + 1][y + delta].getColor() == 0) {
            board[x + 1][y + delta].setLight(true);
            return true;
        }
        return false;
    }

    public static boolean canMove(int x, int y) {
        return canMoveLeft(x, y) || canMoveRight(x, y);
    }

    public static void clear() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                board[j][i].setLight(false);
            }
        }
    }

    public static boolean haveToAttackLeft(int x, int y) {
        int color = board[x][y].getColor();
        if (color == 1) {
            if (board[x - 1][y + 1].getColor() == 2 && board[x - 2][y + 2].getColor() == 0 && x - 2 <= 0 && y + 2 <= 7) {
                board[x][y].setMustAttack(true);
                board[x - 2][y + 2].setLight(true);
                return true;
            }
        }
        if (color == 2) {
            if (board[x - 1][y - 1].getColor() == 1 && board[x - 2][y - 2].getColor() == 0 && x - 2 <= 0 && y - 2 <= 0) {
                board[x][y].setMustAttack(true);
                board[x - 2][y - 2].setLight(true);
                return true;
            }
        }
        return false;
    }
}
