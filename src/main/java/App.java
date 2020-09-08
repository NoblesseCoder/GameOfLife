import com.company.Board;
import com.company.GameRules;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Board board = Board.getInstance();
        int boardSize = 4;
        board.initBoardParameters(boardSize);
        boolean[][] pattern = new boolean[][]{{false,false,false,false},
                {false,true,true,false},
                {false,true,true,false},
                {false,false,false,false}};
        board.seed(pattern);
        board.display();
        GameRules gameRules = new GameRules(board);

        while (true){
            gameRules.apply();
            board.display();
        }

    }
}
