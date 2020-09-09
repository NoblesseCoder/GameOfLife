import com.company.Board;
import com.company.GameRules;
import com.company.gui.MainFrame;

public class App {
    private static int GUI_WIDTH = 900;
    private static int GUI_HEIGHT = 700;
    private static int BOARD_WIDTH = 100;
    private static int BOARD_HEIGHT = 100;

    public static void main(String[] args) throws InterruptedException {

        Board board = Board.getInstance();
        board.initBoardParameters(BOARD_WIDTH, BOARD_HEIGHT);
        GameRules gameRules = new GameRules(board);
        new MainFrame(board,gameRules,GUI_WIDTH,GUI_HEIGHT);
    }
}
