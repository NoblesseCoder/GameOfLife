package com.company.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Move implements MouseMotionListener {

    BoardPanel boardPanel;

    Move(BoardPanel boardPanel){
        this.boardPanel = boardPanel;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int mX = mouseEvent.getX();
        int mY = mouseEvent.getY();
        boardPanel.seed(mX, mY);
        boardPanel.paintComponent(boardPanel.getGraphics());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
