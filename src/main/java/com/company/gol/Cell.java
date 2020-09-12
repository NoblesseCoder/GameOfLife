package com.company.gol;

public class Cell {
    // Single (Atomic) unit of the Universe

    private final int xPos;
    private final int yPos;
    private boolean status; // Alive Status (by default Dead (false))

    public Cell(int xPos, int yPos, boolean status){
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = status;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public boolean isAlive() {
        return status;
    }

    public void setAlive(boolean status) {
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
