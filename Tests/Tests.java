import org.junit.jupiter.api.Test;
import sample.Tile;

import static org.junit.jupiter.api.Assertions.*;
import static sample.Game.*;

class Tests {
    public void setChecker(int x, int y, int color, boolean queen, boolean mustAttack, boolean globalAttack, boolean light) {
        board[x][y].setColor(color);
        board[x][y].setQueen(queen);
        board[x][y].setMustAttack(mustAttack);
        board[x][y].setGlobalAttack(globalAttack);
        board[x][y].setLight(light);
    }

    private void clearBoard() {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if ((i + j) % 2 == 1) setChecker(i, j, 0, false, false,false, false);
            }
        }
    }

    //черная шашка ходит, а затем белая ее бьет
    @Test
    public void test1() {
        clearBoard();
        blackTurn = true;
        setChecker(2, 3, 1, false, false, false, false);
        setChecker(4, 1, 2, false, false, false, false);
        turn(2, 3);
        turn(3, 2);
        turn(4, 1);
        turn(2, 3);
        assertEquals(board[2][3], new Tile(2, false, false, false, false));
    }

    //когда черная дамка начала бить и может бить дальше, другая черная шашка, которая до этого могла бить,
    //такой возможности уже не имееет
    @Test
    public void test2 () {
        clearBoard();
        blackTurn = true;
        setChecker(1, 2, 1, true, false, false, false);
        setChecker(1, 4, 1, false, false, false, false);
        setChecker(2, 1, 2, false, false, false, false);
        setChecker(4, 1, 2, false, false, false, false);
        setChecker(2, 5, 2, false, false, false, false);
        turn(1, 2);
        turn(3, 0);
        turn(1, 4);
        turn(3, 6);
        turn(3, 0);
        turn(5, 2);
        assertEquals(board[1][2], new Tile(0, false, false, false, false));
        assertEquals(board[2][1], new Tile(0, false, false, false, false));
        assertEquals(board[3][0], new Tile(0, false, false, false, false));
        assertEquals(board[4][1], new Tile(0, false, false, false, false));
        assertEquals(board[1][4], new Tile(1, false, false, false, false));
        assertEquals(board[2][5], new Tile(2, false, false, false, false));
        assertEquals(board[5][2], new Tile(1, true, false, false, false));
    }
}
