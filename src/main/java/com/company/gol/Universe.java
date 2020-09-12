package com.company.gol;

import com.company.Config;
import com.company.gui.MainFrame;

import java.util.ArrayList;
import java.util.List;


public class Universe {
    // Manages all Game Board related stuff

    private int widthOfUniverse;  // equal to num cols
    private int heightOfUniverse; // equal to num rows
    private List<Cell> cells = null;

    private Universe(){}

    private static class SingletonHandler{
        private static final Universe instance = new Universe();
    }

    public static Universe getInstance(){
        return SingletonHandler.instance;
    }

    // Initial Set-Up Functions

    public void initCells(int universeWidth, int universeHeight){
        cells = new ArrayList<>();
        widthOfUniverse = universeWidth;
        heightOfUniverse = universeHeight;
        for (int x=0;x<heightOfUniverse;x++){
            for (int y=0;y<widthOfUniverse;y++){
                cells.add(new Cell(x, y, Config.DEAD));
            }
        }
    }

    // Update Functions

    public void tick(){
        List<Boolean> newCellStatuses = applyRules();
        Universe.getInstance().updateStatusOfCells(newCellStatuses);
    }

    public List<Boolean> applyRules(){
        // Returns alive statuses of all Cells in Universe

        List<Boolean> aliveStatuses = new ArrayList<>();
        for (Cell cell: cells){
            if (cell.isAlive()){
                aliveStatuses.add(getStatusOfAliveCell(cell));
            }
            else{
                aliveStatuses.add(getStatusOfDeadCell(cell));
            }
        }
        return aliveStatuses;
    }

    private void updateStatusOfCells(List<Boolean> statuses) {
        for (int i=0;i<cells.size();i++){
            cells.get(i).setAlive(statuses.get(i));
        }
    }

    private boolean getStatusOfAliveCell(Cell cell){
        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        return ((numberOfAliveNeighbours == 2) ||
                (numberOfAliveNeighbours == 3));
    }

    private boolean getStatusOfDeadCell(Cell cell){
        // Returns the future status of a dead cell

        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        return (numberOfAliveNeighbours == 3);
    }

    private int getNumberOfAliveNeighbours(Cell cell){
        int aliveCnt = 0;
        List<Cell> neighbours = getNeighbours(cell);
        for (Cell neighbour : neighbours){
            if (neighbour.isAlive()){
                aliveCnt++;
            }
        }
        return aliveCnt;
    }

    private List<Cell> getNeighbours(Cell cell){
        /*
            Return neighbours based on type of cell
            Corner Cell: 3 neighbours
            Edge Cell: 5 neighbours
            Center Cell: 8 neighbours
         */

        List<Cell> neighbours = new ArrayList<>();
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                int xPos = cell.getXPos() + i, yPos = cell.getYPos() + j;
                if (!((xPos == cell.getXPos()) && (yPos == cell.getYPos()))) {
                    // Don't include cell itself
                    if (isCellPositionValid(xPos, yPos)) {
                        int index = widthOfUniverse * xPos + yPos; // Row-Major form
                        neighbours.add(cells.get(index));
                    }
                }
            }
        }
        return neighbours;
    }

    private boolean isCellPositionValid(int xPos, int yPos){
        return (((xPos>=0) && (yPos>=0)) &&
                ((xPos <= heightOfUniverse-1) && (yPos <= widthOfUniverse-1)));
    }

    public void resetCells() {
        for (Cell cell: cells){
            cell.setAlive(false);
        }
    }

    // Fetch Functions

    public List<Cell> getCells() {
        return cells;
    }

    // Display Functions

    public void run(){
        new MainFrame();
    }

}
