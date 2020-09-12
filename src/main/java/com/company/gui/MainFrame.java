package com.company.gui;

import com.company.Config;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final boolean IS_RESIZABLE = false;

    private static final boolean IS_VISIBLE = true;

    public MainFrame(){
        setTitle(Config.TITLE);
        setSize(Config.GUI_WINDOW_FRAME_WIDTH,
                Config.GUI_WINDOW_FRAME_HEIGHT);
        setLocation(Config.GUI_WINDOW_FRAME_SPAWN_WIDTH,
                Config.GUI_WINDOW_FRAME_SPAWN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(IS_RESIZABLE);

        Container mainContainer = getContentPane();
        mainContainer.setBackground(Color.WHITE);
        initComponents(mainContainer);
        setVisible(IS_VISIBLE);
    }

    public void initComponents(Container container){

        // Adding BoardPanel
        BoardPanel boardPanel = new BoardPanel();
        container.add(boardPanel,BorderLayout.CENTER);

        // Adding MenuPanel
        MenuPanel menuPanel = new MenuPanel(boardPanel);
        container.add(menuPanel,BorderLayout.NORTH);
    }
}
