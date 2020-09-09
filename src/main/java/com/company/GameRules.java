package com.company;

import java.util.ArrayList;
import java.util.List;

public class GameRules {
    // Apply Game Rules on a board State

    private final int boardWidth;
    private final int boardHeight;
    List<Cell> cells;

    public GameRules(Board board){
        this.boardWidth = board.getBoardWidth();
        this.boardHeight =  board.getBoardHeight();
        this.cells = board.getCells();
    }

    public void apply(){
        // updates boardState by applying game rules
        // New State is pure function of preceding one

        List<Boolean> statuses = new ArrayList<>();

        for (Cell cell: cells){
            if (cell.isAlive()){
                statuses.add(handleAliveCell(cell));
            }
            else{
                statuses.add(handleDeadCell(cell));
            }
        }

        // Update all Cell States
        for (int i=0;i<cells.size();i++){
            cells.get(i).setStatus(statuses.get(i));
        }
    }

    private boolean isCellPositionValid(int xPos, int yPos){
        return (((xPos>=0) && (yPos>=0)) &&
                ((xPos <= boardHeight-1) && (yPos <= boardWidth-1)));
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
                        int index = boardWidth * xPos + yPos; // Row-Major form
                        neighbours.add(cells.get(index));
                    }
                }
            }
        }
        return neighbours;
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

    private boolean handleAliveCell(Cell cell){
        // Returns the future status of an alive cell

        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        return ((numberOfAliveNeighbours == 2) ||
                (numberOfAliveNeighbours == 3));
    }

    private boolean handleDeadCell(Cell cell){
        // Returns the future status of a dead cell

        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        return (numberOfAliveNeighbours == 3);
    }

}
