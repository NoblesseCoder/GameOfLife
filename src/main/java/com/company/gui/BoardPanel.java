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
    private final int F_WIDTH = 900;
    private final int F_HEIGHT = 700;
    private final int WIDTH;
    private final int HEIGHT;
    int CELL_SIZE;
    List<Cell> grid;
    boolean flag = true;
    GameRules gameRules;

    public BoardPanel(Board board, GameRules gameRules){
        WIDTH = board.getBoardWidth();
        HEIGHT = board.getBoardHeight();
        this.gameRules = gameRules;
        CELL_SIZE = F_WIDTH/WIDTH;
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
        for (int i=0;i<F_WIDTH;i++){
            graphics.drawLine(0,i * CELL_SIZE,
                    F_WIDTH-1, i * CELL_SIZE); // draw row
            graphics.drawLine(i * CELL_SIZE,0,
                    i * CELL_SIZE, F_HEIGHT-1); // draw Col
        }
    }

    public void seed(){
//        if (flag){
//            for (int x=0;x<HEIGHT;x++){
//                for (int y=0;y<WIDTH;y++){
//                    if ((int)(Math.random()*5) == 0){
//                        int index = WIDTH*x + y;
//                        grid.get(index).setStatus(true);
//                    }
//                }
//            }
//        }
        if (flag){
            int x = HEIGHT/2;
            for (int y=0;y<WIDTH;y++){
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
                    graphics.fillRect(x * CELL_SIZE, y * CELL_SIZE,
                            CELL_SIZE, CELL_SIZE);
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

