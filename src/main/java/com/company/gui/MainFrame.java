package com.company.gui;

import com.company.Board;
import com.company.GameRules;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final int SPAWN_WIDTH = 100;
    private final int SPAWN_HEIGHT = 100;


    public MainFrame(Board board, GameRules gameRules,int GUI_WIDTH, int GUI_HEIGHT){
        setTitle("Game Of Life");
        setSize(GUI_WIDTH, GUI_HEIGHT);
        setLocation(SPAWN_WIDTH, SPAWN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container mainContainer = getContentPane();
        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(Color.WHITE);

        MenuPanel menuPanel = new MenuPanel();
        mainContainer.add(menuPanel,BorderLayout.NORTH);
        System.out.println(mainContainer.getAlignmentY());
        BoardPanel boardPanel = new BoardPanel(board, gameRules,
                GUI_WIDTH, GUI_HEIGHT);
        mainContainer.add(boardPanel);
        setVisible(true);
    }
}
