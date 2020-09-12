package com.company.gui;

import com.company.Config;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener {

    private int mX = -100;
    private int mY = -100;
    BoardPanel boardPanel;
    Click(BoardPanel boardPanel){
        this.boardPanel = boardPanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mX = mouseEvent.getX();
        mY = mouseEvent.getY();
        boardPanel.seed(mX,mY);
        boardPanel.paintComponent(boardPanel.getGraphics());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
