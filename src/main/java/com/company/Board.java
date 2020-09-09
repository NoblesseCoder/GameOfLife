package com.company;

import java.util.ArrayList;
import java.util.List;


public class Board {
    // Manages all Game Board related stuff

    private List<Cell> cells = null;
    private int boardWidth;
    private int boardHeight;

    private Board(){}

    private static class SingletonHandler{
        private static final Board instance = new Board();
    }

    public static Board getInstance(){
        return SingletonHandler.instance;
    }

    public void initBoardParameters(int boardWidth, int boardHeight){
        // Init Board
        cells = new ArrayList<>();
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        for (int i=0;i<this.boardHeight;i++){
            for (int j=0;j<this.boardWidth;j++){
                cells.add(new Cell(i,j));
            }
        }
    }

    public void seed(boolean[][] pattern){
        // Seeds the input pattern
        for (int i=0;i<this.boardHeight;i++){
            for (int j=0;j<this.boardWidth;j++){
                int index = this.boardWidth*i + j;
                boolean status = pattern[i][j];
                cells.get(index).setStatus(status);
            }
        }

    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public void setBoardState(List<Cell> cells) {
        this.cells = cells;
    }

    public void display(){
        System.out.println("");
        for (int i=0;i<boardHeight;i++){
            for (int j=0;j<boardWidth;j++){
                int index = boardWidth*i + j;
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
