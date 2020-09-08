package com.company;

public class Cell {
    // Handles all Cell related stuff

    private final int xPos;
    private final int yPos;
    private boolean status;

    public Cell(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = false; // default cell is dead
    }

    public boolean isAlive(){
        return this.status;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", status=" + status +
                '}';
    }
}
