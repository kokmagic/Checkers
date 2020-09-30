package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static sample.Game.turn;

public class Controller  {
    @FXML
    GridPane gridPane;

    @FXML
    void num1(MouseEvent event) { turn(0, 1); updateUI(); }

    @FXML
    void num2(MouseEvent event) { turn(0, 3); updateUI(); }

    @FXML
    void num3(MouseEvent event) { turn(0, 5); updateUI(); }

    @FXML
    void num4(MouseEvent event) { turn(0, 7); updateUI(); }

    @FXML
    void num5(MouseEvent event) { turn(1, 0); updateUI(); }

    @FXML
    void num6(MouseEvent event) { turn(1, 2); updateUI(); }

    @FXML
    void num7(MouseEvent event) { turn(1, 4); updateUI(); }

    @FXML
    void num8(MouseEvent event) { turn(1, 6); updateUI(); }

    @FXML
    void num9(MouseEvent event) { turn(2, 1); updateUI(); }

    @FXML
    void num10(MouseEvent event) { turn(2, 3); updateUI(); }

    @FXML
    void num11(MouseEvent event) { turn(2, 5); updateUI(); }

    @FXML
    void num12(MouseEvent event) { turn(2, 7); updateUI(); }

    @FXML
    void num13(MouseEvent event) { turn(3, 0); updateUI(); }

    @FXML
    void num14(MouseEvent event) { turn(3, 2); updateUI(); }

    @FXML
    void num15(MouseEvent event) { turn(3, 4); updateUI(); }

    @FXML
    void num16(MouseEvent event) { turn(3, 6); updateUI(); }

    @FXML
    void num17(MouseEvent event) { turn(4, 1); updateUI(); }

    @FXML
    void num18(MouseEvent event) { turn(4, 3); updateUI(); }

    @FXML
    void num19(MouseEvent event) { turn(4, 5); updateUI(); }

    @FXML
    void num20(MouseEvent event) { turn(4, 7); updateUI(); }

    @FXML
    void num21(MouseEvent event) { turn(5, 0); updateUI(); }

    @FXML
    void num22(MouseEvent event) { turn(5, 2); updateUI(); }

    @FXML
    void num23(MouseEvent event) { turn(5, 4); updateUI(); }

    @FXML
    void num24(MouseEvent event) { turn(5, 6); updateUI(); }

    @FXML
    void num25(MouseEvent event) { turn(6, 1); updateUI(); }

    @FXML
    void num26(MouseEvent event) { turn(6, 3); updateUI(); }

    @FXML
    void num27(MouseEvent event) { turn(6, 5); updateUI(); }

    @FXML
    void num28(MouseEvent event) { turn(6, 7); updateUI(); }

    @FXML
    void num29(MouseEvent event) { turn(7, 0); updateUI(); }

    @FXML
    void num30(MouseEvent event) { turn(7, 2); updateUI(); }

    @FXML
    void num31(MouseEvent event) { turn(7, 4); updateUI(); }

    @FXML
    void num32(MouseEvent event) { turn(7, 6); updateUI(); }


    Map<String, Image> listOfImages = new HashMap<>();

    public Controller() {
        try {
            listOfImages.put("Черная", new Image(new FileInputStream("src\\resources\\black.png")));
            listOfImages.put("Белая", new Image(new FileInputStream("src\\resources\\white.png")));
            listOfImages.put("Ничего", new Image(new FileInputStream("src\\resources\\nothing.jpg")));
            listOfImages.put("Черная подсвеченная", new Image(new FileInputStream("src\\resources\\blacklighted.png")));
            listOfImages.put("Черная дамка", new Image(new FileInputStream("src\\resources\\blackqueen.png")));
            listOfImages.put("Черная дамка подсвеченная", new Image(new FileInputStream("src\\resources\\blackqueenlighted.png")));
            listOfImages.put("Белая подсвеченная", new Image(new FileInputStream("src\\resources\\whitelighted.png")));
            listOfImages.put("Белая дамка", new Image(new FileInputStream("src\\resources\\whitequeen.png")));
            listOfImages.put("Белая дамка подсвеченная", new Image(new FileInputStream("src\\resources\\whitequeenlighted.png")));
            listOfImages.put("Ничего подсвеченное", new Image(new FileInputStream("src\\resources\\nothinglighted.jpg")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateUI() {
        for(Node n : gridPane.getChildren()) {
            ImageView images = (ImageView) n;
            images.setImage(listOfImages.get(Game.board[GridPane.getRowIndex(n)][GridPane.getColumnIndex(n)].getCodeWord()));
        }
    }
}
