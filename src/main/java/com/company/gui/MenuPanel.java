package com.company.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public MenuPanel(){

        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");

        add(playButton);
        add(pauseButton);
        add(resetButton);
    }
}
