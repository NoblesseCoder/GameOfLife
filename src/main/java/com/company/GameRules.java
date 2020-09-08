package com.company;

import java.util.ArrayList;
import java.util.List;

public class GameRules {
    // Apply Game Rules on a board State

    private final List<Cell> cells;
    private final int boardSize;

    public GameRules(Board board){
        this.cells = board.getCells();
        this.boardSize = board.getBoardSize();
    }

    public void apply(){
        // updates boardState by applying game rules
        // New State is pure function of preceding one

        for (Cell cell: cells){
            if (cell.isAlive()){
                handleAliveCell(cell);
            }
            else{
                handleDeadCell(cell);
            }
        }
    }

    public boolean isCellPositionValid(int xPos, int yPos){
        return (((xPos>=0) && (yPos>=0)) &&
                ((xPos <= boardSize-1) && (yPos <= boardSize-1)));
    }

    public List<Cell> getNeighbours(Cell cell){
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
                if (isCellPositionValid(xPos, yPos)){
                    int index = boardSize*xPos + yPos; // Row-Major form
                    //System.out.println(xPos + " " +yPos + " " + index);
                    neighbours.add(cells.get(index));
                }
            }
        }
        return neighbours;
    }

    public int getNumberOfAliveNeighbours(Cell cell){
        int aliveCnt = 0;
        List<Cell> neighbours = getNeighbours(cell);
        for (Cell neighbour : neighbours){
            if (neighbour.isAlive()){
                aliveCnt++;
            }
        }
        return aliveCnt;
    }

    public void handleAliveCell(Cell cell){
        // Decides the future status of an alive cell

        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        if ( !((numberOfAliveNeighbours == 2) ||
                (numberOfAliveNeighbours == 3))){
            // Under-Population or Over population
            cell.setStatus(false);
        }
    }

    public void handleDeadCell(Cell cell){
        // Decides the future status of a dead cell

        int numberOfAliveNeighbours = getNumberOfAliveNeighbours(cell);
        if (numberOfAliveNeighbours == 3){
            // Reproduction
            cell.setStatus(true);
        }
    }

}
