package com.company;

import com.company.Cell;

import java.util.ArrayList;
import java.util.List;


public class Board {
    // Manages all Game Board related stuff

    private List<Cell> cells = null;
    private int boardSize;

    private Board(){}

    private static class SingletonHandler{
        private static final Board instance = new Board();
    }

    public static Board getInstance(){
        return SingletonHandler.instance;
    }

    public void initBoardParameters(int boardSize){
        // Init Board
        cells = new ArrayList<>();
        this.boardSize = boardSize;
        for (int i=0;i<this.boardSize;i++){
            for (int j=0;j<this.boardSize;j++){
                cells.add(new Cell(i,j));
            }
        }
    }

    public void seed(boolean[][] pattern){
        // Seeds the input pattern
        for (int i=0;i<this.boardSize;i++){
            for (int j=0;j<this.boardSize;j++){
                int index = boardSize*i + j;
                boolean status = pattern[i][j];
                cells.get(index).setStatus(status);
            }
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardState(List<Cell> cells) {
        this.cells = cells;
    }

    public void display(){
        System.out.println("");
        for (int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
                int index = boardSize*i + j;
                if (cells.get(index).isAlive()){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
