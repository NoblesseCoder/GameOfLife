import com.company.Board;
import com.company.GameRules;
import com.company.gui.MainFrame;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Board board = Board.getInstance();
        int boardWidth = 200, boardHeight = 200;
        board.initBoardParameters(boardWidth, boardHeight);
        GameRules gameRules = new GameRules(board);

//        board.display();
//        GameRules gameRules = new GameRules(board);
//
//        while (true){
//            gameRules.apply();
//            board.display();
//        }
        new MainFrame(board,gameRules);
    }
}
