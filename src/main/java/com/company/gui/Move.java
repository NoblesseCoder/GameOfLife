package com.company.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Move implements MouseMotionListener {
    private int mx = -100;
    private int my= -100;

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mx = mouseEvent.getX();
        my = mouseEvent.getY();
    }


}
