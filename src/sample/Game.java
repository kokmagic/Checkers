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
        if (color == 1 && blackTurn) {
            previousX = x;
            previousY = y;
        }
        if (color == 0) {
            board[previousX][previousY].setColor(0);
            board[x][y].setColor(1);
        }

    }
}
