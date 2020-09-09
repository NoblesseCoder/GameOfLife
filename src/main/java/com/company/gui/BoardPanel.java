package com.company.gui;

import com.company.Board;
import com.company.Cell;
import com.company.GameRules;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BoardPanel extends JPanel implements ActionListener{
    private final int WIDTH;
    private final int HEIGHT;
    private final int CELL_WIDTH_SIZE;
    private final int CELL_HEIGHT_SIZE;
    List<Cell> grid;
    boolean flag = true;
    GameRules gameRules;

    public BoardPanel(Board board, GameRules gameRules, int GUI_WIDTH,
                      int GUI_HEIGHT){
        WIDTH = board.getBoardWidth();
        HEIGHT = board.getBoardHeight();
        this.gameRules = gameRules;
        CELL_WIDTH_SIZE = GUI_WIDTH /WIDTH;
        CELL_HEIGHT_SIZE = GUI_HEIGHT /HEIGHT;
        grid = board.getCells();;
        setBackground(Color.DARK_GRAY);
        setLayout(new FlowLayout(FlowLayout.TRAILING));
        new Timer(80,this).start();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawBoard(graphics);
        seed();
        display(graphics);
    }

    public void drawBoard(Graphics graphics){
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i=0;i<=HEIGHT;i++){
            graphics.drawLine(0,i * CELL_HEIGHT_SIZE,
                    WIDTH*CELL_WIDTH_SIZE-1, i * CELL_HEIGHT_SIZE); // draw row
        }
        for (int j=0;j<=WIDTH;j++){
            graphics.drawLine(j * CELL_WIDTH_SIZE,0,
                    j * CELL_WIDTH_SIZE, HEIGHT*CELL_HEIGHT_SIZE-1); // draw Col
        }
    }

    public void seed(){
        if (flag){
            int y = WIDTH/2;
            for (int x=0;x<HEIGHT;x++){
                int index = WIDTH*x + y;
                grid.get(index).setStatus(true);
            }
        }
        flag = false;
    }

    public void display(Graphics graphics){
        graphics.setColor(Color.GREEN);
        for (int x=0;x<HEIGHT;x++) {
            for (int y = 0; y < WIDTH; y++) {
                int index = WIDTH*x + y;

                if (grid.get(index).isAlive()) {
                    graphics.fillRect(y * CELL_WIDTH_SIZE, x * CELL_HEIGHT_SIZE,
                            CELL_WIDTH_SIZE, CELL_HEIGHT_SIZE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameRules.apply();
        repaint();
    }
}

