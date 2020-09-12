package com.company.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class MenuPanel extends JPanel {
    Timer timer;
    public MenuPanel(BoardPanel boardPanel){
        timer = boardPanel.getTimer();
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton resetButton = new JButton("Reset");

        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!boardPanel.getTimer().isRunning()){
                    boardPanel.getTimer().start();
                    pauseButton.setEnabled(true);
                    playButton.setEnabled(false);
                    resetButton.setEnabled(true);
                }
            }
        });


        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(boardPanel.getTimer().isRunning()) {
                    boardPanel.getTimer().stop();
                    boardPanel.getTimer().start();
                    pauseButton.setEnabled(false);
                    playButton.setEnabled(true);
                    resetButton.setEnabled(true);
                }

            }
        });


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boardPanel.unSeed();
                boardPanel.repaint();
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);
                resetButton.setEnabled(false);
            }
        });

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 10);
        jSlider.setValue(80);
        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(10, new JLabel("Fast"));
        labels.put(100, new JLabel("Medium"));
        labels.put(200, new JLabel("Slow"));
        jSlider.setLabelTable(labels);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                if(boardPanel.getTimer().isRunning()) {
                    boardPanel.getTimer().stop();
                    boardPanel.setTimer(new Timer(jSlider.getValue(), boardPanel));
                    boardPanel.timer.start();
                    boardPanel.repaint();
                }
            }
        });
        add(playButton);
        add(pauseButton);
        add(resetButton);
        add(jSlider);
    }
}
