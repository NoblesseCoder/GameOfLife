package com.company.gui;

import com.company.Board;
import com.company.GameRules;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private int FRAME_WIDTH = 900;
    private int FRAME_HEIGHT = 700;
    private final int SPAWN_WIDTH = 100;
    private final int SPAWN_HEIGHT = 100;


    public MainFrame(Board board, GameRules gameRules){

        setTitle("Game Of Life");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(SPAWN_WIDTH, SPAWN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        Container mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.WHITE);

        MenuPanel menuPanel = new MenuPanel();
        mainContainer.add(menuPanel,BorderLayout.NORTH);
        BoardPanel boardPanel = new BoardPanel(board, gameRules);
        mainContainer.add(boardPanel);
    }
}
