package sample;

public class Game {
    static Tile[][] board = new Tile[8][8];
    static boolean blackTurn = true;
    static int previousX;
    static int previousY;
    static boolean isGlobalAttack;
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
        checkerReachedEnd(x, y);
        if (color == 1 && blackTurn && isThereLights()) clear();
        if (color == 2 && !blackTurn && isThereLights()) clear();
        if (isGlobalAttack && !board[x][y].getGlobalAttack() && board[x][y].getColor() != 0) {
            clear();
        }
        if (color == 0 && board[x][y].getLight() && isThereAttacker()) {
            if (blackTurn && haveToAttackLeft(previousX, previousY)) {
                board[previousX][previousY].setColor(0);
                board[x][y].setColor(1);
                if (board[previousX][previousY].getQueen()) {
                    board[x][y].setQueen(true);
                    board[previousX][previousY].setQueen(false);
                    if (board[previousX - 1][y + 1].getColor() == 2) {
                        if (x == previousX + 2) {
                            board[x - 1][y + 1].setQueen(false);
                            board[x - 1][y + 1].setColor(0);
                        }
                        if (x == previousX - 2) {
                            board[x + 1][y + 1].setQueen(false);
                            board[x + 1][y + 1].setColor(0);
                        }
                    } else {
                        board[x - 1][y + 1].setColor(0);
                        board[x - 1][y + 1].setQueen(false);
                    }
                } else {
                    board[x - 1][y + 1].setColor(0);
                    board[x - 1][y + 1].setQueen(false);
                }
                board[previousX][previousY].setMustAttack(false);
                board[previousX][previousY].setGlobalAttack(false);
                if (haveToAttack(x, y)) {
                    board[x][y].setMustAttack(true);
                    board[x][y].setGlobalAttack(true);
                    isGlobalAttack = true;
                } else {
                    board[x][y].setMustAttack(false);
                    board[x][y].setGlobalAttack(false);
                    isGlobalAttack = false;
                    blackTurn = !blackTurn;
                    checkerReachedEnd(x, y);
                }
                clear();
            }
            if (blackTurn && haveToAttackRight(previousX, previousY)) {
                board[previousX][previousY].setColor(0);
                board[x][y].setColor(1);
                if (board[previousX][previousY].getQueen()) {
                    board[x][y].setQueen(true);
                    board[previousX][previousY].setQueen(false);
                    if (board[previousX - 1][y - 1].getColor() == 2) {
                        if (x == previousX + 2) {
                            board[x - 1][y - 1].setQueen(false);
                            board[x - 1][y - 1].setColor(0);
                        }
                        if (x == previousX - 2) {
                            board[x + 1][y - 1].setQueen(false);
                            board[x + 1][y - 1].setColor(0);
                        }
                    } else {
                        board[x - 1][y - 1].setColor(0);
                        board[x - 1][y - 1].setQueen(false);
                    }
                } else {
                    board[x - 1][y - 1].setColor(0);
                    board[x - 1][y - 1].setQueen(false);
                }
                board[previousX][previousY].setMustAttack(false);
                board[previousX][previousY].setGlobalAttack(false);
                if (haveToAttack(x, y)) {
                    board[x][y].setMustAttack(true);
                    board[x][y].setGlobalAttack(true);
                    isGlobalAttack = true;
                } else {
                    board[x][y].setMustAttack(false);
                    board[x][y].setGlobalAttack(false);
                    isGlobalAttack = false;
                    blackTurn = !blackTurn;
                    checkerReachedEnd(x, y);
                }
                clear();
            }
            if (!blackTurn && haveToAttackLeft(previousX, previousY)) {
                board[previousX][previousY].setColor(0);
                board[x][y].setColor(2);
                if (board[previousX][previousY].getQueen()) {
                    board[x][y].setQueen(true);
                    board[previousX][previousY].setQueen(false);
                    if (board[previousX + 1][previousY - 1].getColor() == 1) {
                        if (x == previousX + 2) {
                            board[previousX + 1][previousY - 1].setQueen(false);
                            board[previousX + 1][previousY - 1].setColor(0);
                        }
                        if (x == previousX - 2) {
                            board[previousX - 1][previousY - 1].setQueen(false);
                            board[previousX - 1][previousY - 1].setColor(0);
                        }
                    } else {
                        board[previousX - 1][previousY - 1].setColor(0);
                        board[previousX - 1][previousY - 1].setQueen(false);
                    }
                } else {
                    board[x + 1][y + 1].setColor(0);
                    board[x + 1][y + 1].setQueen(false);
                }
                board[previousX][previousY].setMustAttack(false);
                board[previousX][previousY].setGlobalAttack(false);
                if (haveToAttack(x, y)) {
                    board[x][y].setMustAttack(true);
                    board[x][y].setGlobalAttack(true);
                    isGlobalAttack = true;
                } else {
                    board[x][y].setMustAttack(false);
                    board[x][y].setGlobalAttack(false);
                    isGlobalAttack = false;
                    blackTurn = !blackTurn;
                    checkerReachedEnd(x, y);
                }
                clear();
            }
            if (!blackTurn && haveToAttackRight(previousX, previousY)) {
                board[previousX][previousY].setColor(0);
                board[x][y].setColor(2);
                if (board[previousX][previousY].getQueen()) {
                    board[x][y].setQueen(true);
                    board[previousX][previousY].setQueen(false);
                    if (board[previousX + 1][y - 1].getColor() == 1) {
                        if (x == previousX + 2) {
                            board[x - 1][y - 1].setQueen(false);
                            board[x - 1][y - 1].setColor(0);
                        }
                        if (x == previousX - 2) {
                            board[x + 1][y - 1].setQueen(false);
                            board[x + 1][y - 1].setColor(0);
                        } else {
                            board[x + 1][y - 1].setColor(0);
                            board[x + 1][y - 1].setQueen(false);
                        }
                    } else {
                        board[x + 1][y - 1].setColor(0);
                        board[x + 1][y - 1].setQueen(false);
                    }
                } else {
                    board[x + 1][y - 1].setColor(0);
                    board[x + 1][y - 1].setQueen(false);
                }
                board[previousX][previousY].setMustAttack(false);
                board[previousX][previousY].setGlobalAttack(false);
                if (haveToAttack(x, y)) {
                    board[x][y].setMustAttack(true);
                    board[x][y].setGlobalAttack(true);
                    isGlobalAttack = true;
                } else {
                    board[x][y].setMustAttack(false);
                    board[x][y].setGlobalAttack(false);
                    isGlobalAttack = false;
                    blackTurn = !blackTurn;
                    checkerReachedEnd(x, y);
                }
                clear();
            }
        }
        if (color == 0 && board[x][y].getLight()) {
            board[previousX][previousY].setColor(0);
            if (blackTurn) board[x][y].setColor(1);
            else board[x][y].setColor(2);
            blackTurn = !blackTurn;
            if (board[previousX][previousY].getQueen()) {
                board[previousX][previousY].setQueen(false);
                board[x][y].setQueen(true);
            }
            checkerReachedEnd(x, y);
            clear();
        }
        if (color == 1 && blackTurn && haveToAttack(x, y)) {
            board[x][y].setLight(true);
            previousX = x;
            previousY = y;
        }
        if (color == 1 && blackTurn && (!haveToAttackLeft(x, y) && !haveToAttackRight(x, y))) {
            if (canMove(x, y) && !setAttacker(1)) {
                board[x][y].setLight(true);
                previousX = x;
                previousY = y;
            }
        }
        if (color == 2 && !blackTurn && haveToAttack(x, y)) {
            board[x][y].setLight(true);
            previousX = x;
            previousY = y;
        }
        if (color == 2 && !blackTurn && (!haveToAttackLeft(x, y) && !haveToAttackRight(x, y))) {
            if (canMove(x, y) && !setAttacker(2)) {
                board[x][y].setLight(true);
                previousX = x;
                previousY = y;
            }
        }
    }

    public static boolean canMoveLeft(int x, int y) {
        if (y == 0) return false;
        int color = board[x][y].getColor();
        if (board[x][y].getQueen()) {
            if (x - 1 >= 0 && x + 1 <= 7) {
                if (board[x - 1][y - 1].getColor() == 0) board[x - 1][y - 1].setLight(true);
                if (board[x + 1][y - 1].getColor() == 0) board[x + 1][y - 1].setLight(true);
                return true;
            }
            if (x + 1 >= 7) {
                if (board[x - 1][y - 1].getColor() == 0) {
                    board[x - 1][y - 1].setLight(true);
                    return true;
                }
            }
            if (x - 1 <= 0) {
                if (board[x + 1][y - 1].getColor() == 0) {
                    board[x + 1][y - 1].setLight(true);
                    return true;
                }
            }
            return false;
        }
        int delta;
        if (color == 1) delta = 1;
        else delta = -1;
        if (board[x + delta][y - 1].getColor() == 0) {
            board[x + delta][y - 1].setLight(true);
            return true;
        }
        return false;
    }

    public static boolean canMoveRight(int x, int y) {
        if (y == 7) return false;
        int color = board[x][y].getColor();
        if (board[x][y].getQueen()) {
            if (x - 1 >= 0 && x + 1 <= 7) {
                if (board[x - 1][y + 1].getColor() == 0) board[x - 1][y + 1].setLight(true);
                if (board[x + 1][y + 1].getColor() == 0) board[x + 1][y + 1].setLight(true);
                return true;
            }
            if (x + 1 >= 7) {
                if (board[x - 1][y + 1].getColor() == 0) {
                    board[x - 1][y + 1].setLight(true);
                    return true;
                }
            }
            if (x - 1 <= 0) {
                if (board[x + 1][y + 1].getColor() == 0) {
                    board[x + 1][y + 1].setLight(true);
                    return true;
                }
            }
            return false;
        }
        int delta;
        if (color == 1) delta = 1;
        else delta = -1;
        if (board[x + delta][y + 1].getColor() == 0) {
            board[x + delta][y + 1].setLight(true);
            return true;
        }
        return false;
    }

    public static void clear() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1) board[j][i].setLight(false);
            }
        }
    }

    public static boolean haveToAttackLeft(int x, int y) {
        int color = board[x][y].getColor();
        if (board[x][y].getQueen()) {
            int delta;
           if (color == 1) delta = 2;
           else delta = 1;
           if (x - 2 >= 0 && x + 2 <= 7 && y - 2 >= 0) {
               int count = 0;
               if (board[x - 1][y - 1].getColor() == delta && board[x - 2][y - 2].getColor() == 0) {
                   count ++;
                   board[x][y].setMustAttack(true);
                   board[x - 2][y - 2].setLight(true);
               }
               if (board[x + 1][y - 1].getColor() == delta && board[x + 2][y - 2].getColor() == 0) {
                   count ++;
                   board[x][y].setMustAttack(true);
                   board[x + 2][y - 2].setLight(true);
               }
               if (count > 0) return true;
           }
           if (x - 2 <= 0 && y - 2 >= 0) {
                if (board[x + 1][y - 1].getColor() == delta && board[x + 2][y - 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x + 2][y - 2].setLight(true);
                    return true;
                }
            }
           if (x + 2 >= 7 && y - 2 >= 0) {
               if (board[x - 1][y - 1].getColor() == delta && board[x - 2][y - 2].getColor() == 0) {
                   board[x][y].setMustAttack(true);
                   board[x - 2][y - 2].setLight(true);
                   return true;
               }
           }
           return false;
        }
        if (color == 1) {
            if (y - 2 >= 0 && x + 2 <= 7) {
                if (board[x + 1][y - 1].getColor() == 2 && board[x + 2][y - 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x + 2][y - 2].setLight(true);
                    return true;
                }
            }
        }
        if (color == 2) {
            if (y - 2 >= 0 && x - 2 >= 0) {
                if (board[x - 1][y - 1].getColor() == 1 && board[x - 2][y - 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x - 2][y - 2].setLight(true);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean haveToAttackRight (int x, int y) {
        int color = board[x][y].getColor();
        if (board[x][y].getQueen()) {
            int delta;
            if (color == 1) delta = 2;
            else delta = 1;
            if (x - 2 >= 0 && x + 2 <= 7 && y + 2 <= 7) {
                int count = 0;
                if (board[x - 1][y + 1].getColor() == delta && board[x - 2][y + 2].getColor() == 0) {
                    count ++;
                    board[x][y].setMustAttack(true);
                    board[x - 2][y + 2].setLight(true);
                }
                if (board[x + 1][y + 1].getColor() == delta && board[x + 2][y + 2].getColor() == 0) {
                    count ++;
                    board[x][y].setMustAttack(true);
                    board[x + 2][y + 2].setLight(true);
                }
                if (count > 0) return true;
            }
            if (x - 2 <= 0 && y + 2 <= 7) {
                if (board[x + 1][y + 1].getColor() == delta && board[x + 2][y + 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x + 2][y + 2].setLight(true);
                    return true;
                }
            }
            if (x + 2 >= 7 && y + 2 <= 7) {
                if (board[x - 1][y + 1].getColor() == delta && board[x - 2][y + 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x - 2][y + 2].setLight(true);
                    return true;
                }
            }
            return false;
        }
        if (color == 1) {
            if (y + 2 <= 7 && x + 2 <= 7) {
                if (board[x + 1][y + 1].getColor() == 2 && board[x + 2][y + 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x + 2][y + 2].setLight(true);
                    return true;
                }
            }
        }
        if (color == 2) {
            if (y + 2 <= 7 && x - 2 >= 0) {
                if (board[x - 1][y + 1].getColor() == 1 && board[x - 2][y + 2].getColor() == 0) {
                    board[x][y].setMustAttack(true);
                    board[x - 2][y + 2].setLight(true);
                    return true;
                }
            }
        }
        return false;
    }


    public static void checkerReachedEnd(int x, int y) {
        int color = board[x][y].getColor();
        if ((color == 1 && x == 7) || (color == 2 && x == 0)) {
            board[x][y].setQueen(true);
        }
    }

    public static boolean isThereLights() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1 && board[j][i].getLight()) return true;
            }
        }
        return false;
    }

    public static boolean isThereAttacker() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1 && board[j][i].getMustAttack()) return true;
            }
        }
        return false;
    }

    public static boolean canMove(int x, int y) {
        return canMoveLeft(x, y) | canMoveRight(x, y);
    }

    public static boolean haveToAttack(int x, int y) {
        return haveToAttackLeft(x, y) | haveToAttackRight(x, y);
    }

    public static boolean setAttacker(int color) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1 && board[j][i].getColor() == color && haveToAttack(j, i)) {
                    clear();
                    return true;
                }
            }
        }
        return false;
    }
}
