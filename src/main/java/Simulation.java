import com.company.Config;
import com.company.gol.Universe;

public class Simulation {
    public static void main(String[] args){
        Universe universe = Universe.getInstance();
        universe.initCells(Config.UNIVERSE_WIDTH, Config.UNIVERSE_HEIGHT);
        universe.run();
    }
}
