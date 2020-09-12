package com.company.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener {

    private int mx = -100;
    private int my = -100;

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mx = mouseEvent.getX();
        my = mouseEvent.getY();
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
